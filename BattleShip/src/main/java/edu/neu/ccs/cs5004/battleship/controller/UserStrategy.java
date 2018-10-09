package edu.neu.ccs.cs5004.battleship.controller;



import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.io.InputStream;


/**
 * Represents the user choice of not yet hit cell on the map.
 */
public class UserStrategy implements IStrategy {

  IConsolePrinter printer;
  InputStream stream;

  /**
   * Create an instance of user strategy.
   *
   * @param printer a console printer to get user input
   * @param stream  an input stream to get user input.
   */
  public UserStrategy(IConsolePrinter printer, InputStream stream) {
    this.printer = printer;
    this.stream = stream;
  }

  /**
   * Create an instance of user strategy.
   */
  public UserStrategy() {
    this.printer = IConsolePrinter.createGameView();
    this.stream = System.in;
  }

  /**
   * Return a position on the map to be attacked.
   *
   * @param map represents the battle map.
   * @return a position on the map to be attacked.
   */
  @Override
  public Position chooseCellToAttack(IMap map) {

    Position posn;
    do {
      posn = printer.getUserInputPosition(stream);
    } while (map.getCell(posn).getIsHit());
    return posn;
  }

}


