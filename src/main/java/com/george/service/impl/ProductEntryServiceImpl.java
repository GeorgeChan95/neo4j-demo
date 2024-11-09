package com.george.service.impl;

import com.george.dao.neo4j.ProductEntryRepository;
import com.george.model.ProductEntryNode;
import com.george.model.R;
import com.george.service.ProductEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductEntryServiceImpl
 * @Description
 * @Author George
 * @Date 2024/11/8 9:56
 */
@Slf4j
@Service
public class ProductEntryServiceImpl implements ProductEntryService {

    @Autowired
    private ProductEntryRepository productEntryRepository;

    @Override
    public R<ProductEntryNode> save(ProductEntryNode node) {
        ProductEntryNode entryNode = productEntryRepository.save(node);
        return new R<>(entryNode);
    }

    @Override
    public R deleteById(String uuid) {
        productEntryRepository.deleteById(uuid);
        return new R();
    }

    @Override
    public List<ProductEntryNode> getDataByQuery(String aliasName) {
        List<ProductEntryNode> list = productEntryRepository.getDataByQuery(aliasName);
        return list;
    }
}
