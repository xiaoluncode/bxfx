package com.wyl.fx.service.serviceImpl;


import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRule;

import java.math.BigDecimal;

/*
@作者：wyl
*/
public class TeamPerformanceBonusRule implements CommissionRule {

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal bonusRate = BigDecimal.ZERO;
        BigDecimal performance = order.getAgent().getMonthlyPerformance();

        if (performance.compareTo(new BigDecimal("1000000")) >= 0) {
            bonusRate = new BigDecimal("0.02");
        } else if (performance.compareTo(new BigDecimal("500000")) >= 0) {
            bonusRate = new BigDecimal("0.01");
        }

        return order.getAmount().multiply(bonusRate);
    }

    @Override
    public String getRuleName() {
        return "团队业绩奖励规则";
    }
}

