package com.george.service;

import com.george.model.ProductEntryNode;
import com.george.model.R;

import java.util.List;

/**
 * @ClassName ProductEntryService
 * @Description
 * @Author George
 * @Date 2024/11/8 9:56
 */
public interface ProductEntryService {

    /**
     * 保存产品数据
     * @param node
     * @return
     */
    R<ProductEntryNode> save(ProductEntryNode node);

    /**
     * 根据主键删除
     * @param uuid
     * @return
     */
    R deleteById(String uuid);


    /**
     * 根据产品别名查询产品数据集
     * @param aliasName 产品别名
     * @return
     */
    List<ProductEntryNode> getDataByQuery(String aliasName);
}
