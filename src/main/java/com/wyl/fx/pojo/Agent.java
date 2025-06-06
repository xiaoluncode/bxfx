package com.wyl.fx.pojo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
@作者：wyl
@创建时间：2025/6/3 17:45  
*/
@Data
public class Agent {
    private String agentId;
    private String name;
    private String level; // 普通、高级、专家
    private String channelLevel; // A、B、C
    private String teamId;
    private BigDecimal monthlyPerformance;
    private LocalDateTime joinTime;
    private boolean isNewAgent;

    // Getter 和 Setter 省略，记得要生成
}

