package com.lifeihu.spring.cloud.weather.Service;

import com.lifeihu.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/26.
 */
@FeignClient("msa-weather-city-eureka")
@Service
public interface CityService {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
