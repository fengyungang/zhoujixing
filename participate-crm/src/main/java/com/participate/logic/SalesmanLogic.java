package com.participate.logic;

import com.participate.entity.SalesmanModel;
import com.participate.service.SalesmanService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 销售人员业务逻辑层
 */
@Component
public class SalesmanLogic {
    @Autowired
    private SalesmanService salesmanService;

    /**
     * 添加销售人员信息
     * @param salesmanModel
     * @return
     */
    public Result add(SalesmanModel salesmanModel){
        salesmanModel.setSalesman_create_time(new Date());
        int res = salesmanService.add(salesmanModel);
        return Result.generate(0,"add salesman success",salesmanModel);
    }

    /**
     * 根据销售人员id删除销售人员信息（物理删除）
     * @param salesman_id
     * @return
     */
    public Result delete(Integer salesman_id){
        if (salesman_id != null){
            int res = salesmanService.delById(salesman_id);
            return Result.generate(0,"delete salesman success",res);
        }
        return Result.generate(1,"delete salesman fail",null);
    }

    /**
     * 根据id修改销售人员信息
     * @param salesmanModel
     * @return
     */
    public Result update(SalesmanModel salesmanModel){
        int res = salesmanService.update(salesmanModel);
        if (res<0){
            return Result.generate(1,"update salesman fail",null);
        }
        return  Result.generate(0,"update salesman success",salesmanModel);
    }

    /**
     * 根据id查询单条销售人员信息
     * @param salesman_id
     * @return
     */
    public Result selO(Integer salesman_id){
        SalesmanModel salesmanModel = new SalesmanModel();

        salesmanModel = salesmanService.getById(salesman_id);
        salesmanModel.setSalesman_password("");
        return Result.generate(0,"select salesman success",salesmanModel);
    }

    /**
     * 查询所有销售人员信息列表（可按条件模糊查询）
     * @param salesman_parent_id
     * @param salesman_name
     * @param salesman_phone_number
     * @param salesman_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selA(Integer salesman_parent_id,String salesman_name,String salesman_phone_number, String salesman_create_time ,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        map.put("salesman_parent_id",salesman_parent_id);
        map.put("salesman_name",salesman_name);
        map.put("salesman_phone_number",salesman_phone_number);
        if (salesman_create_time!=null&&!"".equals(salesman_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("salesman_create_time", DateUtils.StD(salesman_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select salesman success",salesmanService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据身份标识查看所属一个组长的销售人员信息功能(展示组长列表信息)
     * @param salesman_parent_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result leaderGetBySalesman (Integer salesman_parent_id,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        map.put("salesman_parent_id",salesman_parent_id);
        return Result.generate(0,"select salesman success",salesmanService.selA(map,pageIndex,pageSize));
    }

    /**
     * 管理员给销售人员分配角色
     * @param salesman_id
     * @param salesman_parent_id
     * @return
     */
    public Result leaderGiveRole(Integer salesman_id,Integer salesman_parent_id){
        SalesmanModel salesmanModel = new SalesmanModel();
        salesmanModel.setSalesman_id(salesman_id);
        salesmanModel.setSalesman_parent_id(salesman_parent_id);
        int res = salesmanService.update(salesmanModel);
        if (res<0){
            return Result.generate(1,"update salesman fail ",null);
        }
        return Result.generate(0,"update salesman success",salesmanModel);
    }


}
