package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门信息
     * @return
     */
    @Select("select * from tlias_dept")
    List<Dept> list();

    /**
     * 根据id删除部门数据
     * @param id
     */
    @Delete("delete from tlias_dept where id = #{id}")
    void delete(Integer id);

    /**
     * 添加部门数据
     * @param dept
     */
    @Insert("insert into tlias_dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门数据
     * @param id
     * @return
     */
    @Select("select * from tlias_dept where id = #{id}")
    Dept get(Integer id);

    /**
     * 修改部门数据
     * @param dept
     */
    @Update("update tlias_dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
