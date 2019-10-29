package com.itheima.config;

import com.itheima.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {
    @Bean
    public JobDetail getWeatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("WeatherDataSyncJob").storeDurably().build();
    }
    @Bean
    public Trigger getWeatherDataSyncTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(7200).repeatForever();
        return TriggerBuilder.newTrigger().forJob(getWeatherDataSyncJobDetail()).withIdentity("WeatherDataSyncTrigger").withSchedule(simpleScheduleBuilder).build();
    }
}
