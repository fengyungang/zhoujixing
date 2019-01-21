package com.zhoujixing.wechat.smq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BarcodeConsumer {
    //消费者线程
    private Thread thread;
    //数据保存服务（可有多个）
    private List<BarcodeSaveService> barcodeSaveServices = new ArrayList<>();
    private boolean quit;

    public void stopConsume(){
        if (thread!=null){
            thread.interrupt();
            //释放资源
            for (BarcodeSaveService barcodeSaveService : barcodeSaveServices){
                barcodeSaveService.finish();
            }
        }
    }
    /**
     * 启动消费者线程
     * 此方法在Tomcat启动的时候被调用
     */
    public void startConsume(){
        if (thread != null && thread.isAlive()){
            return;
        }
        System.out.println("条形码消费者线程启动");

        System.out.println("注册条形码保存服务");
        barcodeSaveServices();
        thread = new Thread(){
            public void run(){
                while (!quit){
                    try {
                        String barcode = BarcodeBuffer.consume();
                        if (barcodeSaveServices.isEmpty()){
                            System.out.println("没有任何条形码保存服务");
                        }
                        for (BarcodeSaveService barcodeSaveService :barcodeSaveServices){
                            barcodeSaveService.save(barcode);
                        }
                    } catch (InterruptedException e) {
                        quit = true;

                    }
                }
                System.out.println("条形码消费者线程退出");
            }
        };
        thread.setName("consumer");
        thread.start();
    }

    /**
     * 消费者线程从缓冲区获取到数据后需要调用保存服务对数据进行处理
     */
    private void barcodeSaveServices() {
        List<String> classes = getBarcodeSaveServcieImplClasses();
        System.out.println("条形码保存服务实现数目有："+classes.size());
        for (String clazz : classes){
            try {
                BarcodeSaveService barcodeSaveService = (BarcodeSaveService) Class.forName(clazz).newInstance();
                barcodeSaveServices.add(barcodeSaveService);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从类路径下的barcode.save.services文件中获取保存服务类名
     * @return  多个保存服务实现类名
     */
    private List<String> getBarcodeSaveServcieImplClasses() {
        List<String> result = new ArrayList<String>();
        BufferedReader reader = null;
        InputStream in = null;
        try {
        //放在WEB-INF/classes下的“barcode.save.services”会覆盖jar包中的“barcode.save.services”
            URL url = Thread.currentThread().getContextClassLoader().getResource("barcode.save.services");
            System.out.println("url:"+url.getPath());
            in = url.openStream();
            if (in == null){
                System.out.println("没有在类路径下找到条形码保存服务配置文件：barcode.save.services");
                return result;
            }
            reader = new BufferedReader(new InputStreamReader(in,"utf-8"));
            String line = reader.readLine();
            while (line != null ){
                if (!"".equals(line.trim()) && !line.trim().startsWith("#")){
                    result.add(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null ){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
