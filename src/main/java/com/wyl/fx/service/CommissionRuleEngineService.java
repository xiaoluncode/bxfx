package com.wyl.fx.service;

import com.wyl.fx.pojo.CommissionResult;
import com.wyl.fx.pojo.Order;

public class CommissionRuleEngineService {
    private final CommissionRuleChain ruleChain = new CommissionRuleChain();

    public CommissionResult calculateCommission(Order order) {
        return ruleChain.calculateCommission(order);
    }
}
