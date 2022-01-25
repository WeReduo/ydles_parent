package com.ydles.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Project Name: ydl_parent
 * File Name: FileApplication
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/11/上午 11:25
 * Copyright (c) 2022,
 */
@SpringBootApplication
@EnableEurekaClient
public class FileApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class);
    }
}