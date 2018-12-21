package com.participate.logic;

import com.participate.entity.CallLogModel;
import com.participate.service.CallLogService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通话记录业务逻辑层
 */
@Component
public class CallLogLogic {
    @Autowired
    private CallLogService callLogService;

    /**
     * 添加通话记录信息
     * @param callLogModel
     * @return
     */
    public Result add(CallLogModel callLogModel){
        callLogModel.setCall_log_create_time(new Date());
        callLogModel.setCall_log_contact_time(new Date());
        int res = callLogService.add(callLogModel);
        return Result.generate(0,"add call_log success",callLogModel);
    }

    /**
     * 根据通话记录id查询通话记录信息
     * @param call_log_id
     * @return
     */
    public Result getById(Integer call_log_id){
       CallLogModel callLogModel =  callLogService.getById(call_log_id);
       return  Result.generate(0,"select call_log success",callLogModel);
    }

    /**
     * 查询所有通话记录信息列表（可按条件模糊查询）
     * @param customer_id
     * @param salesman_id
     * @param call_log_content
     * @param call_log_customer_feedback
     * @param call_log_create_time
     * @param call_log_contact_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selA(Integer customer_id,Integer salesman_id,String call_log_content,String call_log_customer_feedback,String call_log_create_time,String call_log_contact_time,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("customer_id",customer_id);
        map.put("salesman_id",salesman_id);
        map.put("call_log_content",call_log_content);
        map.put("call_log_customer_feedback",call_log_customer_feedback);
        if (call_log_create_time!=null&&!"".equals(call_log_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("call_log_create_time", DateUtils.StD(call_log_create_time,"yyyy-MM-dd"));
        }
        if (call_log_contact_time!=null&&!"".equals(call_log_contact_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("call_log_contact_time", DateUtils.StD(call_log_contact_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select call_log success",callLogService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据通话记录信息表id更改通话记录信息
     * @param callLogModel
     * @return
     */
    public Result update(CallLogModel callLogModel){
        callLogModel.setCall_log_contact_time(new Date());
        int res = callLogService.update(callLogModel);
        if (res<0){
            return Result.generate(1,"update call_log fail ",null);
        }
        return Result.generate(0,"update call_log success",callLogModel);
    }
}