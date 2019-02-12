package com.zhoujixing.web;

import com.mysql.cj.xdevapi.JsonArray;
import com.zhoujixing.entity.VoteEntity;
import com.zhoujixing.mapper.VoteMapper;
import com.zhoujixing.studyTest.TestThreadPoolManager;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.zhoujixing.demo.FileUtils;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import java.io.File;
import java.util.*;

@Controller
@RestController
public class TestController {

    private final ResourceLoader resourceLoader;

    @Autowired
    private VoteMapper voteMapper;

    @Autowired
    TestThreadPoolManager testThreadPoolManager;

    @Autowired
    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("test")
    public ModelAndView toUpload(){
        return new ModelAndView("index");
    }

    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("fileUpload")
    public ModelAndView upload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){

        // 要上传的目标文件存放路径
        String localPath = "E:/Develop/";
        // 上传成功或者失败的提示
        String msg = "";
        String aaa="kungou";
//        VoteEntity voteEntity=new VoteEntity();
//        voteEntity.setP_tup(localPath);
        Map aa=FileUtils.upload(file, localPath, file.getOriginalFilename(),aaa);
       //System.out.println(aa.get(1)+":aaa");
       boolean cc= (boolean) aa.get(1);
        if (cc){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";

        }

        VoteEntity voteEntity=new VoteEntity();
        voteEntity.setP_name("朱元璋");
        voteEntity.setP_tup((String) aa.get(2));
        voteEntity.setP_jieshao("明代开国皇帝");
        voteEntity.setH_bt("bb");
        int insertPdx = voteMapper.insertPdx(voteEntity);
        List<VoteEntity> selectPd=voteMapper.selecthdb(voteEntity);
        List<VoteEntity> selectPdx=voteMapper.selectPdx(voteEntity);
        VoteEntity tpjl=new VoteEntity();
        tpjl.setT_pid(selectPdx.get(0).getP_id());
        tpjl.setT_hid(selectPd.get(0).getH_id());
        int insertTpjl=voteMapper.insertTpjl(tpjl);


        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
//        System.out.println("AAA:"+file.getOriginalFilename());
//        System.out.println("BBB:"+msg);
        return new ModelAndView("uploadForm",map);

    }
    //////////////////////////////////////////////////////////////
    @RequestMapping("xiutest")
    public ModelAndView xiuUpload(){
        return new ModelAndView("index");
    }

    //修改图片
    @RequestMapping("xiufileUpload")
    public ModelAndView xiuupload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){

        VoteEntity voteEntity=new VoteEntity();
        voteEntity.setP_name("朱元璋");
        List<VoteEntity> selectPdx=voteMapper.selectPdx(voteEntity);
        //System.out.println("p_tup:"+selectPdx.get(0).getP_tup());
        File f = new File(selectPdx.get(0).getP_tup());
        f.delete();


        // 要上传的目标文件存放路径
        String localPath = "E:/Develop/";
        // 上传成功或者失败的提示
        String msg = "";
        String aaa="朱元璋";
        Map aa=FileUtils.upload(file, localPath, file.getOriginalFilename(),aaa);

        boolean cc= (boolean) aa.get(1);
        if (cc){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";

        }
        VoteEntity xiugiatup=new VoteEntity();
        xiugiatup.setP_id(selectPdx.get(0).getP_id());
        xiugiatup.setP_tup((String) aa.get(2));
        int updatetup=voteMapper.updatetup(xiugiatup);
        // 显示图片
        map.put("msg", msg);
        map.put("fileName", file.getOriginalFilename());
        return new ModelAndView("uploadForm",map);

    }
    //修改被投人的信息
    @RequestMapping("xiubeitour")
    public ModelAndView xiubeitour(){
        VoteEntity voteEntity=new VoteEntity();
        voteEntity.setP_name("李渊");
        voteEntity.setP_jieshao("唐朝开国皇帝");

        VoteEntity  selectPdx=new VoteEntity();
        selectPdx.setP_name("朱元璋");
        List<VoteEntity> selectPdxa=voteMapper.selectPdx(selectPdx);
        String aa=null;
        if(selectPdxa.size()==0){
            aa= "没有此投票人";
        }
        voteEntity.setP_id(selectPdxa.get(0).getP_id());
        int xiubeitour=voteMapper.xiubeitour(voteEntity);
        if(xiubeitour!=0){
            aa="修改成功";
        }
        HashMap hashMap=new HashMap();
        hashMap.put("zhuangtai",aa);
        return new ModelAndView("uploadForm",hashMap);
    }
    //删除被投人
    @RequestMapping("deletebeitour")
    public ModelAndView deletebeitour(){
        VoteEntity  selectPdx=new VoteEntity();
        selectPdx.setP_name("朱元璋");
        List<VoteEntity> selectPdxa=voteMapper.selectPdx(selectPdx);
        String zhuangtai=null;
        if(selectPdxa.size()==0){
            zhuangtai="没有此用户";
        }
        int deletebeitour=voteMapper.deletebeitour(selectPdxa.get(0).getP_id());
        if(deletebeitour==0){
           zhuangtai="删除失败请重新操作";
        }
        //return "";
        HashMap hashMap=new HashMap();
        hashMap.put("zhuangtai",zhuangtai);
        return new ModelAndView("uploadForm",hashMap);
    }





    //查询页面所有的信息
    @RequestMapping("selectbeitou")
    public ModelAndView selectbeitou(){
         VoteEntity voteEntity=new VoteEntity();
         voteEntity.setH_bt("bb");
         //标题的数据
         List<VoteEntity> voteEntities=voteMapper.selecthdb(voteEntity);
         String aa=voteEntities.get(0).getH_id()+"";
         //票数的数据
         List<VoteEntity> selectbtchatpjl=voteMapper.selectbtchatpjl(voteEntities.get(0).getH_id());
         //System.out.println("voteEntities.get(0).getH_id():"+voteEntities.get(0).getH_id());
         //System.out.println("aaa:"+selectbtchatpjl.size());
         //票数和用户名整合
        String  zhaungtai=null;
         if(selectbtchatpjl.size()==0){
             zhaungtai="请重新操作";
         }
        //Map  shujujihe=new HashMap<>();
        List<VoteEntity>selecttpjlpdx=null;
         List afd=new ArrayList();
         afd.add(0,voteEntities);
         for (int i=0;i<selectbtchatpjl.size();i++){
             //被投人的信息
             selecttpjlpdx=voteMapper.selecttpjlpdx(selectbtchatpjl.get(i).getT_pid());
             selecttpjlpdx.get(0).setT_ps(selectbtchatpjl.get(i).getT_ps());
             afd.add(i+1,selecttpjlpdx);
             zhaungtai="操作成功";

         }
           //System.out.println(selectbtchatpjl.get(2).getT_pid());

          HashMap  zhenghe=new HashMap<>();
          zhenghe.put("zhuangtai",zhaungtai);
          zhenghe.put("afd",afd);
//          for (int i=0;i<selecttpjlpdx.size();i++){
//            System.out.println(selecttpjlpdx.size());
//        }
       // return afd;

        return new ModelAndView("uploadForm",zhenghe);
    }

//    /**
//     * 显示单张图片
//     * @return
//     */
//    @RequestMapping("show")
//    public ResponseEntity showPhotos(String fileName){
//
//        try {
//            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    ///////////////////////////////


    /**
     * 插入基本活动规格
     * @param
     * @return
     */
    @RequestMapping("start")
    public ModelAndView start() {
//        //模拟的随机数
//        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();
          VoteEntity voteEntity=new VoteEntity();
          voteEntity.setX_tpr("IG");
          voteEntity.setT_pid(1);
          voteEntity.setZ_ygt(2);
          voteEntity.setP_jieshao("aa");
          voteEntity.setH_bt("bb");
         int insertHdb = voteMapper.insertHdb(voteEntity);
         voteEntity.setZ_hid(voteEntity.getH_id());
         System.out.println("voteEntity.getH_id()"+voteEntity.getH_id());
         int insertZhid = voteMapper.insertZhid(voteEntity);
         String aa=null;
         if(insertZhid!=0){
             aa="插入成功";
         }else {
             aa="插入失败";
         }
         testThreadPoolManager.addOrders(voteEntity);
        HashMap<String, String> hash=new HashMap<String,String>();
        hash.put("状态",aa);
        return new ModelAndView("uploadForm",hash);
    }

    @RequestMapping("toutiao")
    public ModelAndView toutiao(){

        VoteEntity voteEntitya=new VoteEntity();
        voteEntitya.setH_bt("bb");
        //标题的数据
        List<VoteEntity> voteEntities=voteMapper.selecthdb(voteEntitya);

        VoteEntity voteEntity=new VoteEntity();
        voteEntity.setX_tpr("IG");
        voteEntity.setT_pid(1);
        List<VoteEntity> chaxuntoup=voteMapper.chaxuntoup(voteEntity.getX_tpr());
        List<VoteEntity> zhidselect=null;
        String aa=null;
        if(chaxuntoup.size()==0){
            int insertSheZhi = voteMapper.insertSheZhi(voteEntity);
        }else {
            zhidselect=voteMapper.zhidselect(voteEntities.get(0).getH_id());
            if(zhidselect.get(0).getZ_zdt()>chaxuntoup.get(0).getX_tps()){
//                System.out.println("aa"+zhidselect.get(0).getZ_zdt());
//                System.out.println("bb"+chaxuntoup.get(0).getX_tps());
                VoteEntity voteEntity1=new VoteEntity();
                voteEntity1.setX_id(chaxuntoup.get(0).getX_id());
                voteEntity1.setX_tps(chaxuntoup.get(0).getX_tps()+1);
                int xiugaitoup=voteMapper.xiugaitoup(voteEntity1);
                if(xiugaitoup==1){
                    aa= "投票成功";
                }
            }else {
                aa= "已经投票";
            }

        }
        StringBuilder a=null;
        HashMap<String, String> hash=new HashMap<String,String>();
        hash.put("xiangqing",aa);
        //return "请重新操作";

        return new ModelAndView("uploadForm",hash);
    }

//    /**
//     * 停止服务
//     * @param id
//     * @return
//     */
//    @GetMapping("end")
//    public String end(@PathVariable Long id) {
//
//        testThreadPoolManager.shutdown();
//
//        Queue q = testThreadPoolManager.getMsgQueue();
//        System.out.println("关闭了线程服务，还有未处理的信息条数：" + q.size());
//        return "Test ThreadPoolExecutor start";
//    }

//    //修改图片
//    @RequestMapping("ModifyingPictures")
//   public String ModifyingPictures(){
//        String PicturesName = "kungou";
//        String Route = "E:/Develop/";
//        File f = new File(Route+PicturesName+".png");
//        File g = new File(Route+PicturesName+".jpg");
//        f.delete();
//        g.delete();
//
//
//        return "aaa";
//   }
   /////////////////////

}
