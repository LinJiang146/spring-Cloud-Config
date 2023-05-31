package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class configApplication1001 {
    public static void main(String[] args) {
        SpringApplication.run(configApplication1001.class,args);
    }


}
