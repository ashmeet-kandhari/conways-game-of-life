package com.ptc.plms.gol.oops.strategy;

import java.util.Set;

import com.ptc.plms.gol.oops.Cell;
import com.ptc.plms.gol.oops.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public interface GameStrategy {

	Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);

}
