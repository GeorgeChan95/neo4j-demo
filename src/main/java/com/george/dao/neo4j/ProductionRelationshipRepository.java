package com.george.dao.neo4j;

import com.george.dto.CompanyDto;
import com.george.model.CompanyEntryNode;
import com.george.model.ProductionRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductionRelationshipRepository
 * @Description
 * @Author George
 * @Date 2024/11/8 9:45
 */
@Repository
public interface ProductionRelationshipRepository extends Neo4jRepository<ProductionRelationship, String> {

    /**
     * 根据产品获取供应商
     *
     * 经过测试，返回结果无法映射自定义DTO对象，这里需要用Map接收自定以返回数据
     * @param productEntryId
     * @return
     */
    @Query("match (c:CompanyNode)-[:Production]->(p:ProductNode) where p.productEntryId = {productEntryId} return c.companyId as companyId, c.name as name ")
    List<Map<String, Object>> getCompanyByProductId(@Param("productEntryId") String productEntryId);

    /**
     * 根据产品获取供应商
     * @param aliasName 产品名称
     * @return
     */
    @Query("match (c:CompanyNode)-[:Production]->(p:ProductNode) where p.aliasName = {aliasName} return c")
    List<CompanyEntryNode> getCompanyByProductName(@Param("aliasName") String aliasName);
}
