package edu.neu.ccs.cs5004.battleship.view;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidCallException;

import java.io.InputStream;

/**
 * Represents the game view.
 */
public class GameView extends ConsolePrinter{


  /**
   * Get number of battleships from user input.
   *
   * @return number of battleships provided by user
   */
  @Override
  public int getUserInputNumOfBattleShips(InputStream stream) {
    throw new InvalidCallException("Don't support user input for number of "
        + "BattleShips in game mode.");
  }

  /**
   * Get number of Cruiser from user input.
   *
   * @return number of Cruisers provided by user
   */
  @Override
  public int getUserInputNumOfCruisers(InputStream stream) {
    throw new InvalidCallException("Don't support user input for number of "
        + "Cruisers in game mode.");
  }

  /**
   * Get number of Submarine from user input.
   *
   * @return number of submarine provided by user
   */
  @Override
  public int getUserInputNumOfSubmarine(InputStream stream) {
    throw new InvalidCallException("Don't support user input for number of "
        + "Submarine in game mode.");
  }

  /**
   * Get number of Destroyer from user input.
   *
   * @return number of destroyer provided by user
   */
  @Override
  public int getUserInputNumOfDestroyer(InputStream stream) {
    throw new InvalidCallException("Don't support user input for number of "
        + "Destroyer in game mode.");
  }


  /**
   * Update the map for map observer.
   *
   * @param userFleetMap      represent user's fleet map.
   * @param computerFleetMap  represent computer's fleet map.
   * @param userBattleMap     represent user's battle map.
   * @param computerBattleMap represent computer's battle map.
   */
  @Override
  public void update(IMap userFleetMap, IMap computerFleetMap, IMap userBattleMap,
                     IMap computerBattleMap) {
    System.out.println("\n\n Current user fleet map:\n");
    toConsole(userFleetMap);
    System.out.println("\n\n Current user battle map:\n");
    toConsole(userBattleMap);
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return 29;
  }

  @Override
  public String toString() {
    return "GameView{} " + super.toString();
  }

}
