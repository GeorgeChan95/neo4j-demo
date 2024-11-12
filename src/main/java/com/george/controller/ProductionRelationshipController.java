package com.george.controller;

import com.george.dto.CompanyDto;
import com.george.dto.RelationshipDto;
import com.george.model.CompanyEntryNode;
import com.george.model.ProductionRelationship;
import com.george.model.R;
import com.george.service.ProductionRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProductionRelationshipController
 * @Description
 * @Author George
 * @Date 2024/11/8 11:29
 */
@Slf4j
@RestController
@RequestMapping(value = "/productionRelationship")
public class ProductionRelationshipController {
    @Autowired
    private ProductionRelationshipService productionRelationshipService;

    /**
     * 关联公司产品关系
     * @param companyUuid 公司节点唯一标识
     * @param productId 产品唯一标识
     * @param incomeProportion 收入占比
     * @param productGross 毛利率
     * @param productPrice 产品单价
     * @return
     */
    @GetMapping("/addRelationship")
    public R addRelationship(@RequestParam(value = "companyUuid", required = false) String companyUuid,
                             @RequestParam(value = "productId", required = false) String productId,
                             @RequestParam(value = "incomeProportion", required = false) String incomeProportion,
                             @RequestParam(value = "productGross", required = false) String productGross,
                             @RequestParam(value = "productPrice", required = false) String productPrice) {
        ProductionRelationship relationship = productionRelationshipService.addProductionRelationship(companyUuid, productId, incomeProportion, productGross, productPrice);
        return new R(relationship);
    }

    /**
     * 根据产品获取供应商信息
     * @param productId 产品唯一标识
     * @return
     */
    @GetMapping("/getCompanyByProductId")
    public R<List<CompanyDto>> getCompanyByProductId(@RequestParam(value = "productId", required = false) String productId) {
        List<CompanyDto> companyDtos = productionRelationshipService.getCompanyByProductId(productId);
        return new R(companyDtos);
    }

    /**
     * 根据产品名称获取供应商信息
     * @param productName 产品名称
     * @return
     */
    @GetMapping("/getCompanyByProductName")
    public R<List<CompanyEntryNode>> getCompanyByProductName(@RequestParam(value = "productName", required = false) String productName) {
        List<CompanyEntryNode> companyDtos = productionRelationshipService.getCompanyByProductName(productName);
        return new R(companyDtos);
    }

    /**
     * 删除所有节点关系
     * @return
     */
    @DeleteMapping("/deleteAllRelationship")
    public R deleteAllRelationship() {
        R result = productionRelationshipService.deleteAllRelationship();
        return result;
    }

    /**
     * 根据参数查询并返回关系数据
     * @param typeName 关系类型名称
     * @param companyName 公司名称
     * @param productName 产品名称
     * @return
     */
    @GetMapping("/getRelationshipByParam")
    public R<ProductionRelationship> getRelationshipByParam(@RequestParam(value = "typeName", required = false) String typeName,
                                                            @RequestParam(value = "companyName", required = false) String companyName,
                                                            @RequestParam(value = "productName", required = false) String productName) {
        ProductionRelationship relationship = productionRelationshipService.getRelationshipByParam(typeName, companyName, productName);
        return new R<>(relationship);
    }

    /**
     * 根据产品名称和公司名称获取之间的关系
     * @param productName 产品名称
     * @param companyName 公司名称
     * @return
     */
    @GetMapping("/getRelationshipByAliasName")
    public R<List<RelationshipDto>> getRelationshipByAliasName(@RequestParam(value = "productName", required = false) String productName,
                                                                      @RequestParam(value = "companyName", required = false) String companyName) {
        List<RelationshipDto> relationship = productionRelationshipService.getRelationshipByAliasName(productName, companyName);
        return new R<>(relationship);
    }
}
