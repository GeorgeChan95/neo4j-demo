package com.george.service;

import com.george.model.CompanyEntryNode;
import com.george.model.R;

import java.util.List;

/**
 * @ClassName CompanyEntryService
 * @Description
 * @Author George
 * @Date 2024/11/7 16:55
 */
public interface CompanyEntryService {

    /**
     * 新增数据
     * @param entryNode
     * @return
     */
    R save(CompanyEntryNode entryNode);

    /**
     * 根据主键ID，主键：uuid
     * @param uuid
     * @return
     */
    R deleteById(String uuid);

    /**
     * 根据 companyId 属性删除数据
     * @param companyId
     * @return
     */
    R deleteByCompanyId(String companyId);

    /**
     * 删除实体类的type属性
     * @param companyId 查询参数companyId
     * @return
     */
    R removeType(String companyId);

    /**
     * 数据更新
     * @param entryNode
     * @return
     */
    R update(CompanyEntryNode entryNode);

    /**
     * 获取所有数据
     *
     * @return
     */
    List<CompanyEntryNode> getAll();

    /**
     * 根据companyId查询
     * @param companyId
     * @return
     */
    List<String> getByCompanyId(String companyId);

}
