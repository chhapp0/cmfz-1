package com.baizhi.service;

import com.baizhi.dao.BannerMapper;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Split;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/13.
 */
@Service
@Transactional
public interface BannerService {

    //查询所有的轮播图
    public Split<Banner> selectAll(Integer page, Integer rows);

    //查询一个轮播图
    public Banner queryOne(String id);

    //添加一个轮播图
    public void addBanner(Banner banner);

    //修改一个轮播图
    public void updateBanner(Banner banner);

    //删除一个轮播图
    public void deleteBanner(String id);
}
