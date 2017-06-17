package com.baizhi.service;

import com.baizhi.dao.EssayMapper;
import com.baizhi.entity.Essay;
import com.baizhi.entity.Split;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/15.
 */
@Service
@Transactional
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayMapper essayMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Essay> selectAll(Integer page, Integer rows) {
        Page<Essay> startPage = PageHelper.startPage(page,rows);
        List<Essay> essays = essayMapper.selectAll();

        Split<Essay> essaySplit = new Split<Essay>();
        essaySplit.setTotal((int) startPage.getTotal());
        essaySplit.setRows(essays);
        return essaySplit;
    }

    //根据上师查询文章
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Essay> selectByGuru(String tid,Integer page, Integer rows) {
        Page<Essay> startPage = PageHelper.startPage(page, rows);
        List<Essay> essays = essayMapper.selectByGuru(tid);

        Split<Essay> essaySplit = new Split<Essay>();
        essaySplit.setRows(essays);
        essaySplit.setTotal((int) startPage.getTotal());
        return essaySplit;
    }

    public void addEssay(Essay essay) {
        essay.setId(UUID.randomUUID().toString());
        essay.setPubdate(new Date());
        essayMapper.insert(essay);
    }

    public void deleteEssay(String id) {
        essayMapper.deleteByPrimaryKey(id);
    }

    public void updateEssay(Essay essay) {
        essayMapper.updateByPrimaryKey(essay);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Essay queryOne(String id) {
        Essay essay = essayMapper.selectByPrimaryKey(id);
        return essay;
    }
}
