package edu.neu.ccs.cs5004.battleship.view;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidArgumentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Represents the debug view.
 */
public class DebugView extends ConsolePrinter {


  /**
   * Get number of battleships from user input.
   *
   * @return number of battleships provided by user
   */
  @Override
  public int getUserInputNumOfBattleShips(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    int temp = 0;
    while (true) {
      try {
        System.out.println("Please input the number of battleships(0/1): ");
        String input = bufferedReader.readLine();
        System.out.println("input:" + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect a number from 0 to 1: ");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect a number from 0 to 1: ");
        }
        try {
          int num = Integer.parseInt(input);
          if (num < 0 || num > 1) {
            throw new InvalidArgumentException("invalid input, expect a number from 0 to 1, "
                + "given: " + input);
          } else {
            temp = num;
            break;
          }
        } catch (NumberFormatException exc) {
          throw new InvalidArgumentException("expect a number from 0 to 1 given: " + input);
        }
      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage());

      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }
    /*if (bufferedReader != null) {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }*/
    return temp;
  }

  /**
   * Get number of Cruiser from user input.
   *
   * @return number of Cruisers provided by user
   */
  @Override
  public int getUserInputNumOfCruisers(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    int temp = 0;
    while (true) {
      try {
        System.out.println("Please input the number of cruisers(0/2): ");
        String input = bufferedReader.readLine();
        System.out.println("input:" + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect a number from 0 to 2: ");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect a number from 0 to 2: ");
        }
        try {
          int num = Integer.parseInt(input);
          if (num < 0 || num > 2) {
            throw new InvalidArgumentException("invalid input, expect a number from 0 to 2, "
                + "given: " + input);
          } else {
            temp = num;
            break;
          }
        } catch (NumberFormatException exc) {
          throw new InvalidArgumentException("expect a number from 0 to 2 given: " + input);
        }
      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage());

      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
  }


  /**
   * Get number of Submarine from user input.
   *
   * @return number of submarine provided by user
   */
  @Override
  public int getUserInputNumOfSubmarine(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    int temp = 0;
    while (true) {
      try {
        System.out.println("Please input the number of submarine(0/3): ");
        String input = bufferedReader.readLine();
        System.out.println("input:" + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect a number from 0 to 3: ");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect a number from 0 to 3: ");
        }
        try {
          int num = Integer.parseInt(input);
          if (num < 0 || num > 3) {
            throw new InvalidArgumentException("invalid input, expect a number from 0 to 3, "
                + "given: " + input);
          } else {
            temp = num;
            break;
          }
        } catch (NumberFormatException exc) {
          throw new InvalidArgumentException("expect a number from 0 to 3 given: " + input);
        }
      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage());

      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
  }


  /**
   * Get number of Destroyer from user input.
   *
   * @return number of destroyer provided by user
   */
  @Override
  public int getUserInputNumOfDestroyer(InputStream stream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream,
        StandardCharsets.UTF_8));
    int temp = 0;
    while (true) {
      try {
        System.out.println("Please input the number of destroyers(0/4): ");
        String input = bufferedReader.readLine();
        System.out.println("input:" + input);
        if (input == null || input.length() < 1) {
          throw new InvalidArgumentException("not enough input, expect a number from 0 to 4: ");
        }
        if (input.length() > 1) {
          throw new InvalidArgumentException("too much input, expect a number from 0 to 4: ");
        }
        try {
          int num = Integer.parseInt(input);
          if (num < 0 || num > 4) {
            throw new InvalidArgumentException("invalid input, expect a number from 0 to 4, "
                + "given: " + input);
          } else {
            temp = num;
            break;
          }
        } catch (NumberFormatException exc) {
          throw new InvalidArgumentException("expect a number from 0 to 4 given: " + input);
        }
      } catch (InvalidArgumentException exc) {
        System.out.println(exc.getMessage());

      } catch (IOException e) {
        e.printStackTrace();
        Runtime.getRuntime().exit(-1);
      }
    }

    return temp;
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
    System.out.println("\n  Current user fleet map:\n");
    toConsole(userFleetMap);
    System.out.println("\n  Current user battle map:\n");
    toConsole(userBattleMap);
    System.out.println("\n Current computer fleet map:\n");
    toConsole(computerFleetMap);
    System.out.println("\n Current computer battle map:\n");
    toConsole(computerBattleMap);
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }


  @Override
  public int hashCode() {
    return 23;
  }

  @Override
  public String toString() {
    return "DebugView{} " + super.toString();
  }
}
