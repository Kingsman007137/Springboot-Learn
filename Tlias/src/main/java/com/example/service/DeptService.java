package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门信息
     * @return
     */
    List<Dept> list();

    /**
     * 根据id删除部门数据
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门数据
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询部门数据
     * @param id
     */
    Dept get(Integer id);

    /**
     * 修改部门数据
     * @param dept
     */
    void update(Dept dept);
}
