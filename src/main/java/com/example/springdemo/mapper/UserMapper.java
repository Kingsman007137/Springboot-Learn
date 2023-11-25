package com.example.springdemo.mapper;

import com.example.springdemo.bean.UserBean;

/** DAO层访问数据库接口文件 */
public interface UserMapper {

    UserBean getInfo(String name,String password);

}
