package com.george.controller;

import com.george.dto.CompanyDto;
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
    public R<List<CompanyDto>> getCompanyByProductId(String productId) {
        List<CompanyDto> companyDtos = productionRelationshipService.getCompanyByProductId(productId);
        return new R(companyDtos);
    }

    /**
     * 根据产品名称获取供应商信息
     * @param aliasName 产品名称
     * @return
     */
    @GetMapping("/getCompanyByProductName")
    public R<List<CompanyEntryNode>> getCompanyByProductName(String aliasName) {
        List<CompanyEntryNode> companyDtos = productionRelationshipService.getCompanyByProductName(aliasName);
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
}
