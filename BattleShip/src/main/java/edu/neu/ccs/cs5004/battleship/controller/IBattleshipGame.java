package edu.neu.ccs.cs5004.battleship.controller;


/**
 * Represents the controller of battleship game.
 */
public interface IBattleshipGame {

  /**
   * Starts the battleship game.
   */
  static void startBattleshipGame() {
    AbstractBattleshipGame game = new GameMode();
    game.getConsolePrinter().printGreeting();
    game = game.chooseGameMode(System.in, System.in);
    game.setUpGame();
    GameResult gameResult = game.playGame();
    game.endGame(gameResult);
  }
}
