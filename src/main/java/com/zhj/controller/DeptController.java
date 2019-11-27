package com.zhj.controller;

import com.zhj.common.JsonData;
import com.zhj.entity.ZhjDept;
import com.zhj.service.DeptService;
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
@RequestMapping("dept")
@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     *  新增部门
     * @param dept
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public JsonData save(@RequestBody ZhjDept dept){
        try {
            log.info("保存部门参数"+dept);
            boolean flag =  deptService.save(dept);
            if(flag){
                return JsonData.success(flag,"保存部门成功。。");
            }
            return JsonData.fail("保存部门失败！！！");
        } catch (Exception e) {
            log.error("保存部门异常"+e.getMessage());
        }
        return JsonData.fail("保存部门失败！！！");
    }

    /**
     *  查询部门列表
     * @param pageQuery
     * @return
     */
    @RequestMapping("queryDeptList")
    @ResponseBody
    public JsonData queryDeptList(@RequestBody PageQuery pageQuery){
        log.info("查询部门列表分页参数:"+pageQuery);
        //查询部门的列表
        PageResult<ZhjDept> list = deptService.queryDeptList(pageQuery);
        if(list.getData() != null &&list.getTotal() != 0){
            return  JsonData.success(list,"查询用户列表成功！");
        }
        return JsonData.fail("查询用户列表失败");
    }
    //删除单个部门
    @RequestMapping("deleteDeptByPrimaryKey")
    @ResponseBody
    public JsonData deleteDeptByPrimaryKey(Integer deptId){
        log.info("删除部门的deptId："+deptId);
        boolean flag = deptService.deleteDeptByPrimaryKey(deptId);
        if(flag){
            return JsonData.success(flag,"删除部门成功！");
        }
        return JsonData.fail("删除部门失败！");
    }
    //批量删除部门
    @RequestMapping("batchdeleteDept")
    @ResponseBody
    public JsonData batchdeleteDept(@RequestBody List<Integer> idList){
        log.info("批量删除部门id集合"+idList);
        boolean flag = deptService.batchdeleteDept(idList);
        if(flag){
            return JsonData.success(flag,"批量删除部门成功！");
        }
        return JsonData.fail("批量删除部门失败！");
    }
    ////根据 部门 id 查询 部门
    @RequestMapping("selectDepthById")
    @ResponseBody
    public JsonData selectDepthById(Integer deptId){
        log.info("部门deptId:"+deptId);
        ZhjDept zhjDept = deptService.selectDepthById(deptId);
        if(zhjDept.getDeptName() !=null){
            return JsonData.success(zhjDept,"查询部门成功！");
        }
        return JsonData.fail("查询部门失败deptId:"+deptId);
    }
    //根据 部门 id 修改部门
    @RequestMapping("updateDeptById")
    @ResponseBody
    public JsonData updateDeptById(@RequestBody ZhjDept zhjDept){
        boolean flag = deptService.updateDeptById(zhjDept);
        if(flag){
            return  JsonData.success(flag,"修改部门成功！");
        }
        return  JsonData.fail("修改部门失败！");
    }


}
