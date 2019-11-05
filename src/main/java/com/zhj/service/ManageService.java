package com.zhj.service;

import com.zhj.model.Declare;
import com.zhj.util.ParamUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/22 11:50
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface ManageService {
    void Add(Declare d);

    void Update(Declare d);

    void Delete(Integer id);

    Map Query(ParamUtil param);

    void BatchDelete(String[] id);

    List<Declare> query(Integer id);
}
