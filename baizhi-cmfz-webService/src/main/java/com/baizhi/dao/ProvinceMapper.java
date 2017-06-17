package com.baizhi.dao;

import com.baizhi.entity.Province;

import java.util.List;

public interface ProvinceMapper {

    public List<Province> selectAll();

    public Province selectByPrimaryKey(String id);

}