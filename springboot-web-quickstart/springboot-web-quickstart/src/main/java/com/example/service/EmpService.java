package com.example.service;

import com.example.pojo.Emp;
import java.util.List;

//业务逻辑接口
public interface EmpService {
    //获取员工列表
    public List<Emp> listEmp();
}
