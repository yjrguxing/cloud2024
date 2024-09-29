package com.atguigu.cloud.controller;

import com.atguigu.cloud.entitys.Pay;
import com.atguigu.cloud.entitys.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {

    private final PayService payService;

    public PayController(PayService payService){
        this.payService = payService;
    }

    @PostMapping("save")
    public String savePay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        // 回写id 其他默认值不回写 需要查询确定
        Pay save = payService.saveSelective(pay);
        return "成功插入数据,返回值:" + save;
    }

    @DeleteMapping("{id}")
    public Integer deletePay(@PathVariable("id") Integer id){
        return payService.deleteById(id);
    }

    @PutMapping
    public String updatePay(@RequestBody @Valid PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        Pay update = payService.updateSelective(pay);
        return "成功修改数据,返回值:" + update;
    }

    @GetMapping("{id}")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.findById(id);
    }

    @GetMapping("get/all")
    public List<Pay> findAll(){
        return payService.findAll();
    }
}
