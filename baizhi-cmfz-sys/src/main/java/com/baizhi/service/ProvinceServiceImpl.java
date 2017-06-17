package com.baizhi.service;

import com.baizhi.dao.ProvinceMapper;
import com.baizhi.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    public List<Province> selectAll() {
        List<Province> provinces = provinceMapper.selectAll();
        return provinces;
    }
}
