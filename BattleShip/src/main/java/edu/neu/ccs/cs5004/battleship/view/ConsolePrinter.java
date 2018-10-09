package edu.neu.ccs.cs5004.battleship.view;


import edu.neu.ccs.cs5004.battleship.controller.GameResult;
import edu.neu.ccs.cs5004.battleship.controller.GameType;
import edu.neu.ccs.cs5004.battleship.controller.PlacementType;
import edu.neu.ccs.cs5004.battleship.model.AttackResult;
import edu.neu.ccs.cs5004.battleship.model.Cell;
import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.Hit;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidArgumentException;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.SpecificShipCell;
import edu.neu.ccs.cs5004.battleship.model.Sunk;
import edu.neu.ccs.cs5004.battleship.model.WaterCell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Represents a printer which could print to the console.
 */
public abstract class ConsolePrinter implements IConsolePrinter {

  protected StringBuilder view;
  static final String HIT = "  X";
  static final String SUNK = "  .";
  static final String LIVE = "  O";
  static final String WATER = "   ";
  static final String ATTACK_WATER = "  ~";


  /**
   * Print{@code SpecificShipCell} to the console.
   *
   * @param specificShipCell represents the specific ship cell to be printed to the console.
   */

  public void toConsole(SpecificShipCell specificShipCell) {
    //System.out.println("checkpoint 3 ");
    if (specificShipCell.getIsHit() && (!specificShipCell.getIsSunk())) {
      view.append(HIT);
    } else if (specificShipCell.getIsSunk()) {
      view.append(SUNK);
    } else {
      //System.out.println("checkpoint 10 ");
      view.append(LIVE);
    }
  }


  /**
   * Print{@code EnemyShipCell} to the console.
   *
   * @param enemyShipCell represents the enemy ship cell to be printed to the console.
   */

  public void toConsole(EnemyShipCell enemyShipCell) {
    if (enemyShipCell.getIsHit() && (!enemyShipCell.getIsSunk())) {
      view.append(HIT);
    } else if (enemyShipCell.getIsSunk()) {
      view.append(SUNK);
    }
  }



  /**
   * Print{@code AbstractWaterCell} to the console.
   *
   * @param waterCell represents the WATER cell to be printed to the console.
   */

  public void toConsole(WaterCell waterCell) {
    if (waterCell.getIsHit()) {
      view.append(ATTACK_WATER);
    } else {
      view.append(WATER);
    }
  }


  /**
   * Print {@code map} to the console.
   *
   * @param map represent the map to be printed to the console.
   */
  public void toConsole(IMap map) {
    Cell[][] cells = map.getCells();
    printColumnIndex(cells[0].length);//print column index
    for (int i = 0; i < cells.length; ++i) {
      System.out.format("%3d", i + 1);//print row index
      view = new StringBuilder(cells[0].length);
      for (int j = 0; j < cells[0].length; ++j) {
        cells[i][j].prettyPrint(this);
      }
      System.out.print(view);
      System.out.println();
    }
  }

  /**
   * Print the column index according to the given number of columns.
   *
   * @param numOfColumns the number of columns
   */
  protected void printColumnIndex(int numOfColumns) {
    System.out.format("%3c", ' ');
    for (Character column = 'A'; column < 'A' + numOfColumns; column++) {
      System.out.format("%3c", column);
    }
    System.out.println();
  }


  /**
   * Get game mode from user input.
   *
   * @return game mode provided by user
   */
  public GameType getUserInputGameMode(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    GameType temp = null;
    while (true) {
      try {
        System.out.println("Please choose the mode for your game: DeBug(D)/GameMode(G): ");
        String input = bufferedReader.readLine();
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect 'D' or 'G'");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect 'D' or 'G'");
        }
        if (Character.toUpperCase(input.charAt(0)) != 'D'
            && Character.toUpperCase(input.charAt(0)) != 'G') {
          throw new InvalidArgumentException("expect letter 'D' or letter 'G'" + "given: " + input);
        } else {
          if (Character.toUpperCase(input.charAt(0)) == 'D') {
            temp = GameType.DEBUG_MODE;
            System.out.println("\nEntering debug mode.\n");
            break;
          } else {
            temp = GameType.GAME_MODE;
            System.out.println("\nEntering real game mode.\n");
            break;
          }
        }
      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage());

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return temp;

//    BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(stream));
//    try {
//      String input = bufferedReader.readLine();
//      if (input == "D") {
//        return GameType.DEBUG_MODE;
//      } else {
//        throw new InvalidArgumentException("Expected D or G");
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return GameType.GAME_MODE;
  }

  /**
   * Get position from user input.
   *
   * @return position provided by user
   */
  @Override
  public Position getUserInputPosition(InputStream stream) {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    Position temp = null;

    while (true) {
      try {
        System.out.println("Please enter a position (column A-J, row: 1-10): ");
        String input = bufferedReader.readLine();
        if (input == null) {
          throw new InvalidArgumentException("no input");
        }
        temp = new Position(input); //save the input into a temp position and parse it
        System.out.println("input: " + input);
        break;
      } catch (InvalidArgumentException e1) {
        System.out.println(e1.getMessage() + "\n");
      } catch (IOException e2) {
        e2.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
  }

  /**
   * Get direction from user input.
   *
   * @return direction provided by user
   */
  @Override
  public Direction getUserInputDirection(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    Direction temp = null;

    while (true) {
      try {

        System.out.println("Please enter the direction for the ship: Horizontal(H) "
            + "or Vertical(V):");
        String input = bufferedReader.readLine();
        System.out.println("your input is: " + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect 'H' or 'V'");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect 'H' or 'V'");
        }
        if (Character.toUpperCase(input.charAt(0)) != 'H'
            && Character.toUpperCase(input.charAt(0)) != 'V') {
          throw new InvalidArgumentException("expect letter 'H' or letter 'V'" + "given" + input);
        } else {
          if (Character.toUpperCase(input.charAt(0)) == 'H') {
            temp = Direction.HORIZONTAL;
            break;
          } else {
            temp = Direction.VERTICAL;
            break;
          }
        }

      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
  }


  /**
   * Get the method for ship placement from user, either random or user placement.
   *
   * @return method for ship placement
   */
  @Override
  public PlacementType getUserInputPlacement(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    PlacementType temp = null;

    while (true) {
      try {

        System.out.println("Please enter the placement type for the ship: Random Placement (R) "
            + "or UserPlacement(U): ");
        String input = bufferedReader.readLine();
        System.out.println("your input is: " + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect 'R' or 'U'");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect 'R' or 'U'");
        }
        if (Character.toUpperCase(input.charAt(0)) != 'R'
            && Character.toUpperCase(input.charAt(0)) != 'U') {
          throw new InvalidArgumentException("expect letter 'R' or letter 'U'" + "given: " + input);
        } else {
          if (Character.toUpperCase(input.charAt(0)) == 'R') {
            temp = PlacementType.RANDOM_PLACEMENT;
            break;
          } else {
            temp = PlacementType.USER_PLACEMENT;
            break;
          }
        }

      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
  }

  /**
   * Print the error message to the console.
   * @param prompt represents the promt message.
   */
  @Override

  public void displayErrorMessage(String prompt) {

    System.out.println(prompt);

  }

  /**
   * Print the start game view.
   */
  public void printGreeting() {

    System.out.println("\nWelcome to the battleship game!\n");

  }


  /**
   * Print computer ship placement message.
   */
  public void startComputerShipPlacement() {
    System.out.println("\nStart placing ships on computer fleet map.\n");
  }

  /**
   * Print user ship placement message.
   */
  public void startUserShipPlacement() {
    System.out.println("\nStart placing ships on user fleet map.\n");
  }

  /**
   * Print computer ship placement message.
   */
  public void completeComputerShipPlacement() {
    System.out.println("\nComplete placing ships on computer fleet map.\n");
  }

  /**
   * Print user ship placement message.
   */
  public void completeUserShipPlacement() {
    System.out.println("\nComplete placing ships on user fleet map.\n");
  }

  /**
   * Print start game message to the console.
   */
  @Override
  public void startGameView() {
    System.out.println("\nStart playing battleship game now.\n");
  }

  /**
   * Print user attack message to the console.
   */
  @Override
  public void userAttackView() {
    System.out.println("\nIt's time for user to attack.\n");
  }

  /**
   * Print computer attack message to the console.
   */
  @Override
  public void computerAttackView() {
    System.out.println("\nIt's time for computer to attack\n");
  }

  /**
   * Print the position being attacked to the console.
   * @param posn represents the given position.
   */
  @Override
  public void displayAttackedPosition(Position posn) {
    System.out.println(posn + " is attacked.");
  }

  /**
   * Print attack result to the console.
   *
   * @param attackResult the attack result.
   */
  @Override
  public void displayAttackResult(AttackResult attackResult) {
    if (attackResult instanceof Sunk) {
      System.out.println("\nThe ship is SUNK!\n");
    } else if (attackResult instanceof Hit) {
      System.out.println("\nHit a ship!\n");
    } else {
      System.out.println("\nMissed!\n");
    }
  }

  /**
   * Print the game result to the console.
   *
   * @param gameResult represents the result of the battleship game.
   */
  @Override
  public void endGameView(GameResult gameResult) {
    if (gameResult == GameResult.USER_WIN) {
      System.out.println("\nCongratulations! You win the battleship game!\n");
    } else {
      System.out.println("\nYou lose! Computer win the battleship game!\n");
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
    ConsolePrinter that = (ConsolePrinter) object;
    return Objects.equals(view, that.view);
  }

  @Override
  public int hashCode() {

    return Objects.hash(view);
  }

  @Override
  public String toString() {
    return "ConsolePrinter{"
        + "view=" + view
        + '}';
  }
}
