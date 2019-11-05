package com.zhj.service;

import com.zhj.dao.DealDao;
import com.zhj.model.Deal;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/24 17:02
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class DealServiceImpl implements DealService{
    @Autowired
    private DealDao dealDao;

    @Override
    public void Add(Deal d) {
        dealDao.Add(d);
    }

    @Override
    public void Update(Deal d) {
    dealDao.Update(d);
    }

    @Override
    public void Delete(Integer id) {
        dealDao.Delete(id);
    }

    @Override
    public void BatchDelete(String[] id) {
        dealDao.BatchDelete(id);
    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=dealDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Users> users=dealDao.Query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }
}
