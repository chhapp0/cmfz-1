package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User record);

    //查询所有的用户
    public List<User> selectAll();

    //根据上师ID查询所有的用户
    public List<User> selectByGuru(String tid);


}