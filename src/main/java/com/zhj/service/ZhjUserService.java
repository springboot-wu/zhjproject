package com.zhj.service;

import com.zhj.entity.ZhjUser;
import com.zhj.param.UserParam;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;

import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/10/22 9:22
 * @description：
 * @package ：com.zhj.service
 * @version:
 */
public interface ZhjUserService {



    //====================
 //   PageResult<ZhjUser> zhjUserList(Map<String, Object> jsonMap);
    PageResult<ZhjUser> zhjUserList(String userName, Integer deptId, PageQuery pageQuery);

    boolean deleteUserByPrimaryKey(Integer userId);

    boolean save(UserParam param);

    boolean batchdeleteUsers(List<Integer> listUserId);

    ZhjUser selectByUserId(Integer userId);

    boolean updateUserByid(UserParam param);
}
