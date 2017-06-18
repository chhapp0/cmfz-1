package com.baizhi.test;

import com.baizhi.entity.*;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestUser {

    @Autowired
    private UserService userService;
    @Test
    public void testUtil(){



    }
    @Test
    public void testSelectAll(){
        Split<User> userSplit = userService.selectAll(1, 1);
        System.out.println(userSplit.getRows());
        Guru guru = new Guru();
        guru.setId("1");
        Province province = new Province();
        province.setId("1");
        City city = new City();
        city.setId("1");
        userService.addUser(new User());

    }

    @Test
    public void testSelect(){
        //System.out.println(userService.selectOne("da56b17a-e9f1-4d47-9ce6-1e67f899a4ce"));
        //System.out.println(userService.selectAll(1,10).getRows().get(4));
        Split<User> userSplit = userService.selectAll(1, 10);
        List<User> rows = userSplit.getRows();
        for (User row : rows) {
            System.out.println(row);
        }
       // System.out.println(userSplit);

    }


}
