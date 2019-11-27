package com.zhj.service;

import com.zhj.dao.RoleDao;
import com.zhj.entity.ZhjRole;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
   private RoleDao roleDao;

    /**
     * 保存角色
     * @param role
     * @return
     */
    @Override
    public boolean saveRole(ZhjRole role) {
        try {
            int  i =   roleDao.saveRole(role);
            return i >0 ;
        } catch (Exception e) {
           //e.printStackTrace();
            log.error("保存角色失败"+e.getMessage());
        }
        return false;
    }
   //查询角色的列表
    public PageResult<ZhjRole> queryRoleList(PageQuery pageQuery){

         int count = roleDao.countForRoleList();
         if(count > 0 ){
             List<ZhjRole> list = roleDao.queryRoleList(pageQuery);
             return PageResult.<ZhjRole>builder().total(count).data(list).build();
         }
         return  PageResult.<ZhjRole>builder().build();
    }
    //删除单个角色
    public boolean deleteRoleByPrimaryKey(Integer roleId){
        try {
            int i = roleDao.deleteRoleByPrimaryKey(roleId);
            //TODO
            // 根据角色id 删除 角色 权限中间表
//              int n = roleDao.deleteRoleAndPopedom(roleId);
//            return i > 0 && n > 0;
            return  i>0;
        } catch (Exception e) {
           // e.printStackTrace();
            log.error("删除角色异常"+e.getMessage());
        }
        return  false;
    }
   //批量删除角色
    public boolean batchdeleteRole(List<Integer> idList){

        try {
            int i = roleDao.batchdeleteRole(idList);
            //TODO
            // 批量删除角色权限中间表
//            int n = roleDao.deleteRoleAndPopedomByIdList(idList);
//            return i >0 && n > 0 ;
            return i >0;
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("批量删除角色异常"+e.getMessage());
        }
        return  false;
    }

    //根据 角色 id 查询
    public ZhjRole selectRoleById(Integer roleId){
        try {
            ZhjRole zhjRole = roleDao.selectRoleById(roleId);
            return zhjRole;
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("查询角色异常"+e.getMessage());
        }
        return ZhjRole.builder().build();
    }
   //根据 角色 id 修改
   public boolean updateRoleById(ZhjRole zhjRole){
       try {
           int i = roleDao.updateRoleById(zhjRole);
           return i>0;
       } catch (Exception e) {
           //e.printStackTrace();
           log.error("修改角色异常"+e.getMessage());
       }
       return false;
   }



}
