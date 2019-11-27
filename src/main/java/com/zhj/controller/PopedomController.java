package com.zhj.controller;

import com.zhj.common.JsonData;
import com.zhj.entity.ZhjPopedomTree;
import com.zhj.service.PopedomTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("Popedom")
public class PopedomController {

    @Autowired
    private PopedomTreeService popedomTreeService;

    /**
     * 查询所有的 权限列表 （权限页面）
     * @return
     */
    @RequestMapping("findAllPopedomList")
    @ResponseBody
   public List<ZhjPopedomTree> findAllPopedomList(){
        List<ZhjPopedomTree> allPopedomList = popedomTreeService.findAllPopedomList();
        log.info("查询所有的 权限列表:"+allPopedomList);
        return allPopedomList;
    }

    /**
     * 根据角色id 查询拥有的权限 回显。
     * @param roleId
     * @return
     */
    @RequestMapping("findPopedomListByRoleID")
    @ResponseBody
    public List<ZhjPopedomTree> findPopedomListByRoleID(Integer roleId){
        log.info("根据角色id 查询拥有的权限roleId:"+roleId);
        List<ZhjPopedomTree> popedomListByRoleID = popedomTreeService.findPopedomListByRoleID(roleId);
        return popedomListByRoleID;
    }

    /**
     *  保存角色 权限中间表
     * @param roleId
     * @param podIdList
     * @return
     */
    @RequestMapping("saveRolePopedom")
    @ResponseBody
    public JsonData saveRolePopedom(Integer roleId, @RequestBody List<Integer> podIdList){
//    public JsonData saveRolePopedom(@RequestBody Map<String,Object> jsonMap){
          log.info("角色roleId:"+roleId+"==========权限集合"+podIdList);
//        String roleId = MapToStrUtils.getMapToStr(jsonMap,"roleId");
        boolean flag =  popedomTreeService.saveRolePopedom(roleId,podIdList);
        return JsonData.success(flag);
    }


}
