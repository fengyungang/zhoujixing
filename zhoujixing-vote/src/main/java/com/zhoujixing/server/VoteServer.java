package com.zhoujixing.server;

import com.zhoujixing.entity.VoteEntity;

import java.util.List;

public interface VoteServer {

    /*
      投票设置
     */
    int insertSheZhi(VoteEntity voteEntity);
    //zhid
    int insertZhid(VoteEntity voteEntity);
    //tpjl
    int insertTpjl(VoteEntity voteEntity);
    //pdx
    int insertPdx(VoteEntity voteEntity);
    //hdb
    int insertHdb(VoteEntity voteEntity);

    List<VoteEntity>  selecthdb(VoteEntity voteEntity);

    List<VoteEntity>  selectPdx(VoteEntity voteEntity);

    //修改图片路径
    int updatetup(VoteEntity voteEntity);

    //投票tpjl
    int inserttpjl(VoteEntity voteEntity);

    //修改被投人的信息
    int xiubeitour(VoteEntity voteEntity);

    //查询被投人的信息
    List<VoteEntity> selectbeitou();

    //删除被投人
    int deletebeitour(int p_id);

    //通过标题id查出tpjl表的信息
    List<VoteEntity> selectbtchatpjl(int p_id);

    //通过tpjl表查出pdx表的数据
    List<VoteEntity> selecttpjlpdx(int t_pid);

    //查询投票人
    List<VoteEntity> chaxuntoup(String x_name);

    int xiugaitoup(VoteEntity voteEntity1);

    List<VoteEntity> zhidselect(int z_hid);

}
