package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 一个城市所有监测点的AQI数据（含详情）
 *
 */

public class Weather implements Serializable {
    private static final long serialVersionUID = 7595905287564959517L;
    private String aqi;//空气质量指数(AQI)，即air quality index，是定量描述空气质量状况的无纲量指数
    private String area;//城市名称
    private Double co;//一氧化碳1小时平均
    private Double co_24h;//一氧化碳24小时滑动平均
    private Integer no2;//二氧化氮1小时平均
    private Integer no2_24h;//二氧化氮24小时滑动平均
    private Integer o3;//臭氧1小时平均
    private Integer o3_24h;//臭氧日最大1小时平均
    private Integer o3_8h;//臭氧8小时滑动平均
    private Integer o3_8h_24h;//臭氧日最大8小时滑动平均
    private Integer pm10;//颗粒物（粒径小于等于10μm）1小时平均
    private Integer pm10_24h;//颗粒物（粒径小于等于10μm）24小时滑动平均
    private Integer pm2_5;//颗粒物（粒径小于等于2.5μm）1小时平均
    private Integer pm2_5_24h;//颗粒物（粒径小于等于2.5μm）24小时滑动平均
    private String position_name;//监测点名称
    private String primary_pollutant;//首要污染物
    private String quality;//空气质量指数类别，有“优、良、轻度污染、中度污染、重度污染、严重污染”6类
    private Integer so2;//二氧化硫1小时平均
    private Integer so2_24h;//二氧化硫24小时滑动平均
    private String station_code;//监测点编码
    private Date time_point;//数据发布的时间

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getCo_24h() {
        return co_24h;
    }

    public void setCo_24h(Double co_24h) {
        this.co_24h = co_24h;
    }

    public Integer getNo2() {
        return no2;
    }

    public void setNo2(Integer no2) {
        this.no2 = no2;
    }

    public Integer getNo2_24h() {
        return no2_24h;
    }

    public void setNo2_24h(Integer no2_24h) {
        this.no2_24h = no2_24h;
    }

    public Integer getO3() {
        return o3;
    }

    public void setO3(Integer o3) {
        this.o3 = o3;
    }

    public Integer getO3_24h() {
        return o3_24h;
    }

    public void setO3_24h(Integer o3_24h) {
        this.o3_24h = o3_24h;
    }

    public Integer getO3_8h() {
        return o3_8h;
    }

    public void setO3_8h(Integer o3_8h) {
        this.o3_8h = o3_8h;
    }

    public Integer getO3_8h_24h() {
        return o3_8h_24h;
    }

    public void setO3_8h_24h(Integer o3_8h_24h) {
        this.o3_8h_24h = o3_8h_24h;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getPm10_24h() {
        return pm10_24h;
    }

    public void setPm10_24h(Integer pm10_24h) {
        this.pm10_24h = pm10_24h;
    }

    public Integer getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Integer pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Integer getPm2_5_24h() {
        return pm2_5_24h;
    }

    public void setPm2_5_24h(Integer pm2_5_24h) {
        this.pm2_5_24h = pm2_5_24h;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPrimary_pollutant() {
        return primary_pollutant;
    }

    public void setPrimary_pollutant(String primary_pollutant) {
        this.primary_pollutant = primary_pollutant;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getSo2() {
        return so2;
    }

    public void setSo2(Integer so2) {
        this.so2 = so2;
    }

    public Integer getSo2_24h() {
        return so2_24h;
    }

    public void setSo2_24h(Integer so2_24h) {
        this.so2_24h = so2_24h;
    }

    public String getStation_code() {
        return station_code;
    }

    public void setStation_code(String station_code) {
        this.station_code = station_code;
    }

    public Date getTime_point() {
        return time_point;
    }

    public void setTime_point(Date time_point) {
        this.time_point = time_point;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "aqi='" + aqi + '\'' +
                ", area='" + area + '\'' +
                ", co=" + co +
                ", co_24h=" + co_24h +
                ", no2=" + no2 +
                ", no2_24h=" + no2_24h +
                ", o3=" + o3 +
                ", o3_24h=" + o3_24h +
                ", o3_8h=" + o3_8h +
                ", o3_8h_24h=" + o3_8h_24h +
                ", pm10=" + pm10 +
                ", pm10_24h=" + pm10_24h +
                ", pm2_5=" + pm2_5 +
                ", pm2_5_24h=" + pm2_5_24h +
                ", position_name='" + position_name + '\'' +
                ", primary_pollutant='" + primary_pollutant + '\'' +
                ", quality='" + quality + '\'' +
                ", so2=" + so2 +
                ", so2_24h=" + so2_24h +
                ", station_code='" + station_code + '\'' +
                ", time_point=" + time_point +
                '}';
    }
}
