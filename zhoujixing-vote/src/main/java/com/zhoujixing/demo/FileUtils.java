package com.zhoujixing.demo;

import com.zhoujixing.entity.VoteEntity;
import com.zhoujixing.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传工具包
 */
public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static Map upload(MultipartFile file, String path, String fileName,String aaa){

        // 生成新的文件名
        String realPath = path + "/" + FileNameUtils.getFileName(fileName,aaa);
        String localPath = "E:/Develop/";
        VoteEntity voteEntity=new VoteEntity();
        voteEntity.setP_tup(realPath);


        //使用原文件名
        //String realPath = path + "/" + fileName;

        File dest = new File(realPath);
        Map aa=new HashMap();

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            aa.put(1,true);
            aa.put(2,realPath);
            return aa;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            aa.put(1,false);
            aa.put(2,realPath);
            return aa;


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            aa.put(1,false);
            aa.put(2,realPath);
            return aa;
        }

    }
}
