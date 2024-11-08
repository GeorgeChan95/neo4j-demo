package com.george.dao.neo4j;

import com.george.model.CompanyEntryNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CompanyEntryRepository
 * @Description
 * @Author George
 * @Date 2024/11/7 16:52
 */
@Repository
public interface CompanyEntryRepository extends Neo4jRepository<CompanyEntryNode, String> { // <实体类, 主键>

    /**
     * 根据公司id判断 公司是否已经存在
     * match(n:CompanyNode {companyId: "id1"}) return n.aliasName;
     * @param companyId 查询参数companyId
     * @return
     */
    @Query("match(n:CompanyNode {companyId: {companyId}}) return n.introduction")
    List<String> existsByCompanyId(String companyId);

    /**
     * 根据companyId删除数据
     * @param companyId 查询参数companyId
     * @return
     */
    @Query("match(n:CompanyNode {companyId: {companyId}}) delete n")
    void deleteByCompanyId(String companyId);

    /**
     * 删除实体类的某个属性
     * @param companyId 查询参数companyId
     * @return
     */
    @Query("match(n:CompanyNode {companyId: {companyId}}) remove n.type")
    void removeTypeByCompanyId(String companyId);
}
