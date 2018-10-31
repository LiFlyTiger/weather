package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.lifeihu.spring.cloud.weather.Service.DataClient;
import com.lifeihu.spring.cloud.weather.Service.WeatherDataService;
import com.lifeihu.spring.cloud.weather.Service.WeatherReprotService;
import com.lifeihu.spring.cloud.weather.vo.Forecast;
import com.lifeihu.spring.cloud.weather.vo.Weather;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
@Service
public class WeatherReprotServiceImpl implements WeatherReprotService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //TODO 由天气数据API提供
        WeatherResponse weatherResponse = dataClient.getDataByCityId(cityId);
        return weatherResponse.getData();
    }
}
