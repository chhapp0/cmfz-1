package com.baizhi.dao;

import com.baizhi.entity.Work;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String id);

    int insert(Work record);

    Work selectByPrimaryKey(String id);

    int updateByPrimaryKey(Work record);

    public List<Work> selectAll();

    //根据用户查询
    public List<Work> selectByUser(String id);
}