package com.zhj.controller;

import com.zhj.common.JsonData;
import com.zhj.service.SysPopedomTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tree")
public class SysPopedomTree {

    @Autowired
    private SysPopedomTreeService sysPopedomTreeService;

    @RequestMapping("podedomTree")
    @ResponseBody
    public JsonData tree(@RequestBody List<Integer> midList) {
//        midList.add(1);
//        midList.add(17);
        return JsonData.success(sysPopedomTreeService.getAllPopedom(midList));
    }

}
