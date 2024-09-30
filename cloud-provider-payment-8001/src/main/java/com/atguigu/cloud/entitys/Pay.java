package com.atguigu.cloud.entitys;

import io.mybatis.provider.Entity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author psyduck
 */
@Data
@Entity.Table("t_pay")
@Schema(title = "支付交易表实体类")
public class Pay {

    @Entity.Column(id = true)
    @Schema(title = "主键")
    private Integer id;

    @Entity.Column("pay_no")
    @Schema(title = "支付流水号")
    private String payNo;

    @Entity.Column("order_no")
    @Schema(title = "订单流水号")
    private String orderNo;

    @Entity.Column("user_id")
    @Schema(title = "用户id")
    private Integer userId;

    @Entity.Column("amount")
    private BigDecimal amount;

    @Entity.Column("deleted")
    private Byte deleted;

    @Entity.Column("create_time")
    @Schema(title = "创建时间")
    private Date createTime;

    @Entity.Column("update_time")
    @Schema(title = "更新时间")
    private Date updateTime;
}
