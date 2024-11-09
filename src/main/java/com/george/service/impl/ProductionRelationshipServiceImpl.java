package com.george.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.george.dao.neo4j.CompanyEntryRepository;
import com.george.dao.neo4j.ProductEntryRepository;
import com.george.dao.neo4j.ProductionRelationshipRepository;
import com.george.dto.CompanyDto;
import com.george.model.CompanyEntryNode;
import com.george.model.ProductEntryNode;
import com.george.model.ProductionRelationship;
import com.george.model.R;
import com.george.service.ProductionRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName ProductionRelationshipServiceImpl
 * @Description
 * @Author George
 * @Date 2024/11/8 10:23
 */
@Slf4j
@Service
public class ProductionRelationshipServiceImpl implements ProductionRelationshipService {
    @Autowired
    private ProductionRelationshipRepository productionRelationshipRepository;

    @Autowired
    private CompanyEntryRepository companyEntryRepository;

    @Autowired
    private ProductEntryRepository productEntryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ProductionRelationship addProductionRelationship(CompanyEntryNode startNode, ProductEntryNode toNode, String incomeProportion, String productGross, String productPrice) {
        ProductionRelationship productionRelationship = new ProductionRelationship();
        productionRelationship.setStartNode(startNode);
        productionRelationship.setEndNode(toNode);
        productionRelationship.setIncomeProportion(incomeProportion);
        productionRelationship.setProductGross(productGross);
        productionRelationship.setProductPrice(productPrice);
        ProductionRelationship save = productionRelationshipRepository.save(productionRelationship);
        return save;
    }

    @Override
    public ProductionRelationship addProductionRelationship(String startNodeId, String toNodeId, String incomeProportion, String productGross, String productPrice) {
        ProductionRelationship relationship = null;
        Optional<CompanyEntryNode> companyOptional = companyEntryRepository.findById(startNodeId);
        Optional<ProductEntryNode> productOptional = productEntryRepository.findById(toNodeId);
        if (companyOptional.isPresent() && productOptional.isPresent()) {
            relationship = addProductionRelationship(companyOptional.get(), productOptional.get(), incomeProportion, productGross, productPrice);
        }
        return relationship;
    }

    @Override
    public List<CompanyDto> getCompanyByProductId(String productEntryId) {
        List<CompanyDto> companyDtos = new ArrayList<>();
        List<Map<String, Object>> maps = productionRelationshipRepository.getCompanyByProductId(productEntryId);
        try {
            String json = objectMapper.writeValueAsString(maps);
            companyDtos = objectMapper.readValue(json, new TypeReference<List<CompanyDto>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return companyDtos;
    }

    @Override
    public List<CompanyEntryNode> getCompanyByProductName(String aliasName) {
        List<CompanyEntryNode> list = productionRelationshipRepository.getCompanyByProductName(aliasName);
        return list;
    }

    @Override
    public R deleteAllRelationship() {
        productionRelationshipRepository.deleteAll();
        return new R();
    }
}
