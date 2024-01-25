package com.example.service;

import com.example.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;

public interface DeptLogService {

    void insert(DeptLog deptLog);
}
