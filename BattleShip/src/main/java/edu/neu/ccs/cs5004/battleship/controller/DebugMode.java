package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.BattleShip;
import edu.neu.ccs.cs5004.battleship.model.Cruiser;
import edu.neu.ccs.cs5004.battleship.model.Destroyer;
import edu.neu.ccs.cs5004.battleship.model.Ship;
import edu.neu.ccs.cs5004.battleship.model.Submarine;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the debug mode of the battleship game.
 */
public class DebugMode extends AbstractBattleshipGame {

  /**
   * Create a new game in debug mode.
   */
  protected DebugMode(InputStream stream) {
    super();
    setConsolePrinter(IConsolePrinter.createDebugView());

    List<Ship> userShips = new ArrayList<>();
    List<Ship> computerShips = new ArrayList<>();

    int numOfBattleships = getConsolePrinter().getUserInputNumOfBattleShips(stream);
    for (int i = 0; i < numOfBattleships; i++) {
      userShips.add(new BattleShip());
      computerShips.add(new BattleShip());
    }

    int numOfCruisers = getConsolePrinter().getUserInputNumOfCruisers(stream);
    for (int i = 0; i < numOfCruisers; i++) {
      userShips.add(new Cruiser());
      computerShips.add(new Cruiser());
    }

    int numOfSubmarines = getConsolePrinter().getUserInputNumOfSubmarine(stream);
    for (int i = 0; i < numOfSubmarines; i++) {
      userShips.add(new Submarine());
      computerShips.add(new Submarine());
    }

    int numOfDestroyers = getConsolePrinter().getUserInputNumOfDestroyer(stream);
    for (int i = 0; i < numOfDestroyers; i++) {
      userShips.add(new Destroyer());
      computerShips.add(new Destroyer());
    }
    getShipController().setUserShips(userShips);
    getShipController().setComputerShips(computerShips);

  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public String toString() {
    return "DebugMode{} " + super.toString();
  }

  @Override
  public int hashCode() {
    return 13;
  }


}
