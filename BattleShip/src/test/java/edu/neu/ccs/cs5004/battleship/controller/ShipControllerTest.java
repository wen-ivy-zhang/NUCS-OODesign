package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.battleship.model.BattleShip;
import edu.neu.ccs.cs5004.battleship.model.Cruiser;
import edu.neu.ccs.cs5004.battleship.model.Destroyer;
import edu.neu.ccs.cs5004.battleship.model.Ship;
import edu.neu.ccs.cs5004.battleship.model.Submarine;

import java.util.ArrayList;
import java.util.List;

public class ShipControllerTest {
  private ShipController shipController;
  private ShipController sameRefShipController;
  private ShipController sameStateShipController;
  private ShipController yetAnotherShipController;
  private ShipController diffShipController;
  private ShipController nullShipController;
  private ShipController shipController1;
  private ShipController shipController2;
  private ShipController shipController3;
  private MapController mapController;


  @Before
  public void setUp() throws Exception {
    shipController = new ShipController();
    sameRefShipController = shipController;
    sameStateShipController = new ShipController();
    yetAnotherShipController = new ShipController();
    diffShipController = new ShipController(3,2,3,4);
    shipController1 = new ShipController(2,2,7,8);
    shipController2 = new ShipController(1,2,3,5);
    shipController3 = new ShipController(1,9,3,4);
    mapController = new MapController();
    nullShipController = null;
  }

  @Test
  public void getShips() {
    List<Ship> ships = new ArrayList<>();
    for (int i = 0; i < 1; i++) {
      ships.add(new BattleShip());
    }
    for (int i = 0; i < 2; i++) {
      ships.add(new Cruiser());
    }
    for (int i = 0; i < 3; i++) {
      ships.add(new Submarine());
    }
    for (int i = 0; i < 4; i++) {
      ships.add(new Destroyer());
    }
    Assert.assertEquals(ships, shipController.getUserShips());
    Assert.assertEquals(ships, shipController.getComputerShips());
  }

  @Test
  public void setShips() {
    List<Ship> list = new ArrayList<>();
    list.add(new BattleShip());
    list.add(new Cruiser());
    list.add(new Submarine());
    list.add(new Destroyer());
    shipController.setUserShips(list);
    shipController.setComputerShips(list);
    Assert.assertEquals(list, shipController.getUserShips());
    Assert.assertEquals(list, shipController.getComputerShips());
  }

  @Test
  public void equals() {
    Assert.assertTrue(this.shipController.equals(sameRefShipController));
    Assert.assertTrue(this.shipController.equals(sameStateShipController));
    Assert.assertTrue(this.sameStateShipController.equals(shipController));
    Assert.assertEquals(this.shipController.equals(sameStateShipController)
        &&sameStateShipController.equals(yetAnotherShipController),
        yetAnotherShipController.equals(shipController));
    Assert.assertFalse(this.shipController.equals(diffShipController));
    Assert.assertFalse(this.shipController.equals(shipController1));
    Assert.assertFalse(this.shipController.equals(shipController2));
    Assert.assertFalse(this.shipController.equals(shipController3));
    Assert.assertFalse(this.shipController.equals(mapController));
    Assert.assertFalse(this.shipController.equals(nullShipController));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(this.shipController.hashCode()==this.sameStateShipController.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(this.shipController.toString(),"ShipController{userShips=[BattleShip{} " +
        "AbstractShip{size=4, numOfHitCells=0}, " +
        "Cruiser{} AbstractShip{size=3, numOfHitCells=0}, " +
        "Cruiser{} AbstractShip{size=3, numOfHitCells=0}, " +
        "Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}], " +
        "computerShips=[BattleShip{} AbstractShip{size=4, " +
        "numOfHitCells=0}, Cruiser{} AbstractShip{size=3, " +
        "numOfHitCells=0}, Cruiser{} AbstractShip{size=3, " +
        "numOfHitCells=0}, Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Submarine{} AbstractShip{size=2, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}," +
        " Destroyer{} AbstractShip{size=1, numOfHitCells=0}, " +
        "Destroyer{} AbstractShip{size=1, numOfHitCells=0}]}");
  }

  @Test
  public void allShipSunk() {
    List<Ship> ships = new ArrayList<>();
    List<Ship> allSunkShips = new ArrayList<>();
    allSunkShips.add(new Cruiser(3, 3));
    allSunkShips.add(new Destroyer(1,1));
    ships.add(new Destroyer(1,1));
    ships.add(new Destroyer(1,0));
    Assert.assertFalse(shipController.allShipSunk(ships));
    Assert.assertTrue(shipController.allShipSunk(allSunkShips));

  }
}