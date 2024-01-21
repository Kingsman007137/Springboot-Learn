package com.example.service;

import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
}
