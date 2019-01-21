package com.zhoujixing.controller;

import com.zhoujixing.entity.Store;
import com.zhoujixing.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/addstore")
    public Map<String,Object> addStore(String storeName,String storeAddress,String practiceTime,String storeType,Integer storeStatus,String image,String dutyParagraph,String enterpriseLegalPerson,String phone){
        Map<String,Object> modelMap = new HashMap<>();
        Store store = new Store();
        store.setStoreName(storeName);
        store.setStoreAddress(storeAddress);
        store.setPracticeTime(practiceTime);
        store.setStoreType(storeType);
        store.setStoreStatus(storeStatus);
        store.setImage(image);
        store.setDutyParagraph(dutyParagraph);
        store.setEnterpriseLegalPerson(enterpriseLegalPerson);
        store.setPhone(phone);
        modelMap.put("store",storeService.addStore(store));
        return modelMap;
    }

    @RequestMapping("/getallstore")
    public Map<String,Object> getAllStore(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Store> list = storeService.getAllStore();
        modelMap.put("store",list);
        return modelMap;
    }

    @RequestMapping("/getbyid")
    public Map<String,Object> getById(Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        Store store = storeService.getById(id);
        modelMap.put("store",store);
        return modelMap;
    }

    @RequestMapping("/modifystore")
    public Map<Object,String> modifyStore(Integer id,String storeName,String storeAdress,String practiceTime,String storeType,Integer storeStatus,String image,String dutyParagraph,String enterpriseLegalPerson,String phone){
        Map<Object,String> modelMap = new HashMap<>();
        Store store = storeService.getById(id);
        if (store != null){
            store.setStoreName(storeName);
            store.setStoreAddress(storeAdress);
            store.setPracticeTime(practiceTime);
            store.setStoreType(storeType);
            store.setStoreStatus(storeStatus);
            store.setImage(image);
            store.setDutyParagraph(dutyParagraph);
            store.setEnterpriseLegalPerson(enterpriseLegalPerson);
            store.setPhone(phone);
            storeService.updateStore(store);
            modelMap.put(1,"店铺信息修改成功！");
        }else {
            modelMap.put(0,"店铺不存在！");
        }
        return modelMap;
    }

    @RequestMapping("/removestore")
    public Map<Object,String> removeStore(Integer id){
        Map<Object,String> modelMap = new HashMap<>();
        if (storeService.removeStore(id)){
            modelMap.put(1,"删除成功！");
        }else {
            modelMap.put(0,"店铺不存在！");
        }
        return modelMap;
    }
}
