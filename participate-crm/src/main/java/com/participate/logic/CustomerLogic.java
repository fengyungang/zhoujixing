package com.participate.logic;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.participate.entity.CustomerModel;
import com.participate.entity.SalesmanModel;
import com.participate.entity.WordBookModel;
import com.participate.service.CallLogService;
import com.participate.service.CustomerService;
import com.participate.service.SalesmanService;
import com.participate.service.WordBookService;
import com.participate.utils.DateUtils;
import com.participate.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 客户业务逻辑层
 */
@Component
public class CustomerLogic {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private WordBookService wordBookService;

    /**
     * 添加客户信息
     * @param customerModel
     * @return
     */
    public Result add(CustomerModel customerModel){
        customerModel.setCustomer_create_time(new Date());
        customerModel.setWord_book_code(0);
        int res = customerService.add(customerModel);

        return Result.generate(0,"add customer success",customerModel);
    }

    /**
     * 根据客户id查询客户信息
     * @param customer_id
     * @return
     */
    public Result getById(Integer customer_id){
        CustomerModel customerModel =  customerService.getById(customer_id);
        return Result.generate(0,"select customer success",customerModel);
    }

    /**
     * 查询所有客户的信息列表（可按条件模糊查询）
     * @param salesman_id
     * @param customer_name
     * @param customer_phone_number
     * @param customer_sex
     * @param customer_del
     * @param customer_create_time
     * @param word_book_code
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer salesman_id, String customer_name, String customer_phone_number,String customer_sex,Integer customer_del, String customer_create_time,Integer word_book_code,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("salesman_id",salesman_id);
        map.put("customer_name",customer_name);
        map.put("customer_phone_number",customer_phone_number);
        map.put("customer_sex",customer_sex);
        map.put("customer_del",customer_del);
        if (customer_create_time!=null&&!"".equals(customer_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("customer_create_time", DateUtils.StD(customer_create_time,"yyyy-MM-dd"));
        }
        map.put("word_book_code",word_book_code);
        return Result.generate(0,"select customer success",customerService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据客户id修改客户信息
     * @param customerModel
     * @return
     */
    public Result updCustomer(CustomerModel customerModel){
        int res = customerService.update(customerModel);
        if (res<0){
            return Result.generate(1,"update customer fail ",null);
        }
        return Result.generate(0,"update customer success",customerModel);
    }

    /**
     * 在逻辑上删除客户信息
      * @return customer_id
     */
    public Result delCustomer(Integer customer_id){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomer_id(customer_id);
        customerModel.setCustomer_del(1);
        customerService.update(customerModel);
        return Result.generate(0,"delet customer success",customerModel);
    }

    /**
     * 根据销售id查看自己底下的客户信息功能
     * @param salesman_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public  Result salesmanGetByCustomer(Integer salesman_id,Integer pageIndex,Integer pageSize){
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("salesman_id",salesman_id);

        return Result.generate(0,"select customer success",customerService.selA(map,pageIndex,pageSize));
    }

    /**
     * 销售与销售之间转让客户信息
     * @param customer_id
     * @param salesman_id
     * @return
     */
    public Result salesmanGiveWay(Integer customer_id,Integer salesman_id){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomer_id(customer_id);
        customerModel.setSalesman_id(salesman_id);
        int res = customerService.update(customerModel);
        if (res<0){
            return Result.generate(1,"update customer fail ",null);
        }
        return Result.generate(0,"update customer success",customerModel);
    }

    /**
     * 组长查看底下销售人员的对应客户信息
     * @param salesman_name
     * @param salesman_phone_number
     * @param customer_name
     * @param customer_phone_number
     * @param salesman_parent_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result leaderBySalesmanByCustomer(String salesman_name,String salesman_phone_number,String customer_name,String customer_phone_number,Integer salesman_parent_id,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        // 设置查询条件
        map.put("salesman_name",salesman_name);
        map.put("salesman_phone_number",salesman_phone_number);
        map.put("salesman_parent_id",salesman_parent_id);
        map.put("customer_name",customer_name);
        map.put("customer_phone_number",customer_phone_number);
        map.put("customer_del",0);
        // 根据条件查询所有
        map = customerService.selA(map,pageIndex,pageSize);

        // 获取客户列表
        List<CustomerModel> customerModelList = (List<CustomerModel>) map.get("customerModelList");

        // 查询客户对应销售，将两者写入有一个jsonObject中

        JSONArray jsonArray = new JSONArray();
        // 遍历查询赋值
        for (Iterator<CustomerModel> iterator = customerModelList.iterator(); iterator.hasNext(); ) {

            CustomerModel next =  iterator.next();
            SalesmanModel salesmanModel = salesmanService.getById(next.getSalesman_id());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("customer_id",next.getCustomer_id());
            jsonObject.put("customer_name",next.getCustomer_name());
            jsonObject.put("customer_phone_number",next.getCustomer_phone_number());
            jsonObject.put("customer_sex",next.getCustomer_sex());
            jsonObject.put("customer_address",next.getCustomer_address());
            jsonObject.put("salesman_id",salesmanModel.getSalesman_id());
            jsonObject.put("salesman_name",salesmanModel.getSalesman_name());
            jsonObject.put("salesman_phone_number",salesmanModel.getSalesman_phone_number());
            jsonArray.add(jsonObject);

        }
        // 更改map中的内容，将封装好的对象的集合jsonArray放入返回结果map
        map.put("customerModelList",jsonArray);

        return Result.generate(0,"success",map);
    }

    /**
     *把客户信息，销售信息，字典信息整一块（取销售Id+Name，客户Id+Name+字典Name）
     *
     * @param salesman_id
     * @param customer_name
     * @param customer_phone_number
     * @param customer_sex
     * @param customer_del
     * @param customer_create_time
     * @param word_book_code
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result kehuAxiaoshouAzidian(Integer salesman_id, String customer_name, String customer_phone_number,String customer_sex,Integer customer_del, String customer_create_time,Integer word_book_code,Integer pageIndex,Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> customerMap = new HashMap<>();

        customerMap.put("salesman_id",salesman_id);
        customerMap.put("customer_name",customer_name);
        customerMap.put("customer_phone_number",customer_phone_number);
        customerMap.put("customer_sex",customer_sex);
        customerMap.put("customer_del",customer_del);
        if (customer_create_time!=null&&!"".equals(customer_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            customerMap.put("customer_create_time", DateUtils.StD(customer_create_time,"yyyy-MM-dd"));
        }
        customerMap.put("word_book_code",word_book_code);
        Map<String, Object> map1 = customerService.selA(customerMap, pageIndex, pageSize);
        List<SalesmanModel> salesmanModelList = salesmanService.selA(map);
        List<WordBookModel> wordBookModelList = wordBookService.selA(map);
        //清空map（筛选条件），放入输出结果
        map.clear();
        map.put("kehu",map1);

        map.put("xiaoshou",salesmanModelList);
        map.put("zidian",wordBookModelList);
        return Result.generate(0,"success",map);
    }

    /**
     * 组长查看底下销售人员的对应客户的满意度
     * @param salesman_name
     * @param salesman_phone_number
     * @param customer_name
     * @param customer_phone_number
     * @param salesman_parent_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result leaderBySalesmanByCustomerName(String salesman_name,String salesman_phone_number,String customer_name,String customer_phone_number,Integer salesman_parent_id,Integer word_book_code,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        // 设置查询条件
        map.put("salesman_name",salesman_name);
        map.put("salesman_phone_number",salesman_phone_number);
        map.put("salesman_parent_id",salesman_parent_id);
        map.put("customer_name",customer_name);
        map.put("customer_phone_number",customer_phone_number);
        map.put("word_book_code",word_book_code);
        map.put("customer_del",0);
        // 根据条件查询所有
        map = customerService.selA(map,pageIndex,pageSize);

        // 获取客户列表
        List<CustomerModel> customerModelList = (List<CustomerModel>) map.get("customerModelList");

        // 查询客户对应销售，将两者写入有一个jsonObject中

        JSONArray jsonArray = new JSONArray();
        // 遍历查询赋值
        for (Iterator<CustomerModel> iterator = customerModelList.iterator(); iterator.hasNext(); ) {

            CustomerModel next =  iterator.next();
            SalesmanModel salesmanModel = salesmanService.getById(next.getSalesman_id());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("customer_id",next.getCustomer_id());
            jsonObject.put("customer_name",next.getCustomer_name());
            jsonObject.put("customer_phone_number",next.getCustomer_phone_number());
            jsonObject.put("customer_sex",next.getCustomer_sex());
            jsonObject.put("customer_address",next.getCustomer_address());
            jsonObject.put("salesman_id",salesmanModel.getSalesman_id());
            jsonObject.put("salesman_name",salesmanModel.getSalesman_name());
            jsonObject.put("salesman_phone_number",salesmanModel.getSalesman_phone_number());
            WordBookModel wordBookModel = wordBookService.getByCode(next.getWord_book_code());
            jsonObject.put("word_book_name",wordBookModel.getWord_book_name());
            jsonObject.put("word_book_code",next.getWord_book_code());
            jsonArray.add(jsonObject);
        }
        // 更改map中的内容，将封装好的对象的集合jsonArray放入返回结果map
        map.put("customerModelList",jsonArray);

        return Result.generate(0,"success",map);
    }

    /**
     * 组长查看底下销售人员的对应客户的所有信息
     * @param salesman_name
     * @param salesman_phone_number
     * @param customer_name
     * @param customer_phone_number
     * @param salesman_parent_id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result leaderGetAllInfo(String salesman_name,String salesman_phone_number,String customer_name,String customer_phone_number,Integer salesman_parent_id,Integer word_book_code,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();
        // 设置查询条件
        map.put("salesman_name",salesman_name);
        map.put("salesman_phone_number",salesman_phone_number);
        map.put("salesman_parent_id",salesman_parent_id);
        map.put("customer_name",customer_name);
        map.put("customer_phone_number",customer_phone_number);
        map.put("word_book_code",word_book_code);
        map.put("customer_del",0);
        // 根据条件查询所有
        map = customerService.selA(map,pageIndex,pageSize);

        //查询销售和字典
        List<SalesmanModel> salesmanModelList = salesmanService.selA(new HashMap<String, Object>());
        List<WordBookModel> wordBookModelList = wordBookService.selA(new HashMap<String, Object>());
        //存入返回map中
        map.put("salesmanModelList",salesmanModelList);
        map.put("wordBookModelList",wordBookModelList);
        return Result.generate(0,"success",map);
    }

}