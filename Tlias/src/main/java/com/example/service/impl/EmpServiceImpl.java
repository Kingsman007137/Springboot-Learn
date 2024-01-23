package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long total = empMapper.total();
//
//        // 获取分页查询记录列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.rows(start, pageSize);
//
//        // 根据结果封装实体类
//        return new PageBean(total, rows);
//    }

    @Override
    // 用到了PageHelper插件
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        // 根据结果封装实体类
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
