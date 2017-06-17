package com.baizhi.service;

import com.baizhi.dao.BannerMapper;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.baizhi.entity.Split;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/13.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Banner> selectAll(Integer page,Integer rows) {
        Page<Banner> banner = PageHelper.startPage(page, rows);
        List<Banner> banners = bannerMapper.selectAll();

        Split<Banner> bannerSplit = new Split<Banner>();
        bannerSplit.setRows(banners);
        bannerSplit.setTotal((int) banner.getTotal());

        return bannerSplit;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Banner queryOne(String id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        return banner;
    }

    public void addBanner(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerMapper.insert(banner);
    }

    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    public void deleteBanner(String id) {
        bannerMapper.deleteByPrimaryKey(id);
    }
}
