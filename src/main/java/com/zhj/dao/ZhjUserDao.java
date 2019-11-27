package com.zhj.dao;

import com.zhj.entity.ZhjUser;
import com.zhj.util.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/10/22 9:24
 * @description：
 * @package ：com.zhj.dao
 * @version:
 */
public interface ZhjUserDao {

    List<ZhjUser>  zhjUserList(@Param("name") String userName, @Param("deptId") Integer deptId, @Param("page") PageQuery page);
    // 查询用户列表条数
    int countByUserNameAndDeptId(@Param("name") String userName, @Param("deptId") Integer deptId);

    int deleteUserByPrimaryKey(Integer userId);

    // 添加用户
    int insertSelective(ZhjUser user);
    // 添加 用户 角色 中间表
    int saveUserRoleId(@Param("userId") Integer userID, @Param("roleId") Integer roleId);

    int batchdeleteUsers(@Param("idList") List<Integer> listUserId);

    ZhjUser selectByUserId(Integer userId);

    int updateZhjUser(ZhjUser user);
    // 删除用户角色中间表
    int delUserRoleByUserId(Integer userId);

    // 批量删除用户角色 中间表
    int  batchdeleteUsersAndRole(@Param("listUserId") List<Integer> listUserId);
}