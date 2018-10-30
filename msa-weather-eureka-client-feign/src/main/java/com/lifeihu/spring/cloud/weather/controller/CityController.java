package com.lifeihu.spring.cloud.weather.controller;

import com.lifeihu.spring.cloud.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e-lifeihu on 2018/10/26.
 */
@RestController
public class CityController {
    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public String listCity() {
        // 通过Feign客户端来查找
        String body = cityClient.listCity();
        return body;
    }
}
