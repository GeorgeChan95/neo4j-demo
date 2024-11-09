package com.george.model;

import lombok.Data;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

/**
 * @ClassName ProductionRelationship
 * @Author George
 * @Date 2024/11/8 9:38
 * @Description
 * 公司->生产 产品关系
 * 指定关系名称为Production
 */
@Data
@RelationshipEntity(type = "Production")
public class ProductionRelationship {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class) // 将字段ID标识为主键，配合 @GeneratedValue 自动生成id值， 生成策略默认是 InternalIdStrategy.class 生成的Long值
    private String uuid;

    @StartNode // 表示节点指向的起点
    private CompanyEntryNode startNode;

    @EndNode // 表示节点指向的终点
    private ProductEntryNode endNode;

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

    /**
     * 产能
     */
    private String capacity;

    /**
     * 产能利用率
     */
    private String capacityRatio;

    /**
     * 产能占比
     */
    private String capacityProportion;
}
