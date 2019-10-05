package com.ptc.plms.gol.oops.utils;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import com.ptc.plms.gol.oops.strategy.DefaultGameStrategy;
import com.ptc.plms.gol.oops.strategy.GameStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CellUtilsTest {

    GameStrategy gameStrategy;
    Set<Cell> nextGenerationCells;
    Set<Cell> currentGenerationCells;

    Cell cell1 = new Cell(0, 0);
    Cell cell2 = new Cell(0, 1, State.LIVE);
    Cell cell3 = new Cell(0, 2);
    Cell cell4 = new Cell(1, 0, State.LIVE);
    Cell cell5 = new Cell(1, 1, State.LIVE);
    Cell cell6 = new Cell(1, 2, State.LIVE);
    Cell cell7 = new Cell(2, 0, State.LIVE);
    Cell cell8 = new Cell(2, 1, State.DEAD);
    Cell cell9 = new Cell(2, 2, State.LIVE);
    Cell cell10 = new Cell(3, 1, State.LIVE);

    @Before
    public void setUp() {
        nextGenerationCells = new HashSet<>();
        gameStrategy = new DefaultGameStrategy();

        currentGenerationCells = new HashSet<>();
        currentGenerationCells.add(cell2);
        currentGenerationCells.add(cell5);
        currentGenerationCells.add(cell6);
        currentGenerationCells.add(cell7);
        currentGenerationCells.add(cell9);
        currentGenerationCells.add(cell10);
    }

    @Test
    public void processCellShouldUpdateTheNextGenerationCellToDeadWhenLiveCellHasOneOrNoLiveNeighbours() {
        CellUtils.processCell(cell1, currentGenerationCells, nextGenerationCells, gameStrategy);
        assertTrue(State.DEAD.equals(nextGenerationCells.iterator().next().getState()));
    }

    @Test
    public void processCellShouldUpdateTheNextGenerationCellToLiveWhenDeadCellHasTwoLiveNeighbours() {
        CellUtils.processCell(cell3, currentGenerationCells, nextGenerationCells, gameStrategy);
        assertTrue(State.LIVE.equals(nextGenerationCells.iterator().next().getState()));
    }
}