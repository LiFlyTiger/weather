package com.lifeihu.spring.cloud.weather.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e-lifeihu on 2018/10/22.
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        String version = SpringBootVersion.getVersion();
        System.out.println(version);
        String implementationVersion = SpringApplication.class.getPackage().getImplementationVersion();

        System.out.println(implementationVersion);

        return "SpringBoot版本"+version +"------------"+ implementationVersion;
    }
}
