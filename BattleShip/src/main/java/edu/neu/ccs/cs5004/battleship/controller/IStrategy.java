package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Position;


/**
 * Represents a strategy used to attack opponent's ship in battleship game.
 */
public interface IStrategy {

  /**
   * Create random strategy.
   *
   * @return a new random strategy.
   */
  static IStrategy createRandomStrategy() {
    return new RandomStrategy();
  }


  /**
   * Create user strategy.
   *
   * @return a new user strategy.
   */
  static IStrategy createUserStrategy() {
    return new UserStrategy();
  }

  /**
   * Create smart strategy.
   *
   * @return a new user strategy.
   */
  static IStrategy createSmartStrategy() {
    return new SmartStrategy();
  }

  /**
   * Return a position on the map to be attacked.
   *
   * @param map represents the battle map.
   * @return a position on the map to be attacked.
   */
  Position chooseCellToAttack(IMap map);
}
