package com.participate.server;

import com.participate.entity.*;

import java.util.List;


public interface WuPinServer {
    //插入仓库名
    int insertWuPin(MenuEntity menuEntity);

    /**\
     * 查询所有数据
     * @param
     * @return
     */
    List<MenuEntity> selecatSuoyou();

    //查询仓库名
    List<MenuEntity> selectWuPin(int fuid);

    //删除仓库名
    boolean deleteWuPin(int id);

    /**
     * 通过名字查询父id
     */
    List<MenuEntity> deleteCangku(String name);

    /**
     * 查询id查询有父id的个数
     */
    List<MenuEntity> selectCangKu(int id);
    /**
     * 插入仓库数据
     * @param menuEntity
     * @return
     */
    int insertCangKu(MenuEntity menuEntity);


    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * 插入物品信息模块
     */
    /**
     * 插入字典表
     * 单位表
     */

    //插入数据
    int insertDanWei(CompanyEntity companyEntity);
    //比较名字不能重复查询出来是状态0下的数据
    List<CompanyEntity> selectDanWei();

    //修改单位表的状态，1改0
    int updateDanWei(int dan_id);

    //查询出状态1下的数据
    List<CompanyEntity> selectDanWeia();
    //删除单位表的数据
    int deleteDanWei(int dan_id);

    //修改单位表的数据
    int xiugaiDanWei(CompanyEntity companyEntity);
    //通过名称查询出id
    List<CompanyEntity> chaxunDanWei(String name);



    /**
     * 品牌表的修改
     */
    //品牌表的插入语句
    int insertPinPai(DrandEntity drandEntity);

    //查询品牌表里状态0下的数据
    List<DrandEntity> selectPinPai();

    //查询品牌表里状态1下的数据
    List<DrandEntity> selectPinPaia();

    //如果查询出来的数据有这一条就不用插入了
    //吧本条数据的状态改成0就可以了
    int xiugaiPinPai(int id);

    //品牌表的状态下的删除
    String deletePinPai(int id);

    //通过name查询出自己的数据
    List<DrandEntity> namePinPai(String name);

    //修改品牌表的数据
    int xiunamePinPai(DrandEntity drandEntity);


    /**
     * 物品插入模块
     * 插入物品的信息
     */
    int insertgoods(CaruEntity caruEntity);

    /*
       树形表的操作
       通过物品名查询出id的信息
     */
    List<CaruEntity> nameupdateshuxing(String name);

    /*
      把物品的插入数据所返回 的实时id插入到树形表中
     */
    int updateshuxing(CaruEntity caruEntity);

    /*
      单位表
      通过名称查询出所有数据
     */
    List<CaruEntity> nameselectDanwei(String name);

    /*
      品牌表
      通过名称查询出所有数据
     */
    List<CaruEntity> nameselectPinpai(String name);
    /*
    物品表查询物品的信息
     */
    List<CaruEntity> nameselectWupin(int shuid);

    List<CaruEntity> pinselectwupin(int pinid);

    List<CaruEntity> danselectwupin(int danid);

    /*
      品牌表
      通过物品名进行删除操作
     */
    int deletenamewupin(String name);

    /*
      品牌表
      通过物品名进行修改数据
     */
    int updatenamewupin(CaruEntity caruEntity);

    List<CaruEntity> nameselectwupina(String name);

    List<MenuEntity> selectsy(String name);

    List<ChuruEntity> selectshuxing(String name);

    List<ChuruEntity> selectwupin(ChuruEntity churuEntity);

    int updatewupin(ChuruEntity churuEntity);

    int insertchuruku(ChuruEntity churuEntity);

    List<ChuruEntity> kucunselect(ChuruEntity churuEntity);

    List<MenuEntity> fuidselect(int id);

    List<ChuruEntity> cangkunameselect(ChuruEntity churuEntity);

    List<ChuruEntity> fubenselect(ChuruEntity churuEntity);

    List<ChuruEntity> youwupinselect(ChuruEntity churuEntity);

    List<ChuruEntity> youwupinselecta(ChuruEntity churuEntity);

    List<ChuruEntity> zhiyouwupin(ChuruEntity churuEntity);

    List<ChuruEntity> youfenlwup(ChuruEntity churuEntity);

    List<ChuruEntity> suoyou();

    List<ChuruEntity>  banxiaoshi();

    List<ChuruEntity> tongji(ChuruEntity churuEntity);

    List<ChuruEntity> tongjia(ChuruEntity churuEntity);
}
