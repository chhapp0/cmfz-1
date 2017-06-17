package com.baizhi.test;

import com.baizhi.dao.AdminMapper;
import com.baizhi.dao.MenuMapper;
import com.baizhi.entity.Menu;
import com.baizhi.service.AdminService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestMenu {

    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void testQueryAll(){

        List<Menu> menus = menuService.selectAll();
        for (Menu m: menus ) {
            System.out.println(m.getName()+"1");
            for (Menu n: m.getMenus() ) {
                System.out.println(n.getName()+"2");
            }
        }

    }

}
