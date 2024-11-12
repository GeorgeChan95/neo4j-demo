package com.george.dto;

import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * @ClassName RelationshipDto
 * @Description 自定义spring-data 查询结果集
 * @Author George
 * @Date 2024/11/12 15:22
 */
@Data
@QueryResult // 此注解用于返回Spring-data-neo4j查询返回自定义结果集
public class RelationshipDto {

    private String uuid;

    /**
     * 收入占比
     */
    private String incomeProportion;

    /**
     * 毛利率
     */
    private String productGross;

    /**
     * 产品单价
     */
    private String productPrice;

}
