package com.zhoujixing.controller;

import com.zhoujixing.entity.Lottery;
import com.zhoujixing.entity.Record;
import com.zhoujixing.entity.User;
import com.zhoujixing.service.RecordService;
import com.zhoujixing.service.UserService;
import com.zhoujixing.util.DrawUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AwardController {
    /**/
    @Autowired
    private UserService userService;

    @Autowired
    private RecordService recordService;

    @RequestMapping("/luckdraw")
    public Map<String,String> luckDraw(Integer id){
        Map<String,String> mapModel = new HashMap<>();
        Record record = new Record();
        User user = userService.getById(id);
        DrawUtil drawUtil = new DrawUtil();
        Lottery lottery ;

        if(user != null){
            Integer integral = user.getIntegral();
            if(integral>10){
                lottery = drawUtil.generateAward();
                integral -= 10;
                user.setIntegral(integral);
                userService.modifyUser(user);
                mapModel.put(user.getUserName(),lottery.getPrize());
                record.setUid(id);
                record.setPrizeName(lottery.getPrize());
                record.setCreateTime(new Date());

                recordService.addRecord(record);
            }

        }else {
            mapModel.put("111","请注册会员！");
        }
        return mapModel;
    }


}
