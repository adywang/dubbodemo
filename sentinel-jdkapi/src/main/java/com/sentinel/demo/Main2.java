package com.sentinel.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<FlowRule> rules=new ArrayList<>();
        FlowRule rule=new FlowRule();
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(15);
        rule.setResource("hello2");
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP);
        rule.setStrategy(RuleConstant.STRATEGY_DIRECT);
        rules.add(rule);

        FlowRuleManager.loadRules(rules);
        while (true){
            try {
                Entry entry = SphU.entry("hello2");
                System.out.println("hello2--->"+System.currentTimeMillis());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (BlockException e) {
                System.out.println("blocked");
            }
        }

    }


}
