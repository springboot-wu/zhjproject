package com.zhj.dao;

import com.zhj.entity.ZhjDept;
import com.zhj.util.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeptDao {

     // 保存部门
     int saveDept(ZhjDept dept);
     // 查询部门的列表
    List<ZhjDept> queryDeptList(@Param("page") PageQuery page);
    int countForDeptList();
     //删除单个部门
    int deleteDeptByPrimaryKey(Integer deptId);

    //批量删除部门
    int batchdeleteDept(@Param("idList") List<Integer> idList);

    //根据 部门 id 查询 部门
    ZhjDept selectDepthById(Integer deptId);

    //根据 部门 id 修改部门
    int updateDeptById(ZhjDept dept);



}
