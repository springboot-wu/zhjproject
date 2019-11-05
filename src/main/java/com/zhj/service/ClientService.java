package com.zhj.service;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Declare;
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


    void Password(String password, Integer id);

    void AddDeclare(Declare declare);

    Map Query(ParamUtil param);
}