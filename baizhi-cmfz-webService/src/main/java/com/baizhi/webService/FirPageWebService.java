package com.baizhi.webService;

import com.baizhi.entity.*;

import javax.jws.WebService;

/**
 * Created by Lenovo on 2017/6/16.
 */
@WebService
public interface FirPageWebService {

    //第一页的接口
    public FirPageDATE showFir(String uid,String type,String sub_type);

    //登录接口
    public User login(String phone, String password);

}
