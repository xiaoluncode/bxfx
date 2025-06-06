package com.wyl.fx.service.serviceImpl;


import com.wyl.fx.pojo.Agent;
import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
@作者：wyl
*/
public class ChannelBonusRule implements CommissionRule {
    private final Map<String, BigDecimal> channelRates = new HashMap<>();

    public ChannelBonusRule() {
        channelRates.put("A", new BigDecimal("0.03"));
        channelRates.put("B", new BigDecimal("0.02"));
        channelRates.put("C", new BigDecimal("0.01"));
    }

    @Override
    public BigDecimal calculate(Order order) {
        Agent agent = order.getAgent();
        BigDecimal rate = channelRates.getOrDefault(agent.getChannelLevel(), BigDecimal.ZERO);
        return order.getAmount().multiply(rate);
    }

    @Override
    public String getRuleName() {
        return "渠道奖励规则";
    }
}

