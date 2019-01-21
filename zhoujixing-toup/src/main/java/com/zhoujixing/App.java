package com.zhoujixing;

import com.zhoujixing.entity.VoteEntity;
import com.zhoujixing.server.VoteServer;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
        {
            SpringApplication.run(App.class, args);

            //private static int corePoolSize = Runtime.getRuntime().availableProcessors();
        }
}
