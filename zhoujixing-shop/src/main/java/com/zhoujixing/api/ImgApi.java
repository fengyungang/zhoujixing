package com.zhoujixing.api;

import com.alibaba.fastjson.JSONObject;

import com.zhoujixing.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * 文件上传区分文件目录
 */
@RequestMapping("fileOther")
@Controller
/*@CrossOrigin(origins = "*", maxAge = 3600)*/
@Api(value="其他文件上传管理", tags="其他文件上传接口")
public class ImgApi extends com.zhoujixing.utils.FileUpload {

    /**
     * 获取本地图片
     * @param req
     * @param url
     * @param response
     * @throws UnsupportedEncodingException
     */
    @ApiOperation(value = "获取本地图片",notes = "获取本地图片",httpMethod = "POST")
    @ApiImplicitParam(name = "url",value = "图片地址",dataType = "String",paramType = "query")
    @RequestMapping(value = "/getImageData")
    public void getImageData(
            HttpServletRequest req, String url, HttpServletResponse response)
            throws UnsupportedEncodingException {

        //String realPath = req.getSession().getServletContext().getRealPath("/");
        //固定路径
        String realPath = "F:\\img";
        // 设置返回的信息
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("image/jpeg");
        File file = new File(realPath + url);
        byte buffBytes[] = new byte[1024];
        ServletOutputStream out;
        try {
            if (file.exists()) {
                @SuppressWarnings("resource")
                BufferedInputStream input = new BufferedInputStream(
                        new FileInputStream(file));
                out = response.getOutputStream();
                int read = 0;
                while ((read = input.read(buffBytes)) != -1) {
                    out.write(buffBytes, 0, read);
                }
                out.flush();
                out.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 上传图片区分文件目录
     * @param file
     * @param request
     * @param response
     * @param flag
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("ImgUpload")
    @ResponseBody
    @ApiOperation(value = "上传图片",notes = "上传图片",httpMethod = "POST")
    @ApiImplicitParam(name = "file",value = "文件",dataType = "__file",paramType = "query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "文件",dataType = "MultipartFile",paramType = "query"),
            @ApiImplicitParam(name = "flag", value = "文件类别", required = false, dataType = "int", paramType = "query"),

    })
    public String productPhotoUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                     HttpServletRequest request,
                                     HttpServletResponse response, Integer flag) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        JSONObject resultObj = new JSONObject();
        resultObj.put("code", 0);
        resultObj.put("message", "上传成功");
        try {
            super.upload(file, judgeTimeByYear(flag), request);
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            JSONObject resMap = new JSONObject();
            resMap.put("fileName", file.getOriginalFilename());
            resMap.put("fileUrl", super.getFileName());
            resMap.put("suffix", suffix);
            resultObj.put("result", resMap);


        } catch (Exception e) {
            resultObj.put("code", 0);
            resultObj.put("message", e.getMessage());
        }

        return resultObj.toString();
    }


    public String judgeTimeByYear(Integer flag) {

        String month = DateUtils.DtS(new Date(),"MM");

        switch(flag){
            case 0:
                return "/course/" + month + "/";
            case 1:
                return "/department/" + month + "/";
            case 2:
                return "/disrict/" + month + "/";

            case 3:
                return "/essay/" + month + "/";

            case 4:
                return "/staff/" + month + "/";

            case 5:
                return "/user/" + month + "/";
                
            default:
                return "/img/" + month + "/";
        }

    }

}
