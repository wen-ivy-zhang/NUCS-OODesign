package edu.neu.ccs.cs5004.battleship.view;

import edu.neu.ccs.cs5004.battleship.controller.GameResult;
import edu.neu.ccs.cs5004.battleship.controller.GameType;
import edu.neu.ccs.cs5004.battleship.controller.PlacementType;
import edu.neu.ccs.cs5004.battleship.model.AttackResult;
import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.SpecificShipCell;
import edu.neu.ccs.cs5004.battleship.model.WaterCell;


import java.io.InputStream;

/**
 * Represents a printer which could print to the console.
 */
public interface IConsolePrinter {


  /**
   * Create a new debug view.
   * @return a new debug view.
   */
  static IConsolePrinter createDebugView() {
    return new DebugView();
  }

  /**
   * Create a new game view.
   * @return a new game view.
   */
  static IConsolePrinter createGameView() {
    return new GameView();
  }

  /**
   * Print {@code map} to the console.
   * @param map represent the map to be printed to the console.
   */
  void toConsole(IMap map);

  /**
   * Print{@code AbstractWaterCell} to the console.
   * @param waterCell represents the WATER cell to be printed to the console.
   */
  void toConsole(WaterCell waterCell);

  /**
   *Print{@code SpecificShipCell} to the console.
   * @param specificShipCell represents the specific ship cell to be printed to the console.
   */
  void toConsole(SpecificShipCell specificShipCell);


  /**
   * Print{@code EnemyShipCell} to the console.
   * @param enemyShipCell represents the enemy ship cell to be printed to the console.
   */
  void toConsole(EnemyShipCell enemyShipCell);

  /**
   * Print the start game view.
   */
  void printGreeting();

  /**
   * Get position from user input.
   * @return position provided by user
   */
  Position getUserInputPosition(InputStream stream);

  /**
   * Get direction from user input.
   * @return direction provided by user
   */
  Direction getUserInputDirection(InputStream stream);

  /**
   * Get game mode from user input.
   * @return game mode provided by user
   */
  GameType getUserInputGameMode(InputStream stream);

  /**
   * Get number of battleships from user input.
   * @return number of battleships provided by user
   */
  int getUserInputNumOfBattleShips(InputStream stream);

  /**
   * Get number of Cruiser from user input.
   * @return number of Cruisers provided by user
   *
   */
  int getUserInputNumOfCruisers(InputStream stream);

  /**
   * Get number of Submarine from user input.
   * @return number of submarine provided by user
   */
  int getUserInputNumOfSubmarine(InputStream stream);


  /**
   * Get number of Destroyer from user input.
   * @return number of destroyer provided by user
   */
  int getUserInputNumOfDestroyer(InputStream stream);

  /**
   * Get the method for ship placement from user, either random or user placement.
   * @return method for ship placement
   */
  PlacementType getUserInputPlacement(InputStream stream);


  /**
   * Print the error message to the console.
   * @param prompt represents the promt message.
   */
  void displayErrorMessage(String prompt);

  /**
   * Print computer ship placement message.
   */
  void startComputerShipPlacement();

  /**
   * Print user ship placement message.
   */
  void startUserShipPlacement();

  /**
   * Print computer ship placement message.
   */
  void completeComputerShipPlacement();

  /**
   * Print user ship placement message.
   */
  void completeUserShipPlacement();

  /**
   * Update the map for map observer.
   * @param userFleetMap represent user's fleet map.
   * @param computerFleetMap represent computer's fleet map.
   * @param userBattleMap represent user's battle map.
   * @param computerBattleMap represent computer's battle map.
   */
  void update(IMap userFleetMap, IMap computerFleetMap, IMap userBattleMap, IMap computerBattleMap);

  /**
   * Print start game message to the console.
   */
  void startGameView();

  /**
   * Print user attack message to the console.
   */
  void userAttackView();

  /**
   * Print computer attack message to the console.
   */
  void computerAttackView();

  /**
   * Print the position being attacked to the console.
   * @param posn represents the given position.
   */
  void displayAttackedPosition(Position posn);

  /**
   * Print attack result to the console.
   * @param attackResult the attack result.
   */
  void displayAttackResult(AttackResult attackResult);
  /**
   * Print the game result to the console.
   * @param gameResult represents the result of the battleship game.
   */
  void endGameView(GameResult gameResult);

}
