package com.zhoujixing.controller;

import com.zhoujixing.entity.CooperateEntity;
import com.zhoujixing.entity.NewsEntity;
import com.zhoujixing.service.CooperateService;
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
import java.util.Map;

/**
 * 新闻管理逻辑层
 */
@io.swagger.annotations.Api(value="news接口", tags="news接口")
@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 添加新闻文章
     * @param newsEntity
     * @return
     */
    @ApiOperation(value = "添加新闻文章", notes = "addNews接口的添加新闻文章信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "发布文章作者（关联用户表的主键id）", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "news_title", value = "文章标题", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_content", value = "文章内容", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_type", value = "文章类型（0企业类型，1行业类型）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_subordinate", value = "文章所属（0原创，1转载）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_route", value = "转载路径", required = false, dataType = "String", paramType = "query")
    })
    @PostMapping("/addNews")
    public Result addNews(NewsEntity newsEntity) {
        System.out.println(newsEntity);
        newsEntity.setNews_del("0");
        newsEntity.setNews_browse(0);
        newsEntity.setNews_good(0);
        newsEntity.setNews_create_time(new Date());
        newsService.add(newsEntity);
        return Result.generate(0, "add News success", newsEntity);
    }

    /**
     * 修改新闻信息
     * @param newsEntity
     * @return
     */
    @ApiOperation(value = "修改新闻信息", notes = "updNews接口的修改新闻信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "新闻表主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "user_id", value = "发布文章作者（关联用户表的主键id）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "news_title", value = "文章标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_content", value = "文章内容", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_type", value = "文章类型（0企业类型，1行业类型）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_subordinate", value = "文章所属（0原创，1转载）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_route", value = "转载路径", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_browse", value = "浏览次数", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_good", value = "点赞次数", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_create_time", value = "文章发布时间", required = false, dataType = "String", paramType = "query")

    })

    @PutMapping("/updNews")
    public Result updNews(NewsEntity newsEntity) {
        newsEntity.setNews_id(newsEntity.getNews_id());
        int res =newsService.update(newsEntity);
        if (res < 0) {
            return Result.generate(1, "update News fail ", null);
        }
        return Result.generate(0, "update News success", newsEntity);
    }

    /**
     *  查询新闻列表信息（可按条件模糊查询）
     * @param user_id
     * @param news_title
     * @param news_content
     * @param news_type
     * @param news_subordinate
     * @param news_route
     * @param news_browse
     * @param news_good
     * @param news_create_time
     * @param news_del
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询新闻列表信息（可按条件模糊查询）",notes = "selANews接口的查询新闻列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "发布文章作者（关联用户表的主键id）", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "news_title", value = "文章标题", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_content", value = "文章内容", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_type", value = "文章类型（0企业类型，1行业类型）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_subordinate", value = "文章所属（0原创，1转载）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_route", value = "转载路径", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_browse", value = "浏览次数", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_good", value = "点赞次数", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_create_time", value = "文章发布时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "news_del", value = "删除状态（0未删除，1已删除）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selANews")
    public Result selANews(Integer user_id,String news_title,String news_content,String news_type,String news_subordinate,String news_route,Integer news_browse,Integer news_good,String news_create_time,String news_del,Integer pageIndex,Integer pageSize)
    {
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("news_title",news_title);
        map.put("news_content",news_content);
        map.put("news_type",news_type);
        map.put("news_subordinate",news_subordinate);
        map.put("news_route",news_route);
        map.put("news_browse",news_browse);
        map.put("news_good",news_good);
        map.put("news_del",news_del);
        if (news_create_time!=null&&!"".equals(news_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("news_create_time", DateUtils.StD(news_create_time,"yyyy-MM-dd HH:mm:ss"));
        }
        return Result.generate(0,"select News success",newsService.selA(map,pageIndex,pageSize));
    }

    /**
     * 查询新闻信息（根据id查询单条）
     * @param news_id
     * @return
     */
    @ApiOperation(value = "查询新闻信息（根据id查询单条）",notes = "selONews接口的查询新闻信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "新闻表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selONews")
    public Result selONews(Integer news_id) {
        //阅读量加一
        int res = newsService.addBrowse(news_id);
        //查询文章
        NewsEntity newsEntity = newsService.getById(news_id);
        return Result.generate(0, "select News success", newsEntity);
    }

    /**
     * 删除新闻（逻辑删除）
     * @param newsEntity
     * @return
     */
    @ApiOperation(value = "删除新闻（逻辑删除）", notes = "UdelNews接口的删除新闻（逻辑删除）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "新闻表主键id", required = true, dataType = "Integer", paramType = "query")
    })

    @PutMapping("/UdelNews")
    public Result UdelNews(NewsEntity newsEntity) {
        newsEntity.setNews_id(newsEntity.getNews_id());
        newsEntity.setNews_del("1");
        int res =newsService.update(newsEntity);
        if (res < 0) {
            return Result.generate(1, "delete News fail ", null);
        }
        return Result.generate(0, "delete News success", newsEntity);
    }

    /**
     * 删除新闻（物理删除）
     * @param news_id
     * @return
     */
    @ApiOperation(value = "删除新闻（物理删除）", notes = "MdelNews接口的删除新闻（物理删除）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news_id", value = "新闻表主键id", required = true, dataType = "Integer", paramType = "query")
    })

    @DeleteMapping("/MdelNews")
    public Result MdelNews(Integer news_id) {
        int res =newsService.delById(news_id);
        if (res < 0) {
            return Result.generate(1, "delete News fail ", null);
        }
        return Result.generate(0, "delete News success", null);
    }



}




