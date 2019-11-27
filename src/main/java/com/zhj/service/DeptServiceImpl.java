package com.zhj.service;

import com.zhj.dao.DeptDao;
import com.zhj.entity.ZhjDept;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
   private DeptDao deptDao;
    @Override
    public boolean save(ZhjDept dept) {
        try {
            int  i =   deptDao.saveDept(dept);
            return i > 0 ;
        } catch (Exception e) {
           // e.printStackTrace();
            log.error("保存部门失败"+e.getMessage());
        }
        return false;
    }
   //查询部门的列表
    public PageResult<ZhjDept> queryDeptList(PageQuery pageQuery){
        //查询部门总条数
        int count = deptDao.countForDeptList();
        if(count >0){
            List<ZhjDept> zhjDepts = deptDao.queryDeptList(pageQuery);
            return PageResult.<ZhjDept>builder().total(count).data(zhjDepts).build();
        }
        return PageResult.<ZhjDept>builder().build();
    }
    //删除单个部门
    public boolean deleteDeptByPrimaryKey(Integer deptId){
        try {
            int i = deptDao.deleteDeptByPrimaryKey(deptId);
            return i > 0;
        } catch (Exception e) {
          //  e.printStackTrace();
            log.error("删除单个部门异常"+e.getMessage());
        }
        return  false;
    }
   //批量删除部门
    public boolean batchdeleteDept(List<Integer> idList){

        try {
            int i = deptDao.batchdeleteDept(idList);
            return i >0 ;
        } catch (Exception e) {
           // e.printStackTrace();
            log.error("批量删除部门异常"+e.getMessage());
        }
        return false;
    }

    //根据 部门 id 查询 部门
    public ZhjDept selectDepthById(Integer deptId){
        try {
            ZhjDept zhjDept = deptDao.selectDepthById(deptId);
            return zhjDept;
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("根据部门id查询异常"+e.getMessage());
        }
        return ZhjDept.builder().build();
    }
   //根据 部门 id 修改部门
   public boolean updateDeptById(ZhjDept zhjDept){
       try {
           int i = deptDao.updateDeptById(zhjDept);
           return i > 0;
       } catch (Exception e) {
          // e.printStackTrace();
           log.error("修改部门异常"+e.getMessage());
       }
       return false;
   }



}
