package net.lightwing.qyshm_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("net.lightwing.qyshm_web.dao")
public class QyshmWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(QyshmWebApplication.class, args);
    }

}
