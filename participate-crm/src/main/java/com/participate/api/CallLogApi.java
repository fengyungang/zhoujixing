package com.participate.api;

import com.participate.entity.CallLogModel;
import com.participate.logic.CallLogLogic;
import com.participate.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通话记录信息api层
 */
@io.swagger.annotations.Api(value="call_log接口", tags="call_log接口")
@RestController
@RequestMapping("api/call_log")
public class CallLogApi extends BaseApi{
    @Autowired
    private CallLogLogic callLogLogic;

    /**
     * 添加通话记录信息
     * @param token
     * @param callLogModel
     * @return
     */
    @ApiOperation(value = "新增通话记录信息",notes = "addCustomer接口的添加通话记录信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表id（关联外键）", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "call_log_content", value = "联系内容", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "call_log_customer_feedback", value = "客户反馈", required = true, dataType = "String", paramType = "form")

    })
    @ResponseBody
    @PostMapping("/addCallLog")
    public Result addCallLog(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CallLogModel callLogModel)
    {
        return callLogLogic.add(callLogModel);
    }

    /**
     * 查询通话记录列表信息（可按条件模糊查询）
     * @param token
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
    @ApiOperation(value = "查询通话记录列表信息（可按条件模糊查询）",notes = "selACallLog接口的查询客户列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customer_id", value = "客户表id（关联外键）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "salesman_id", value = "销售人员id（关联外键）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "call_log_content", value = "联系内容", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "call_log_customer_feedback", value = "客户反馈", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "call_log_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "call_log_contact_time", value = "联系时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selACallLog")
    public Result selACallLog(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer customer_id, Integer salesman_id, String call_log_content,String call_log_customer_feedback, String call_log_create_time,String call_log_contact_time,Integer pageIndex,Integer pageSize)
    {
        return callLogLogic.selA(customer_id,salesman_id,call_log_content,call_log_customer_feedback,call_log_create_time,call_log_contact_time,pageIndex,pageSize);
    }

    /**
     * 根据id查询单条通话记录信息
     * @param token
     * @param call_log_id
     * @return
     */
    @ApiOperation(value = "根据id查询单条通话记录信息",notes = "selOCallLog接口的查询单条通话记录信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "call_log_id", value = "通话记录信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOCallLog")
    public Result selOCallLog(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer call_log_id)
    {
        return callLogLogic.getById(call_log_id);
    }

    /**
     * 修改客户信息
     * @param token
     * @param callLogModel
     * @return
     */
    @ApiOperation(value = "修改通话记录信息",notes = "updCallLog接口的修改通话记录信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "call_log_id", value = "通话记录信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/updCallLog")
    public Result updCallLog(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CallLogModel callLogModel)
    {
        return callLogLogic.update(callLogModel);
    }
}











