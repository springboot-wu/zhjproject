package com.zhj.dao;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.model.Declare;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ： 朱友
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

    void Password(@Param("password") String password, @Param("id") Integer id);

    void AddDeclare(@Param("declar") Declare declare);

    void AddDeclar(@Param("declar")Declare declare);

    Integer Total(ParamUtil param);

    List<Declare> Query(@Param("page") Integer page, @Param("size") Integer size,@Param("p")ParamUtil param);
}
