package com.participate.api;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 基础注释包，用于定义api层类的同一属性，例如：跨域、swagger注释等等
 *
 */
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或日期/数字字段格式不正确。"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")}
)
// @CrossOrigin 开启跨域 origins允许地址，最大链接时间，https 跨域错误 加上http网址即可
@CrossOrigin(origins = "*", maxAge = 3600)
// @Profile({"dev","test"}) dev test开启swagger
//@Profile({"dev","test"})
public abstract class BaseApi {
        protected static final Logger logger = LoggerFactory.getLogger(BaseApi.class);

}
