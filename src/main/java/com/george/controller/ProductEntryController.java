package com.george.controller;

import com.george.model.ProductEntryNode;
import com.george.model.R;
import com.george.service.ProductEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ProductEntryController
 * @Description
 * @Author George
 * @Date 2024/11/8 10:01
 */
@Slf4j
@RestController
@RequestMapping(value = "/productEntry")
public class ProductEntryController {

    @Autowired
    private ProductEntryService productEntryService;

    /**
     * 保存产品数据
     * @param node 参数列表
     * @return
     */
    @PostMapping("/save")
    public R<ProductEntryNode> save(@RequestBody ProductEntryNode node) {
        R<ProductEntryNode> result = productEntryService.save(node);
        return result;
    }

    /**
     * 根据id删除
     * @param uuid
     * @return
     */
    @DeleteMapping("/deleteById")
    public R deleteById(@RequestParam(value = "uuid", required = false) String uuid) {
        R result = productEntryService.deleteById(uuid);
        return result;
    }

    /**
     * 根据产品别名查询产品数据集
     * @param aliasName 产品别名
     * @return
     */
    @GetMapping("/getDataByQuery")
    public R<List<ProductEntryNode>> getDataByQuery(@RequestParam(value = "aliasName", required = false) String aliasName) {
        List<ProductEntryNode> list = productEntryService.getDataByQuery(aliasName);
        return new R<>(list);
    }
}
