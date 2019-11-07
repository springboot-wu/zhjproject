package com.zhj.dao;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:31
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ClientDao {
    void Add(Client c);

    void Update(Client c);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    List<Deal> QueryUsers(@Param("s") String s);

    Users Password(@Param("oldpassword") String oldpassword, @Param("id") Integer id);

    void AddDeclare(@Param("declar") Declare declare);

    void AddDeclar(@Param("declar") Declare declare);

    Integer Total(ParamUtil param);

    List<Declare> Query(@Param("page") Integer page, @Param("size") Integer size, @Param("p") ParamUtil param);

    List<Users> Message(Integer id);

    List<Users> QueryPassword(Integer id);

    void OldPassword(@Param("password") String password, @Param("id") Integer id);

    List<Deal> More(@Param("p") ParamUtil param);

    String da();

    String time();

    String date();

    String tim();
}
