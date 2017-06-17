package com.baizhi.test;

import com.baizhi.dao.CityMapper;
import com.baizhi.dao.ProvinceMapper;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestCity {
    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityService cityService;



    @Test
    public void testSelectAll(){
       // System.out.println(provinceMapper.selectAll());
        System.out.println(provinceMapper.selectByPrimaryKey("14"));
        System.out.println(provinceMapper.selectAll());
    }

    @Test
    public void testSelectAllCity(){
        System.out.println(cityMapper.selectByProvince("14"));

    }

    //城市查一个
    @Test
    public void testSelectOneCity(){
       /* City city = cityMapper.selectByPrimaryKey("101");
        System.out.println(city);*/

        List<City> cities = cityMapper.selectByProvince("14");
        System.out.println(cities);

    }



}
