package com.itheima.domain;

public class PMData {
    private String city;
    private String PM25;
    private String AQI;
    private String quality;
    private String PM10;
    private String CO;
    private String NO2;
    private String O3;
    private String SO2;
    private String time;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPM25() {
        return PM25;
    }

    public void setPM25(String PM25) {
        this.PM25 = PM25;
    }

    public String getAQI() {
        return AQI;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPM10() {
        return PM10;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getNO2() {
        return NO2;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public String getO3() {
        return O3;
    }

    public void setO3(String o3) {
        O3 = o3;
    }

    public String getSO2() {
        return SO2;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PMData{" +
                "city='" + city + '\'' +
                ", PM25='" + PM25 + '\'' +
                ", AQI='" + AQI + '\'' +
                ", quality='" + quality + '\'' +
                ", PM10='" + PM10 + '\'' +
                ", CO='" + CO + '\'' +
                ", NO2='" + NO2 + '\'' +
                ", O3='" + O3 + '\'' +
                ", SO2='" + SO2 + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
