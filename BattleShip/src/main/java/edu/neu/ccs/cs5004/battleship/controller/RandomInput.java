package edu.neu.ccs.cs5004.battleship.controller;



import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.Position;

import java.util.Random;



/**
 * Generate random position and direction for other class.
 */
public class RandomInput implements IRandomInput {

  /**
   * Generate a random position.
   *
   * @return a random position
   */
  public Position generateRandomPosition() {
    Random rand = new Random();
    int row = rand.nextInt(10) + 1;
    char column = Character.toChars('A' + rand.nextInt(10))[0];
    return new Position(row, column);
  }

  /**
   * Generate a random direction.
   *
   * @return a random direction.
   */
  public Direction generateRandomDirection() {
    Random rand = new Random();
    int number = rand.nextInt(2);
    if (number == 0) {
      return Direction.HORIZONTAL;
    } else {
      return Direction.VERTICAL;
    }
  }


}
