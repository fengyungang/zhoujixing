package com.zhoujixing.controller;

import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.GoodEntity;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.service.GoodService;
import com.zhoujixing.service.NewsService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 点赞管理逻辑层
 */
@io.swagger.annotations.Api(value="good接口", tags="good接口")
@RestController
@RequestMapping("good")
public class GoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private NewsService newsService;

    /**
     * 添加点赞
     * @param goodEntity
     * @return
     */
    @ApiOperation(value = "添加点赞", notes = "addGood接口的添加点赞方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "关联的新闻表的主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "user_id", value = "关联的用户表的主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PostMapping("/addGood")
    public Result addGood(GoodEntity goodEntity) {

        //设置查询条件
        Map<String,Object> map = new HashMap<>();

        map.put("user_id",goodEntity.getUser_id());
        map.put("news_id",goodEntity.getNews_id());
        //根据用户id和新闻id查询点赞列表
        List<GoodEntity> goodEntities = goodService.getList(map);
        //判断用户点赞次数
        if (goodEntities.size()==0){
            //点赞
            goodEntity.setGood_create_time(new Date());
            goodService.add(goodEntity);
            newsService.addGood(goodEntity.getNews_id());

            return Result.generate(0, "add Good success", goodEntity);
        }else {
            //点过赞
            return Result.generate(1,"add Good limit",null);
        }
    }

    /**
     * 查询点赞列表信息（可按条件模糊查询）
     * @param news_id
     * @param user_id
     * @param good_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询点赞列表信息（可按条件模糊查询）",notes = "selAGood接口的查询点赞列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "关联的新闻表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "user_id", value = "关联的用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "good_create_time", value = "点赞时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selAGood")
    public Result selAGood(Integer news_id,Integer user_id,String good_create_time,Integer pageIndex,Integer pageSize)
    {
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("news_id",news_id);
        if (good_create_time!=null&&!"".equals(good_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("good_create_time", DateUtils.StD(good_create_time,"yyyy-MM-dd HH:mm:ss"));
        }
        return Result.generate(0,"select Good success",goodService.selA(map,pageIndex,pageSize));
    }

    /**
     * 查询点赞信息（根据id查询单条）
     * @param good_id
     * @return
     */
    @ApiOperation(value = "查询点赞信息（根据id查询单条）",notes = "selOGood接口的查询点赞信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "good_id", value = "点赞表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOComment")
    public Result selOComment(Integer good_id) {
        GoodEntity goodEntity = goodService.getById(good_id);
        return Result.generate(0, "select Good success", goodEntity);
    }

    /**
     * 删除单条点赞记录（物理删除）
     * @param good_id
     * @return
     */
    @ApiOperation(value = "删除单条点赞记录（物理删除）", notes = "delGood接口的删除单条点赞记录（物理删除）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "good_id", value = "点赞表主键id", required = true, dataType = "Integer", paramType = "query")
    })

    @DeleteMapping("/delGood")
    public Result delGood(Integer good_id) {
        int res =goodService.delById(good_id);
        if (res < 0) {
            return Result.generate(1, "delete Good fail ", null);
        }
        return Result.generate(0, "delete Good success", null);
    }
}