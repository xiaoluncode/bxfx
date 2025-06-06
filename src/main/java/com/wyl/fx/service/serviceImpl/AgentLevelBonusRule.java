package com.wyl.fx.service.serviceImpl;


import com.wyl.fx.pojo.Agent;
import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
@作者：wyl
@创建时间：2025/6/3 17:50  
*/
public class AgentLevelBonusRule implements CommissionRule {
    private final Map<String, BigDecimal> levelRates = new HashMap<>();

    public AgentLevelBonusRule() {
        levelRates.put("专家", new BigDecimal("0.05"));
        levelRates.put("高级", new BigDecimal("0.03"));
        levelRates.put("普通", new BigDecimal("0.01"));
    }

    @Override
    public BigDecimal calculate(Order order) {
        Agent agent = order.getAgent();
        BigDecimal rate = levelRates.getOrDefault(agent.getLevel(), BigDecimal.ZERO);
        return order.getAmount().multiply(rate);
    }

    @Override
    public String getRuleName() {
        return "代理人等级奖励规则";
    }
}

