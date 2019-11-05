package com.zhj.dao;

import com.zhj.model.*;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:24
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */

public interface UserDao {


    void Update(@Param("id") Integer id, @Param("time") String time);

    List<Jurisdiction> Tree(Integer id);

    User LoginUser(User user);

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);

    List<User> Login(Integer id);

    Users LoginUsers(Users users);

    Integer Total(ParamUtil param);

    List<Users> QueryUser(@Param("page") Integer page, @Param("rows") Integer rows, @Param("p") ParamUtil param);

    Integer total(ParamUtil param);

    List<User> query(@Param("page") Integer page, @Param("rows") Integer rows, @Param("p") ParamUtil param);

    void add(User u);

    void update(User u);

    void delete(Integer id);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    Integer rtotal(ParamUtil param);

    List<Role> QueryRole(@Param("page") Integer page, @Param("rows") Integer rows);

    void RoleUser(Integer id);

    void RoleBatchDelete(String[] id);

    void BatchDeleteUser(String[] id);

    void AddRole(Role role);

    void UpdateRole(Role role);

    Integer QueryTotal(ParamUtil param);

    List<Department> QueryDepartment(@Param("page") Integer page, @Param("rows") Integer size);

    void AddDepartment(Department department);

    void UpdateDepartment(Department department);

    void DeleteDepartment(Integer id);

    void BatchDeleteDepartment(String[] id);
}