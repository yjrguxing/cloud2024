package com.atguigu.cloud.controller;

import com.atguigu.cloud.entitys.Pay;
import com.atguigu.cloud.entitys.PayDTO;
import com.atguigu.cloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/pay/")
@Slf4j
public class PayController {

    private final PayService payService;

    public PayController(PayService payService){
        this.payService = payService;
    }

    @PostMapping("save")
    public String savePay(Pay pay){
        System.out.println(pay.toString());
        Pay save = payService.save(pay);
        return "成功插入数据,返回值:" + save;
    }

    @DeleteMapping("{id}")
    public Integer deletePay(@PathVariable("id") Integer id){
        return payService.deleteById(id);
    }

    @PutMapping
    public String updatePay(PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        Pay update = payService.update(pay);
        return "成功修改数据,返回值:" + update;
    }

    @GetMapping("{id}")
    public Pay getById(@PathVariable Integer id){
        return payService.findById(id);
    }

    @GetMapping("get/all")
    public List<Pay> findAll(){
        return payService.findAll();
    }
}
