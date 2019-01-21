package com.zhoujixing.controller;

import com.zhoujixing.entity.CooperateEntity;
import com.zhoujixing.service.CooperateService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 合作申请业务逻辑层
 */
@io.swagger.annotations.Api(value="cooperate接口", tags="cooperate接口")
@RestController
@RequestMapping("cooperate")
public class CooperateController {
    @Autowired
    private CooperateService cooperateService;

    /**
     * 添加合作申请人信息
     * @param cooperateEntity
     * @return
     */
    @ApiOperation(value = "添加合作申请人信息", notes = "addCooperate接口的添加合作申请人信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperate_corporate_name", value = "公司名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_subsector", value = "从属行业", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_province", value = "所属省份", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_city", value = "所属城市", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_area", value = "所属区县", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_linkman", value = "联系人", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_phone", value = "联系电话", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_qq", value = "QQ号码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("/addCooperate")
    public Result addCooperate(CooperateEntity cooperateEntity) {
        System.out.println(cooperateEntity.toString());
        cooperateService.add(cooperateEntity);
        return Result.generate(0, "add Cooperate success", cooperateEntity);
    }

   /* //添加一条数据
    @ApiOperation("添加一条记录")
    @RequestMapping(value = "/addC",method = RequestMethod.POST)
    public String addPerson(@ModelAttribute CooperateEntity cooperateEntity){
        CooperateEntity c = new CooperateEntity();
        c.setCooperate_corporate_name(c.getCooperate_corporate_name());
        c.setCooperate_subsector(c.getCooperate_subsector());
        c.setCooperate_province(c.getCooperate_province());
        c.setCooperate_city(c.getCooperate_city());
        c.setCooperate_area(c.getCooperate_area());
        c.setCooperate_linkman(c.getCooperate_linkman());
        c.setCooperate_phone(c.getCooperate_phone());
        c.setCooperate_qq(c.getCooperate_qq());
        cooperateService.add(c);
        return "success";
    }*/

    /**
     * 修改申请合作人的信息状态
     * @param cooperate_id
     * @param cooperate_state
     * @return
     */
    @ApiOperation(value = "修改申请合作人的信息状态", notes = "updCooperate接口的修改申请合作人的信息状态方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperate_id", value = "合作申请表主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_state", value = "状态（0未读，1是已读）", required = true, dataType = "Integer", paramType = "query")
    })

    @PutMapping("/updCooperate")
    public Result updCooperate(Integer cooperate_id,Integer cooperate_state) {
        CooperateEntity c = new CooperateEntity();
        c.setCooperate_id(cooperate_id);
        c.setCooperate_state(cooperate_state);
        int res = cooperateService.update(c);
        if (res < 0) {
            return Result.generate(1, "update Cooperate fail ", null);
        }
        return Result.generate(0, "update Cooperate success", c);
    }

    /**
     * 查询合作申请人的列表信息（可按条件模糊查询）
     * @param cooperate_corporate_name
     * @param cooperate_subsector
     * @param cooperate_province
     * @param cooperate_city
     * @param cooperate_area
     * @param cooperate_linkman
     * @param cooperate_phone
     * @param cooperate_qq
     * @param cooperate_state
     * @param cooperate_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询合作申请人的列表信息（可按条件模糊查询）",notes = "selACooperate接口的查询合作申请人的列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cooperate_corporate_name", value = "公司名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_subsector", value = "从属行业", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_province", value = "所属省份", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_city", value = "所属城市", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_area", value = "所属区县", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_linkman", value = "联系人", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_phone", value = "联系电话", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_qq", value = "QQ号码", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_state", value = "状态（0未读，1是已读）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "cooperate_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selACooperate")
    public Result selACooperate(String cooperate_corporate_name, String cooperate_subsector, String cooperate_province,String cooperate_city, String cooperate_area,String cooperate_linkman,String cooperate_phone,String cooperate_qq,Integer cooperate_state,String cooperate_create_time,Integer pageIndex,Integer pageSize)
    {
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("cooperate_corporate_name",cooperate_corporate_name);
        map.put("cooperate_subsector",cooperate_subsector);
        map.put("cooperate_province",cooperate_province);
        map.put("cooperate_city",cooperate_city);
        map.put("cooperate_area",cooperate_area);
        map.put("cooperate_linkman",cooperate_linkman);
        map.put("cooperate_phone",cooperate_phone);
        map.put("cooperate_qq",cooperate_qq);
        map.put("cooperate_state",cooperate_state);
        map.put("cooperate_create_time",cooperate_create_time);
        if (cooperate_create_time!=null&&!"".equals(cooperate_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("cooperate_create_time", DateUtils.StD(cooperate_create_time,"yyyy-MM-dd HH:mm:ss"));
        }
        return Result.generate(0,"select Cooperate success",cooperateService.selA(map,pageIndex,pageSize));
    }

}

