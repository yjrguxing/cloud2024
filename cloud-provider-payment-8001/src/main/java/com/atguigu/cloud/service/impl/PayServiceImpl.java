package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entitys.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import io.mybatis.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PayServiceImpl extends AbstractService<Pay,Integer, PayMapper> implements PayService{
}
