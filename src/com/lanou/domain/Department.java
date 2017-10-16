package com.lanou.domain;

import java.util.List;

/**
 * Created by dllo on 2017/10/16.
 */
public class Department {
    private Integer id;//部门id
    private String dname;//部门名称
    private List<Post> postList;//当前部门下的所有职务集合


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + dname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
