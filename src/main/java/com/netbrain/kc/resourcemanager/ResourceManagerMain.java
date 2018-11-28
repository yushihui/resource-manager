package com.netbrain.kc.resourcemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ResourceManagerMain {

    public static void main(String[] args) {
        SpringApplication.run(ResourceManagerMain.class, args);
    }
}
