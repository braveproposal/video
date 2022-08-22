package com.example.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class VideoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(VideoApplication.class, args);
        ConfigurableApplicationContext application = SpringApplication.run(VideoApplication.class, args);

        try {
            Environment env = application.getEnvironment();
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path");
            if (StringUtils.isEmpty(path)) {
                path = "";
            }
            System.out.println("Application is running! Access URLs:");
            System.out.println("Local: \t\thttp://localhost:" + port + path);
            System.out.println("External: \thttp://" + ip + ":" + port + path + "\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
