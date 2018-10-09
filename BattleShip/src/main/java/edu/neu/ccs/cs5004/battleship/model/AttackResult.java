package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents the result after attacking a cell, could be miss, hit or sunk.
 * Miss – the guessed cell does not contain a ship
 * Hit – the cell is a part of the ship, but there are other cells that have not been hit yet (the
 * ship was hit, but has not yet been sunk)
 * Sunk – the cell is a part of the ship and all the other cells of the ship were hit (the ship has
 * been sunk)
 */
public interface AttackResult {

  /**
   * Get the result after attacking a cell as a string.
   * @return attack result as a string
   */
  String getAttackResult();
}
