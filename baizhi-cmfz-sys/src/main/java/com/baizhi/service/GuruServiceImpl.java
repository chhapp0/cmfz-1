package com.baizhi.service;

import com.baizhi.dao.GuruMapper;
import com.baizhi.entity.Guru;
import com.baizhi.entity.Split;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/15.
 */

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruMapper guruMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> selectForUser(){
        List<Guru> gurus = guruMapper.selectAll();
        return gurus;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Guru> selectAll(Integer page,Integer rows) {
        Page<Guru> startPage = PageHelper.startPage(page,rows);
        List<Guru> gurus = guruMapper.selectAll();
        Split<Guru> guruSplit = new Split<Guru>();
        guruSplit.setTotal((int) startPage.getTotal());
        guruSplit.setRows(gurus);
        return guruSplit;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Guru selectOne(String id) {

        Guru guru = guruMapper.selectByPrimaryKey(id);
        return guru;
    }

    public void addGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruMapper.insert(guru);
    }

    public void deleteGuru(String id) {
        guruMapper.deleteByPrimaryKey(id);
    }

    public void updateGure(Guru guru) {
        guruMapper.updateByPrimaryKey(guru);
    }
}
