package com.baizhi.service;

import com.baizhi.entity.Split;
import com.baizhi.entity.Work;

/**
 * Created by Lenovo on 2017/6/15.
 */
public interface WorkService {

    public Split<Work> selectAll(Integer page,Integer rows);

    public Work selectOne(String id);

    public void addWork(Work work);

    public void deleteWork(String id);

    public void updateWork(Work work);

}
