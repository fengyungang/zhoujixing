package com.zhoujixing.server.impl;

import com.zhoujixing.entity.VoteEntity;
import com.zhoujixing.mapper.VoteMapper;
import com.zhoujixing.server.VoteServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class VoteServerImpl implements VoteServer {

    @Autowired
    private VoteMapper voteMapper;
    @Override
    public int insertSheZhi(VoteEntity voteEntity) {
        return voteMapper.insertSheZhi(voteEntity);
    }

    @Override
    public int insertZhid(VoteEntity voteEntity) {
        return voteMapper.insertZhid(voteEntity);
    }

    @Override
    public int insertTpjl(VoteEntity voteEntity) {
        return voteMapper.insertTpjl(voteEntity);
    }

    @Override
    public int insertPdx(VoteEntity voteEntity) {
        return voteMapper.insertPdx(voteEntity);
    }

    @Override
    public int insertHdb(VoteEntity voteEntity) {
        return voteMapper.insertHdb(voteEntity);
    }

    @Override
    public List<VoteEntity>  selecthdb(VoteEntity voteEntity) {
        return voteMapper.selecthdb(voteEntity);
    }

    @Override
    public List<VoteEntity> selectPdx(VoteEntity voteEntity) {
        return voteMapper.selectPdx(voteEntity);
    }

    @Override
    public int updatetup(VoteEntity voteEntity) {
        return voteMapper.updatetup(voteEntity);
    }

    @Override
    public int inserttpjl(VoteEntity voteEntity) {
        return voteMapper.inserttpjl(voteEntity);
    }

    @Override
    public int xiubeitour(VoteEntity voteEntity) {
        return voteMapper.xiubeitour(voteEntity);
    }

    @Override
    public List<VoteEntity> selectbeitou() {
        return voteMapper.selectbeitou();
    }

    @Override
    public int deletebeitour(int p_id) {
        return voteMapper.deletebeitour(p_id);
    }

    @Override
    public List<VoteEntity> selectbtchatpjl(int p_id) {
        return voteMapper.selectbtchatpjl(p_id);
    }

    @Override
    public List<VoteEntity> selecttpjlpdx(int t_pid) {
        return voteMapper.selecttpjlpdx(t_pid);
    }

    @Override
    public List<VoteEntity> chaxuntoup(String x_name) {
        return voteMapper.chaxuntoup(x_name);
    }

    @Override
    public int xiugaitoup(VoteEntity voteEntity1) {
       return voteMapper.xiugaitoup(voteEntity1);
    }

    @Override
    public List<VoteEntity> zhidselect(int z_hid) {
        return voteMapper.zhidselect(z_hid);
    }


}
