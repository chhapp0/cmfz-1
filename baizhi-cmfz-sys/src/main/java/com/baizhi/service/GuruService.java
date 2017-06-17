package com.baizhi.service;

import com.baizhi.dao.GuruMapper;
import com.baizhi.entity.Guru;
import com.baizhi.entity.Split;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/15.
 */

/**
 * 上师   业务层
 */
public interface GuruService {
    //查询所有的上师
    public Split<Guru> selectAll(Integer page,Integer rows);
    //查询一个上师
    public Guru selectOne(String id);

    //增加一个上师
    public void addGuru(Guru guru);

    public void deleteGuru(String id);

    public void updateGure(Guru guru);

    public List<Guru> selectForUser();





}
