package com.itheima.job;

import com.itheima.service.IWeatherService;
import com.itheima.service.WeatherServiceServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherDataSyncJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceServiceImpl.class);
    @Autowired
    private IWeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        weatherService.save();
    }
}
