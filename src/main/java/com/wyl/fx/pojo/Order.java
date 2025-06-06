package com.wyl.fx.pojo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
@作者：wyl
@创建时间：2025/6/3 17:47  
*/
@Data
public class Order {
    private String orderId;
    private String productType; // 寿险、重疾险、年金险
    private BigDecimal amount;
    private LocalDateTime createTime;
    private Agent agent;

    // Getter 和 Setter 省略
}

