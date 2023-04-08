package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: w3143087
 * @description: 嘉宾信息Dao层
 * @date: 2023/04/07 16:06
 */
public interface MemberDao {
    /**
     * 新增嘉宾信息
     */
    int addMember(JSONObject jsonObject);

    /**
     * 统计嘉宾信息总数
     */
    int countMember(JSONObject jsonObject);

    /**
     * 嘉宾信息列表
     */
    List<JSONObject> listMember(JSONObject jsonObject);

    /**
     * 更新嘉宾信息
     */
    int updateMember(JSONObject jsonObject);

    /**
     * 删除当前选中的嘉宾信息
     */
    int deleteMember(JSONObject jsonObject);

    /**
     * 嘉宾信息检索
     */
    List<JSONObject> searchMember(JSONObject jsonObject);
}
