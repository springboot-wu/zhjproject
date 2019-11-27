package com.zhj.dao;

import com.zhj.entity.ZhjPopedom;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PopedomDao {

    // 获取 用户左侧树权限集合
    List<ZhjPopedom> getAllPopedom(@Param("midList") List<Integer> midList);

    // 获取所有的权限集合
    List<ZhjPopedom> findPopedomList();
    // 根据角色id 查询 权限集合
    List<ZhjPopedom> findPopedomCollectionByRoleId(Integer roleId);


    // 保存角色 权限中间表
    int saveRolePopedom(@Param("roleId") Integer roleId, @Param("podIdList") List<Integer> podIdList);

}
