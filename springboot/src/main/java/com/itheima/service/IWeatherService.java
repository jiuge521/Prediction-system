package com.itheima.service;

import com.itheima.domain.PMData;
import com.itheima.domain.Weather;

import java.util.List;

public interface IWeatherService {
    //根据城市名称获取天气数据
    List<Weather> getWeatherByCityName(String cityName);
    PMData getRequest2(String city);
    void save();
    PMData findOne();

}
