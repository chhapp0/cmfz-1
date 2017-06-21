package com.baizhi.webService;

import com.baizhi.entity.Album;
import com.baizhi.entity.FirPageDATE;
import com.baizhi.entity.User;
import com.baizhi.service.FirPageService;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/6/16.
 */
@WebService
@Path("/face")
public class FirPageWebServiceImpl implements FirPageWebService {

    @Resource
    private FirPageService firPageService;

    @GET
    @Path("/showFir/{uid}/{type}/{sub_type}")
    @Produces("application/json;charset=utf-8")
    public FirPageDATE showFir(@PathParam("uid") String uid,@PathParam("type") String type,@PathParam("sub_type") String sub_type) {
        return firPageService.makeFirPage(uid,type,sub_type );
    }



    @GET
    @Path("/showAlbum/{uid}/{id}/")
    @Produces("application/json;charset=utf-8")
    public Album showAlbum(@PathParam("uid") String uid,@PathParam("id") String id) {

        Album album = firPageService.selecetOneAlbum(uid, id);
        return album;
    }


    @POST
    @Path("/login/{phone}/{password}/")
    @Produces("application/json;charset=utf-8")
    //参数密码为md5后的
    public HashMap<String ,String > login(@PathParam("phone") String phone,@PathParam("password") String password) {
        User user = firPageService.selectByPhone(phone);
        HashMap<String, String> map = new HashMap<String, String>();
        if (user!=null){
            if (user.getPwd().equals(password)){
                map.put("password",user.getPwd());
                map.put("farmington",user.getFarmington());
                map.put("uid",user.getId());
                map.put("nickname",user.getNickname());
                map.put("gender",user.getGender());
                map.put("photo",user.getPhoto());
                map.put("province",user.getProvince().getPname());
                map.put("city",user.getCity().getName());
                map.put("description",user.getDescription());
                map.put("phone",user.getPhone());
            }else {
                map.put("errno","-200");
                map.put("errmsg","密码错误");
            }
        }else{
            map.put("errno","-200");
            map.put("errmsg","账号不存在");
        }

        return map;
    }




    @POST
    @Path("/showAlbum/{phone}/{password}/")
    @Produces("application/json;charset=utf-8")
    public HashMap<String, String> regist(@PathParam("phone") String phone,@PathParam("password") String password) {
        HashMap<String, String> map = new HashMap<String, String>();
        try{
            User regist = firPageService.regist(phone, password);
            map.put("uid",regist.getId());
            map.put("password",regist.getPwd());
            map.put("phone",regist.getPhone());
            return map;
        }catch (Exception e){
            map.put("errno","-200");
            map.put("err_msg","注册失败");
            return map;
        }
    }
}
