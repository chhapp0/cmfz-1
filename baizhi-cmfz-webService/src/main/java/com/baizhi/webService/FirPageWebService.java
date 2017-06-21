package com.baizhi.webService;

import com.baizhi.entity.*;

import javax.jws.WebService;
import java.util.Map;

/**
 * Created by Lenovo on 2017/6/16.
 */
@WebService
public interface FirPageWebService {

    //第一页的接口
    public FirPageDATE showFir(String uid,String type,String sub_type);

    //登录接口
    public Map<String ,String > login(String phone, String password);

    //专辑展示接口
    public Album showAlbum(String uid,String id);

    //注册接口
    public Map<String ,String> regist(String phone,String password);

}
