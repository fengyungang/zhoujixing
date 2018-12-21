package com.participate.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.CallLogMapper;
import com.participate.entity.CallLogModel;
import com.participate.service.CallLogService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CallLogServiceImpl implements CallLogService {
    @Autowired
    private CallLogMapper callLogMapper;

    /**
     * 添加方法
     * @param callLogModel
     * @return
     */
    @Override
    public int add(CallLogModel callLogModel) {
        return callLogMapper.add(callLogModel);
    }

    /**
     * 根据id查询一条信息
     * @param call_log_id
     * @return
     */
    @Override
    public CallLogModel getById(Integer call_log_id) {
        return callLogMapper.getById(call_log_id);
    }

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<CallLogModel> callLogModelList = callLogMapper.selA(map);
        PageInfo<CallLogModel> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();

        map.put("callLogModelList",callLogModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<CallLogModel> selA(Map<String,Object> map) {
        return callLogMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param callLogModel
     * @return
     */
    @Override
    public int update(CallLogModel callLogModel) {
        return callLogMapper.update(callLogModel);
    }
}

