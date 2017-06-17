package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */
public interface CityService {

    public List<City> selectByProvince(String id);

}
