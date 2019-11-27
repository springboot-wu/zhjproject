package com.zhj.controller;

import com.zhj.common.JsonData;
import com.zhj.entity.ZhjUser;
import com.zhj.param.UserParam;
import com.zhj.service.ZhjUserService;
import com.zhj.util.BeanValidator;
import com.zhj.util.PageQuery;
import com.zhj.util.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author ：
 * @date ：Created in 2019/10/22 9:17
 * @description：
 * @package ：com.zhj.controller
 * @version:
 */
@Slf4j
@Controller
@RequestMapping("User")
public class ZhjUserController {
    @Autowired
    private ZhjUserService userService;


    /***
     *
     * @param //userName
     * @param //deptId
     * @param //pageQuery
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "zhjUserList",produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    //    public JsonData  zhjUserList(@RequestBody Map<String,Object> jsonMap){
//        log.info("查询用户列表插入参数："+jsonMap.toString());
    public JsonData zhjUserList(String userName , Integer deptId, PageQuery pageQuery){
        try {
            log.info("==============================="+pageQuery);
            log.info("==============================="+deptId);
            if(userName != null && userName.trim() != ""){
                userName =  new String(userName.getBytes("iso-8859-1"),"UTF-8");
                log.info("==============================="+userName);
            }
//            String name = new String(userName.getBytes("iso-8859-1"),"UTF-8");
            PageResult<ZhjUser> list = userService.zhjUserList(userName,deptId,pageQuery);
            return JsonData.success(list,"200");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return JsonData.fail("查询用户列表失败");
    }

    /**
     * 根据主键删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "deleteUserByPrimaryKey",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonData deleteUserByPrimaryKey(Integer userId){
        log.info("删除用户 userId:"+userId);
        if(userId == null || userId.equals("")){
            return JsonData.fail("请求参数为空！！！");
        }
        try {
            boolean  flag =  userService.deleteUserByPrimaryKey(userId);
            if(flag){
                return JsonData.success(flag,"200");
            }
            return JsonData.fail("删除用户失败！！！userId:"+userId);
        } catch (Exception e) {
            // e.printStackTrace();
            log.error("删除用户 userId:"+userId+"========="+e.getMessage());
        }
        return JsonData.fail("删除用户失败！！！");
    }
    /**
     *  批量删除用户
     */
    @RequestMapping(value = "batchdeleteUsers",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonData batchdeleteUsers(@RequestBody List<Integer> listUserId){
        log.info("批量删除用户 listUserId："+listUserId);
        if(listUserId == null || listUserId.size() == 0){
            return JsonData.fail("批量删除用户参数为空！！！");
        }
        try {
            boolean  flag = userService.batchdeleteUsers(listUserId);
            if(flag){
                return JsonData.success(flag,"批量删除用户成功！");
            }
            return JsonData.fail("批量删除用户失败");

        } catch (Exception e) {
            //e.printStackTrace();
            log.error(e.getMessage());
        }
        return JsonData.fail("批量删除用户失败");
    }

    /**
     *  添加用户
     * @param param
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody UserParam param){
        log.info(param.toString());
        BeanValidator.check(param);
        try {
            log.info(String.valueOf(param));
            boolean  flag =  userService.save(param);
            if(flag){
                return JsonData.success(flag,"保存用户成功");
            }
            return JsonData.fail("添加用户失败");

        } catch (Exception e) {
            //e.printStackTrace();
            log.error(e.getMessage());
        }
        return JsonData.fail("添加用户失败");
    }

    /**
     * 根据用户id 查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectByUserId",method = RequestMethod.GET)
    @ResponseBody
    public JsonData selectByUserId(Integer userId){
        log.info("用户userId："+userId);
        if(userId == null || userId.equals("")){
            return  JsonData.fail("查询用户userId 为空!!!");
        }
        ZhjUser user= userService.selectByUserId(userId);
        if(user != null){
            return JsonData.success(user,"查询用户成功");
        }
        return  JsonData.fail("查询用户失败");
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @RequestMapping(value = "updateUserByid",method = RequestMethod.POST)
    @ResponseBody
    public JsonData updateUserByid(@RequestBody UserParam param){
        log.info("更新部门参数:"+param);
         BeanValidator.check(param);
        try {
            boolean flag = userService.updateUserByid(param);
            if(flag){
                return  JsonData.success(flag,"修改用户成功！！！");
            }
            JsonData.fail("修改用户失败");
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("更新用户异常========"+e.getMessage());
        }
        return  JsonData.fail("更新用户失败");
    }

}
