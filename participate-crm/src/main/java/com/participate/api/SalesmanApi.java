package com.participate.api;

import com.participate.entity.SalesmanModel;
import com.participate.logic.SalesmanLogic;
import com.participate.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 销售人员api层
 */
@io.swagger.annotations.Api(value="salesman接口", tags="salesman接口")
@RestController
@RequestMapping("api/salesman")
public class SalesmanApi extends BaseApi{
    @Autowired
    private SalesmanLogic salesmanLogic;

    /**
     * 添加销售人员信息
     * @param token
     * @param salesmanModel
     * @return
     */
    @ApiOperation(value = "添加销售人员信息",notes = "addSalesman接口的添加销售人员信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_parent_id", value = "身份标识（可以为空，当为0时是组长，为其他值时是所属组长）", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "salesman_name", value = "姓名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "salesman_phone_number", value = "手机号", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "salesman_password", value = "密码", required = true, dataType = "String", paramType = "form")

    })
    @ResponseBody
    @PostMapping("/addSalesman")
    public Result addSalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      SalesmanModel salesmanModel)
    {
        return salesmanLogic.add(salesmanModel);
    }

    /**
     * 删除销售人员信息（根据id）
     * @param token
     * @param salesman_id
     * @return
     */
    @ApiOperation(value = "删除销售人员信息",notes = "delSalesman接口的删除销售人员信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @DeleteMapping("/delSalesman")
    public Result delSalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              Integer salesman_id)
    {
        return salesmanLogic.delete(salesman_id);
    }

    /**
     * 修改销售人员信息
     * @param token
     * @param salesmanModel
     * @return
     */
    @ApiOperation(value = "修改销售人员信息",notes = "updSalesman接口的修改销售人员信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/updSalesman")
    public Result updSalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              SalesmanModel salesmanModel)
    {
        return salesmanLogic.update(salesmanModel);
    }

    /**
     * 查询销售人员列表信息（可按条件模糊查询）
     * @param token
     * @param salesman_parent_id
     * @param salesman_name
     * @param salesman_phone_number
     * @param salesman_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询销售人员列表信息（可按条件模糊查询）",notes = "selASalesman接口的查询销售人员列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_parent_id", value = "身份标识（可以为空，当为0时是组长，为其他值时是所属组长）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "salesman_name", value = "姓名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "salesman_phone_number", value = "手机号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "salesman_password", value = "密码", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "salesman_create_time", value = "创建时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selASalesman")
    public Result selASalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer salesman_parent_id,String salesman_name,String salesman_phone_number, String salesman_create_time ,Integer pageIndex,Integer pageSize)
    {
        return salesmanLogic.selA(salesman_parent_id,salesman_name,salesman_phone_number,salesman_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id查询单条销售人员信息
     * @param token
     * @param salesman_id
     * @return
     */
    @ApiOperation(value = "根据id查询单条销售人员信息",notes = "selOSalesman接口的查询单条销售人员信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员信息表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOSalesman")
    public Result selOSalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer salesman_id)
    {
        return salesmanLogic.selO(salesman_id);
    }

    /**
     * 根据身份标识查看所属一个组长的销售人员信息功能(展示组长列表信息)
     * @param token
     * @param salesman_parent_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "根据身份标识查看所属一个组长的销售人员信息功能(展示组长列表信息)",notes = "leaderGetBySalesman接口的根据身份标识查看所属一个组长的销售人员信息方法(展示组长列表信息)", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_parent_id", value = "身份标识（可以为空，当为0时是组长，为其他值时是所属组长）", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/leaderGetBySalesman")
    public Result leaderGetBySalesman(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                                        Integer salesman_parent_id,Integer pageIndex,Integer pageSize)
    {
        return salesmanLogic.leaderGetBySalesman(salesman_parent_id,pageIndex,pageSize);
    }

    /**
     * 管理员给销售人员分配角色
     * @param token
     * @param salesman_id
     * @param salesman_parent_id
     * @return
     */
    @ApiOperation(value = "管理员给销售人员分配角色",notes = "leaderGiveRole接口的管理员给销售人员分配角色方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesman_id", value = "销售人员信息表主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "salesman_parent_id", value = "身份标识（可以为空，当为0时是组长，为其他值时是所属组长）", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @PutMapping("/leaderGiveRole")
    public Result leaderGiveRole(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                                  Integer salesman_id,Integer salesman_parent_id)
    {
        return salesmanLogic.leaderGiveRole(salesman_id,salesman_parent_id);
    }


}
