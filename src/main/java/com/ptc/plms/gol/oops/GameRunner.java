package com.ptc.plms.gol.oops;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.entity.State;
import com.ptc.plms.gol.oops.game.GameOfLife;
import com.ptc.plms.gol.oops.game.GameOfLifeImpl;

import java.util.HashSet;
import java.util.Set;

public class GameRunner {

    public static void main(String[] args) {
        Set<Cell> liveCells = new HashSet<>();
        liveCells.add(new Cell(0, 1, State.LIVE));
        liveCells.add(new Cell(1, 1, State.LIVE));
        liveCells.add(new Cell(2, 2, State.LIVE));

        GameOfLife gameOfLife = new GameOfLifeImpl();

        System.out.println(gameOfLife.run(liveCells));
    }


}
