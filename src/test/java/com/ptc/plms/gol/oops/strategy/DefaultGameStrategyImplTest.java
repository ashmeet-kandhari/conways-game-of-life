package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DefaultGameStrategyImplTest {

    private GameStrategy gameStrategy;

    @Before
    public void setUp() throws Exception {
        this.gameStrategy = new DefaultGameStrategy();
    }

    @Test
    public void findNeighboursGivesAllTheNeighboursOfTheGivenCellWithTheirOriginalState() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        Cell cell3 = new Cell(0, 2);
        Cell cell4 = new Cell(1, 0);
        Cell cell5 = new Cell(1, 1, State.LIVE);
        Cell cell6 = new Cell(1, 2, State.LIVE);
        Cell cell7 = new Cell(2, 0);
        Cell cell8 = new Cell(2, 1, State.DEAD);
        Cell cell9 = new Cell(2, 2, State.LIVE);
        Cell cell10 = new Cell(3, 1, State.LIVE);


        Set<Cell> liveCellSet = new HashSet<>();
        liveCellSet.add(cell5);
        liveCellSet.add(cell6);
        liveCellSet.add(cell9);
        liveCellSet.add(cell10);

        Set<Cell> expectedNeighbourCells = new HashSet<>();
        expectedNeighbourCells.add(cell1);
        expectedNeighbourCells.add(cell2);
        expectedNeighbourCells.add(cell3);
        expectedNeighbourCells.add(cell4);
        expectedNeighbourCells.add(cell9);
        expectedNeighbourCells.add(cell6);
        expectedNeighbourCells.add(cell7);
        expectedNeighbourCells.add(cell8);

        Set<Cell> neighbourCells = gameStrategy.findNeighbours(cell5, liveCellSet);

        assertEquals(expectedNeighbourCells, neighbourCells);
    }
}