package com.example.service;

import com.example.dao.*;
import com.example.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Primary //让当前Bean生效
@Service
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        //1. 调用dao, 获取数据
        List<Emp> empList = empDao.listEmp();

        //2. 对数据进行转换处理 - gender, job
        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男性");
            }else if("2".equals(gender)){
                emp.setGender("女性");
            }

            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("大侠");
            }else if("2".equals(job)){
                emp.setJob("高手");
            }else if("3".equals(job)){
                emp.setJob("宗师");
            }
        });
        return empList;
    }
}
