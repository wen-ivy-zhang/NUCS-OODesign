package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.GapCell;
import edu.neu.ccs.cs5004.battleship.model.Hit;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Map;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.Submarine;
import edu.neu.ccs.cs5004.battleship.model.Sunk;
import edu.neu.ccs.cs5004.battleship.view.DebugView;



public class MapControllerTest {

  private MapController mapController;
  private MapController sameRefMapController;
  private MapController sameStateMapController;
  private MapController yetAnotherMapController;
  private ShipController shipController;
  private MapController nullMapController;
  private IMap userFleetMap;
  private IMap userBattleMap;
  private IMap computerFleetMap;
  private IMap computerBattleMap;
  private MapController mapController2;



  @Before
  public void setUp() throws Exception {
    mapController = new MapController();
    sameRefMapController = mapController;
    sameStateMapController = new MapController();
    yetAnotherMapController= new MapController();
    shipController = new ShipController();
    nullMapController= null;
    userFleetMap = IMap.createEmptyMap();
    userFleetMap.setCell(new Position(3,5),new GapCell(true));
    userBattleMap = IMap.createEmptyMap();
    userBattleMap.setCell(new Position(7,5),new EnemyShipCell(true, true));
    computerFleetMap = IMap.createEmptyMap();
    computerFleetMap.setCell(new Position(1,2),new GapCell(true));
    computerBattleMap = IMap.createEmptyMap();
    computerBattleMap.setCell(new Position(2,2),new EnemyShipCell(true,false));
    mapController2 = new MapController(this.userFleetMap,this.userBattleMap,this.computerFleetMap,this.computerBattleMap);

  }

  @Test
  public void getUserFleetMap() {
    Assert.assertEquals(new Map(), mapController.getUserFleetMap());
  }

  @Test
  public void getComputerFleetMap() {
    Assert.assertEquals(new Map(), mapController.getComputerFleetMap());
  }

  @Test
  public void getUserBattleMap() {
    Assert.assertEquals(new Map(), mapController.getUserBattleMap());
  }

  @Test
  public void getComputerBattleMap() {
    Assert.assertEquals(new Map(), mapController.getComputerBattleMap());
  }

  @Test
  public void registerObserver() {
    DebugView debugView = new DebugView();
    mapController.registerObserver(debugView);
  }

  @Test
  public void notifyObservers() {
    DebugView debugView = new DebugView();
    mapController.registerObserver(debugView);
    mapController.getUserFleetMap().placeShipOnMap(new Position("B 2"), Direction.HORIZONTAL,
        new Submarine());
    mapController.notifyObservers();
  }


  @Test
  public void updateFleetMapAfterAttack() {
    this.mapController.updateFleetMapAfterAttack(new Position(3,5), new Hit(),this.mapController.getUserFleetMap());
    this.mapController.updateFleetMapAfterAttack(new Position(1,7),new Sunk(),this.mapController.getComputerFleetMap());

  }

  @Test
  public void updateBattleMapAfterAttack() {
    this.mapController.updateBattleMapAfterAttack(new Position(2,2),new Hit(), this.mapController.getComputerBattleMap());
    this.mapController.updateBattleMapAfterAttack(new Position(1,5),new Sunk(),this.mapController.getUserBattleMap());
  }

  @Test
  public void equals() {
    Assert.assertTrue(this.mapController.equals(sameRefMapController));
    Assert.assertTrue(this.mapController.equals(sameStateMapController));
    Assert.assertEquals(this.mapController.equals(sameStateMapController)&&sameStateMapController.equals(yetAnotherMapController),
        yetAnotherMapController.equals(mapController));
    Assert.assertFalse(this.mapController.equals(shipController));
    Assert.assertFalse(this.mapController.equals(nullMapController));
    Assert.assertFalse(this.mapController.equals(mapController2));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(this.mapController.hashCode() == this.sameRefMapController.hashCode());
    Assert.assertTrue(this.mapController.hashCode() == this.sameStateMapController.hashCode());
  }


}