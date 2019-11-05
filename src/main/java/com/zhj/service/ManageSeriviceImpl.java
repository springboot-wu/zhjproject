package com.zhj.service;

import com.zhj.dao.ManageDao;
import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.ParamUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:51
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class ManageSeriviceImpl implements ManageService {
    @Autowired
    private ManageDao manageDao;

    @Override
    public void Add(Declare d) {
        manageDao.Add(d);
    }

    @Override
    public void Update(Declare d) {
       manageDao.Update(d);
    }

    @Override
    public void Delete(Integer id) {
        manageDao.Delete(id);
    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=manageDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Declare> users=manageDao.Query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public void BatchDelete(String[] id) {
        manageDao.BatchDelete(id);
    }

    @Override
    public List<Declare> query(Integer id) {
        return manageDao.query(id);
    }

}
