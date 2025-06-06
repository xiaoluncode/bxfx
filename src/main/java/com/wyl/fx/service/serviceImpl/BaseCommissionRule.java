package com.wyl.fx.service.serviceImpl;


import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
@作者：wyl
*/
public class BaseCommissionRule implements CommissionRule {
    private final Map<String, BigDecimal> productRates = new HashMap<>();

    public BaseCommissionRule() {
        productRates.put("寿险", new BigDecimal("0.1"));
        productRates.put("重疾险", new BigDecimal("0.15"));
        productRates.put("年金险", new BigDecimal("0.08"));
    }

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal rate = productRates.getOrDefault(order.getProductType(), BigDecimal.ZERO);
        return order.getAmount().multiply(rate);
    }

    @Override
    public String getRuleName() {
        return "基础佣金规则";
    }
}

