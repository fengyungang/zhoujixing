package com.zhoujixing.logic;


import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CommentModel;
import com.zhoujixing.service.CartService;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.utils.DateUtils;
import com.zhoujixing.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品评论逻辑层
 */
@Component
public class CommentLogic {
    @Autowired
    private CommentService commentService;
    /**
     * 添加商品评论
     * @param commentModel
     * @return
     */
    public Result addComment(CommentModel commentModel){
        commentModel.setShop_comment_create_time(new Date());

        int res = commentService.add(commentModel);
        return Result.generate(0,"add comment success",commentModel);
    }

    /**
     * 根据id查询商品的评论信息
     * @param shop_comment_id
     * @return
     */
    public Result getById(Integer shop_comment_id){
        CommentModel commentModel = commentService.getById(shop_comment_id);
        return Result.generate(0,"select comment success",commentModel);
    }

    /**
     * 查询所有的商品评论信息列表（可按条件模糊查询）
     * @param user_id
     * @param shop_goods_id
     * @param shop_comment_content
     * @param shop_comment_create_time
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Result selAll(Integer user_id, Integer shop_goods_id, String shop_comment_content,String shop_comment_create_time,Integer pageIndex,Integer pageSize){

        // 设置默认页码每页数量
        pageIndex = pageIndex==null?1:pageIndex;
        pageSize = pageSize==null?5:pageSize;

        Map<String,Object> map = new HashMap<>();

        map.put("user_id",user_id);
        map.put("shop_goods_id",shop_goods_id);
        map.put("shop_comment_content",shop_comment_content);

        if (shop_comment_create_time!=null&&!"".equals(shop_comment_create_time)){
            //传入格式 yyyy-MM-dd，判断是否为空，空指针
            map.put("shop_comment_create_time", DateUtils.StD(shop_comment_create_time,"yyyy-MM-dd"));
        }
        return Result.generate(0,"select comment success",commentService.selA(map,pageIndex,pageSize));
    }

    /**
     * 根据id修改商品评论信息
     * @param commentModel
     * @return
     */
    public Result updComment(CommentModel commentModel){
        int res = commentService.update(commentModel);
        if (res<0){
            return Result.generate(1,"update comment fail ",null);
        }
        return Result.generate(0,"update comment success",commentModel);
    }

    /**
     * 删除商品评论信息
      * @return customer_id
     */
    public Result delComment(Integer shop_comment_id){
        CommentModel commentModel = new CommentModel();
        commentModel.setShop_comment_id(shop_comment_id);

        int res = commentService.delById(shop_comment_id);
        if (res<0){
            return Result.generate(0,"delet comment fail",null);
        }else {
            return Result.generate(0,"delet comment success",null);
        }

    }


}