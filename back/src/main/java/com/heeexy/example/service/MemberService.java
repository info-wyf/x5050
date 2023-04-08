package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.MemberDao;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: w3143087
 * @date: 2023/04/07 16:07
 */
@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    /**
     * 新增嘉宾信息
     */
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addMember(JSONObject jsonObject) {
        memberDao.addMember(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 嘉宾信息列表
     */
    public JSONObject listMember(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = memberDao.countMember(jsonObject);
        List<JSONObject> list = memberDao.listMember(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 更新嘉宾信息
     */
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateMember(JSONObject jsonObject) {
        memberDao.updateMember(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 删除嘉宾信息
     */
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteMember(JSONObject jsonObject) {
        memberDao.deleteMember(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 嘉宾信息检索
     */
    public JSONObject searchMember(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = memberDao.countMember(jsonObject);
        List<JSONObject> list = memberDao.searchMember(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
