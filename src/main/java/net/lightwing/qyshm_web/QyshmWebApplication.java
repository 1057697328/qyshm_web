package net.lightwing.qyshm_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("net.lightwing.qyshm_web.dao")
public class QyshmWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyshmWebApplication.class, args);
    }


}
