package com.lifeihu.spring.cloud.weather.controller;

import com.lifeihu.spring.cloud.weather.Service.CityService;
import com.lifeihu.spring.cloud.weather.Service.DataClient;
import com.lifeihu.spring.cloud.weather.Service.WeatherReprotService;
import com.lifeihu.spring.cloud.weather.vo.City;
import com.lifeihu.spring.cloud.weather.vo.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e-lifeihu on 2018/10/22.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
    @Autowired
    private WeatherReprotService weatherReprotService;

    @Autowired
    private DataClient dataClient;
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportDataByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        //TODO通过城市数据接口获取
        List<City> cities = null;
        try {
            //TODO 改为由城市数据API微服务数据提供
            cities = dataClient.listCity();// cityDataService.listCity();

        } catch (Exception e) {
            logger.error("Exception:" ,e);
        }
        Weather weather = weatherReprotService.getDataByCityId(cityId);
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cities);
        model.addAttribute("report",weatherReprotService.getDataByCityId(cityId));
        return  new ModelAndView("weather/report","reportModel",model);

    }

}
