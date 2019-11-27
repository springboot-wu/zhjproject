package com.zhj.service;

import com.zhj.dao.ZhjUserDao;
import com.zhj.entity.ZhjDept;
import com.zhj.entity.ZhjUser;
import com.zhj.exception.ParamException;
import com.zhj.param.UserParam;
import com.zhj.util.BeanValidator;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/22 9:23
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
@Slf4j
@Service
public class ZhjUserServiceImpl implements ZhjUserService {

    @Autowired
    private ZhjUserDao userDao;



    //====================================================

    /**
     *  查询 用户列表
     * @return
     */
    @Override
   // public PageResult<ZhjUser> zhjUserList(Map<String,Object> jsonMap){
    public PageResult<ZhjUser> zhjUserList(String userName , Integer deptId, PageQuery page){
       /* String userName = MapToStrUtils.getMapToStr(jsonMap,"userName");
        String strdeptId =MapToStrUtils.getMapToStr(jsonMap,"deptId");
        String pageNo =MapToStrUtils.getMapToStr(jsonMap,"pageNo");
        String pageSize =MapToStrUtils.getMapToStr(jsonMap,"pageSize");
        Integer deptId = null;
        if(deptId != null){
            deptId = Integer.valueOf(strdeptId);
        }
        PageQuery page = null;
        if(pageNo != null && pageSize != null){
            page = PageQuery.builder().pageNo(Integer.valueOf(pageNo)).pageSize(Integer.valueOf(pageSize)).build();
        }else{
            page = PageQuery.builder().pageNo(1).pageSize(10).build();
        }*/
        BeanValidator.check(page);
        int count =  userDao.countByUserNameAndDeptId(userName,deptId);
        if(count >0){
            List<ZhjUser>  list= userDao.zhjUserList(userName,deptId,page);

            return PageResult.<ZhjUser>builder().total(count).data(list).build();
        }
        return PageResult.<ZhjUser>builder().build();

    }

    @Override
    @Transactional
    public boolean deleteUserByPrimaryKey(Integer userId) {
        int count = userDao.deleteUserByPrimaryKey(userId);
        // 删除用户角色中间表
        int count2 =  userDao.delUserRoleByUserId(userId);
        return count > 0 && count2 > 0;
    }

    @Override
    @Transactional
    public boolean save(UserParam param) {

        try {
            ZhjDept dept = ZhjDept.builder().deptId(param.getDeptId()).build();
            // 保存用户
            ZhjUser user = ZhjUser.builder().loginName(param.getLoginName()).userName(param.getUserName())
                    .mobile(param.getMobile()).zhjDept(dept).loginPwd(param.getLoginPwd()).status(1).onDutyDate(new Date()).build();
            int i = userDao.insertSelective(user);
//        System.out.println(i+"======"+param.getRoleId()+"新增用户id"+userID);
            //保存用户 角色 中间表
            Integer roleId = param.getRoleId();
            Integer userId = user.getUserID();
            int count = userDao.saveUserRoleId(userId,roleId);
            return i >0 && count >0;
        } catch (ParamException e) {
            // e.printStackTrace();
            log.error("保存用户异常======"+e.getMessage());
        }
        return  false;
    }

    /**
     * 批量删除用户
     * @param listUserId
     * @return
     */
    @Override
    @Transactional
    public boolean batchdeleteUsers(List<Integer> listUserId) {
        try {
            // 删除用户
            int i = userDao.batchdeleteUsers(listUserId);
            // 删除用户角色中间表
            int i1 = userDao.batchdeleteUsersAndRole(listUserId);
            return i >0 && i1 >0;
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("批量删除用户异常"+e.getMessage());
        }
        return false;
    }

    @Override
    public ZhjUser selectByUserId(Integer userId) {
        ZhjUser user= null;
        try {
            user = userDao.selectByUserId(userId);
        } catch (Exception e) {
            // e.printStackTrace();
            log.error("查询用户异常 userId"+userId+"========================="+e);
        }
        return user;
    }

    /**
     *  修改用户/部门 及角色
     * @param param
     * @return
     */
    @Override
    @Transactional
    public boolean updateUserByid(UserParam param) {
        try {

            ZhjDept dept = ZhjDept.builder().deptId(param.getDeptId()).build();
            ZhjUser user = ZhjUser.builder().userID(param.getUserId()).loginName(param.getLoginName()).userName(param.getUserName())
                    .mobile(param.getMobile()).zhjDept(dept).loginPwd(param.getLoginPwd()).build();
            // 更新用户信息
            int i = userDao.updateZhjUser(user);
            // 更新用户角色关联表
            // 删除用户 角色 关联表
            Integer userId = param.getUserId();
            Integer roleId = param.getRoleId();
            int  is=  userDao.delUserRoleByUserId(userId);
            // 添加用户角色 中间表
            int i1 = userDao.saveUserRoleId(userId, roleId);
            return i >0 && is>0 && i1 > 0;
        } catch (ParamException e) {
            //e.printStackTrace();
            log.error("更新用户信息失败======="+e.getMessage());
        }
        return false;
    }
}
