package com.ptc.plms.gol.oops.game;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import com.ptc.plms.gol.oops.strategy.DefaultGameStrategy;
import com.ptc.plms.gol.oops.strategy.GameStrategy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.ptc.plms.gol.oops.utils.CellUtils.processCell;

public class GameOfLifeImpl implements GameOfLife {


    @Override
    public Set<Cell> run(Set<Cell> liveCells) {
        return run(liveCells, new DefaultGameStrategy());
    }

    @Override
    public Set<Cell> run(Set<Cell> liveCells, GameStrategy gameStrategy) {
        HashSet<Cell> nextGeneration = new HashSet<>();

        Set<Cell> neighbouringCells;
        for (Cell cellFromCurrentGeneration : liveCells) {
            processCell(cellFromCurrentGeneration, liveCells, nextGeneration, gameStrategy);

            neighbouringCells = gameStrategy.findNeighbours(cellFromCurrentGeneration, liveCells);

            for (Cell neighbouringCell : neighbouringCells) {
                processCell(neighbouringCell, liveCells, nextGeneration, gameStrategy);
            }
        }

        return filterDead(nextGeneration);
    }

    private Set<Cell> filterDead(HashSet<Cell> nextGeneration) {
        Iterator<Cell> iterator = nextGeneration.iterator();

        while (iterator.hasNext()) {
            if (State.DEAD.equals(iterator.next().getState())) {
                iterator.remove();
            }
        }

        return nextGeneration;
    }


}
