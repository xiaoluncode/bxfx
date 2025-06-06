package com.wyl.fx.service.serviceImpl;


import com.wyl.fx.pojo.Agent;
import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/*
@作者：wyl
*/
public class NewAgentBonusRule implements CommissionRule {

    @Override
    public BigDecimal calculate(Order order) {
        Agent agent = order.getAgent();
        if (agent.isNewAgent()) {
            // 入职时间小于等于 90 天
            long daysSinceJoin = ChronoUnit.DAYS.between(agent.getJoinTime(), LocalDateTime.now());
            if (daysSinceJoin <= 90) {
                return order.getAmount().multiply(new BigDecimal("0.05"));
            }
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String getRuleName() {
        return "新代理人扶持奖励规则";
    }
}
