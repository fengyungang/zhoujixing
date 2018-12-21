package com.participate.dao;

import com.participate.entity.CallLogModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CallLogMapper {
    /**
     * 添加方法
     * @param callLogModel
     * @return
     */
    int add(CallLogModel callLogModel);

    /**
     * 根据id查询一条信息
     * @param call_log_id
     * @return
     */
    CallLogModel getById(Integer call_log_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<CallLogModel> selA(Map<String,Object> map);

    /**
     * 根据id修改某条信息
     * @param callLogModel
     * @return
     */
    int update(CallLogModel callLogModel);

}
