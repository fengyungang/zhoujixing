package com.zhoujixing.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * <p class="detail">
 * 功能：公共上传
 * </p>
 *
 * @ClassName: BaseAction
 * @version V1.0
 * @date 2014年9月25日
 * @author wangsheng
 */
public class FileUpload {
    private String allowSuffix = "JPG,PNG,GIF,JPEG,PDF,DOC,DOCX,XLS,XLSX,PPT,PPTX";//允许文件格式
    private int allowSize = 10;//允许文件大小
    private String fileName;
    private String[] fileNames;

    public String getAllowSuffix() {
        return allowSuffix;
    }

    public void setAllowSuffix(String allowSuffix) {
        this.allowSuffix = allowSuffix;
    }

    public long getAllowSize() {
        return allowSize*1024*1024;
    }

    public void setAllowSize(int allowSize) {
        this.allowSize = allowSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }



    /**
     *
     * <p class="detail">
     * 功能：重新命名文件
     * </p>
     * @author wangsheng
     * @date 2014年9月25日
     * @return
     */
    private String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }

    /**
     *
     * <p class="detail">
     * 功能：文件上传
     * </p>
     * @author wangsheng
     * @date 2014年9月25日
     * @param files
     * @param destDir
     * @throws Exception
     */
    public void uploads(MultipartFile[] files, String destDir, HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        try {
            fileNames = new String[files.length];
            int index = 0;
            for (MultipartFile file : files) {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                int length = getAllowSuffix().indexOf(suffix);
                if(length == -1){
                    throw new Exception("请上传允许格式的文件");
                }
                if(file.getSize() > getAllowSize()){
                    throw new Exception("您上传的文件大小已经超出范围");
                }
                String realPath = request.getSession().getServletContext().getRealPath("/");
                File destFile = new File(realPath+destDir);
                if(!destFile.exists()){
                    destFile.mkdirs();
                }
               // String fileNameNew = getFileNameNew()+"."+suffix;//
                File f = new File(destFile.getAbsoluteFile()+"\\"+file.getOriginalFilename());
                file.transferTo(f);
                f.createNewFile();
                fileNames[index++] = destDir+file.getOriginalFilename();
        }
    } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * <p class="detail">
     * 功能：文件上传
     * </p>
     * @author wangsheng
     * @date 2014年9月25日
     * @param file
     * @param destDir
     * @throws Exception
     */
    public void upload(@RequestParam(value = "frs")MultipartFile file, String destDir, HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            int length = getAllowSuffix().indexOf(suffix.toUpperCase());
            if(length == -1){
                throw new Exception("请上传允许格式的文件");
            }
            if(file.getSize() > getAllowSize()){
                throw new Exception("您上传的文件大小已经超出范围");
            }

            //String realPath = request.getSession().getServletContext().getRealPath("/");
            //写死路径固定磁盘
            String realPath = "F:\\img";
            File destFile = new File(realPath+destDir);
            if(!destFile.exists()){
                destFile.mkdirs();
            }
           /* String fileNameNew = getFileNameNew()+"."+suffix;*/
            File f = new File(destFile.getAbsoluteFile()+"/"+file.getOriginalFilename());
            if(!f.exists()){
                file.transferTo(f);
                f.createNewFile();
            }
            fileName = destDir+file.getOriginalFilename();
        } catch (Exception e) {
            throw e;
        }
    }
}
