package com.participate.web;

import com.participate.entity.*;
import com.participate.mapper.WuPinMapper;
import com.participate.server.impl.WuPinServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RestController
public class wupinController {

    @Autowired
    private WuPinMapper wuPinMapper;

    @Autowired
    private WuPinServerImpl wuPinServer;

    /**
     * 插入仓库名称的数据
     * @return
     */
    @RequestMapping(value = "/zhankai")
    private String   wupin() {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName("仓库5");
        menuEntity.setDizhi("滹沱河");
        menuEntity.setFuid(0);
        List<MenuEntity> wuPinMaapper = wuPinServer.selecatSuoyou();

        for (int i = 0; i < wuPinMaapper.size(); i++) {
            System.out.println(i);
            if (wuPinMaapper.get(i).getName().equals(menuEntity.getName())) {
                return "仓库名重复了";
            } else {

            }

        }
        int Wu = wuPinMapper.insertWuPin(menuEntity);
        if (Wu != 0) {
            return "插入成功";
        } else {
            return "插入失败";
        }
    }

    /**
     * 查询仓库名称的信息
     * 通过名称查询出父id通过父id查询出数据
     * 仓库信息的父id都是0
     * @param
     * @return
     */
    @RequestMapping("/chaxun")
    private Map<String, Object> selectwupin(String name){
        if(name.equals("aaa")){
            Map<String,Object> modelMap = new HashMap<String,Object>();
            List<MenuEntity> wuPinMapper=wuPinServer.selectWuPin(0);
            modelMap.put("Cangku",wuPinMapper);
            return modelMap;
        }else {
            Map<String,Object> modelMap = new HashMap<String,Object>();
            List<MenuEntity> PinMapper=wuPinServer.deleteCangku(name);
            //名字是唯一的所以用名字查出来的数据只有一条
            System.out.println(PinMapper.size());
            System.out.println(PinMapper.get(0).getId());
            List<MenuEntity> wuPinMapper=wuPinServer.selectWuPin(PinMapper.get(0).getId());
            modelMap.put("Cangku",wuPinMapper);
            return  modelMap;
        }

    }

    /**
     * 通过名字查出id
     * 通过id删除数据
     * @param
     * @return
     */
    @RequestMapping("deletewu")
    private Map<String,Object> delete(String name){
        List<MenuEntity> PinMapper=wuPinServer.deleteCangku(name);
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",wuPinServer.deleteWuPin(PinMapper.get(0).getId()));

        return  modelMap;

    }

    /**
     * 插入仓库分类名称的信息
     * @param name
     * @return
     */
    @RequestMapping("deletecangku")
    private String  deleteCangku(String  name){

        List<MenuEntity> PinMapper=wuPinServer.deleteCangku(name);
        List<MenuEntity> idgeshuMapper =wuPinServer.selectCangKu(PinMapper.get(0).getId());

        MenuEntity menuEntity =new MenuEntity();
        menuEntity.setName("桌椅");
        menuEntity.setDizhi("板凳");
        menuEntity.setFuid(PinMapper.get(0).getId());
        menuEntity.setPaixu(idgeshuMapper.size()+1);

        List<MenuEntity> wuPinMaapper = wuPinServer.selecatSuoyou();

        for (int i = 0; i < wuPinMaapper.size(); i++) {
            System.out.println(i);
            if (wuPinMaapper.get(i).getName().equals(menuEntity.getName())) {
                return "分类名称重复了";
            } else {

            }

        }

        int charu=wuPinMapper.insertCangKu(menuEntity);
        if (charu!=0){
            return "插入成功";
        }else {
            return "插入失败";
        }

    }

///////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 插入物品信息模块
     */
    /**
     * 插入字典表
     * 单位表
     * 状态：0表示能用
     * 名称不能重复
     */

    @RequestMapping("/insertDanWei")
    private  String  insertDanWei(){
        CompanyEntity companyEntity=new CompanyEntity();
        companyEntity.setDan_name("个");
        companyEntity.setDan_state(0);
        List<CompanyEntity> select=wuPinMapper.selectDanWei();
        for(int i=0;i<select.size();i++){
            if(select.get(i).getDan_name().equals(companyEntity.getDan_name())){
                return "名称重复";
            }
        }
        List<CompanyEntity> upd=wuPinMapper.selectDanWeia();
        for(int i=0;i<upd.size();i++){
            if(upd.get(i).getDan_name().equals(companyEntity.getDan_name())){
                int a=wuPinMapper.updateDanWei(upd.get(i).getDan_id());
                if(a!=0){
                    return "插入成功";
                }
            }
        }
        int insertDanWei=wuPinMapper.insertDanWei(companyEntity);
        if(insertDanWei!=0){
            return "插入成功";
        }else{
            return "插入失败";
        }

    }
    //查询所有单位表的数据
    @RequestMapping("/selectDanWei")
    private  List<CompanyEntity> selectDanWei(){
        List<CompanyEntity> select=wuPinMapper.selectDanWei();

        return select;
    }

    //删除单位表的数据

    @RequestMapping("/deleteDanWei")
    private String deleteDanWei(String name){
        List<CompanyEntity> select=wuPinMapper.selectDanWei();
        for(int i=0;i<select.size();i++){
            if(select.get(i).getDan_name().equals(name)){
                int deleteDanWei=wuPinMapper.deleteDanWei(select.get(i).getDan_id());
                if(deleteDanWei!=0){
                    return "删除成功";
                }

            }
        }
        return "删除失败";
    }
    //修改单位表的数据
    @RequestMapping("/xiugaiDanWei")
    private String xiugaiDanWei(String name,String user){
        if(name.equals("")){
            return "不能为空";
        }
        if(user.equals("")){
            return "不能修改为空";
        }
        List<CompanyEntity>  chaxunDanWei=wuPinMapper.chaxunDanWei(name);
        CompanyEntity companyEntity=new CompanyEntity();
        companyEntity.setDan_name(user);
        if(chaxunDanWei.size()==0){
            return "修改失败,请重新修改";
        }
        List<CompanyEntity> select=wuPinMapper.selectDanWei();

        for(int i=0;i<select.size();i++){
            if(select.get(i).getDan_name().equals(user)){
                return "名称重复";
            }
        }
        companyEntity.setDan_id(chaxunDanWei.get(0).getDan_id());
        int cc=wuPinMapper.xiugaiDanWei(companyEntity);
        if(cc!=0){
            return "修改成功";
        }

        return "请重新插入";
    }

    /**
     * 品牌表的修改
     */
    //品牌表的插入语句

    @RequestMapping("/insertPinPai")
    private String insertPinPai(String name){
        DrandEntity drandEntity=new DrandEntity();
        drandEntity.setPin_name(name);
        drandEntity.setPin_state(0);
        List<DrandEntity> chaxun=wuPinMapper.selectPinPai();

        for(int i=0;i<chaxun.size();i++){
            if(chaxun.get(i).getPin_name().equals(drandEntity.getPin_name())){

                return "名称重复";
            }
        }
        List<DrandEntity> chaya=wuPinMapper.selectPinPaia();
        for (int i=0;i<chaya.size();i++){
            if(chaya.get(i).getPin_name().equals(drandEntity.getPin_name())){
                int aaaaaa=wuPinMapper.xiugaiPinPai(chaya.get(i).getPin_id());
                if(aaaaaa!=0){
                    return "修改成功";
                }
            }
        }
        int inserPinpai=wuPinMapper.insertPinPai(drandEntity);
        if(inserPinpai!=0){
            return "插入成功";
        }else {
            return "插入失败";
        }
    }

    //查询品牌表的所有数据
    @RequestMapping("/selectPinPai")
    private List<DrandEntity> selectPinPai(){
        List<DrandEntity>  aa=wuPinMapper.selectPinPai();

        return aa;
    }
    //品牌表删除数据
    @RequestMapping("/deletePinPai")
    private String deletePinPai(String name){
        List<DrandEntity> aa=wuPinMapper.selectPinPai();
        for(int i=0;i<aa.size();i++){
            if(aa.get(i).getPin_name().equals(name)){
                String bb= wuPinServer.deletePinPai(aa.get(i).getPin_id());
                return bb;
            }
        }

        return "删除失败";
    }
    //修改品牌表的数据
    @RequestMapping("/updatePinPai")
    private String updatePinPai(String name,String  user){
        if(name.equals("")){
            return "不能为空";
        }
        if(user.equals("")){
            return "不能修改为空";
        }
        List<DrandEntity> namePinPai = wuPinMapper.namePinPai(name);
        if(namePinPai.size()==0){
            return "修改失败,请重新修改";
        }
        DrandEntity drandEntity=new DrandEntity();
        drandEntity.setPin_name(user);
        List<DrandEntity> selectPinPai=wuPinMapper.selectPinPai();
        for(int i=0;i<selectPinPai.size();i++){
            if(selectPinPai.get(i).getPin_name().equals(user)){
                return "名称重复";
            }
        }
        drandEntity.setPin_id(namePinPai.get(0).getPin_id());
        int cc=wuPinMapper.xiunamePinPai(drandEntity);
        if(cc!=0){
            return "修改成功";
        }


        return "修改失败";
    }
    /**
     * 物品插入模块
     * 插入物品的信息
     */
    @RequestMapping("/charuwupin")
    private String charuwupin(String name) {
        CaruEntity caruEntity=new CaruEntity();
        caruEntity.setWu_name("扫把");
        caruEntity.setDan_name("d");
        caruEntity.setPin_name("冠军");
        caruEntity.setWu_remarks("保质期3个月");
        caruEntity.setWu_price(20);//商品价格
        caruEntity.setWu_foundtime(new Date());
        caruEntity.setWu_founder("");

        List<CaruEntity> nameselectwupin=wuPinMapper.nameselectwupina(caruEntity.getWu_name());
        List<MenuEntity> selectsy=wuPinMapper.selectsy(name);

        if(nameselectwupin.size()!=0){
            for(int i=0;i<nameselectwupin.size();i++){
                if(nameselectwupin.get(i).getShu_id() == selectsy.get(0).getId()){
                    return "名称重复";
                }
            }
        }

        List<CaruEntity> nameselectDanwei=wuPinMapper.nameselectDanwei(caruEntity.getDan_name());
        if(nameselectDanwei.size()==0){
            CompanyEntity companyEntity=new CompanyEntity();
            companyEntity.setDan_name(caruEntity.getDan_name());
            companyEntity.setDan_state(0);
            int insertDanWei=wuPinMapper.insertDanWei(companyEntity);
            System.out.println("单位插入方法"+companyEntity.getDan_id());

            //插入单位表的id到物品表
            caruEntity.setDan_id(companyEntity.getDan_id());
            if(insertDanWei==0){
                return "物品表插入失败";
            }
        }else {
            if(nameselectDanwei.get(0).getDan_state()==1){
                List<CompanyEntity> upd=wuPinMapper.selectDanWeia();
                for(int i=0;i<upd.size();i++){
                    if(upd.get(i).getDan_name().equals(caruEntity.getDan_name())){

                        //插入单位表的id到物品表
                        caruEntity.setDan_id(upd.get(i).getDan_id());
                        int a=wuPinMapper.updateDanWei(upd.get(i).getDan_id());
                        if(a==0){
                            return "物品表修改失败";
                        }
                    }
                }
            }else {
                caruEntity.setDan_id(nameselectDanwei.get(0).getDan_id());
            }
        }
        //品牌
        List<CaruEntity> nameselectPinpai=wuPinMapper.nameselectPinpai(caruEntity.getPin_name());
        if(nameselectPinpai.size()==0){
            DrandEntity  drandEntity=new DrandEntity();
            drandEntity.setPin_name(caruEntity.getPin_name());
            drandEntity.setPin_state(0);
            int insertPinpai=wuPinMapper.insertPinPai(drandEntity);
            //System.out.println(drandEntity.getPin_id());
            //插入品牌表的id到物品表
            caruEntity.setPin_id(drandEntity.getPin_id());
            if(insertPinpai==0){
                return "品牌表插入失败";
            }
        }else {
            if(nameselectPinpai.get(0).getPin_state()==1){
                List<DrandEntity> chaya=wuPinMapper.selectPinPaia();
                for (int i=0;i<chaya.size();i++){
                    if(chaya.get(i).getPin_name().equals(caruEntity.getPin_name())){
                        //插入品牌表的id到物品表
                        caruEntity.setPin_id(chaya.get(i).getPin_id());
                        int aaaaaa=wuPinMapper.xiugaiPinPai(chaya.get(i).getPin_id());
                        if(aaaaaa==0){
                            return "品牌表修改失败";
                        }
                    }
                }
            }else {
                caruEntity.setPin_id(nameselectPinpai.get(0).getPin_id());
            }
        }

        List<CaruEntity> nameshuxing=wuPinMapper.nameupdateshuxing(name);

        caruEntity.setShu_id(nameshuxing.get(0).getCai_id());
        int aa=wuPinMapper.insertgoods(caruEntity);

        if(aa!=0){
            return "物品数据插入成功";
        }else {
            return "物品数据插入失败";
        }
    }
    /**
     * 物品插入模块
     * 查询功能
     */
    @RequestMapping("nameselectWupin")
    private List<CaruEntity> nameselectWupin(String name) throws Exception {

            List<CaruEntity> nameshuxing=wuPinMapper.nameupdateshuxing(name);
            if(nameshuxing.size()!=0){
                List<CaruEntity> listselectwupin=wuPinMapper.nameselectWupin(nameshuxing.get(0).getCai_id());

                List<CaruEntity> caruEntities=new ArrayList<CaruEntity>();
                for(int i=0;i<listselectwupin.size();i++){
                    List<CaruEntity> pinselectwupin=wuPinMapper.pinselectwupin(listselectwupin.get(i).getPin_id());
                    List<CaruEntity> danselectwupin=wuPinMapper.danselectwupin(listselectwupin.get(i).getDan_id());
                    CaruEntity caruEntity=new CaruEntity();
                    caruEntity.setWu_name(listselectwupin.get(i).getWu_name());
                    caruEntity.setDan_name(danselectwupin.get(0).getDan_name());
                    caruEntity.setPin_name(pinselectwupin.get(0).getPin_name());
                    caruEntity.setWu_remarks(listselectwupin.get(i).getWu_remarks());
                    caruEntity.setWu_price(listselectwupin.get(i).getWu_price());
                    caruEntities.add(caruEntity);
                }

                return caruEntities;
            }
            List<CaruEntity>  bb=new ArrayList<>();
            CaruEntity cc=new CaruEntity();
            bb.add(cc);
            return  bb;
    }

    /*
      物品插入模块
    * 删除功能
     */
    @RequestMapping("deletenamewupin")
    private  String  deletewupin(String name){
        int a=wuPinMapper.deletenamewupin(name);
        if(a!=0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }


    @RequestMapping("updatenamewupin")
    private String updatewupin(String name){
        CaruEntity caruEntity=new CaruEntity();
        caruEntity.setWu_name("桌子");
        caruEntity.setDan_name("罐子");
        caruEntity.setPin_name("闪电");
        caruEntity.setWu_remarks("略微破损");
        caruEntity.setWu_price(10);
        caruEntity.setName(name);

            List<CaruEntity> nameselectwupin=wuPinMapper.nameselectwupina(name);

            if(nameselectwupin.size()!=0){
                caruEntity.setWu_id(nameselectwupin.get(0).getWu_id());
            }else {
                return "名字输入错误";
            }



        if(caruEntity.getDan_name()!=null){
            List<CaruEntity> nameselectDanwei=wuPinMapper.nameselectDanwei(caruEntity.getDan_name());
            if(nameselectDanwei.size()==0){
                CompanyEntity companyEntity=new CompanyEntity();
                companyEntity.setDan_name(caruEntity.getDan_name());
                companyEntity.setDan_state(0);
                int insertDanWei=wuPinMapper.insertDanWei(companyEntity);
                System.out.println("单位插入方法"+companyEntity.getDan_id());

                //插入单位表的id到物品表
                caruEntity.setDan_id(companyEntity.getDan_id());
                if(insertDanWei==0){
                    return "物品表插入失败";
                }else {

                }

            }else {
                if(nameselectDanwei.get(0).getDan_state()==1){
                    List<CompanyEntity> upd=wuPinMapper.selectDanWeia();
                    for(int i=0;i<upd.size();i++){
                        if(upd.get(i).getDan_name().equals(caruEntity.getDan_name())){

                            //插入单位表的id到物品表
                            caruEntity.setDan_id(upd.get(i).getDan_id());
                            int a=wuPinMapper.updateDanWei(upd.get(i).getDan_id());
                            if(a==0){
                                return "物品表修改失败";
                            }else {

                            }
                        }
                    }
                }else {
                    caruEntity.setDan_id(nameselectDanwei.get(0).getDan_id());
                }

             }

        }
        if(caruEntity.getPin_name()!=null){
            List<CaruEntity> nameselectPinpai=wuPinMapper.nameselectPinpai(caruEntity.getPin_name());
            if(nameselectPinpai.size()==0){
                DrandEntity  drandEntity=new DrandEntity();
                drandEntity.setPin_name(caruEntity.getPin_name());
                drandEntity.setPin_state(0);
                int insertPinpai=wuPinMapper.insertPinPai(drandEntity);
                //System.out.println(drandEntity.getPin_id());
                //插入品牌表的id到物品表
                caruEntity.setPin_id(drandEntity.getPin_id());
                if(insertPinpai==0){
                    return "品牌表插入失败";
                }else {

                }
            }else {
                if(nameselectPinpai.get(0).getPin_state()==1){
                    List<DrandEntity> chaya=wuPinMapper.selectPinPaia();
                    for (int i=0;i<chaya.size();i++){
                        if(chaya.get(i).getPin_name().equals(caruEntity.getPin_name())){
                            //插入品牌表的id到物品表
                            caruEntity.setPin_id(chaya.get(i).getPin_id());
                            int aaaaaa=wuPinMapper.xiugaiPinPai(chaya.get(i).getPin_id());
                            if(aaaaaa==0){
                                return "修改成功";
                            }else {

                            }
                        }
                    }
                }else {
                    caruEntity.setPin_id(nameselectPinpai.get(0).getPin_id());
                }
            }
        }
        //System.out.println("品牌:"+caruEntity.getPin_id());
        //System.out.println("单位:"+caruEntity.getDan_id());
        int aa=wuPinMapper.updatenamewupin(caruEntity);
        if(aa!=0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    /**
     * 仓库
     * 入库表
     */
    @RequestMapping("rukucharu")
   private String  rukucharu(){
        ChuruEntity churuEntity=new ChuruEntity();
        churuEntity.setWu_name("桌子");//入库名称
        churuEntity.setRu_ruku(new Date());//入库时间
        churuEntity.setRu_rukur("");//入库人
        churuEntity.setRu_cangid("仓库1");//仓库名称
        churuEntity.setRu_rukushu(12);//入库数量

        churuEntity.setRu_leixing(0);//0入库1出库
        churuEntity.setRu_sunhao(0);//损耗
        churuEntity.setRu_shijiru(churuEntity.getRu_rukushu());//实际入库
        churuEntity.setWu_fenlei("桌椅");//分类名称

        List<ChuruEntity> selectshuxing=wuPinMapper.selectshuxing(churuEntity.getWu_fenlei());

        churuEntity.setRu_shuid(selectshuxing.get(0).getCai_id());

        List<ChuruEntity> selectwupin=wuPinMapper.selectwupin(churuEntity);

        churuEntity.setRu_wuid(selectwupin.get(0).getWu_id());

        churuEntity.setWu_kucun(selectwupin.get(0).getWu_kucun()+churuEntity.getRu_rukushu());//库存

        int updatewupin=wuPinMapper.updatewupin(churuEntity);

        int insertchuruku=wuPinMapper.insertchuruku(churuEntity);
        if(insertchuruku!=0){
            return "插入成功";
        }else {
            return "插入失败";
        }

   }
    /**
     * 仓库
     * 出库表
     */
    @RequestMapping("chukuchuru")
    private String chukuchuru(){

        ChuruEntity churuEntity=new ChuruEntity();
        churuEntity.setWu_name("毛巾");//入库名称
        churuEntity.setRu_ruku(new Date());//入库时间
        churuEntity.setRu_rukur("");//入库人
        churuEntity.setRu_cangid("仓库1");//仓库名称
        churuEntity.setRu_rukushu(12);//入库数量
        churuEntity.setRu_leixing(1);//0入库1出库
        churuEntity.setRu_sunhao(0);//损耗
        churuEntity.setRu_shijiru(churuEntity.getRu_rukushu());//实际入库
        churuEntity.setWu_fenlei("桌椅");//分类名称

        List<ChuruEntity> selectshuxing=wuPinMapper.selectshuxing(churuEntity.getWu_fenlei());

        churuEntity.setRu_shuid(selectshuxing.get(0).getCai_id());

        List<ChuruEntity> selectwupin=wuPinMapper.selectwupin(churuEntity);

        churuEntity.setRu_wuid(selectwupin.get(0).getWu_id());

        churuEntity.setWu_kucun(selectwupin.get(0).getWu_kucun()-churuEntity.getRu_rukushu());//库存

        int updatewupin=wuPinMapper.updatewupin(churuEntity);

        int insertchuruku=wuPinMapper.insertchuruku(churuEntity);
        if(insertchuruku!=0){
            return "插入成功";
        }else {
            return "插入失败";
        }

    }

    /**
     * 库存查询模块
     *
     */
    @RequestMapping("kucunselect")
    private List<ChuruEntity>   kucunselect(String name, String fenlei, String wuname){
        ChuruEntity churuEntity=new ChuruEntity();
        churuEntity.setName(name);//仓库名称
        churuEntity.setWu_fenlei(fenlei);//分类名称
        churuEntity.setWu_name(wuname);//物品名称


        List<MenuEntity> fuidselect = null;
        List<MenuEntity> menuEntitiesa = null;
        List<ChuruEntity> cangkunameselect = null;
        List<ChuruEntity> churuEntities=null;
        List<ChuruEntity>  youwupinselect = null;
        List<ChuruEntity>  youwupinselecta=null;
        List<ChuruEntity>  zhiyouwuru=null;
        List<ChuruEntity> youfenlwup=null;
        List<ChuruEntity> suoyou=null;
        if(churuEntity.getName()==""){
            if(churuEntity.getWu_fenlei()==""){
                if(churuEntity.getWu_name()==""){
                    suoyou=wuPinMapper.suoyou();
                    return suoyou;
                }
                 zhiyouwuru=wuPinMapper.zhiyouwupin(churuEntity);
                 return zhiyouwuru;

            }
            menuEntitiesa=wuPinMapper.deleteCangku(churuEntity.getWu_fenlei());
            //如果只有分类名称的时候
            if(menuEntitiesa.size()!=0 && churuEntity.getWu_name()==""){
//                   churuEntity.setShu_id(menuEntitiesa.get(0).getId());
//                   fuidselect=wuPinMapper.fuidselect(menuEntitiesa.get(0).getId());
//                   churuEntity.setCai_id(fuidselect.get(0).getId());
                     churuEntity.setCai_id(menuEntitiesa.get(0).getId());
                   youwupinselecta=wuPinMapper.youwupinselecta(churuEntity);
                   return youwupinselecta;


            }else {//如果有分类名称有物品名称

                List<MenuEntity> menuEntities=wuPinMapper.deleteCangku(churuEntity.getWu_fenlei());
                churuEntity.setCai_id(menuEntities.get(0).getId());
//                churuEntities=wuPinMapper.fubenselect(churuEntity);
//                churuEntity.setCai_id(churuEntities.get(0).getCai_id());
                youfenlwup=wuPinMapper.youfenlwup(churuEntity);
                return youfenlwup;
            }
        }else {
            List<MenuEntity> menuEntities=wuPinMapper.deleteCangku(churuEntity.getName());
            if(menuEntities.size()!=0){
                //如果只有仓库名称没有分类名称的时候
                  if(churuEntity.getWu_fenlei()==""){
                          fuidselect=wuPinMapper.fuidselect(menuEntities.get(0).getId());

                          //List<ChuruEntity> churuEntities=new ArrayList<ChuruEntity>();

                          for(int i=0;i<fuidselect.size();i++) {
                              churuEntity.setShu_id(fuidselect.get(i).getId());
                               cangkunameselect=wuPinMapper.cangkunameselect(churuEntity);
                              //churuEntities.add(i,cangkunameselect);
                          }
                      return cangkunameselect;
                }else {

                      //要有分类名称才能有物品名称  //如果只有仓库名分类名的时候
                      if(churuEntity.getWu_name()==""){
                          churuEntity.setCai_id(menuEntities.get(0).getId());
                          churuEntities=wuPinMapper.fubenselect(churuEntity);
                          churuEntity.setCai_id(churuEntities.get(0).getCai_id());
                          youwupinselecta=wuPinMapper.youwupinselecta(churuEntity);
                          return youwupinselecta;
                      }else {  //如果有仓库名称有分类名称有物品名称的时候
                          churuEntity.setCai_id(menuEntities.get(0).getId());
                          churuEntities=wuPinMapper.fubenselect(churuEntity);
                          churuEntity.setCai_id(churuEntities.get(0).getCai_id());
                          youwupinselect=wuPinMapper.youwupinselect(churuEntity);
                          return youwupinselect;
                      }

                  }
            }else {
                List<ChuruEntity>  bb=new ArrayList<>();
                ChuruEntity cc=new ChuruEntity();
                bb.add(cc);
            }

        }




        return youwupinselect;
    }

    @RequestMapping("tongji")
    public List<ChuruEntity> tongji(String name, int user){
        int shijian=-100;
//        if(user=="周"){
//            shijian=-7;
//        }
//        if(user=="月"){
//            //取得系统当前时间
//            Calendar cal = Calendar.getInstance();
//            //取得系统当前时间所在月第一天时间对象
//            cal.set(Calendar.DAY_OF_MONTH, 1);
//            //日期减一,取得上月最后一天时间对象
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//            //输出上月最后一天日期
//            System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//        }
//        if(user=="年"){
//            shijian=-365;
//        }
        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);
        //System.out.println(modate);

        churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);
        calendar.add(calendar.DATE,user);//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");
        String qidate = formatter.format(date1);
        //System.out.println("推迟时间"+qidate);
        churuEntity.setQidate(qidate);
        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongji(churuEntity);

        return churuEntityList;
    }


    @RequestMapping("tongjiyue")
    public List<ChuruEntity> tongjiyue(String name){
        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);

        ChuruEntity churuEntitya=new ChuruEntity();
        Date datea=new Date();
        long timesa = date.getTime();//时间戳
        SimpleDateFormat formatteraa = new SimpleDateFormat("dd");
        String modatea = formatteraa.format(date);
        int b=0;
        int c=0;
        try {

            int a = Integer.parseInt(modatea);
            b=b-a;
            c=c-a;
            System.out.println("aaa:"+a);
            System.out.println("bbbb:"+b);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);
        ////////////
        Calendar aa=Calendar.getInstance(); //调用Calendar 中的方法；
        aa.set(Calendar.DAY_OF_MONTH, 1); // 把时间调整为当月的第一天；
        aa.add(Calendar.MONTH,0);   // 月份调至下个月；
        aa.add(Calendar.DAY_OF_MONTH, -1); // 时间减去一天（就等于上个月的最后一天）
        int month=aa.get(Calendar.MONTH)+1;  //调取月份（月份在表示中会少 1，如：1月份得出数字是 0；
        int days=aa.get(Calendar.DAY_OF_MONTH);//调取当月的天数。
        System.out.println(month+"月份有"+days+"天");//打印最后被结果。
        b=b+(-days);
        ///////////
        System.out.println("一共有:"+b);
        calendar.add(calendar.DATE,b+1);//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");

        String qidate = formattera.format(date1);
        churuEntity.setQidate(qidate);
        /////////////////////////////////////////
        Date date2=new Date();
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(date2);
        Calendar aaa=Calendar.getInstance();
        aaa.set(Calendar.DAY_OF_MONTH, 1); // 把时间调整为当月的第一天；
        aaa.add(Calendar.MONTH,0);   // 月份调至下个月；
        aaa.add(Calendar.DAY_OF_MONTH, -1); // 时间减去一天（就等于上个月的最后一天）
        int montha=aaa.get(Calendar.MONTH)+1;
        int daysa=aaa.get(Calendar.DAY_OF_MONTH);
        calendar1.add(calendar1.DATE,c);
        date2=calendar1.getTime();
        SimpleDateFormat formatteraaa = new SimpleDateFormat("yyyy-MM-dd HH");
        String qidatea = formatteraaa.format(date2);
        churuEntity.setModate(qidatea);
        System.out.println("qidate:"+churuEntity.getQidate());
        System.out.println("modate:"+churuEntity.getModate());

        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongji(churuEntity);

        return churuEntityList;
    }

    @RequestMapping("tongjinian")
    public ModelAndView tongjinian(String name){

        //获取今天日期
        Calendar cal = Calendar.getInstance();
        //输出今天是今天多少天
        //今天是20111111，所以是第315天  输出:315
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));

        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);
        //System.out.println("modate:"+modate);



        ChuruEntity churuEntitya=new ChuruEntity();
        Date datea=new Date();
        long timesa = date.getTime();//时间戳
        SimpleDateFormat formatteraa = new SimpleDateFormat("dd");
        String modatea = formatteraa.format(date);


        churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);


        calendar.add(calendar.DATE,-cal.get(Calendar.DAY_OF_YEAR));//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");

        String qidate = formatter.format(date1);
        //System.out.println("推迟时间"+qidate);
        churuEntity.setQidate(qidate);
        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongji(churuEntity);
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("a",churuEntityList);
        for(int i=0;i<churuEntityList.size();i++){
            modelMap.put(""+i+"",churuEntityList);
        }
        return new ModelAndView("index",modelMap);
    }
    //////////////////////////出货统计
    @RequestMapping("tongjia")
    public List<ChuruEntity> tongjia(String name, int user){
        int shijian=-100;

        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);
        //System.out.println(modate);

        churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);
        calendar.add(calendar.DATE,user);//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");
        String qidate = formatter.format(date1);
        //System.out.println("推迟时间"+qidate);
        churuEntity.setQidate(qidate);
        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongjia(churuEntity);

        return churuEntityList;
    }
    ///周统计
    @RequestMapping("tongjiyuea")
    public List<ChuruEntity> tongjiyuea(String name){
        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);

        ChuruEntity churuEntitya=new ChuruEntity();
        Date datea=new Date();
        long timesa = date.getTime();//时间戳
        SimpleDateFormat formatteraa = new SimpleDateFormat("dd");
        String modatea = formatteraa.format(date);
        int b=0;
        int c=0;
        try {

            int a = Integer.parseInt(modatea);
            b=b-a;
            c=c-a;
            //System.out.println("aaa:"+a);
            //System.out.println("bbbb:"+b);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);
        ////////////
        Calendar aa=Calendar.getInstance(); //调用Calendar 中的方法；
        aa.set(Calendar.DAY_OF_MONTH, 1); // 把时间调整为当月的第一天；
        aa.add(Calendar.MONTH,0);   // 月份调至下个月；
        aa.add(Calendar.DAY_OF_MONTH, -1); // 时间减去一天（就等于上个月的最后一天）
        int month=aa.get(Calendar.MONTH)+1;  //调取月份（月份在表示中会少 1，如：1月份得出数字是 0；
        int days=aa.get(Calendar.DAY_OF_MONTH);//调取当月的天数。
        System.out.println(month+"月份有"+days+"天");//打印最后被结果。
        b=b+(-days);
        ///////////
        System.out.println("一共有:"+b);
        calendar.add(calendar.DATE,b+1);//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");

        String qidate = formattera.format(date1);
        churuEntity.setQidate(qidate);
        /////////////////////////////////////////
        Date date2=new Date();
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(date2);
        Calendar aaa=Calendar.getInstance();
        aaa.set(Calendar.DAY_OF_MONTH, 1); // 把时间调整为当月的第一天；
        aaa.add(Calendar.MONTH,0);   // 月份调至下个月；
        aaa.add(Calendar.DAY_OF_MONTH, -1); // 时间减去一天（就等于上个月的最后一天）
        int montha=aaa.get(Calendar.MONTH)+1;
        int daysa=aaa.get(Calendar.DAY_OF_MONTH);
        calendar1.add(calendar1.DATE,c);
        date2=calendar1.getTime();
        SimpleDateFormat formatteraaa = new SimpleDateFormat("yyyy-MM-dd HH");
        String qidatea = formatteraaa.format(date2);
        churuEntity.setModate(qidatea);
        System.out.println("qidate:"+churuEntity.getQidate());
        System.out.println("modate:"+churuEntity.getModate());

        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongjia(churuEntity);

        return churuEntityList;
    }
    //统计年
    @RequestMapping("tongjiniana")
    public ModelAndView tongjiniana(String name){

        //获取今天日期
        Calendar cal = Calendar.getInstance();
        //输出今天是今天多少天
        //今天是20111111，所以是第315天  输出:315
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));

        ChuruEntity churuEntity=new ChuruEntity();
        Date date=new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
        String modate = formatter.format(date);
        //System.out.println("modate:"+modate);



        ChuruEntity churuEntitya=new ChuruEntity();
        Date datea=new Date();
        long timesa = date.getTime();//时间戳
        SimpleDateFormat formatteraa = new SimpleDateFormat("dd");
        String modatea = formatteraa.format(date);


        churuEntity.setModate(modate);

        Date date1=new Date();
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date1);


        calendar.add(calendar.DATE,-cal.get(Calendar.DAY_OF_YEAR));//把日期往后增加一天.整数往后推,负数往前移动
        date1=calendar.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formattera = new SimpleDateFormat("yyyy-MM-dd HH");

        String qidate = formatter.format(date1);
        //System.out.println("推迟时间"+qidate);
        churuEntity.setQidate(qidate);
        churuEntity.setName(name);
        List<ChuruEntity> churuEntityList=wuPinMapper.tongjia(churuEntity);
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("a",churuEntityList);
        for(int i=0;i<churuEntityList.size();i++){
            modelMap.put(""+i+"",churuEntityList);
        }
        return new ModelAndView("index",modelMap);
    }




























}