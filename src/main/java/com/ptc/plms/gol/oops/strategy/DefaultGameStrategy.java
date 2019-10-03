package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.Cell;
import com.ptc.plms.gol.oops.State;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hdhingra
 */
public class DefaultGameStrategy implements GameStrategy {

    public Set<Cell> findNeighbours(Cell cell, Set<Cell> liveCells) {
        HashSet<Cell> neighbours = new HashSet<Cell>();

        int x = cell.getX();
        int y = cell.getY();
        Cell tempCell;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;

                tempCell = new Cell(i, j);
                if (liveCells.contains(tempCell)) {
                    tempCell.setState(State.LIVE);
                }
                neighbours.add(tempCell);
            }
        }

        return neighbours;
    }
}
