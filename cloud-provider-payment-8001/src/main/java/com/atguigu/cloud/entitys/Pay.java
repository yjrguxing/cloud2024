package com.atguigu.cloud.entitys;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author psyduck
 */
@Data
@Entity.Table("t_pay")
public class Pay {

    @Entity.Column(id = true)
    private Integer id;

    @Entity.Column("pay_no")
    private String payNo;

    @Entity.Column("order_no")
    private String orderNo;

    @Entity.Column("user_id")
    private Integer userId;

    @Entity.Column("amount")
    private BigDecimal amount;

    @Entity.Column("deleted")
    private Byte deleted;

    @Entity.Column("create_time")
    private Date createTime;

    @Entity.Column("update_time")
    private Date updateTime;
}
