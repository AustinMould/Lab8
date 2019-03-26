import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest {

	@Test
	public void ColorTest() {
		Color col1 = Color.CYAN;
		Color col2 = Color.RED;
		
		Assert.assertEquals("Incorrect G value", col1.getG(), 255);
		Assert.assertEquals("Incorrect B value", col1.getB(), 255);
		Assert.assertEquals("Incorrect R value", col1.getR(), 0);
		
		Assert.assertEquals("Incorrect R value", col2.getR(), 255);
	}
	
	@Test
	public void ShapeTest() {
		
	}
	@Test
	public void BoardGameConstructorTest() {
	BoardGame bestGame = new BoardGame();
	
	/**
	 * adds players to board game and tests all possible game pieces the majority of locations
	 */
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Micah", GamePiece.RED_RACER, Location.BALLROOM));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Brady", GamePiece.BLUE_RACER, Location.KITCHEN));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Kevin", GamePiece.RED_THIMBLE, Location.BILLIARD_ROOM));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Dalton", GamePiece.MAGENTA_RACER, Location.STUDY));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Joey", GamePiece.BLUE_BOOT, Location.CONSERVATORY));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Brooklyn", GamePiece.YELLOW_BOOT, Location.DINING_ROOM));
	Assert.assertEquals("Player not added, already in game", true, bestGame.addPlayer("Bronwyn", GamePiece.GREEN_BOOT, Location.LIBRARY));
	
	/**
	 * tests adding a player that is already in game
	 */
	Assert.assertEquals("Player added, not already in game", false, bestGame.addPlayer("Dalton", GamePiece.RED_RACER, Location.LOUNGE));
	Assert.assertEquals("Player added, not already in game", false, bestGame.addPlayer("Kevin", GamePiece.BLUE_BOOT, Location.HALL));
	
	}
	
	@Test
	public void getterTests() {
		BoardGame greatestGame = new BoardGame();
		greatestGame.addPlayer("Brady", GamePiece.BLUE_RACER, Location.LOUNGE);
		greatestGame.addPlayer("Dalton", GamePiece.BLUE_BOOT, Location.HALL);
		
		Assert.assertEquals("Player GamePiece incorrect", GamePiece.BLUE_RACER, greatestGame.getPlayerGamePiece("Brady"));
		Assert.assertEquals("Player GamePiece incorrect", GamePiece.BLUE_BOOT, greatestGame.getPlayerGamePiece("Dalton"));
		
		Assert.assertEquals("Player name incorrect", "Brady", greatestGame.getPlayerWithGamePiece(GamePiece.BLUE_RACER));
		Assert.assertEquals("Player name incorrect", "Dalton", greatestGame.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		
		Assert.assertEquals("Player name incorrect", Location.LOUNGE, greatestGame.getPlayersLocation("Brady"));
		Assert.assertEquals("Player name incorrect", Location.HALL, greatestGame.getPlayersLocation("Dalton"));
	}
	@Test
	public void LocationMovementTest() {
		BoardGame greatGame = new BoardGame();
		greatGame.addPlayer("Kevin", GamePiece.RED_THIMBLE, Location.BILLIARD_ROOM);
		greatGame.addPlayer("Micah", GamePiece.MAGENTA_RACER, Location.BILLIARD_ROOM);
		greatGame.addPlayer("Troy", GamePiece.YELLOW_BOOT, Location.BILLIARD_ROOM);
		
		ArrayList<String> poolSharks = greatGame.getPlayersAtLocation(Location.BILLIARD_ROOM);
		
		Assert.assertEquals("Player name incorrect", "Kevin", poolSharks.get(0));
		Assert.assertEquals("Player name incorrect", "Micah", poolSharks.get(1));
		Assert.assertEquals("Player name incorrect", "Troy", poolSharks.get(2));
		
		String[] poolBros = {"Troy", "Micah"};
		Location[] newLocs = {Location.KITCHEN, Location.CONSERVATORY};
		greatGame.movePlayer("Kevin", Location.KITCHEN);
		String[] playersAtNewLocs = greatGame.moveTwoPlayers(poolBros, newLocs);
		
		Assert.assertEquals("Wrong player name", poolBros[0], "Micah");
		Assert.assertEquals("Wrong player name", poolBros[1], "Troy");
		
		Assert.assertEquals("Wrong location" , greatGame.getPlayersLocation("Kevin"), Location.KITCHEN);
		Assert.assertEquals("Wrong location" , greatGame.getPlayersLocation("Troy"), Location.CONSERVATORY);
		Assert.assertEquals("Wrong location" , greatGame.getPlayersLocation("Kevin"), Location.KITCHEN);
	}
}
