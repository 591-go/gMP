package com.go.gmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiang on 2017/6/14.
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class MainClass {

    public static void main(String[] args) {
        String pidFile = null;
        if (null != args && args.length > 0) {
            //默认第一个参数是pid文件泉路径
            pidFile = args[0];
            if (null == pidFile || "".equals(pidFile)) {
                //pidFile若为空,则使用默认全路径:application.pid
                pidFile = "application.pid";
            }
        } else {
            //pidFile若为空,则使用默认全路径:application.pid
            pidFile = "application.pid";
        }


        SpringApplication springApplication =
                new SpringApplication(MainClass.class);
        springApplication.addListeners(
                new ApplicationPidFileWriter(pidFile));
        springApplication.run();
    }
}
