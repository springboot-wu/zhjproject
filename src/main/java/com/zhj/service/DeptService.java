package com.zhj.service;

import com.zhj.entity.ZhjDept;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;

import java.util.List;

public interface DeptService {
    boolean save(ZhjDept dept);
    //查询部门的列表
    PageResult<ZhjDept> queryDeptList(PageQuery pageQuery);

    //删除单个部门
    boolean deleteDeptByPrimaryKey(Integer deptId);
    //批量删除部门
    boolean batchdeleteDept(List<Integer> idList);
    ////根据 部门 id 查询 部门
    ZhjDept selectDepthById(Integer deptId);
   //根据 部门 id 修改部门
   boolean updateDeptById(ZhjDept zhjDept);

}
