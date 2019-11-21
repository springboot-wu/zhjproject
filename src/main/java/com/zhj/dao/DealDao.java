package com.zhj.dao;

import com.zhj.model.Client;
import com.zhj.model.Deal;
import com.zhj.util.ParamUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 朱福
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

    List<Deal> Query(@Param("page") Integer page,@Param("rows") Integer rows,@Param("p") ParamUtil param);

    int queryRegionIdByName(String customername);

    int queryClientByName(String region);

    void saveDeal(Deal deal);

    List<Deal> QueryDeal(Integer id);

    List<Client> QueryClient();
}
