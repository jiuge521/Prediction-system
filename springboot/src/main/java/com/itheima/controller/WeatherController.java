package com.itheima.controller;

import com.itheima.domain.PMData;
import com.itheima.domain.Weather;
import com.itheima.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private IWeatherService weatherService;

    /**
     * 获取一个城市所有监测点的AQI数据（含详情）
     * @param cityName
     * @return
     */
    @GetMapping("/getWeatherByCityName/{cityName}")
    public List<Weather> getWeatherByCityName(@PathVariable("cityName")String cityName){
        return weatherService.getWeatherByCityName(cityName);
    }
    @RequestMapping("/getPMData")
    public PMData getPMDat(@RequestParam("city")String city){
        return weatherService.getRequest2(city);
    }

    /**
     * 获取最新数据
     * @return
     */
    @RequestMapping("/findOne")
    public PMData findOne(){
        return weatherService.findOne();
    }

}
