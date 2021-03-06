package com.lifeihu.spring.cloud.weather.Service;

import com.lifeihu.spring.cloud.weather.ServiceImpl.DataClientFallback;
import com.lifeihu.spring.cloud.weather.vo.City;
import com.lifeihu.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/26.
 */
@FeignClient(name="msa-weather-eureka-zuul-client", fallback=DataClientFallback.class)
@Service
public interface DataClient {

    @GetMapping("city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
