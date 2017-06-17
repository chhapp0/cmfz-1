package com.baizhi.service;

import com.baizhi.dao.WorkMapper;
import com.baizhi.entity.Split;
import com.baizhi.entity.Work;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lenovo on 2017/6/15.
 */

@Service
@Transactional
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkMapper workMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Split<Work> selectAll(Integer page,Integer rows) {
        Page<Work> objects = PageHelper.startPage(page,rows);
        List<Work> works = workMapper.selectAll();
        Split<Work> workSplit = new Split<Work>();
        workSplit.setRows(works);
        workSplit.setTotal((int) objects.getTotal());
        return workSplit;
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Work selectOne(String id) {

        Work work = workMapper.selectByPrimaryKey(id);

        return work;
    }

    public void addWork(Work work) {
        work.setId(UUID.randomUUID().toString());
        work.setCreatedate(new Date());
        workMapper.insert(work);
    }

    public void deleteWork(String id) {
        workMapper.deleteByPrimaryKey(id);
    }

    public void updateWork(Work work) {
        workMapper.updateByPrimaryKey(work);
    }
}
