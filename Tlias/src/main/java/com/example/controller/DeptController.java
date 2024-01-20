package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门信息
     * @return
     */
    @GetMapping// 指定请求方式为GET
    public Result list(){
        log.info("查询全部部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据ID删除部门数据
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门数据：{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门数据
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门数据：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询部门信息：{}", id);
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }

    /**
     * 修改部门数据
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门数据：{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
