package com.itheima.service;


import com.itheima.MySpringBootApplication;
import com.itheima.domain.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class
)@SpringBootTest(classes= MySpringBootApplication.class)
public class WeatherServiceServiceImplTest {
    @Autowired
    private IWeatherService weatherService;
    @Test
    public void getWeatherByCityName() {
        List<Weather> weatherList = weatherService.getWeatherByCityName("xian");
        for (Weather weather : weatherList) {
            System.out.println(weather);
        }

    }
}