package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by Lenovo on 2017/6/12.
 */
public interface AdminService {

    public Admin login(Admin admin);

    public void addAdmin(Admin admin);

}
