package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.AttackResult;
import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidArgumentException;
import edu.neu.ccs.cs5004.battleship.model.Miss;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.Ship;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * Represents an abstract battleship game.
 */
public abstract class AbstractBattleshipGame implements IBattleshipGame {


  private MapController mapController;
  private ShipController shipController;
  private IConsolePrinter consolePrinter;

  /**
   * Create an abstract battleship game.
   */
  public AbstractBattleshipGame() {
    this.mapController = new MapController();
    this.shipController = new ShipController();
    this.consolePrinter = null;
  }

  /**
   * Getter for property mapController.
   *
   * @return the value for property mapController.
   */
  protected MapController getMapController() {
    return mapController;
  }

  /**
   * Getter for property shipController.
   *
   * @return the value for property shipController
   */
  protected ShipController getShipController() {
    return shipController;
  }

  /**
   * Setter for property shipController.
   */
  protected void setShipController(ShipController shipController) {
    this.shipController = shipController;

  }

  /**
   * Getter for property console printer.
   *
   * @return the value for property console printer.
   */
  protected IConsolePrinter getConsolePrinter() {
    return consolePrinter;
  }


  /**
   * Setter for property console printer.
   *
   * @param consolePrinter value to set for property console printer.
   */
  protected void setConsolePrinter(IConsolePrinter consolePrinter) {
    this.consolePrinter = consolePrinter;
  }

  /**
   * Randomly choose a position and direction to place the given ship on map.
   *
   * @param ship represents the given ship.
   * @param map  represents the given map.
   */
  protected void randomPlaceOneShip(Ship ship, IMap map) {
    IRandomInput randomInput = IRandomInput.createRandomInput();
    Position posn = randomInput.generateRandomPosition();
    Direction direction = randomInput.generateRandomDirection();
    try {
      map.placeShipOnMap(posn, direction, ship);
    } catch (InvalidArgumentException e) {
      randomPlaceOneShip(ship, map);
    }
  }

  /**
   * User choose a position and direction to place the given ship on map.
   *
   * @param ship represents the given ship.
   * @param map  represents the given map.
   */
  protected void userPlaceOneShip(Ship ship, IMap map, InputStream stream1, InputStream stream2) {

    Position posn = consolePrinter.getUserInputPosition(stream1);
    Direction direction = consolePrinter.getUserInputDirection(stream2);
    try {
      map.placeShipOnMap(posn, direction, ship);
    } catch (InvalidArgumentException e) {
      consolePrinter.displayErrorMessage(e.getMessage());
      userPlaceOneShip(ship, map, stream1, stream2);
    }
    mapController.notifyObservers();
  }

  /**
   * Use random position and direction to place all of computer's or player's ships on the map.
   *
   * @param map   the map to place ships on.
   * @param ships represents the ships to be placed on the map.
   */
  protected void randomPlacement(IMap map, List<Ship> ships) {

    for (Ship ship : ships) {
      randomPlaceOneShip(ship, map);
    }
  }

  /**
   * Use position and direcetion from user input to place all of player's ships one the map.
   *
   * @param map the map to place ships on.
   */
  private void userPlacement(IMap map, InputStream stream1, InputStream stream2) {

    for (Ship ship : shipController.getUserShips()) {
      userPlaceOneShip(ship, map, stream1, stream2);
    }
  }

  /**
   * Place ships on user fleet map in either random or user mode according to the user's choice.
   */
  protected void placeShipsOnUserFleetMap(InputStream stream1,
                                          InputStream stream2,
                                          InputStream stream3) {
    consolePrinter.startUserShipPlacement();

    if (consolePrinter.getUserInputPlacement(stream1) == PlacementType.RANDOM_PLACEMENT) {

      randomPlacement(mapController.getUserFleetMap(), getShipController().getUserShips());
      mapController.notifyObservers();
    } else {
      userPlacement(mapController.getUserFleetMap(), stream2, stream3);
    }
    consolePrinter.completeUserShipPlacement();
  }

  /**
   * Place ships on computer fleet map.
   */
  protected void placeShipsOnComputerFleetMap() {
    consolePrinter.startComputerShipPlacement();
    randomPlacement(mapController.getComputerFleetMap(), getShipController().getComputerShips());
    consolePrinter.completeComputerShipPlacement();
    mapController.notifyObservers();
  }

  /**
   * User attack computer's ships.
   *
   * @return game result.
   */
  private GameResult userAttack() {

    IStrategy strategy = IStrategy.createUserStrategy();
    IMap computerFleetMap = getMapController().getComputerFleetMap();
    IMap userBattleMap = getMapController().getUserBattleMap();

    getConsolePrinter().userAttackView();
    AttackResult attackResult = oneRoundOfAttack(strategy, computerFleetMap, userBattleMap);
    getMapController().notifyObservers();

    if (attackResult instanceof Miss) {
      return computerAttack();
    } else if (checkIsGameOver()) {
      return GameResult.USER_WIN;
    } else {
      return userAttack();
    }
  }

  /**
   * Computer attack user's ships.
   *
   * @return game result.
   */
  private GameResult computerAttack() {

    IStrategy strategy = IStrategy.createSmartStrategy();
    IMap userFleetMap = getMapController().getUserFleetMap();
    IMap computerBattleMap = getMapController().getComputerBattleMap();

    getConsolePrinter().computerAttackView();
    AttackResult attackResult = oneRoundOfAttack(strategy, userFleetMap, computerBattleMap);
    getMapController().notifyObservers();

    if (attackResult instanceof Miss) {
      return userAttack();
    } else if (checkIsGameOver()) {
      return GameResult.COMPUTER_WIN;
    } else {
      return computerAttack();
    }
  }

  /**
   * Represent one round of attack.
   *
   * @param strategy  represents the strategy used
   * @param fleetMap  represents the fleet map
   * @param battleMap represents the battle map
   * @return attack result.
   */
  protected AttackResult oneRoundOfAttack(IStrategy strategy, IMap fleetMap, IMap battleMap) {

    Position posn = strategy.chooseCellToAttack(battleMap);
    getConsolePrinter().displayAttackedPosition(posn);
    AttackResult attackResult = fleetMap.getCell(posn).attackResult();
    getConsolePrinter().displayAttackResult(attackResult);
    getMapController().updateFleetMapAfterAttack(posn, attackResult, fleetMap);
    getMapController().updateBattleMapAfterAttack(posn, attackResult, battleMap);
    return attackResult;
  }

  /**
   * Decide whether to end the game.
   *
   * @return true if all user ships are sunk or all computer ships are sunk, false otherwise.
   */
  protected Boolean checkIsGameOver() {
    return getShipController().allShipSunk(getShipController().getUserShips())
        || getShipController().allShipSunk(getShipController().getComputerShips());
  }


  /**
   * Let player choose game mode.
   *
   * @return the game mode that player chose.
   */
  protected AbstractBattleshipGame chooseGameMode(InputStream stream1, InputStream stream2) {
    if (consolePrinter.getUserInputGameMode(stream1) == GameType.DEBUG_MODE) {
      return new DebugMode(stream2);
    } else {
      return new GameMode();
    }
  }

  /**
   * Set up the game, complete ship configuration.
   */
  protected void setUpGame() {
    mapController.registerObserver(consolePrinter);
    placeShipsOnComputerFleetMap();
    placeShipsOnUserFleetMap(System.in, System.in, System.in);
  }

  /**
   * Start playing the battleship game.
   *
   * @return the game result
   */
  protected GameResult playGame() {
    getConsolePrinter().startGameView();
    return userAttack();
  }

  /**
   * End battleship game and print game result.
   *
   * @param gameResult represents the result of the game.
   */
  protected void endGame(GameResult gameResult) {
    getConsolePrinter().endGameView(gameResult);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractBattleshipGame that = (AbstractBattleshipGame) object;
    return Objects.equals(getMapController(), that.getMapController())
        && Objects.equals(getShipController(), that.getShipController())
        && Objects.equals(getConsolePrinter(), that.getConsolePrinter());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getMapController(), getShipController(), getConsolePrinter());
  }


}
