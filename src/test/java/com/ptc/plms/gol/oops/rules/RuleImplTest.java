package com.ptc.plms.gol.oops.rules;

import com.ptc.plms.gol.oops.State;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleImplTest {

    private Rule rule;

    @Before
    public void setUp() throws Exception {
        this.rule = new RuleImpl();
    }

    //    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    @Test
    public void nextStateReturnsDeadStateWhenALiveCellHasLessThanTwoLiveNeighbours() {
        State expectedState = State.DEAD;
        State currentState = State.LIVE;
        int[] liveNeighboursArr = {0, 1};

        assertStateForDifferentLiveNeighbours(expectedState, currentState, liveNeighboursArr);
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void nextStateShouldReturnLiveStateWhenALiveCellHasTwoOrThreeLiveNeighbours() {
        State expectedState = State.LIVE;
        State currentState = State.LIVE;
        int[] liveNeighboursArr = {2, 3};

        assertStateForDifferentLiveNeighbours(expectedState, currentState, liveNeighboursArr);
    }

    //Any live cell with more than three live neighbours dies, as if by overpopulation.
    @Test
    public void nextStateShouldReturnDeadStateWhenALiveCellHasMoreThanThreeLiveNeighbours() {
        State expectedState = State.DEAD;
        State currentState = State.LIVE;
        int[] liveNeighboursArr = {4, 5};

        assertStateForDifferentLiveNeighbours(expectedState, currentState, liveNeighboursArr);
    }

    //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    @Test
    public void nextStateShouldReturnLiveStateWhenADeadCellHasThreeLiveNeighbours() {
        State expectedState = State.LIVE;
        State currentState = State.DEAD;
        int[] liveNeighboursArr = {3};

        assertStateForDifferentLiveNeighbours(expectedState, currentState, liveNeighboursArr);
    }

    @Test
    public void nextStateShouldReturnDeadStateWhenADeadCellHasOtherThanThreeLiveNeighbours() {
        State expectedState = State.DEAD;
        State currentState = State.DEAD;
        int[] liveNeighboursArr = {2, 4};

        assertStateForDifferentLiveNeighbours(expectedState, currentState, liveNeighboursArr);
    }

    private void assertStateForDifferentLiveNeighbours(State expectedState, State currentState, int[] liveNeighboursArr) {
        for (int liveNeighbours : liveNeighboursArr) {
            State nextState = rule.nextState(currentState, liveNeighbours);
            assertEquals(expectedState, nextState);
        }
    }
}