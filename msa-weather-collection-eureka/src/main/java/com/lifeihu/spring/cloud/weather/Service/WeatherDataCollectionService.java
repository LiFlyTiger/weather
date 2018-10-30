package com.lifeihu.spring.cloud.weather.Service;

/**
 * Created by e-lifeihu on 2018/10/25.
 */
public interface WeatherDataCollectionService {

    /**
     * 缓存数据到redis中
     * @param cityId
     */
    void sysncDataByCityId(String cityId);

}
