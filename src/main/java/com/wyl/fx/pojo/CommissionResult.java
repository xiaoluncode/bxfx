package com.wyl.fx.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 佣金计算结果类
 * 用于存储订单相关的佣金信息，包括订单ID、代理信息、订单金额、以及按规则计算的佣金详情
 *
 * @author wyl
 * @date 2025/6/3 17:52
 */
@Data
public class CommissionResult {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 代理ID
     */
    private String agentId;

    /**
     * 代理名称
     */
    private String agentName;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 总佣金，默认初始化为0
     */
    private BigDecimal totalCommission = BigDecimal.ZERO;

    /**
     * 保存每个佣金规则的计算结果
     * 使用LinkedHashMap以保持插入顺序，方便后续处理和展示
     */
    private Map<String, BigDecimal> ruleResults = new LinkedHashMap<>();

    /**
     * 计算时间
     */
    private LocalDateTime calculateTime;

    /**
     * 添加规则计算结果
     * 此方法用于添加单个佣金规则的计算结果，并同时更新总佣金
     *
     * @param ruleName 佣金规则名称
     * @param commission 当前规则计算出的佣金金额
     */
    public void addRuleResult(String ruleName, BigDecimal commission) {
        ruleResults.put(ruleName, commission);
        totalCommission = totalCommission.add(commission);
    }

    // Getter / Setter 省略

    /**
     * 重写toString方法
     * 提供类的字符串表示，便于调试和日志记录
     *
     * @return 类的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n佣金计算结果明细：\n");
        sb.append(String.format("订单号：%s\n", orderId));
        sb.append(String.format("代理人：%s(%s)\n", agentName, agentId));
        sb.append(String.format("订单金额：￥%s\n", orderAmount));
        sb.append("规则计算明细：\n");
        ruleResults.forEach((rule, amount) ->
                sb.append(String.format("- %s: ￥%s\n", rule, amount)));
        sb.append(String.format("总佣金：￥%s\n", totalCommission));
        return sb.toString();
    }
}
