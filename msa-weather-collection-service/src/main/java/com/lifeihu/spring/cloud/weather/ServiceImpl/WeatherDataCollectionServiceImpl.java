package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.lifeihu.spring.cloud.weather.Service.WeatherDataCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by e-lifeihu on 2018/10/25.
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final Long TIME_OUT = 1800L; //1800s

    //利用HttpClient获取天气信息
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sysncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    public void saveWeatherData(String uri){
        //先查询缓存，取缓存中的数据
        String strBody = null;
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();

        //如果缓存中没有的话，取httpClient，获取数据
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
        //将数据写入缓存
        opsForValue.set(uri,strBody,TIME_OUT, TimeUnit.SECONDS);
    }
}
