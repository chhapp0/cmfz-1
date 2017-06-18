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

import java.util.*;

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
        user.setCreateDate(new Date());
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

    public List<Integer> registCount() {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Calendar instance1 = Calendar.getInstance();

        instance1.add(Calendar.DATE,-7);
        Integer integer1 = userMapper.registCount(new Date(), instance1.getTime());

        Calendar instance2 = Calendar.getInstance();
        instance2.add(Calendar.MONTH,-1);
        Integer integer2 = userMapper.registCount(new Date(), instance2.getTime());

        Calendar instance3 = Calendar.getInstance();
        instance3.add(Calendar.MONTH,-3);
        Integer integer3 =  userMapper.registCount(new Date(), instance3.getTime());

        Calendar instance4 = Calendar.getInstance();
        instance4.add(Calendar.MONTH,-6);
        Integer integer4 =  userMapper.registCount(new Date(), instance4.getTime());

        Calendar instance5 = Calendar.getInstance();
        instance5.add(Calendar.YEAR,-1);
        System.out.println(new Date());
        System.out.println(instance5.getTime());
        Integer integer5 =  userMapper.registCount(new Date(), instance5.getTime());


        integers.add(integer1);
        integers.add(integer2);
        integers.add(integer3);
        integers.add(integer4);
        integers.add(integer5);
        return integers;
    }
}
