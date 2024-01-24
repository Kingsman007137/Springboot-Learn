package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 新增员工
     * @param emp
     */
    @Insert("insert into tlias_emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) \n" +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("select * from tlias_emp where id=#{id}")
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询员工
     * 其实就是登录，但是mapper层不应该用业务名称login，应该用数据操作名称
     * @param emp
     * @return
     */
    @Select("select * from tlias_emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
