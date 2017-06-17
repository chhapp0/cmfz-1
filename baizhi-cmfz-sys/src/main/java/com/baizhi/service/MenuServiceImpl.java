package com.baizhi.service;

import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/13.
 */

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> selectAll() {
        List<Menu> menus = menuMapper.selectAll();

        return menus;
    }
}
