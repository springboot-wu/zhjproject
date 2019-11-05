package com.zhj.dao;

import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ： 朱友
 * @date ：Created in 2019/10/22 11:51
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */

public interface ManageDao {
    void Add(Declare d);

    void Update(Declare d);

    void Delete(Integer id);

    Integer Total(ParamUtil param);

    List<Declare> Query(@Param("page") Integer page, @Param("rows") Integer rows,@Param("p") ParamUtil param);

    void BatchDelete(String[] id);

    List<Declare> query(Integer id);
}
