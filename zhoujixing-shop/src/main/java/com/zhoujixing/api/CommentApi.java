package com.zhoujixing.api;


import com.zhoujixing.entity.CommentModel;
import com.zhoujixing.logic.CommentLogic;
import com.zhoujixing.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 商品评论表api层
 */
@io.swagger.annotations.Api(value="comment接口", tags="comment接口")
@RestController
@RequestMapping("api/comment")
public class CommentApi extends BaseApi {
    @Autowired
    private CommentLogic commentLogic;

    /**
     * 添加商品评论
     * @param token
     * @param commentModel
     * @return
     */
    @ApiOperation(value = "添加商品评论",notes = "addComment接口的添加商品评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "shop_comment_content", value = "评论内容", required = true, dataType = "String", paramType = "form")
    })
    @PostMapping("/addComment")
    public Result addComment(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      CommentModel commentModel)
    {
        return commentLogic.addComment(commentModel);
    }

    /**
     * 删除商品评论信息
     * @param token
     * @param shop_comment_id
     * @return
     */
    @ApiOperation(value = "删除商品评论信息",notes = "delComment接口的删除商品评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_comment_id", value = "商品评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @DeleteMapping("/delComment")
    public Result delComment(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                      Integer shop_comment_id)
    {
        return commentLogic.delComment(shop_comment_id);
    }

    /**
     *  查询所有的商品评论信息列表（可按条件模糊查询）
     * @param token
     * @param user_id
     * @param shop_goods_id
     * @param shop_comment_content
     * @param shop_comment_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有的商品评论信息列表（可按条件模糊查询）",notes = "selAComment接口的查询所有的商品评论信息列表方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "关联外键用户表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_goods_id", value = "关联外键商品表的主键id", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shop_comment_content", value = "评论内容", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "shop_comment_create_time", value = "评论时间（创建时间）", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selAComment")
    public Result selAComment(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer user_id, Integer shop_goods_id, String shop_comment_content,String shop_comment_create_time,Integer pageIndex,Integer pageSize)
    {

        return commentLogic.selAll(user_id,shop_goods_id,shop_comment_content,shop_comment_create_time,pageIndex,pageSize);
    }

    /**
     * 根据id修改商品评论信息
     * @param token
     * @param commentModel
     * @return
     */
   @ApiOperation(value = "根据id修改商品评论信息",notes = "updComment接口的根据id修改商品评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_comment_id", value = "商品评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/updComment")
    public Result updComment(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                              CommentModel commentModel)
    {
        return commentLogic.updComment(commentModel);
    }

    /**
     * 根据id查询商品的评论信息
     * @param token
     * @param shop_comment_id
     * @return
     */
    @ApiOperation(value = "根据id查询商品的评论信息",notes = "selOComment接口的根据id查询商品的评论信息方法", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shop_comment_id", value = "商品评论表主键id", required = true, dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selOComment")
    public Result selOComment(@RequestHeader(name = "Authorization", defaultValue = "token") String token,
                               Integer shop_comment_id)
    {
        return commentLogic.getById(shop_comment_id);
    }


}