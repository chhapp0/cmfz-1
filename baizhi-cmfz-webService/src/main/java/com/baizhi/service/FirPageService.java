package com.baizhi.service;

import com.baizhi.entity.FirPageDATE;
import com.baizhi.entity.User;

/**
 * Created by Lenovo on 2017/6/16.
 */
public interface FirPageService {

    public FirPageDATE makeFirPage(String uid,String type,String sub_type);

    //根据手机查询用户
    public User selectByPhone(String phone);

}
