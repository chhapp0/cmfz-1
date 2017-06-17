package com.baizhi.controller;

import com.baizhi.entity.Province;
import com.baizhi.entity.Split;
import com.baizhi.service.ProvinceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Resource
    private ProvinceService provinceService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Province> showAll(){

        List<Province> provinces = provinceService.selectAll();

        return provinces;
    }


}
