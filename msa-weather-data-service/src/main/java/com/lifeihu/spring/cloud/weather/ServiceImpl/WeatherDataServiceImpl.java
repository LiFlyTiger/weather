package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by e-lifeihu on 2018/10/23.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityID) {
        String uri= WEATHER_URI + "citykey=" +  cityID;
        WeatherResponse resp = doGetWeatherData(uri);
        return resp;
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri= WEATHER_URI + "city=" +  cityName;
        WeatherResponse resp = doGetWeatherData(uri);
        return resp;
    }

    /**
     * 获取天气信息方法
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeatherData(String uri) {
        //先查询缓存，取缓存中的数据
        String strBody = null;
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(uri)){
            logger.info("从缓存中获取");
            strBody =  opsForValue.get(uri);
        }else{
            //如果缓存中没有的话，取httpClient，获取数据 ，抛出异常
            logger.info("从HttpClient中获取");
            throw new RuntimeException("从HttpClient中获取");
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }




}
