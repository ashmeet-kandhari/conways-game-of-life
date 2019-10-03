package com.ptc.plms.gol.oops.strategy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultGameStrategyTest {

    private  GameStrategy gameStrategy;

    @Before
    public void setUp() throws Exception {
        this.gameStrategy = new DefaultGameStrategy();
    }

    @Test
    public void findNeighbours() {
    }
}