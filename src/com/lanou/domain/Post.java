package com.lanou.domain;

/**
 * Created by dllo on 2017/10/16.
 */
public class Post {
    private Integer id;//职务id
    private String pname;//职务名称

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
