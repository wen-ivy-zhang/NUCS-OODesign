package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Position;

/**
 * Represents the random choice of not yet hit cell on the map.
 */
public class RandomStrategy implements IStrategy {

  /**
   * Return a position on the map to be attacked.
   *
   * @param map represents the battle map.
   * @return a position on the map to be attacked.
   */
  @Override
  public Position chooseCellToAttack(IMap map) {
    Position posn;
    do {
      IRandomInput randomInput = IRandomInput.createRandomInput();
      posn = randomInput.generateRandomPosition();
    } while (map.getCell(posn).getIsHit());
    return posn;
  }
}
