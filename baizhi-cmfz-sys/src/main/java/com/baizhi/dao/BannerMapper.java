package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

/**
 * 轮播图
 */
public interface BannerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    Banner selectByPrimaryKey(String id);

    int updateByPrimaryKey(Banner record);

    //查询所有轮播图
    public List<Banner> selectAll();

}