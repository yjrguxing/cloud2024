package com.atguigu.cloud.service;

import com.atguigu.cloud.entitys.Pay;
import io.mybatis.mapper.fn.Fn;

import java.util.Collection;
import java.util.List;

public interface PayService {

    Pay save(Pay entity);

    int deleteById(Integer id);

    <F> int deleteByFieldList(Fn<Pay, F> field, Collection<F> fieldValueList);

    Pay update(Pay pay);

    Pay updateSelective(Pay entity, Fn<Pay, Object>... forceUpdateFields);

    Pay findById(Integer id);

    List<Pay> findAll();
}
