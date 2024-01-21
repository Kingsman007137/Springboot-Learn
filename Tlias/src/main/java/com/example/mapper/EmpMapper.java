package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    /**
//     * 查询总记录数
//     * @return
//     */
//    @Select("select count(*) from tlias_emp")
//    Long total();
//
//    /**
//     * 返回数据列表
//     * @param start 起始索引
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from tlias_emp limit #{start}, #{pageSize}")
//    List<Emp> rows(Integer start, Integer pageSize);

    /**
     * 分页查询员工数据（用到PageHelper插件）
     * @return
     */
//    @Select("select * from tlias_emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
}
