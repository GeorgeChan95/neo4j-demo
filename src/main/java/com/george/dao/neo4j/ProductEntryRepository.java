package com.george.dao.neo4j;

import com.george.model.ProductEntryNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProductEntryRepository
 * @Description 产品DAO
 * @Author George
 * @Date 2024/11/8 9:44
 */
@Repository
public interface ProductEntryRepository extends Neo4jRepository<ProductEntryNode, String> {

    /**
     * 根据产品别名查询产品数据集
     * @param aliasName 产品别名
     * @return
     */
    @Query("match(n:ProductNode) where n.aliasName = {aliasName} return n")
    List<ProductEntryNode> getDataByQuery(@Param("aliasName") String aliasName);
}
