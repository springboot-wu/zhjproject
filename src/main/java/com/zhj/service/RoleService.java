package com.zhj.service;

import com.zhj.entity.ZhjRole;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;

import java.util.List;

public interface RoleService {

    boolean saveRole(ZhjRole zhjRole);
    //查询角色的列表
    PageResult<ZhjRole> queryRoleList(PageQuery pageQuery);

    //删除单个角色
    boolean deleteRoleByPrimaryKey(Integer roleId);
    //批量删除角色
    boolean batchdeleteRole(List<Integer> idList);
    ////根据 角色id 查询
    ZhjRole selectRoleById(Integer roleId);
   //根据 角色id 修改角色
   boolean updateRoleById(ZhjRole zhjRole);

}
