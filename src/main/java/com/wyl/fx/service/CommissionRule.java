package com.wyl.fx.service;


import com.wyl.fx.pojo.Order;

import java.math.BigDecimal;

/*
@作者：wyl
*/
public interface CommissionRule {
    BigDecimal calculate(Order order);
    String getRuleName();
}

