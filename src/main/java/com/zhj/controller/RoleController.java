package com.zhj.controller;

import com.zhj.common.JsonData;
import com.zhj.entity.ZhjRole;
import com.zhj.service.RoleService;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequestMapping("role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("saveRole")
    @ResponseBody
    public JsonData saveRole(@RequestBody ZhjRole zhjRole){
        log.info("保存角色参数"+zhjRole);
        boolean flag =  roleService.saveRole(zhjRole);
        return JsonData.success(flag);
    }

    /**
     *  查询部门列表
     * @param pageQuery
     * @return
     */
    @RequestMapping("queryRoleList")
    @ResponseBody
    public JsonData queryRoleList(@RequestBody PageQuery pageQuery){
        log.info("查询角色列表分页"+pageQuery);
        //查询部门的列表
        PageResult<ZhjRole> list = roleService.queryRoleList(pageQuery);
        return  JsonData.success(list);
    }
    //删除单个角色
    @RequestMapping("deleteRoleByPrimaryKey")
    @ResponseBody
    public JsonData deleteRoleByPrimaryKey(Integer roleId){
        log.info("删除角色roleId:"+ roleId);
        boolean  flag = roleService.deleteRoleByPrimaryKey(roleId);
        return JsonData.success(flag);
    }
    //批量删除角色
    @RequestMapping("batchdeleteRole")
    @ResponseBody
    public JsonData batchdeleteRole(@RequestBody  List<Integer> idList){
        log.info("批量删除角色集合:"+idList);
        boolean flag = roleService.batchdeleteRole(idList);
        return JsonData.success(flag);
    }
    ////根据   id 查询 角色
    @RequestMapping("selectRoleById")
    @ResponseBody
    public JsonData selectRoleById(Integer roleId){
        log.info("查询角色roleId:"+roleId);
        ZhjRole zhjRole = roleService.selectRoleById(roleId);
        return JsonData.success(zhjRole);
    }
    //根据 部门 id 修改角色
    @RequestMapping("updateRoleById")
    @ResponseBody
    public JsonData updateRoleById(@RequestBody ZhjRole zhjRole){
        log.info("修改角色参数"+zhjRole);
        boolean  flag= roleService.updateRoleById(zhjRole);
        return  JsonData.success(flag);
    }


}
