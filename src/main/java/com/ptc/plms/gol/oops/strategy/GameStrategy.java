package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.entity.Cell;
import com.ptc.plms.gol.oops.rules.Rule;

import java.util.Set;

/**
 * @author hdhingra
 */
public interface GameStrategy {
	Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);

	Rule[] getRules();
}
