package com.zhoujixing.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhoujixing.entity.WordBookModel;
import com.zhoujixing.service.DateStatisticsService;
import com.zhoujixing.service.TimeStatisticsService;
import com.zhoujixing.service.WordBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 统计数据展示处理工具，传入时间段，返回不同格式数据
 */
@Component
public class StatisticsUtils {

    @Autowired
    private DateStatisticsService dateStatisticsService;

    @Autowired
    private TimeStatisticsService timeStatisticsService;

    @Autowired
    private WordBookService wordBookService;

    /**
     * 获取客户评价code，排除未联系0
     * @return
     */
    public List<WordBookModel> getCustomerReviews(){

        Map<String,Object> map = new HashMap<>();
        map.put("no_word_book_code",0);
        map.put("word_book_type","kehu");
        map.put("word_book_state","启用");
        map.put("order",1);

        return wordBookService.getCode(map);
    }

    public JSONObject BasicOrSmoothedLineChartByXY(String xAxisType,String yAxisType,String seriesType,Boolean smooth,Map<String,Object> map){
        //为空时默认为false
        smooth = smooth==null?false:smooth;
        //新建存储数据的jsonobject
        JSONObject option = new JSONObject();
        JSONObject xAxis = new JSONObject();
        JSONObject yAxis = new JSONObject();
        JSONArray seriesList = new JSONArray();

        //解析map
        List<String> x = (List<String>) map.get("x");
        List<Integer> y = (List<Integer>) map.get("y");

        //将数据放入对应的jsonObject中
        xAxis.put("type",xAxisType);
        xAxis.put("data",x);

        yAxis.put("type",yAxisType);

        JSONObject series = new JSONObject();
        series.put("data",y);
        series.put("type",seriesType);
        series.put("smooth",smooth);

        seriesList.add(series);

        //将包装数据放入jsonObject
        option.put("xAxis",xAxis);
        option.put("yAxis",yAxis);
        option.put("series",seriesList);

        return option;
        //格式化输出，防止null不输出
        //return JSON.toJSONString(option, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * xyl的数格式转换一下，变成折线图的形式
     *
     * @param text
     * @param trigger
     * @param left
     * @param right
     * @param bottom
     * @param containLabel
     * @param xAxisType
     * @param xAxisBoundaryGap
     * @param yAxisType
     * @param seriesType
     * @param seriesStack
     * @param map
     * @return
     */
    public JSONObject StackedLineChartByXYL(String text,String trigger,String left,String right,String bottom,Boolean containLabel,String xAxisType,Boolean xAxisBoundaryGap,String yAxisType,String seriesType,String seriesStack, Map<String,Object> map){

        //新建存储数据的jsonobject
        JSONObject option = new JSONObject();
        JSONObject title = new JSONObject();
        JSONObject tooltip = new JSONObject();
        JSONObject legend = new JSONObject();
        JSONObject grid = new JSONObject();
        JSONObject toolbox = new JSONObject();
        JSONObject feature = new JSONObject();
        JSONObject saveAsImage = new JSONObject();
        JSONObject xAxis = new JSONObject();
        JSONObject yAxis = new JSONObject();
        JSONArray seriesList = new JSONArray();

        //解析map获取参数
        List<String> x = (List<String>) map.get("x");
        Map<String,List<Integer>> y = (Map<String, List<Integer>>) map.get("y");
        List<String> l = (List<String>) map.get("legend");

        //为各个jsonObject赋值
        title.put("text",text);

        tooltip.put("trigger",trigger);

        legend.put("data",l);

        grid.put("left",left);
        grid.put("right",right);
        grid.put("bottom",bottom);
        grid.put("containLabel",containLabel);

        feature.put("saveAsImage",saveAsImage);
        toolbox.put("feature",feature);

        xAxis.put("type",xAxisType);
        xAxis.put("boundaryGap",xAxisBoundaryGap);
        xAxis.put("data",x);

        yAxis.put("type",yAxisType);


        //遍历y轴数据
        for (Map.Entry<String,List<Integer>> entry : y.entrySet()) {
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            JSONObject series = new JSONObject();

            series.put("name",entry.getKey());
            series.put("type",seriesType);
            series.put("stack",seriesStack);
            series.put("data",entry.getValue());

            seriesList.add(series);
        }

        //存储到option里
        option.put("title",title);
        option.put("tooltip",tooltip);
        option.put("legend",legend);
        option.put("grid",grid);
        option.put("toolbox",toolbox);
        option.put("xAxis",xAxis);
        option.put("yAxis",yAxis);
        option.put("series",seriesList);

        return option;
        //格式化输出，防止null不输出
        //return JSON.toJSONString(option, SerializerFeature.WriteNullListAsEmpty);
    }

    //获取以时间为x轴，评论为说明，数量为y轴
    public Map<String,Object> dayXNumYCodeL(List<Date> dates){

        Map<String,Object> map = new HashMap<>();
        //存储x轴信息
        List<String> xDay = new ArrayList<>();
        //存储y轴信息
        Map<String,List<Integer>> yNum = new LinkedHashMap<>();
        // 获取评论值，存储图说明信息
        List<String> lNames = new ArrayList<>();

        //现在的时间
        String flag = "";

        // 获取code和对应名字
        List<WordBookModel> wordBookModels = getCustomerReviews();

        //遍历code及名称，存储说明信息
        for (Iterator<WordBookModel> iterator = wordBookModels.iterator(); iterator.hasNext(); ) {
            WordBookModel next =  iterator.next();
            lNames.add(next.getWord_book_name());
        }

        //遍历日期
        for (Iterator<Date> iterator = dates.iterator(); iterator.hasNext(); ) {
            Date next =  iterator.next();

            //更改时间格式，存储x轴数据
            flag = DateUtils.DtS(next,"yyyy-MM-dd");
            xDay.add(flag);

            //遍历code
            for (Iterator<WordBookModel> integerIterator = wordBookModels.iterator(); integerIterator.hasNext(); ) {
                WordBookModel wordBookModel = integerIterator.next();

                //获取code、name
                Integer code = wordBookModel.getWord_book_code();
                String name = wordBookModel.getWord_book_name();

                //查询参数
                Map<String,Object> param = new HashMap<>();
                param.put("date_statistics_time",next);
                param.put("word_book_code",code);

                // 查询某一天固定code评论数量
                Integer total = dateStatisticsService.getCodeTotal(param);

                // 是否存在储存y轴数据 code对应的list
                if (yNum.get(name)==null){
                    // 创建code对应的list
                    List<Integer> list = new ArrayList<>();
                    list.add(total);
                    yNum.put(name,list);
                }else {
                    // 将数量传入对应的list
                    yNum.get(name).add(total);
                }
            }

        }
        // 将xy轴参数存入
        map.put("x",xDay);
        map.put("y",yNum);
        map.put("legend",lNames);
        return map;
    }

    //获取以时间为x轴，评论为说明，数量为y轴
    public Map<String,Object> hourXNumYCodel(List<Date> dates){

        Map<String,Object> map = new HashMap<>();
        //存储x轴信息
        List<String> xHour = new ArrayList<>();
        //存储y轴信息
        Map<String,List<Integer>> yNum = new HashMap<>();
        // 获取评论值，存储图说明信息
        List<String> names = new ArrayList<>();

        //现在的时间
        String flag = "";

        // 获取code和对应
        List<WordBookModel> wordBookModels = getCustomerReviews();
        //遍历获得说明信息
        for (Iterator<WordBookModel> iterator = wordBookModels.iterator(); iterator.hasNext(); ) {
            WordBookModel next =  iterator.next();
            names.add(next.getWord_book_name());
        }

        //遍历日期
        for (Iterator<Date> iterator = dates.iterator(); iterator.hasNext(); ) {
            Date next =  iterator.next();

            //更改时间格式，存储x轴数据
            flag = DateUtils.DtS(next,"HH");
            //去除首位0
            if (flag.substring(0,1).equals("0")){
                flag=flag.substring(1,2);
            }

            xHour.add(flag);

            //遍历code
            for (Iterator<WordBookModel> integerIterator = wordBookModels.iterator(); integerIterator.hasNext(); ) {
                WordBookModel wordBookModel = integerIterator.next();

                //获取code、name
                Integer code = wordBookModel.getWord_book_code();
                String name = wordBookModel.getWord_book_name();

                //参数
                Map<String,Object> param = new HashMap<>();
                param.put("time_statistics_time",next);
                param.put("word_book_code",code);

                // 查询某一天固定code评论数量
                Integer total = timeStatisticsService.getCodeTotal(param);

                // 是否存在储存y轴数据 code对应的list
                if (yNum.get(name)==null){
                    // 创建code对应的list
                    List<Integer> list = new ArrayList<>();
                    list.add(total);
                    yNum.put(name,list);
                }else {
                    // 将数量传入对应的list
                    yNum.get(name).add(total);
                }
            }

        }
        // 将xy轴参数存入
        map.put("x",xHour);
        map.put("y",yNum);
        map.put("legend",names);
        return map;
    }

    //获取以时间为x轴，评论为说明，数量为y轴
    public Map<String,Object> dayXSumY(List<Date> dates){

        Map<String,Object> map = new HashMap<>();
        //存储x轴信息
        List<String> xDay = new ArrayList<>();
        //存储y轴信息
        List<Integer> ySum = new ArrayList<>();
        //遍历日期
        for (Iterator<Date> iterator = dates.iterator(); iterator.hasNext(); ) {
            Date next =  iterator.next();
            //更改时间格式，存储x轴数据

            xDay.add(DateUtils.DtS(next,"yyyy-MM-dd"));
            Map<String,Object> param = new HashMap<>();
            //查询当天总数
            param.put("date_statistics_time",next);
            ySum.add(dateStatisticsService.getTotal(param));
            }

        // 将xy轴参数存入
        map.put("x",xDay);
        map.put("y",ySum);
        return map;
    }

    //获取以时间为x轴，评论为说明，数量为y轴
    public Map<String,Object> hourXSumY(List<Date> dates){

        Map<String,Object> map = new HashMap<>();
        //存储x轴信息
        List<String> xHour = new ArrayList<>();
        //存储y轴信息
        List<Integer> ySum = new ArrayList<>();
        String flag = "";
        //遍历日期
        for (Iterator<Date> iterator = dates.iterator(); iterator.hasNext(); ) {
            Date next =  iterator.next();
            //更改时间格式，存储x轴数据
            DateUtils.DtS(next,"HH");
            //去除首位0
            if (flag.substring(0,1).equals("0")){
                flag=flag.substring(1,2);
            }
            xHour.add(flag);

            Map<String,Object> param = new HashMap<>();
            //查询当前小时总数
            param.put("time_statistics_time",next);

            ySum.add(timeStatisticsService.getTotal(param));
        }

        // 将xy轴参数存入
        map.put("x",xHour);
        map.put("y",ySum);
        return map;
    }

    /**
     * 获取一段时间内，各评论的总数量
     *
     * @param start
     * @param end
     * @return
     */
    public Map<String,Object> codeXSumY(Date start, Date end){
        //返回结果
        Map<String,Object> map = new HashMap<>();
        //评论x轴
        List<String> codeX = new ArrayList<>();
        //总数量y轴
        List<Integer> sumY = new ArrayList<>();

        // 获取code和对应
        List<WordBookModel> wordBookModels = getCustomerReviews();

        for (Iterator<WordBookModel> iterator = wordBookModels.iterator(); iterator.hasNext(); ) {
            WordBookModel next =  iterator.next();
            //存储x轴
            codeX.add(next.getWord_book_name());
            //查询参数
            Map<String,Object> params = new HashMap<>();

            params.put("word_book_code",next.getWord_book_code());
            params.put("startTime",start);
            params.put("endTime",end);

            sumY.add(dateStatisticsService.getTotal(params));

        }
        map.put("x",codeX);
        map.put("y",sumY);
        return map;
    }



}
