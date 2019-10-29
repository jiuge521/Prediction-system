package com.itheima.mapper;

import com.itheima.domain.PMData;
import org.springframework.stereotype.Repository;

@Repository
public interface PMDataMapper {
    void save(PMData pmData);
    PMData findOne();
}
