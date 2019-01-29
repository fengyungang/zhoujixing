package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class GoodsDetail {
    //商品的编号
    private String goods_id;
    //商品名称
    private String goods_name;
    //商品数量
    private Integer quantity;
    //商品单价，单位为元
    private BigDecimal price;
    //商品类目
    private String goods_category;
    //商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割
    private String categories_tree;
    //商品描述信息
    private String body;
    //商品的展示地址
    private String show_url;

}
