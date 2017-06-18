package com.baizhi.controller;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */

@Controller
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;

    @ResponseBody
    @RequestMapping("/selectByProvince")
    public List<City> selectByProvince(String id){
        List<City> cities = cityService.selectByProvince(id);
        return cities;
    }
}
