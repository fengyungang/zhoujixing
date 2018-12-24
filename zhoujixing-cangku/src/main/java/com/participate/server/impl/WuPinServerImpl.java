package com.participate.server.impl;

import com.participate.entity.*;
import com.participate.mapper.WuPinMapper;
import com.participate.server.WuPinServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class WuPinServerImpl implements WuPinServer {

    @Autowired
    private WuPinMapper wuPinMapper;
    @Override
    public int insertWuPin(MenuEntity menuEntity) {
        return wuPinMapper.insertWuPin(menuEntity);
    }

    @Override
    public List<MenuEntity> selecatSuoyou() {
        return wuPinMapper.selecatSuoyou();
    }

    @Override
    public List<MenuEntity> selectWuPin(int fuid) {

        return wuPinMapper.selectWuPin(fuid);
    }

    @Override
    public boolean deleteWuPin(int id) {
        if(id > 0){
            try{
                //删除区域信息
                int effectedNum = wuPinMapper.delete(id);
                if(effectedNum > 0){
                    return true;
                }else {
                    throw  new RuntimeException("删除信息失败!");
                }
            }catch (Exception e){
                throw  new RuntimeException("删除信息失败:"+e.toString());
            }

        }else{
            throw  new RuntimeException("id不能为空!");

        }
    }

    @Override
    public List<MenuEntity> deleteCangku(String name) {
        return wuPinMapper.deleteCangku(name);
    }

    @Override
    public List<MenuEntity> selectCangKu(int id) {
        return wuPinMapper.selectCangKu(id);
    }

    @Override
    public int insertCangKu(MenuEntity menuEntity) {
        return wuPinMapper.insertCangKu(menuEntity);
    }




    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * 插入物品信息模块
     */
    /**
     * 插入字典表
     * 单位表
     */
    @Override
    public int insertDanWei(CompanyEntity companyEntity) {
        return wuPinMapper.insertDanWei(companyEntity);
    }

    //比较名字不能重复
    @Override
    public List<CompanyEntity> selectDanWei() {
        return wuPinMapper.selectDanWei();
    }

    //修改单位表的状态，1改0
    @Override
    public int updateDanWei(int dan_id) {
        return wuPinMapper.updateDanWei(dan_id);
    }

    //查询出状态1下的数据
    @Override
    public List<CompanyEntity> selectDanWeia() {
        return wuPinMapper.selectDanWeia();
    }

    @Override
    public int deleteDanWei(int dan_id) {
        return wuPinMapper.deleteDanWei(dan_id);
    }


    //修改单位表的数据
    @Override
    public int xiugaiDanWei(CompanyEntity companyEntity) {
        return wuPinMapper.xiugaiDanWei(companyEntity);
    }

    @Override
    public List<CompanyEntity> chaxunDanWei(String name) {
        return wuPinMapper.chaxunDanWei(name);
    }



    /**
     * 品牌表的修改
     */
    //品牌表的插入语句
    @Override
    public int insertPinPai(DrandEntity drandEntity) {
        return wuPinMapper.insertPinPai(drandEntity);
    }

    @Override
    public List<DrandEntity> selectPinPai() {
        return wuPinMapper.selectPinPai();
    }

    @Override
    public List<DrandEntity> selectPinPaia() {
        return wuPinMapper.selectPinPaia();
    }

    @Override
    public int xiugaiPinPai(int id) {
        return wuPinMapper.xiugaiPinPai(id);
    }

    @Override
    public String deletePinPai(int id) {
        int  aa=wuPinMapper.deletePinPai(id);
        if (aa!=0){
            return "删除成功";
        }else {
            return "删除失败";
        }

    }

    @Override
    public List<DrandEntity> namePinPai(String name) {
        return wuPinMapper.namePinPai(name);
    }

    @Override
    public int xiunamePinPai(DrandEntity drandEntity) {
        return wuPinMapper.xiunamePinPai(drandEntity);
    }

    /**
     * 物品插入模块
     * 插入物品的信息
     */
    @Override
    public int insertgoods(CaruEntity caruEntity) {
        return wuPinMapper.insertgoods(caruEntity);
    }

    /*
       树形表的操作
       通过物品名查询出id的信息
     */
    @Override
    public List<CaruEntity> nameupdateshuxing(String name) {
        return wuPinMapper.nameupdateshuxing(name);
    }

    @Override
    public int updateshuxing(CaruEntity caruEntity) {
        return wuPinMapper.updateshuxing(caruEntity);
    }

    @Override
    public List<CaruEntity> nameselectDanwei(String name) {
        return wuPinMapper.nameselectDanwei(name);
    }

    @Override
    public List<CaruEntity> nameselectPinpai(String name) {
        return wuPinMapper.nameselectPinpai(name);
    }

    @Override
    public List<CaruEntity> nameselectWupin(int shuid) {
        return wuPinMapper.nameselectWupin(shuid);
    }

    @Override
    public List<CaruEntity> pinselectwupin(int pinid) {
        return wuPinMapper.pinselectwupin(pinid);
    }

    @Override
    public List<CaruEntity> danselectwupin(int danid) {
        return wuPinMapper.danselectwupin(danid);
    }

    @Override
    public int deletenamewupin(String name) {
        return wuPinMapper.deletenamewupin(name);
    }

    @Override
    public int updatenamewupin(CaruEntity caruEntity) {
        return wuPinMapper.updatenamewupin(caruEntity);
    }

    @Override
    public List<CaruEntity> nameselectwupina(String name) {
        return wuPinMapper.nameselectwupina(name);
    }

    @Override
    public List<MenuEntity> selectsy(String name) {
        return wuPinMapper.selectsy(name);
    }

    @Override
    public List<ChuruEntity> selectshuxing(String name) {
        return wuPinMapper.selectshuxing(name);
    }

    @Override
    public List<ChuruEntity> selectwupin(ChuruEntity churuEntity) {
        return wuPinMapper.selectwupin(churuEntity);
    }

    @Override
    public int updatewupin(ChuruEntity churuEntity) {
        return wuPinMapper.updatewupin(churuEntity);
    }

    @Override
    public int insertchuruku(ChuruEntity churuEntity) {
        return wuPinMapper.insertchuruku(churuEntity);
    }

    @Override
    public List<ChuruEntity> kucunselect(ChuruEntity churuEntity) {
        return wuPinMapper.kucunselect(churuEntity);
    }

    @Override
    public List<MenuEntity> fuidselect(int id) {
        return wuPinMapper.fuidselect(id);
    }

    @Override
    public List<ChuruEntity> cangkunameselect(ChuruEntity churuEntity) {
        return wuPinMapper.cangkunameselect(churuEntity);
    }

    @Override
    public List<ChuruEntity> fubenselect(ChuruEntity churuEntity) {
        return wuPinMapper.fubenselect(churuEntity);
    }

    @Override
    public List<ChuruEntity> youwupinselect(ChuruEntity churuEntity) {
        return wuPinMapper.youwupinselect(churuEntity);
    }

    @Override
    public List<ChuruEntity> youwupinselecta(ChuruEntity churuEntity) {
        return wuPinMapper.youwupinselecta(churuEntity);
    }

    @Override
    public List<ChuruEntity> zhiyouwupin(ChuruEntity churuEntity) {
        return wuPinMapper.zhiyouwupin(churuEntity);
    }

    @Override
    public List<ChuruEntity> youfenlwup(ChuruEntity churuEntity) {
        return wuPinMapper.youfenlwup(churuEntity);
    }

    @Override
    public List<ChuruEntity> suoyou() {
        return wuPinMapper.suoyou();
    }

    @Override
    public List<ChuruEntity> banxiaoshi() {
        return wuPinMapper.banxiaoshi();
    }

    @Override
    public List<ChuruEntity> tongji(ChuruEntity churuEntity) {
        return wuPinMapper.tongji(churuEntity);
    }
    public List<ChuruEntity> tongjia(ChuruEntity churuEntity) {
        return wuPinMapper.tongjia(churuEntity);
    }

}



