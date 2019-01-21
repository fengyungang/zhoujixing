package com.zhoujixing.wechat.smq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *条形码数据缓存区
 * 扫描服务获取到扫描枪输入的数据后将数据加入此缓存区
 * 消费者线程会从此缓冲区中获取数据并执行数据的保存操作
 * 数据的保存可以有多种实现
 * 此缓冲区的意义在于不要因为数据保存出错或速度慢而影响扫描服务工作
 */
public class BarcodeBuffer {
    //阻塞队列
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    /**
     * 产生一条数据，此方法有BarcodeProducterd调用
     * @param barcode
     */
    public static void product(String barcode){
        queue.add(barcode);
    }
    public static String consume() throws InterruptedException {
        return queue.take();
    }
}
