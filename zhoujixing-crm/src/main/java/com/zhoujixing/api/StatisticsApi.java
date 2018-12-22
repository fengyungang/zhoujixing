package com.zhoujixing.api;

import com.zhoujixing.logic.StatisticsLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@io.swagger.annotations.Api(value="statistics接口", tags="statistics接口")
@RestController
@RequestMapping("api/statistics")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StatisticsApi extends BaseApi {

    @Autowired
    private StatisticsLogic statisticsLogic;

    /**
     * 上周每天的评论及对应数量多条折线统计图(x显示时间日期，y数量，l评论说明)
     * @return
     */
    @ApiOperation(value = "上周每天的评论及对应数量多条折线统计图",notes = "weekShowO接口的上周每天的评论及对应数量多条折线统计图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/weekShowO")
    public Result weekShowO() {
        return statisticsLogic.getLastWeekStackedLineChartByDayXNumYCodeL();
    }

    /**
     * 上周每天评论总数量，折线或曲线图（x日期时间，y数量，统计每天评论的数量）
     * @param smooth
     * @return
     */
    @ApiOperation(value = "上周每天评论总数量，折线或曲线图",notes = "weekShowT接口的上周每天评论总数量，折线或曲线图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smooth", value = "统计图类型（false折线图，true曲线图）", required = false, dataType = "Boolean", paramType = "query",defaultValue="false"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/weekShowT")
    public Result weekShowT(Boolean smooth) {
        return statisticsLogic.getLastWeekBasicOrSmoothedLineChartBydayXSumY(smooth);
    }

    /**
     *  前面七天每天的评论及对应数量多条折线统计图(x显示时间日期，y数量，l评论说明)
     * @return
     */
    @ApiOperation(value = " 前面七天每天的评论及对应数量多条折线统计图",notes = "qikShowO接口的前面七天每天的评论及对应数量多条折线统计图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/qikShowO")
    public Result qikShowO() {
        return statisticsLogic.getSevenDaysStackedLineChartByDayXNumYCodeL();
    }

    /**
     *   前面七天每天评论总数量，折线或曲线图（x日期时间，y数量，统计每天评论的数量）
     * @return
     */
    @ApiOperation(value = "  前面七天每天评论总数量，折线或曲线图",notes = "qikShowT接口的 前面七天每天评论总数量，折线或曲线图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smooth", value = "统计图类型（false折线图，true曲线图）", required = false, dataType = "Boolean", paramType = "query",defaultValue="false"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/qikShowT")
    public Result qikShowT(Boolean smooth) {
        return statisticsLogic.getSevenDaysBasicOrSmoothedLineChartBydayXSumY(smooth);
    }

    /**
     * 上个月每天的评论及对应数量多条折线统计图(x显示时间日期，y数量，l评论说明)
     * @return
     */
    @ApiOperation(value = "上个月每天的评论及对应数量多条折线统计图",notes = "monthShowO接口的上个月每天的评论及对应数量多条折线统计图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/monthShowO")
    public Result monthShowO() {
        return statisticsLogic.getLastMonthStackedLineChartByDayXNumYCodeL();
    }

    /**
     * 上个月每天评论总数量，折线或曲线图（x日期时间，y数量，统计每天评论的数量）
     * @param smooth
     * @return
     */
    @ApiOperation(value = "上个月每天评论总数量，折线或曲线图",notes = "monthShowT接口的上个月每天评论总数量，折线或曲线图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smooth", value = "统计图类型（false折线图，true曲线图）", required = false, dataType = "Boolean", paramType = "query",defaultValue="false"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/monthShowT")
    public Result monthShowT(Boolean smooth) {
        return statisticsLogic.getLastMonthBasicOrSmoothedLineChartBydayXSumY(smooth);
    }

    /**
     * 昨天每小时的评论及对应数量多条折线统计图(x显示时间日期，y数量，l评论说明)
     * @return
     */
    @ApiOperation(value = "昨天每小时的评论及对应数量多条折线统计图",notes = "hourShowO接口的昨天每小时的评论及对应数量多条折线统计图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "start", value = "开始时间（格式：yyyy-MM-dd-HH）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "结束时间（格式：yyyy-MM-dd-HH）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/hourShowO")
    public Result hourShowO(String start,String end) {
        return statisticsLogic.getHourStackedLineChartByDayXNumYCodeL(start,end);
    }

    /**
     * 昨天每小时评论总数量，折线或曲线图（x日期时间，y数量，统计每天评论的数量）
     * @param smooth
     * @return
     */
    @ApiOperation(value = "昨天每小时评论总数量，折线或曲线图",notes = "hourShowT接口的昨天每小时评论总数量，折线或曲线图", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smooth", value = "统计图类型（false折线图，true曲线图）", required = false, dataType = "Boolean", paramType = "query",defaultValue="false"),
            @ApiImplicitParam(name = "start", value = "开始时间（格式：yyyy-MM-dd-HH）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "结束时间（格式：yyyy-MM-dd-HH）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/hourShowT")
    public Result hourShowT(Boolean smooth,String start,String end) {
        return statisticsLogic.getHourBasicOrSmoothedLineChartBydayXSumY(smooth,start,end);
    }

    /**
     * 获取一段时间内的各个评论的总数
     * @param smooth
     * @return
     */
    @ApiOperation(value = "获取一段时间内的各个评论的总数",notes = "spaceShow接口的获取一段时间内的各个评论的总数", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smooth", value = "统计图类型（false折线图，true曲线图）", required = false, dataType = "Boolean", paramType = "query",defaultValue="false"),
            @ApiImplicitParam(name = "start", value = "开始时间（格式：yyyy-MM-dd）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "end", value = "结束时间（格式：yyyy-MM-dd）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/spaceShow")
    public Result spaceShow(Boolean smooth,String start,String end) {
        return statisticsLogic.getDayBasicOrSmoothedLineChartByCodeXSumY(smooth,start,end);
    }

}
