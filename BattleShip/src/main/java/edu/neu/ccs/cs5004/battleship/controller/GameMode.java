package edu.neu.ccs.cs5004.battleship.controller;


import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

/**
 * Represents the game mode of the battleship game.
 */
public class GameMode extends AbstractBattleshipGame {

  /**
   * Creates a new game in real game mode.
   */
  protected GameMode() {
    super();
    setConsolePrinter(IConsolePrinter.createGameView());
  }

  @Override
  public String toString() {
    return "GameMode{} " + super.toString();
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
