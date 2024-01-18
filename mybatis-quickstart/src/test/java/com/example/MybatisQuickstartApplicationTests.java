package com.example;

import com.example.mapper.EmpMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Emp;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest//SpringBoot 整合单元测试的注解
class MybatisQuickstartApplicationTests {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testListUser() {
//        List<User> userList = userMapper.list();
//        userList.stream().forEach(user -> {
//            System.out.println(user);
//        });
//    }

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(17);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setDeptId(1);
        emp.setEntryDate(LocalDate.of(2015, 01, 01));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setDeptId(1);
        emp.setEntryDate(LocalDate.of(2015, 01, 01));
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.select(17);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> empList = empMapper.list("张", (short) 1, null, null);
        System.out.println(empList);
    }

    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("Tom2");
        emp.setName("汤姆2222");
        emp.setGender((short) 2);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update2(emp);
    }

    @Test
    public void testDelete2() {
        List<Integer> ids = List.of(16, 17);
        empMapper.delete2(ids);
    }
}
