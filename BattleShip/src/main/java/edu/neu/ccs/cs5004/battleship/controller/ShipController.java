package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.BattleShip;
import edu.neu.ccs.cs5004.battleship.model.Cruiser;
import edu.neu.ccs.cs5004.battleship.model.Destroyer;
import edu.neu.ccs.cs5004.battleship.model.Ship;
import edu.neu.ccs.cs5004.battleship.model.Submarine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the list of ships in the game.
 */
public class ShipController {

  private List<Ship> userShips;
  private List<Ship> computerShips;

  /**
   * Creates a new ship controller with default settings.
   */
  protected ShipController() {

    this.userShips = new ArrayList<>();
    this.computerShips = new ArrayList<>();

    int numOfBattleship = 1; // 1 battleship in game rule.
    for (int i = 0; i < numOfBattleship; i++) {
      userShips.add(new BattleShip());
      computerShips.add(new BattleShip());
    }

    int numOfCruiser = 2; // 2 cruisers in game rule.
    for (int i = 0; i < numOfCruiser; i++) {
      userShips.add(new Cruiser());
      computerShips.add(new Cruiser());
    }

    int numOfSubmarine = 3; // 3 submarines in game rule.
    for (int i = 0; i < numOfSubmarine; i++) {
      userShips.add(new Submarine());
      computerShips.add(new Submarine());
    }

    int numOfDestroyer = 4; // 4 destroyers in game rule.
    for (int i = 0; i < numOfDestroyer; i++) {
      userShips.add(new Destroyer());
      computerShips.add(new Destroyer());
    }
  }

  /**
   * Creates a new ship controller with default settings.
   */
  protected ShipController(Boolean userTestMode) {
    if (userTestMode) {
      this.userShips = new ArrayList<>();
      this.computerShips = new ArrayList<>();

      int numOfBattleship = 1; // 1 battleship in game rule.
      for (int i = 0; i < numOfBattleship; i++) {
        userShips.add(new BattleShip(4, 4));
        computerShips.add(new BattleShip());
      }

      int numOfCruiser = 2; // 2 cruisers in game rule.
      for (int i = 0; i < numOfCruiser; i++) {
        userShips.add(new Cruiser(3, 3));
        computerShips.add(new Cruiser());
      }

      int numOfSubmarine = 3; // 3 submarines in game rule.
      for (int i = 0; i < numOfSubmarine; i++) {
        userShips.add(new Submarine(2, 2));
        computerShips.add(new Submarine());
      }

      int numOfDestroyer = 4; // 4 destroyers in game rule.
      for (int i = 0; i < numOfDestroyer; i++) {
        userShips.add(new Destroyer(1, 1));
        computerShips.add(new Destroyer());
      }
    } else {
      this.userShips = new ArrayList<>();
      this.computerShips = new ArrayList<>();

      int numOfBattleship = 1; // 1 battleship in game rule.
      for (int i = 0; i < numOfBattleship; i++) {
        userShips.add(new BattleShip());
        computerShips.add(new BattleShip(4, 4));
      }

      int numOfCruiser = 2; // 2 cruisers in game rule.
      for (int i = 0; i < numOfCruiser; i++) {
        userShips.add(new Cruiser());
        computerShips.add(new Cruiser(3, 3));
      }

      int numOfSubmarine = 3; // 3 submarines in game rule.
      for (int i = 0; i < numOfSubmarine; i++) {
        userShips.add(new Submarine());
        computerShips.add(new Submarine(2, 2));
      }

      int numOfDestroyer = 4; // 4 destroyers in game rule.
      for (int i = 0; i < numOfDestroyer; i++) {
        userShips.add(new Destroyer());
        computerShips.add(new Destroyer(1, 1));
      }
    }
  }


  /**
   * Creates a new ship controller with input settings.
   */
  protected ShipController(int numOfBattleship, int numOfCruiser,
                           int numOfSubmarine, int numOfDestroyer) {

    this.userShips = new ArrayList<>();
    this.computerShips = new ArrayList<>();

    for (int i = 0; i < numOfBattleship; i++) {
      userShips.add(new BattleShip());
      computerShips.add(new BattleShip());
    }
    for (int i = 0; i < numOfCruiser; i++) {
      userShips.add(new Cruiser());
      computerShips.add(new Cruiser());
    }
    for (int i = 0; i < numOfSubmarine; i++) {
      userShips.add(new Submarine());
      computerShips.add(new Submarine());
    }
    for (int i = 0; i < numOfDestroyer; i++) {
      userShips.add(new Destroyer());
      computerShips.add(new Destroyer());
    }
  }


  /**
   * Getter for property user ships.
   *
   * @return the value for property user ships.
   */
  protected List<Ship> getUserShips() {
    return userShips;
  }

  /**
   * Getter for property computer ships.
   *
   * @return the value for property computer ships.
   */
  protected List<Ship> getComputerShips() {
    return computerShips;
  }


  /**
   * Setter for property user ships.
   *
   * @param ships value to set for property user ships.
   */
  protected void setUserShips(List<Ship> ships) {
    this.userShips = ships;
  }

  /**
   * Setter for property computer ships.
   *
   * @param ships value to set for property computer ships.
   */
  protected void setComputerShips(List<Ship> ships) {
    this.computerShips = ships;
  }

  /**
   * Check if all ship in the ship list is sunk.
   *
   * @param ships represents a list of ships.
   * @return true if all ships are sunk, false otherwise.
   */
  protected boolean allShipSunk(List<Ship> ships) {
    for (Ship ship : ships) {
      if (!ship.isSunk()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ShipController that = (ShipController) object;
    return Objects.equals(getUserShips(), that.getUserShips())
        && Objects.equals(getComputerShips(), that.getComputerShips());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getUserShips(), getComputerShips());
  }

  @Override
  public String toString() {
    return "ShipController{"
        + "userShips=" + userShips
        + ", computerShips=" + computerShips
        + '}';
  }
}
