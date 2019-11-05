package com.zhj.dao;

import com.zhj.model.Deal;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/24 17:03
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */

public interface DealDao {
    void Add(Deal d);

    void Update(Deal d);

    void Delete(Integer id);

    void BatchDelete(String[] id);

    Integer Total(ParamUtil param);

    List<Users> Query(@Param("page") Integer page,@Param("rows") Integer rows,@Param("p") ParamUtil param);
}
