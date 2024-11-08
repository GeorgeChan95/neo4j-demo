package com.george.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

/**
 * @ClassName CompanyEntryNode
 * @Description
 * @Author George
 * @Date 2024/11/7 16:46
 */
@NodeEntity(value = "CompanyNode", label = "公司节点") // value：节点的Lable，label:用户描述该类
@Data
public class CompanyEntryNode {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class) // 将字段ID标识为主键，配合 @GeneratedValue 自动生成id值， 生成策略默认是 InternalIdStrategy.class 生成的Long值
    private String uuid;
    /**
     * 名称
     */
    private String name;

    /**
     * 公司表id
     */
    private String companyId;

    /**
     * 类型
     */
    private String type;

    /**
     * 别名
     */
    private String aliasName;
    /**
     * 行业
     */
    private String industry;

    /**
     * 经营范围
     */
    private String scope;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 状态 0草稿 1已审核
     */
    private String status;

    /**
     * 修改人Id
     */
    private String modifyUserId;

    /**
     * 修改时间
     */
    private Long modifyTime;

    /**
     * 创建人Id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Long createTime;
}
