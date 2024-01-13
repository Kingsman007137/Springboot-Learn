package com.example.springdemo.service;

import com.example.springdemo.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name,String password);
}