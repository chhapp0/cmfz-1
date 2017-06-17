package com.baizhi.service;

import com.baizhi.entity.Split;
import com.baizhi.entity.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/12.
 */


@Service
public interface UserService {

    //查询所有的user
    public Split<User> selectAll(Integer page, Integer rows);

    //查询所有的功课
    public List<User> selectForWork();

    //增加一个用户
    public void addUser(User user);

    //删除一个用户
    public void deleteUser(String id);

    //修改一个用户
    public void updateUser(User user);

    //查询一个用户
    public User selectOne(String id);

}
