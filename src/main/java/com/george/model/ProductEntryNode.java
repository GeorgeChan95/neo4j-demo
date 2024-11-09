package com.george.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

/**
 * @ClassName ProductEntryNode
 * @Description
 * @Author George
 * @Date 2024/11/8 9:18
 */
@NodeEntity(value = "ProductNode", label = "产品节点") // value：节点的Lable，label:用于描述该类
@Data
public class ProductEntryNode {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class) // 将字段ID标识为主键，配合 @GeneratedValue 自动生成id值， 生成策略默认是 InternalIdStrategy.class 生成的Long值
    private String productEntryId;

    /**
     * 词条名称
     */
    private String name;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 词条类型  1:产品种类 2:产品类型 3:产品单元
     */
    private String type;
    /**
     * 别名
     */
    private String aliasName;

    /**
     * 简介
     */
    private String introduction;
}
