package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 2017/10/16.
 */
public class StaffAction extends ActionSupport {

    private List<Department> departList;// 存储所有部门的集合
    private List<Post> postList;

    {
//        初始化部门数据
        departList = new ArrayList<>();

//        部门添加
        for (int i = 0; i < 3; i++) {
            Department department = new Department();
            department.setId(i);//设置部门id
            department.setDname("部门: " + i);//设置部门职务

            List<Post> postList = new ArrayList<>();//存储当前部门下的所有职务集合
//            部门职务集合
            for (int j = 0; j < 5; j++) {
                Post post = new Post();
                post.setId(j);
                post.setPname(i + "职务: " + j);
                postList.add(post);//将职务添加到职务集合中
            }
            department.setPostList(postList);//将职务集合设置到部门对象中
            departList.add(department);//将部门对象加到部门集合中
        }
    }

    private String departId;//发起部门id查询时传过来的部门id

    /**
     * 查找所有部门
     *
     * @return
     */
    public String findDepartment() {
        return SUCCESS;
    }

    /**
     * 根据部门id查找职务集合
     */
    public String findPostsByPid() throws IOException {
        System.out.println("要查询的部门id: " + departId);
        int dId = Integer.parseInt(departId);

        //根据部门id获取该部门下的所有职务集合
        List<Post> postList = departList.get(dId).getPostList();

        JsonConfig jsonConfig = new JsonConfig();
        String jsonArray = JSONArray.fromObject(postList, jsonConfig).toString();

        // 设置编码
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(jsonArray);
        return null;

    }

    /**
     * 根据struts2返回json数据
     * @return
     */
    public String findPostsByPid2(){
        int index = Integer.parseInt(departId);
        postList = departList.get(index).getPostList();
        return SUCCESS;
    }

    public List<Department> getDepartList() {
        return departList;
    }

    public void setDepartList(List<Department> departList) {
        this.departList = departList;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
