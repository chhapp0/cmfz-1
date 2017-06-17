package com.baizhi.dao;

import com.baizhi.entity.Essay;

import java.util.List;

public interface EssayMapper {
    int deleteByPrimaryKey(String id);

    int insert(Essay record);

    Essay selectByPrimaryKey(String id);

    int updateByPrimaryKey(Essay record);

    public List<Essay> selectAll();

    //根据上师id查询
    public List<Essay> selectByGuru(String tid);
}