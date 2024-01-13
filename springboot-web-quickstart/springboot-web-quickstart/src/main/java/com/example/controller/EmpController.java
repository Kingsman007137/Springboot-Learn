package com.example.controller;

import com.example.pojo.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController //@RestController = @Controller + @ResponseBody
public class EmpController {
    //业务层对象
    @Autowired//运行时,从IOC容器中获取该类型对象,赋值给该变量
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
        //1. 调用service层, 获取数据
        List<Emp> empList = empService.listEmp();

        //3. 响应数据
        return Result.success(empList);
    }
}