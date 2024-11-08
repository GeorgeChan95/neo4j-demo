package com.george.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.george.constant.CommonConstants;
import com.george.dao.neo4j.CompanyEntryRepository;
import com.george.model.CompanyEntryNode;
import com.george.model.R;
import com.george.service.CompanyEntryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CompanyEntryServiceImpl
 * @Description
 * @Author George
 * @Date 2024/11/7 16:57
 */
@Slf4j
@Service
public class CompanyEntryServiceImpl implements CompanyEntryService {
    @Autowired
    private CompanyEntryRepository companyEntryRepository;


    @Override
    public R save(CompanyEntryNode entryNode) {
        CompanyEntryNode data = companyEntryRepository.save(entryNode);
        if (ObjectUtils.isEmpty(data)) return new R(false, CommonConstants.FAIL, "操作失败");

        return new R(data);
    }

    @Override
    public R deleteById(String uuid) {
        companyEntryRepository.deleteById(uuid);
        return new R();
    }

    @Override
    public R deleteByCompanyId(String companyId) {
        try {
            companyEntryRepository.deleteByCompanyId(companyId);
        } catch (Exception e) {
            e.printStackTrace();
            return new R(false, CommonConstants.FAIL, "操作失败");
        }
        return new R();
    }


    @Override
    public R removeType(String companyId) {
        companyEntryRepository.removeTypeByCompanyId(companyId);
        return new R();
    }

    @Override
    public R update(CompanyEntryNode entryNode) {
        if (StringUtils.isEmpty(entryNode.getUuid())) return new R(false, CommonConstants.FAIL, "操作失败，参数异常");

        CompanyEntryNode data = companyEntryRepository.save(entryNode);
        return new R(data);
    }

    @Override
    public List<CompanyEntryNode> getAll() {
        Iterable<CompanyEntryNode> all = companyEntryRepository.findAll();
        List<CompanyEntryNode> companyEntryNodes = new ArrayList<>();
        CollectionUtil.addAll(companyEntryNodes, all);
        return companyEntryNodes;
    }

    @Override
    public List<String> getByCompanyId(String companyId) {
        List<String> names = companyEntryRepository.existsByCompanyId(companyId);
        return names;
    }
}
