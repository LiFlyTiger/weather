package com.lifeihu.spring.cloud.weather.ServiceImpl;

import com.lifeihu.spring.cloud.weather.Service.WeatherReprotService;
import com.lifeihu.spring.cloud.weather.vo.Forecast;
import com.lifeihu.spring.cloud.weather.vo.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
@Service
public class WeatherReprotServiceImpl implements WeatherReprotService {


    @Override
    public Weather getDataByCityId(String cityId) {

        Weather data = new Weather();
        data.setAqi("81");
        data.setCity("深圳");
        data.setGanmao("容易感冒！多穿衣");
        data.setWendu("22");

        List<Forecast> forecastList = new ArrayList<>();

        Forecast forecast = new Forecast();
        forecast.setDate("25日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温 11度");
        forecast.setLow("低温 1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("26日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温 11度");
        forecast.setLow("低温 1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("27日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温 11度");
        forecast.setLow("低温 1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("28日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温 11度");
        forecast.setLow("低温 1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("29日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温 11度");
        forecast.setLow("低温 1度");
        forecastList.add(forecast);

        data.setForecast(forecastList);
        //TODO 由天气数据API提供

        return data;
    }
}
