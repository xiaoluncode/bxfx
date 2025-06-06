package com.wyl.fx;


import com.wyl.fx.pojo.Agent;
import com.wyl.fx.pojo.CommissionResult;
import com.wyl.fx.pojo.Order;
import com.wyl.fx.service.CommissionRuleEngineService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
@作者：wyl
@创建时间：2025/6/3 18:28
*/
public class CommissionCalculationExample {
    public static void main(String[] args) {
        // 创建代理人
        Agent agent = new Agent();
        agent.setAgentId("AG001");
        agent.setName("张三");
        agent.setLevel("专家");
        agent.setChannelLevel("A");
        agent.setTeamId("TEAM001");
        agent.setMonthlyPerformance(new BigDecimal("2000000"));
        agent.setJoinTime(LocalDateTime.now().minusDays(30));
        agent.setNewAgent(true);

        // 创建订单
        Order order = new Order();
        order.setOrderId("ORD" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "001");
        order.setProductType("寿险");
        order.setAmount(new BigDecimal("100000"));
        order.setCreateTime(LocalDateTime.now());
        order.setAgent(agent);

        // 用规则引擎计算佣金
        CommissionRuleEngineService service = new CommissionRuleEngineService();
        CommissionResult result = service.calculateCommission(order);

        // 输出结果
        System.out.println(result.toString());
    }
}
