package com.zhoujixing.config;

import com.zhoujixing.entity.VoteEntity;
import com.zhoujixing.mapper.VoteMapper;
import com.zhoujixing.server.VoteServer;
import com.zhoujixing.server.impl.VoteServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@Component
@Scope("prototype")//spring 多例
public class BusinessThread implements Runnable{

    @Autowired
    private VoteMapper voteMapper;

    //@Autowired
    private VoteEntity voteEntity;

    //private String acceptStr;

    public BusinessThread(VoteEntity voteEntity) {
        this.voteEntity=voteEntity;
    }

    public VoteEntity getAcceptStr() {
        return voteEntity;
    }

    public void setAcceptStr(VoteEntity voteEntity) {
        this.voteEntity=voteEntity;
    }

    @Override
    public void run() {
        //业务操作
        System.out.println("多线程已经处理订单插入系统，订单号：");
        System.out.println(voteEntity.getX_tpr()+"aaaa");
//        voteServerImpl.insertSheZhi(voteEntity);
//        int a=voteServer.insertSheZhi(voteEntity);
          System.out.println("toString:"+voteEntity.toString());

          int insertSheZhi = voteMapper.insertSheZhi(voteEntity);
//        int insertTpjl = voteMapper.insertTpjl(voteEntity);
//        int insertZhid = voteMapper.insertZhid(voteEntity);
//        int insertPdx = voteMapper.insertPdx(voteEntity);
//        int insertHdb = voteMapper.insertHdb(voteEntity);

        //线程阻塞
        /*try {
            Thread.sleep(1000);
            System.out.println("多线程已经处理订单插入系统，订单号："+acceptStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}