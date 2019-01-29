package com.zhoujixing.demo;

public class FileNameUtils {
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    //传入用户的原始名称UUIDUtils.getUUID()方法
    public static String getFileName(String fileOriginName,String aaa){
        return UUIDUtils.getUUID(aaa) + FileNameUtils.getSuffix(fileOriginName);

    }
}
