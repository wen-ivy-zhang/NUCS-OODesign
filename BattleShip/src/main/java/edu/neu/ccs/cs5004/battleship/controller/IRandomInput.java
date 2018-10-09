package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.Position;

/**
 * Generate random position and direction for other class.
 */
public interface IRandomInput {

  static IRandomInput createRandomInput() {
    return new RandomInput();
  }


  /**
   * Generate a random position.
   *
   * @return a random position
   */
  Position generateRandomPosition();


  /**
   * Generate a random direction.
   *
   * @return a random direction.
   */
  Direction generateRandomDirection();
}
