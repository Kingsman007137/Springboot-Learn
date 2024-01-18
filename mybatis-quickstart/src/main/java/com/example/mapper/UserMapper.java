package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper//在运行时会自动生成该接口的实现类对象(代理对象)，并且将该对象交给IOC容器管理
public interface UserMapper {
    @Select("select * from user")//在此指定要执行的SQL语句
    public List<User> list();
}

