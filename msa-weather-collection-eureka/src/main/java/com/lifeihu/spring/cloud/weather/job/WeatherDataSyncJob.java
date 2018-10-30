package com.lifeihu.spring.cloud.weather.job;

import com.lifeihu.spring.cloud.weather.Service.WeatherDataCollectionService;
import com.lifeihu.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务，天气数据同步
 * Created by e-lifeihu on 2018/10/24.
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);


    /*@Autowired
    private CityDataService cityDataService;*/

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job. start！");
        //获取城市ID列表
        List<City> cities = null;
        try {
            //TODO 改为由城市数据API微服务数据提供
            cities = new ArrayList<>();// cityDataService.listCity();
            City city = new City();
            city.setCityId("101181801");
            cities.add(city);
        } catch (Exception e) {
            logger.error("Exception:" ,e);
        }
        //遍历城市获取信息
        for (City city:cities) {
            String cityId = city.getCityId();
            weatherDataCollectionService.sysncDataByCityId(cityId);
            logger.info("Weather Data Sync Job. End！"+cityId);
        }
        logger.info("Weather Data Sync Job. End！");
    }
}
