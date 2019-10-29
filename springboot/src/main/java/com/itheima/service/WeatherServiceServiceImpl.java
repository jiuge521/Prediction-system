package com.itheima.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.PMData;
import com.itheima.domain.Weather;
import com.itheima.mapper.PMDataMapper;
import com.itheima.utils.JuheUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class WeatherServiceServiceImpl implements IWeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceServiceImpl.class);
    private static final long TIME_OUT=1800L;//1800s
    @Autowired
    private PMDataMapper pmDataMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //根据城市名称获取天气数据
    @Override
    public List<Weather> getWeatherByCityName(String cityName) {
        String uri="http://www.pm25.in/api/querys/aqi_details.json?city="+cityName+"&token=5j1znBVAsnSf5xQyNQyq";
        String body=null;
        ObjectMapper mapper=new ObjectMapper();
        List<Weather> weatherList=new ArrayList<>();
        //先查缓存
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(uri)){
            logger.info("redis缓存中有数据");
            body=ops.get(uri);
        }else{//缓存没有，再调用服务接口
            logger.info("redis缓存中没有数据");
            ResponseEntity<String> jsonString = restTemplate.getForEntity(uri, String.class);
            if(jsonString.getStatusCodeValue()==200){
                body = jsonString.getBody();
            }
            //数据写入缓存
            ops.set(uri,body, TIME_OUT, TimeUnit.SECONDS);
        }

        JSONArray jsonArray = JSONArray.fromObject(body);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            try {
                Weather weather = mapper.readValue(jsonObject.toString(), Weather.class);
                weatherList.add(weather);
            } catch (IOException e) {
                //e.printStackTrace();
                logger.error("Error",e);
            }
        }
        return weatherList;
    }

    /**
     * 获取最新的数据并预测质量等级
     * @param city
     * @return
     */
    @Override
    public PMData getRequest2(String city){
        PMData pmData = JuheUtil.getRequest2(city);
//        double[] x=new double[]{Double.parseDouble(pmData.getAQI()),Double.parseDouble(pmData.getCO()),
//        Double.parseDouble(pmData.getNO2()),Double.parseDouble(pmData.getO3()),Double.parseDouble(pmData.getPM10()),
//        Double.parseDouble(pmData.getPM25()),Double.parseDouble(pmData.getSO2()),Double.parseDouble(pmData.getAQI()),
//                Double.parseDouble(pmData.getCO()),Double.parseDouble(pmData.getNO2()),Double.parseDouble(pmData.getO3()),
//                Double.parseDouble(pmData.getPM10()),Double.parseDouble(pmData.getPM25())};
//        String quality = BpDeepTest.getQuality(x);
        //pmData.setQuality(quality);
        return pmData;
    }

    /**
     * 把最新的西安地区数据保存到数据库
     */
    @Override
    public void save()  {
        PMData pmData = getRequest2("xian");
        pmDataMapper.save(pmData);
    }

    /**
     * 获取最新数据
     * @return
     */
    @Override
    public  PMData findOne() {
        return pmDataMapper.findOne();
    }

}
