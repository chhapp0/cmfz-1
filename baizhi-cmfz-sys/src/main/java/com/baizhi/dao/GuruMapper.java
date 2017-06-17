package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruMapper {
    int deleteByPrimaryKey(String id);

    int insert(Guru record);

    Guru selectByPrimaryKey(String id);

    int updateByPrimaryKey(Guru record);

    //查询所有的上师
    public List<Guru> selectAll();


}