package com.george;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Neo4jApplication
 * @Description
 * @Author George
 * @Date 2024/11/7 11:28
 */
@Slf4j
@SpringBootApplication
public class Neo4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
        log.info("neo4j-demo启动成功");
    }
}
