package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    City selectByPrimaryKey(String id);

    int updateByPrimaryKey(City record);

    //查询所有的城市
    public List<City> selectAll();

    //根据省份查询城市
    public List<City> selectByProvince(String id);


}