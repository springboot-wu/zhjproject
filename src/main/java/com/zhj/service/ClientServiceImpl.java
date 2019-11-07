package com.zhj.service;

import com.zhj.dao.ClientDao;
import com.zhj.model.Client;
import com.zhj.model.Deal;

import com.zhj.model.Declare;
import com.zhj.model.Users;
import com.zhj.util.LikeUtil;
import com.zhj.util.ParamUtil;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 11:30
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public void Add(Client c) {
       clientDao.Add(c);
    }

    @Override
    public void Update(Client c) {
      clientDao.Update(c);
    }

    @Override
    public void Delete(Integer id) {
        clientDao.Delete(id);
    }

    @Override
    public void BatchDelete(String[] id) {
        clientDao.BatchDelete(id);
    }

    @Override
    public List<Deal> QueryUsers(String da) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(da, pos);
        String format = sim.format(parse);
        String s = LikeUtil.LikeCha(format);
        return clientDao.QueryUsers(s);
    }



    @Override
    public void AddDeclare(Declare declare,Integer id) {
         if (declare.getComparison()==1){
           declare.setLastmonth(declare.getType());
             Date da=new Date();
             SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String time=sim.format(da);
             declare.setDeclaretime(time);
             declare.setStatus(3);
             declare.setUsersid(id);
           clientDao.AddDeclare(declare);
         }else{
            declare.setSamemoth(declare.getType());
             Date da=new Date();
             SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String time=sim.format(da);
            declare.setDeclaretime(time);
            declare.setStatus(3);
             declare.setUsersid(id);
            clientDao.AddDeclar(declare);
         }

    }

    @Override
    public Map Query(ParamUtil param) {
        Integer total=clientDao.Total(param);
        Integer page=(param.getPage()-1)*param.getSize();
        List<Declare> users=clientDao.Query(page,param.getSize(),param);
        Map ma=new HashMap();
        ma.put("total",total);
        ma.put("data",users);
        return ma;
    }

    @Override
    public List<Users> Message(Integer id) {

        return clientDao.Message(id);
    }

    @Override
    public List<Users> QueryPassword(Integer id) {
        return clientDao.QueryPassword(id);
    }

    @Override
    public Users Password(String oldpassword, Integer id) {
        return clientDao.Password(oldpassword,id);
    }

    @Override
    public void OldPassword(String password, Integer id) {
        clientDao.OldPassword(password,id);
    }

    @Override
    public List<Deal> More(ParamUtil param,Integer id) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date parse = sim.parse(param.getYear(), pos);
        String format = sim.format(parse);
        String s = LikeUtil.LikeCha(format);
        param.setYear(s);
        return clientDao.More(param,id);
    }

    @Override
    public Map DateTime() {
         String da=clientDao.da();
        String time=clientDao.time();
        String date=clientDao.date();
        String tim=clientDao.tim();
        Map ma=new HashMap();
        ma.put("sbstatartime",da);
        ma.put("sbendtime",time);
        ma.put("ydstatartime",date);
        ma.put("ydendtime",tim);
        return ma;
    }

    @Override
    public List<Deal> MoreAndMore(Integer id) {
        return clientDao.MoreAndMore(id);
    }


}
