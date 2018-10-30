package com.lifeihu.spring.cloud.weather.Service;

import com.lifeihu.spring.cloud.weather.vo.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * Created by e-lifeihu on 2018/10/24.
 */
public interface WeatherReprotService {

    /**
     * 根据城市Id获取天气信息
     * @param cityId
     * @return
     */
     Weather getDataByCityId(String cityId);

}
