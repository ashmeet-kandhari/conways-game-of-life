package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.oops.rules.RuleImpl;

/**
 * @author hdhingra
 */
public class DefaultGameStrategy extends GameStrategyImpl {

    public DefaultGameStrategy() {
        super(new Rule[]{new RuleImpl()});
    }

}
