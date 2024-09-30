package com.atguigu.cloud.controller;

import com.atguigu.cloud.entitys.Pay;
import com.atguigu.cloud.entitys.PayDTO;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "支付微服务模块",description = "支付CRUD")
@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {

    private final PayService payService;

    public PayController(PayService payService){
        this.payService = payService;
    }

    @PostMapping("save")
    @Operation(summary = "新增",description = "新增支付流水,参数是json串")
    public String savePay(@RequestBody Pay pay){
        System.out.println(pay.toString());
        // 回写id 其他默认值不回写 需要查询确定
        Pay save = payService.saveSelective(pay);
        return "成功插入数据,返回值:" + save;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id){
        return payService.deleteById(id);
    }

    @PutMapping
    @Operation(summary = "修改",description = "修改支付流水方法")
    public String updatePay(@RequestBody @Valid PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        Pay update = payService.updateSelective(pay);
        return "成功修改数据,返回值:" + update;
    }

    @GetMapping("{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Pay getById(@PathVariable("id") Integer id){
        return payService.findById(id);
    }

    @GetMapping("get/all")
    public List<Pay> findAll(){
        return payService.findAll();
    }
}
