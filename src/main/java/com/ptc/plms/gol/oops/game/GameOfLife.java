package com.ptc.plms.gol.oops.game;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.strategy.GameStrategy;

import java.util.Set;

public interface GameOfLife {

    /**
     * Runs and returns next generation of live cells after default strategy is applied.
     *
     * @param liveCells Seed of system.
     * @return New generation cells.
     */
    Set<Cell> run(Set<Cell> liveCells);

    /**
     * Runs and returns next generation of live cells after given strategy is applied.
     *
     * @param liveCells    Seed of system.
     * @param gameStrategy Strategy to be applied to run the game.
     * @return new generation cells.
     */
    Set<Cell> run(Set<Cell> liveCells, GameStrategy gameStrategy);
}
