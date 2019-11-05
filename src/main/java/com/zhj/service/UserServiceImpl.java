package com.zhj.service;

import com.zhj.dao.UserDao;
import com.zhj.model.*;
import com.zhj.util.LikeUtil;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:23
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;




    @Override
    public void Update(Integer id) {
        Date da=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sim.format(da);
        userDao.Update(id,time);
    }

    @Override
    public List<Jurisdiction> Tree(Integer id) {
        return userDao.Tree(id);
    }

    @Override
    public User LoginUser(User user) {
        return userDao.LoginUser(user);
    }




    @Override
    public void AddUser(Users u) {
        Date da=new Date();
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sim.format(da);
        //u.getThistime(time);
     //u.getLasttime(time);
        userDao.AddUser(u);
    }

    @Override
    public List<Users> Query(Integer id) {
        return userDao.Query(id);
    }

    @Override
    public void UpdateUser(Users u) {
        userDao.UpdateUser(u);
    }

    @Override
    public List<User> Login(Integer id) {
        return userDao.Login(id);
    }

    @Override
    public Users LoginUsers(Users users) {
        return userDao.LoginUsers(users);
    }

    @Override
    public Map QueryUser(ParamUtil param) {
        Integer total=userDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        String s1 = LikeUtil.LikeCha(param.getEnterprise());
        String s = LikeUtil.LikeCha(param.getName());
        param.setName(s);
        param.setEnterprise(s1);
        List<Users> users=userDao.QueryUser(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public Map Users(ParamUtil param) {
        Integer total=userDao.total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<User> users=userDao.query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public void add(User u) {
        userDao.add(u);

    }

    @Override
    public void update(User u) {
     userDao.update(u);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void Delete(Integer id) {
        userDao.Delete(id);
    }

    @Override
    public void BatchDelete(String[] id) {
        userDao.BatchDelete(id);
    }

    @Override
    public Map QueryRole(ParamUtil param) {
        Integer total=userDao.rtotal(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Role> users=userDao.QueryRole(page,param.getSize());
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public void RoleDelete(Integer id) {
        userDao.RoleUser(id);
    }

    @Override
    public void RoleBatchDelete(String[] id) {
        userDao.RoleBatchDelete(id);
    }

    @Override
    public void BatchDeleteUser(String[] id) {
        userDao.BatchDeleteUser(id);
    }

    @Override
    public void AddRole(Role role) {
        userDao.AddRole(role);
    }

    @Override
    public void UpdateRole(Role role) {
       userDao.UpdateRole(role);
    }

    @Override
    public Map QueryDepartment(ParamUtil param) {
        Integer total=userDao.QueryTotal(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Department> users=userDao.QueryDepartment(page,param.getSize());
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public void AddDepartment(Department department) {
        userDao.AddDepartment(department);
    }

    @Override
    public void UpdateDepartment(Department department) {
        userDao.UpdateDepartment(department);
    }

    @Override
    public void DeleteDepartment(Integer id) {
        userDao.DeleteDepartment(id);
    }

    @Override
    public void BatchDeleteDepartment(String[] id) {
        userDao.BatchDeleteDepartment(id);
    }
}
