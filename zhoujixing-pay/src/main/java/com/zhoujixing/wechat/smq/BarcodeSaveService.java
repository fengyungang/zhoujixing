package com.zhoujixing.wechat.smq;

public interface BarcodeSaveService {
    /**
     * 在这里释放资源，如数据库连接，关闭文件，关闭网络连接等
     */
    void finish();

    /**
     * 保存条形码
     * @param barcode
     */
    void save(String barcode);
}
