package com.baizhi.service;

import com.baizhi.dao.CityMapper;
import com.baizhi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public List<City> selectByProvince(String id) {
        List<City> cities = cityMapper.selectByProvince(id);
        return cities;
    }
}
