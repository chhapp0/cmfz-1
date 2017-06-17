package com.baizhi.service;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.Split;
import com.baizhi.entity.User;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SaltUtil;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<User> selectAll(Integer page,Integer rows) {
        Page<User> startPage = PageHelper.startPage(page, rows);
        List<User> users = userMapper.selectAll();

        Split<User> userSplit = new Split<User>();
        userSplit.setRows(users);
        userSplit.setTotal((int) startPage.getTotal());

        return userSplit;
    }

    public List<User> selectForWork() {

        List<User> users = userMapper.selectAll();

        return users;
    }

    public void addUser(User user) {

        user.setId(UUID.randomUUID().toString());
        user.setSalt(SaltUtil.getSalt(8));
        user.setPwd(MD5Utils.getMD5(user.getPwd()+user.getSalt()));

        userMapper.insert(user);

    }

    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User selectOne(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
