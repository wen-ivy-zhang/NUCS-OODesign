package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.AttackResult;
import edu.neu.ccs.cs5004.battleship.model.Cell;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.Hit;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.OpenSeaCell;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.Sunk;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Wrapper of maps in the battleship game, which allows to add observers.
 */
public class MapController {

  private IMap userFleetMap;
  private IMap computerFleetMap;
  private IMap userBattleMap;
  private IMap computerBattleMap;

  private List<IConsolePrinter> observers;

  /**
   * Create an Instance of  Map controller.
   */
  protected MapController() {
    this.userFleetMap = IMap.createEmptyMap();
    this.computerFleetMap = IMap.createEmptyMap();
    this.userBattleMap = IMap.createEmptyMap();
    this.computerBattleMap = IMap.createEmptyMap();
    this.observers = new ArrayList<>();
  }

  /**
   * Create an instance of Map controller.
   */
  protected MapController(IMap userFleetMap, IMap userBattleMapMap,
                          IMap computerFleetMap, IMap computerBattleMap) {
    this.userFleetMap = userFleetMap;
    this.computerFleetMap = computerFleetMap;
    this.userBattleMap = userBattleMapMap;
    this.computerBattleMap = computerBattleMap;
    this.observers = new ArrayList<>();
  }

  /**
   * Getter for property player fleet map.
   *
   * @return the value for property player fleet map
   */
  protected IMap getUserFleetMap() {
    return userFleetMap;
  }

  /**
   * Getter for property computer fleet map.
   *
   * @return the value of property computer fleet map
   */
  protected IMap getComputerFleetMap() {
    return computerFleetMap;
  }


  /**
   * Getter for property player battle map.
   *
   * @return the value for property player battle map
   */
  protected IMap getUserBattleMap() {
    return userBattleMap;
  }

  /**
   * Getter for property computer battle map.
   *
   * @return the value for property computer battle map
   */
  protected IMap getComputerBattleMap() {
    return computerBattleMap;
  }

  /**
   * Add map observer to observers list.
   *
   * @param observer the map observer to be added.
   */
  protected void registerObserver(IConsolePrinter observer) {
    observers.add(observer);
  }

  /**
   * Notify all the observers that the maps in the map controller had changed.
   */
  protected void notifyObservers() {
    for (IConsolePrinter observer : observers) {
      observer.update(userFleetMap, computerFleetMap, userBattleMap, computerBattleMap);
    }
  }


  /**
   * Update the fleet map after attack.
   *
   * @param posn         represents the position to be attacked
   * @param attackResult represents the result of the attack
   * @param fleetMap     represents the fleet map.
   */
  protected void updateFleetMapAfterAttack(Position posn, AttackResult attackResult,
                                           IMap fleetMap) {
    Cell newCell = fleetMap.getCell(posn).attackCell();
    fleetMap.setCell(posn, newCell);
    if (attackResult instanceof Sunk) {
      newCell.notifyObserver();
    }
  }

  /**
   * Update the fleet map after attack.
   *
   * @param posn         represents the position to be attacked
   * @param attackResult represents the result of the attack
   * @param battleMap    represents the battle map.
   */
  protected void updateBattleMapAfterAttack(Position posn, AttackResult attackResult,
                                            IMap battleMap) {
    if (attackResult instanceof Sunk) {
      Cell newCell = new EnemyShipCell(true, true);
      battleMap.setCell(posn, newCell);
      newCell.notifyObserver();
    } else if (attackResult instanceof Hit) {
      battleMap.setCell(posn, new EnemyShipCell(true, false));
    } else {
      battleMap.setCell(posn, new OpenSeaCell(true));
    }
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    MapController that = (MapController) object;
    return Objects.equals(getUserFleetMap(), that.getUserFleetMap())
        && Objects.equals(getComputerFleetMap(), that.getComputerFleetMap())
        && Objects.equals(getUserBattleMap(), that.getUserBattleMap())
        && Objects.equals(getComputerBattleMap(), that.getComputerBattleMap())
        && Objects.equals(observers, that.observers);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getUserFleetMap(), getComputerFleetMap(), getUserBattleMap(),
        getComputerBattleMap(), observers);
  }


}
