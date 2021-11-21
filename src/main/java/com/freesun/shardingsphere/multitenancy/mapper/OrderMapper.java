package com.freesun.shardingsphere.multitenancy.mapper;

import com.freesun.shardingsphere.multitenancy.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void save(Order order);

}
