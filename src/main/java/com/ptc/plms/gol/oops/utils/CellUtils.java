package com.ptc.plms.gol.oops.utils;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.oops.strategy.GameStrategy;

import java.util.Set;

public class CellUtils {

    /**
     * Process cell based on the given strategy and add in nextGeneration
     *
     * @param cell              To be processed
     * @param currentGeneration Current generation cells
     * @param nextGeneration    Next generation cells.
     * @param gameStrategy      Strategy to be applied
     */
    public static void processCell(Cell cell, Set<Cell> currentGeneration, Set<Cell> nextGeneration,
                                   GameStrategy gameStrategy) {
        if (nextGeneration.contains(cell)) return; // already processed

        cell = cell.createCopy();

        State nextState = cell.getState();
        for (Rule rule : gameStrategy.getRules()) {
            nextState = rule.nextState(cell.getState(), findLiveNeighbourCount(cell, currentGeneration,
                    gameStrategy));

            if (!cell.getState().equals(nextState)) {
                break;
            }
        }

        cell.setState(nextState);
        nextGeneration.add(cell);
    }

    private static int findLiveNeighbourCount(Cell cell, Set<Cell> liveCells, GameStrategy gameStrategy) {
        int count = 0;
        for (Cell c : gameStrategy.findNeighbours(cell, liveCells)) {
            if (State.LIVE.equals(c.getState())) count++;
        }
        return count;
    }
}
