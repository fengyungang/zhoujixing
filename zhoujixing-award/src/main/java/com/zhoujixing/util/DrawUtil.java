package com.zhoujixing.util;

import com.zhoujixing.entity.Lottery;

import java.util.ArrayList;
import java.util.List;

public class DrawUtil {

    /**
     * 给转盘的每个角度赋初始值
     */
    private final static List<Lottery> initList = new ArrayList<Lottery>(){{
        add(new Lottery(1,"鼠",5));
        add(new Lottery(2,"牛",6));
        add(new Lottery(3,"虎",20));
        add(new Lottery(4,"兔",6));
        add(new Lottery(5,"龙",20));
        add(new Lottery(6,"蛇",5));
        add(new Lottery(7,"马",15));
        add(new Lottery(8,"羊",3));
        add(new Lottery(9,"猴",15));
        add(new Lottery(10,"鸡",3));
        add(new Lottery(11,"狗",1));
        add(new Lottery(12,"猪",1));
    }};

    public Lottery generateAward(){
        List<Lottery> init = initList;
        long result = randomnum(1,100);
        int line =0;
        int temp = 0;
        Lottery lottery = null;
        int index = 0;
        for(int i=0;i<initList.size();i++){
            Lottery lottery1 = initList.get(i);
            int c = lottery1.getV();
            temp = temp + c;
            line = 100 - temp;
            if(c != 0){
                if(result > line && result <= (line + c)){
                    lottery = lottery1;
                    break;
                }
            }
        }
        return lottery;

    }

    //获取两个值之间的随机数
    private long randomnum(int smin,int smax){
        int range = smax - smin;
        double rand = Math.random();
        return (smin + Math.round(rand * range));
    }


    public static void main(String[] args) {
        DrawUtil d = new DrawUtil();
        System.out.println(d.generateAward());
    }
}
