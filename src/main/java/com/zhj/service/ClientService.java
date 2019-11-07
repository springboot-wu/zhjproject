package com.zhj.service;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:30
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface ClientService {
    void Add(Client c);

    void Update(Client c);

    void Delete(Integer id);

    void BatchDelete(String[] id);


    List<Deal> QueryUsers(String da);




    void AddDeclare(Declare declare);

    Map Query(ParamUtil param);

    List<Users> Message(Integer id);

    List<Users> QueryPassword(Integer id);


    Users Password(String oldpassword, Integer id);

    void OldPassword(String password, Integer id);

    List<Deal> More(ParamUtil param);

    Map DateTime();
}
