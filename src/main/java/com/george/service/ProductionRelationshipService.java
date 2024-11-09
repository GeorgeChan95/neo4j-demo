package com.george.service;

import com.george.dto.CompanyDto;
import com.george.model.CompanyEntryNode;
import com.george.model.ProductEntryNode;
import com.george.model.ProductionRelationship;
import com.george.model.R;

import java.util.List;

/**
 * @ClassName ProductionRelationshipService
 * @Description
 * @Author George
 * @Date 2024/11/8 10:23
 */
public interface ProductionRelationshipService {

    /**
     * 添加公司产品 关系
     * @param startNode 公司节点
     * @param toNode 产品节点
     * @param incomeProportion 收入占比
     * @param productGross 毛利率
     * @param productPrice 产品单价
     * @return
     */
    ProductionRelationship addProductionRelationship(CompanyEntryNode startNode, ProductEntryNode toNode, String incomeProportion, String productGross, String productPrice);


    /**
     * 关联公司产品关系
     * @param startNodeId 公司节点唯一标识
     * @param toNodeId 产品唯一标识
     * @param incomeProportion 收入占比
     * @param productGross 毛利率
     * @param productPrice 产品单价
     * @return
     */
    ProductionRelationship addProductionRelationship(String startNodeId, String toNodeId, String incomeProportion, String productGross, String productPrice);

    /**
     * 获取产品的供应商公司
     *
     * @param productEntryId
     * @return
     */
    List<CompanyDto> getCompanyByProductId(String productEntryId);

    /**
     * 获取产品的供应商公司
     *
     * @param aliasName 产品名称
     * @return
     */
    List<CompanyEntryNode> getCompanyByProductName(String aliasName);

    /**
     * 删除所有节点关系
     * @return
     */
    R deleteAllRelationship();
}
