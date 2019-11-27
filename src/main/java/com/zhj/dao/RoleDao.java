package com.zhj.dao;

import com.zhj.entity.ZhjRole;
import com.zhj.util.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleDao {

     // 保存角色
     int saveRole(ZhjRole zhjRole);
     // 查询角色的列表
    List<ZhjRole> queryRoleList(@Param("page") PageQuery page);
    int countForRoleList();
     //删除单个角色
    int deleteRoleByPrimaryKey(Integer roleId);

    //批量删除角色
    int batchdeleteRole(@Param("idList") List<Integer> idList);

    //根据 角色 id 查询
    ZhjRole selectRoleById(Integer roleId);

    //根据 角色id 修改部门
    int updateRoleById(ZhjRole zhjRole);

    // 根据角色id 删除 角色 权限中间表
    int deleteRoleAndPopedom(Integer roleId);
//   批量删除角色权限中间表
    int deleteRoleAndPopedomByIdList(@Param("idList") List<Integer> idList);
}
