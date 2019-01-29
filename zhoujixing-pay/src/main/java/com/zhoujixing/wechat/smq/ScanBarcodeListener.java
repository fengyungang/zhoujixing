package com.zhoujixing.wechat.smq;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebListener
public class ScanBarcodeListener implements ServletContextListener {
    private BarcodeProducter barcodeProducter;
    private BarcodeConsumer barcodeConsumer;

    /**
     * tomcat 启动
     * @param event
     */
    public void contextInitialized(ServletContextEvent event){
        barcodeProducter = new BarcodeProducter();
        barcodeProducter.startProduct();
        barcodeConsumer = new BarcodeConsumer();
        barcodeConsumer.startConsume();
    }
    /**
     * tomcat关闭
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event){
        barcodeProducter.stopProduct();
        barcodeConsumer.stopConsume();
    }

    public static void main(String[] args) throws IOException {
        BarcodeProducter producter=new BarcodeProducter();
        BarcodeConsumer consumer=new BarcodeConsumer();

        producter.startProduct();

        consumer.startConsume();

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入 '<exit>' 退出程序");
        String line=reader.readLine();
        while(line!=null){
            if("exit".equals(line)){


                producter.stopProduct();
                consumer.stopConsume();
                System.exit(0);
            }
            line=reader.readLine();
        }
    }
}
