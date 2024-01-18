package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //根据ID删除数据
    @Delete("delete from tlias_emp where id = #{id}")
    public void delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tlias_emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime});")
    public void insert(Emp emp);

    @Update("update tlias_emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
       "job =#{job}, entrydate = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    @Select("select * from tlias_emp where id = #{id}")
    public Emp select(Integer id);

//    @Select("select * from tlias_emp where name like concat('%', #{name}, '%') and gender = #{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //动态更新员工信息
    public void update2(Emp emp);

    //批量删除
    public void delete2(List<Integer> ids);
}
