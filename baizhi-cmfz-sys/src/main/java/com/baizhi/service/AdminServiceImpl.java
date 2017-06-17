package com.baizhi.service;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SaltUtil;
import com.baizhi.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/12.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin login(Admin admin) {

        Admin dbAdmin = adminMapper.selectByUserName(admin.getUsername());

        if (dbAdmin==null){
            throw new RuntimeException("用户不存在");
        }else if(!MD5Utils.getMD5(admin.getPassword()+dbAdmin.getSalt()).equals(dbAdmin.getPassword())){
            throw new RuntimeException("账号或密码错误！");
        }else{
            return dbAdmin;
        }
    }

    public void addAdmin(Admin admin) {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        System.out.println("-----------------------");
        System.out.println(( snowflakeIdWorker.nextId()));
        admin.setId(String.valueOf(snowflakeIdWorker.nextId()));
        admin.setSalt(SaltUtil.getSalt(8));
        admin.setPassword(MD5Utils.getMD5(admin.getPassword()+admin.getSalt()));
        System.out.println(admin);

        adminMapper.insert(admin);
    }
}
