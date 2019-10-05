package com.ptc.plms.gol.oops.game;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GameOfLifeImplTest {

    Set<Cell> liveCells;
    GameOfLife gameOfLife;

    Cell cell1 = new Cell(0, 0);
    Cell cell2 = new Cell(0, 1, State.LIVE);
    Cell cell3 = new Cell(0, 2);
    Cell cell4 = new Cell(1, 0, State.LIVE);
    Cell cell5 = new Cell(1, 1, State.LIVE);
    Cell cell6 = new Cell(1, 2);
    Cell cell7 = new Cell(2, 0);
    Cell cell8 = new Cell(2, 1);
    Cell cell9 = new Cell(2, 2, State.LIVE);

    @Before
    public void setUpNew() {
        gameOfLife = new GameOfLifeImpl();

        liveCells = new HashSet<>();
        liveCells.add(cell2);
        liveCells.add(cell5);
        liveCells.add(cell9);
    }

    @Test
    public void runWithDefaultStrategyGivesNextGenerationLiveCells() {
        Set<Cell> expectedLiveCells = new HashSet<>();
        expectedLiveCells.add(cell5);
        expectedLiveCells.add(cell6);

        Set<Cell> nextGenerationLiveCells = gameOfLife.run(liveCells);

        assertEquals(expectedLiveCells, nextGenerationLiveCells);
    }
}