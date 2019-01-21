package com.zhoujixing.controller;

import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.NewsEntity;
import com.zhoujixing.service.CommentService;
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
 * 用户评论管理逻辑层
 */
@io.swagger.annotations.Api(value="comment接口", tags="comment接口")
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param commentEntity
     * @return
     */
    @ApiOperation(value = "添加评论", notes = "addComment接口的添加评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联的用户表的主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "news_id", value = "关联的新闻表的主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "comment_content", value = "评论的内容", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("/addComment")
    public Result addComment(CommentEntity commentEntity) {
        System.out.println(commentEntity);
        commentEntity.setComment_del("0");
        commentEntity.setComment_create_time(new Date());
        commentService.add(commentEntity);
        return Result.generate(0, "add Comment success", commentEntity);
    }

    /**
     * 修改评论内容
     * @param commentEntity
     * @return
     */
    @ApiOperation(value = "修改评论内容", notes = "updComment接口的修改评论内容方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论表主键id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "comment_content", value = "评论的内容", required = false, dataType = "String", paramType = "query")
    })

    @PutMapping("/updComment")
    public Result updNews(CommentEntity commentEntity) {
        commentEntity.setComment_id(commentEntity.getComment_id());
        int res =commentService.update(commentEntity);
        if (res < 0) {
            return Result.generate(1, "update Comment fail ", null);
        }
        return Result.generate(0, "update Comment success", commentEntity);
    }

    /**
     * 查询评论内容列表信息（可按条件模糊查询）
     * @param user_id
     * @param news_id
     * @param comment_content
     * @param comment_create_time
     * @param comment_del
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询评论内容列表信息（可按条件模糊查询）",notes = "selAComment接口的查询评论内容列表信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联的用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "news_id", value = "关联的新闻表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "comment_content", value = "评论的内容", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "comment_create_time", value = "评论时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "comment_del", value = "删除状态（0未删除，1已删除）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selAComment")
    public Result selAComment(Integer user_id,Integer news_id,String comment_content,String comment_create_time,String comment_del,Integer pageIndex,Integer pageSize)
    {
        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("news_id",news_id);
        map.put("comment_content",comment_content);
        map.put("comment_del",comment_del);
        if (comment_create_time!=null&&!"".equals(comment_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("comment_create_time", DateUtils.StD(comment_create_time,"yyyy-MM-dd HH:mm:ss"));
        }
        return Result.generate(0,"select Comment success",commentService.selA(map,pageIndex,pageSize));
    }

    /**
     * 查询评论信息（根据id查询单条）
     * @param comment_id
     * @return
     */
    @ApiOperation(value = "查询评论信息（根据id查询单条）",notes = "selOComment接口的查询评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @ResponseBody
    @GetMapping("/selOComment")
    public Result selOComment(Integer comment_id) {
        CommentEntity commentEntity = commentService.getById(comment_id);
        return Result.generate(0, "select Comment success", commentEntity);
    }

    /**
     * 删除评论（逻辑删除）
     * @param commentEntity
     * @return
     */
    @ApiOperation(value = "删除评论（逻辑删除）", notes = "UdelComment接口的删除评论（逻辑删除）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })

    @PutMapping("/UdelComment")
    public Result UdelComment(CommentEntity commentEntity) {
        commentEntity.setComment_id(commentEntity.getComment_id());
        commentEntity.setComment_del("1");
        int res =commentService.update(commentEntity);
        if (res < 0) {
            return Result.generate(1, "delete Comment fail ", null);
        }
        return Result.generate(0, "delete Comment success", commentEntity);
    }

    /**
     * 删除评论（物理删除）
     * @param comment_id
     * @return
     */
    @ApiOperation(value = "删除评论（物理删除）", notes = "MdelComment接口的删除评论（物理删除）方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })

    @DeleteMapping("/MdelComment")
    public Result MdelComment(Integer comment_id) {
        int res =commentService.delById(comment_id);
        if (res < 0) {
            return Result.generate(1, "delete Comment fail ", null);
        }
        return Result.generate(0, "delete Comment success", null);
    }

}




