package com.wyl.fx.service;

import com.wyl.fx.pojo.CommissionResult;
import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;
import com.wyl.fx.service.serviceImpl.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommissionRuleChain {
    private final List<CommissionRule> rules = new ArrayList<>();

    public CommissionRuleChain() {
        rules.add(new BaseCommissionRule());           // 基础佣金
        rules.add(new AgentLevelBonusRule());          // 代理等级奖励
        rules.add(new ChannelBonusRule());             // 渠道奖励
        rules.add(new TeamPerformanceBonusRule());     // 团队业绩奖励
        rules.add(new NewAgentBonusRule());            // 新代理人扶持奖励
    }
    public CommissionResult calculateCommission(Order order) {
        CommissionResult result = new CommissionResult();
        result.setOrderId(order.getOrderId());
        result.setAgentId(order.getAgent().getAgentId());
        result.setAgentName(order.getAgent().getName());
        result.setOrderAmount(order.getAmount());
        result.setCalculateTime(LocalDateTime.now());

        for (CommissionRule rule : rules) {
            BigDecimal commission = rule.calculate(order);
            result.addRuleResult(rule.getRuleName(), commission);
        }

        return result;
    }
}
