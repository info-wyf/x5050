package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.config.annotation.RequiresPermissions;
import com.heeexy.example.service.MemberService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: heeexy
 * @description: 嘉宾信息相关Controller
 * @date: 2017/10/24 16:04
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 查询嘉宾信息列表
     */
    @RequiresPermissions("member:list")
    @GetMapping("/listMember")
    public JSONObject listMember(HttpServletRequest request) {
        return memberService.listMember(CommonUtil.request2Json(request));
    }

    /**
     * 新增嘉宾信息
     */
    @RequiresPermissions("member:add")
    @PostMapping("/addMember")
    public JSONObject addMember(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return memberService.addMember(requestJson);
    }

    /**
     * 修改嘉宾信息
     */
    @RequiresPermissions("member:update")
    @PostMapping("/updateMember")
    public JSONObject updateMember(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return memberService.updateMember(requestJson);
    }

    /**
     * 删除嘉宾信息
     */
    @RequiresPermissions("member:delete")
    @PostMapping("/deleteMember")
    public JSONObject deleteMember(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id");
        return memberService.deleteMember(requestJson);
    }

    /**
     * 按条件检索嘉宾信息信息
     */
    @RequiresPermissions("member:list")
    @GetMapping("/searchMember")
    public JSONObject searchMember(HttpServletRequest request) {
        return memberService.searchMember(CommonUtil.request2Json(request));
    }
}
