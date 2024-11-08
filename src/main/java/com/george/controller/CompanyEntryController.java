package com.george.controller;

import com.george.model.CompanyEntryNode;
import com.george.model.R;
import com.george.service.CompanyEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CompanyEntryController
 * @Description
 * @Author George
 * @Date 2024/11/7 17:01
 */
@Slf4j
@RestController
@RequestMapping(value = "/companyEntry")
public class CompanyEntryController {
    @Autowired
    private CompanyEntryService companyEntryService;

    /**
     * 新增数据
     * @param node
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody CompanyEntryNode node) {
        R result = companyEntryService.save(node);
        return result;
    }

    /**
     * 根据主键删除
     * @param uuid
     * @return
     */
    @DeleteMapping("/deleteById")
    public R deleteById(@RequestParam(value = "uuid", required = false) String uuid) {
        R result = companyEntryService.deleteById(uuid);
        return result;
    }

    /**
     * 根据属性查询后删除
     * @param companyId 查询条件companyId
     * @return
     */
    @DeleteMapping("/deleteByParam")
    public R deleteByParam(@RequestParam(value = "companyId", required = false) String companyId) {
        R result = companyEntryService.deleteByCompanyId(companyId);
        return result;
    }

    /**
     * 删除实体类的某个属性字段
     * @param companyId 查询条件companyId
     * @return
     */
    @GetMapping("/removeType")
    public R removeType(@RequestParam(value = "companyId", required = false) String companyId) {
        R result = companyEntryService.removeType(companyId);
        return result;
    }

    /**
     * 数据更新
     * @param node
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody CompanyEntryNode node) {
        R result = companyEntryService.update(node);
        return result;
    }

    /**
     * 获取所有Company数据
     * @return
     */
    @GetMapping("/getAll")
    public R<List<CompanyEntryNode>> getAll() {
        List<CompanyEntryNode> list = companyEntryService.getAll();
        return new R(list);
    }

    /**
     * 根据CompanyId查询
     * @param companyId
     * @return
     */
    @GetMapping("/getNameByCompanyId")
    public R<List<String>> getNameByCompanyId(@RequestParam(value = "companyId", required = false) String companyId) {
        List<String> names = companyEntryService.getByCompanyId(companyId);
        return new R<>(names);
    }
}
