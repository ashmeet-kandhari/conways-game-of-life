package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import com.ptc.plms.gol.oops.rules.Rule;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hdhingra
 */
public class GameStrategyImpl implements GameStrategy {

    private Rule[] rules;

    public GameStrategyImpl(Rule[] rules) {
        this.rules = rules;
    }

    @Override
    public Rule[] getRules() {
        return rules;
    }

    @Override
    public Set<Cell> findNeighbours(Cell cell, Set<Cell> liveCells) {
        HashSet<Cell> neighbours = new HashSet<>();

        int x = cell.getX();
        int y = cell.getY();
        Cell tempCell;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;

                //bug fix : self neighbour
                if (x == i && y == j) {
                    continue;
                }

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
