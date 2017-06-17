package com.baizhi.webService;

import com.baizhi.entity.FirPageDATE;
import com.baizhi.entity.User;
import com.baizhi.service.FirPageService;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Lenovo on 2017/6/16.
 */
@WebService
@Path("/face")
public class FirPageWebServiceImpl implements FirPageWebService {

    @Resource
    private FirPageService firPageService;

    @GET
    @Path("/showFir")
    @Produces("application/json;charset=utf-8")
    public FirPageDATE showFir(String uid, String type, String sub_type) {
        return firPageService.makeFirPage(uid,type,sub_type );
    }

    @GET
    @Path("/login")
    @Produces("application/json;charset=utf-8")
    //参数密码为md5后的
    public User login(String phone, String password) {
        User user = firPageService.selectByPhone(phone);
        if (user.getPwd().equals(password)){
            return user;
        }
        return null;
    }


}
