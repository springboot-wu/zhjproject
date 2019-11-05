package com.zhj.service;

import com.zhj.model.*;
import com.zhj.util.ParamUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:22
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface UserService {



    void Update(Integer id);

    List<Jurisdiction> Tree(Integer id);

    User LoginUser(User user);

    void AddUser(Users u);

    List<Users> Query(Integer id);

    void UpdateUser(Users u);

    List<User> Login(Integer id);

    Users LoginUsers(Users users);

    Map QueryUser(ParamUtil param);

    Map Users(ParamUtil param);

    void add(User u);

    void update(User u);

    void delete(Integer id);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    Map QueryRole(ParamUtil param);

    void RoleDelete(Integer id);

    void RoleBatchDelete(String[] id);

    void BatchDeleteUser(String[] id);

    void AddRole(Role role);

    void UpdateRole(Role role);

    Map QueryDepartment(ParamUtil param);

    void AddDepartment(Department department);

    void UpdateDepartment(Department department);

    void DeleteDepartment(Integer id);

    void BatchDeleteDepartment(String[] id);
}
