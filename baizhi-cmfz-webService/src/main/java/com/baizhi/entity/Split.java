package com.baizhi.entity;

import java.util.List;

/**
 * Created by Lenovo on 2017/6/13.
 */
public class Split<T> {

    private List<T> rows;

    private Integer total;

    @Override
    public String toString() {
        return "Split{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Split() {

    }

    public Split(List<T> rows, Integer total) {

        this.rows = rows;
        this.total = total;
    }
}
