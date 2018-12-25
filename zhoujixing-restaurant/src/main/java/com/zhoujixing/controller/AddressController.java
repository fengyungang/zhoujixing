package com.zhoujixing.controller;

import com.zhoujixing.entity.Address;
import com.zhoujixing.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/addaddress")
    public Map<String,Object> addAddress(Integer buyerId,Integer storeId,String province,String city,String area,String detailedAddress,Integer isDefault){
        Map<String,Object> modelMap = new HashMap<>();
        Address address = new Address();
        address.setBuyerId(buyerId);
        address.setStoreId(storeId);
        address.setProvince(province);
        address.setCity(city);
        address.setArea(area);
        address.setDetailedAddress(detailedAddress);
        address.setIsDefault(isDefault);
        modelMap.put("address",addressService.addAddress(address));
        return modelMap;
    }

    @RequestMapping("/getbyid")
    public Map<String,Object> getById(Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        Address address = addressService.getById(id);
        modelMap.put("address",address);
        return modelMap;
    }

    @RequestMapping("/getbybuyerid")
    public Map<String,Object> getByBuyerId(Integer buyerId){
        Map<String,Object> modelMap = new HashMap<>();
        Address address = addressService.getByBuyerId(buyerId);
        modelMap.put("address",address);
        return modelMap;
    }

    @RequestMapping("/getbystoreid")
    public Map<String,Object> getByStoreId(Integer storeId){
        Map<String,Object> modelMap = new HashMap<>();
        Address address = addressService.getByStoreId(storeId);
        modelMap.put("address",address);
        return modelMap;
    }

    @RequestMapping("/modifyaddress")
    public Map<Object,String> modifyAddress(Integer id,Integer buyerId,Integer storeId,String province,String city,String area,String detailedAddress,Integer isDefault){
        Map<Object,String> modelMap = new HashMap<>();
        Address address = addressService.getById(id);
        if (address != null){
            address.setBuyerId(buyerId);
            address.setStoreId(storeId);
            address.setProvince(province);
            address.setCity(city);
            address.setArea(area);
            address.setDetailedAddress(detailedAddress);
            address.setIsDefault(isDefault);
            addressService.modifyAddress(address);
            modelMap.put(1,"地址修改成功！");
        }else {
            modelMap.put(0,"地址不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removeaddress")
    public Map<Object,String> removeAddress(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (addressService.removeAddress(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"地址不存在！");
        }
        return modelMap;
    }

}
