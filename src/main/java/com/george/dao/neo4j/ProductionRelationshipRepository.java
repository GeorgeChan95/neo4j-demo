package com.george.dao.neo4j;

import com.george.dto.RelationshipDto;
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

    /**
     * 根据参数查询并返回关系数据
     * match relationship = (c:CompanyNode)-[r:Production]->(p:ProductNode) where type(r) = "Production" and c.aliasName = "肯德基" and p.aliasName = "麦辣鸡" return relationship limit 1;
     * @param typeName 关系类型名称
     * @param companyName 公司名称
     * @param productName 产品名称
     * @return
     */
    @Query("match relationship = (c:CompanyNode)-[r]->(p:ProductNode) where type(r) = {typeName} and c.aliasName = {companyName} and p.aliasName = {productName} return relationship limit 1")
    ProductionRelationship getRelationshipByParam(@Param("typeName") String typeName, @Param("companyName") String companyName, @Param("productName") String productName);

    /**
     * 根据产品名称和公司名称获取之间的关系,返回自定义结果集
     * match relationship =  (p:ProductNode {aliasName: "麦辣鸡"})-[r:Production]-(c:CompanyNode {aliasName: "肯德基"}) return relationship;
     * @param productName 产品名称
     * @param companyName 公司名称
     * @return
     */
    @Query("match (p:ProductNode {aliasName: {productName}})-[r:Production]-(c:CompanyNode {aliasName: {companyName}}) return r.uuid as uuid, r.incomeProportion as incomeProportion, r.productGross as productGross, r.productPrice as productPrice")
    List<RelationshipDto> getRelationshipByAliasName(@Param("productName") String productName, @Param("companyName") String companyName);
}
