import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Set;

public class BoardGame {
	protected LinkedHashMap<String, GamePiece> playerPieces;
	
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		playerPieces = new LinkedHashMap<String, GamePiece>();
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer (String playerName, GamePiece gamePiece, Location initialLocation) {
		boolean isNewPlayer = !playerPieces.containsKey(playerName);;
		if(isNewPlayer) {
			playerPieces.putIfAbsent(playerName, gamePiece);
			playerLocations.putIfAbsent(playerName, initialLocation);
		}
		return isNewPlayer;
	}

	public GamePiece getPlayerGamePiece (String playerName) {
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece (GamePiece gamePiece) {
		
	}
	
	public void movePlayer (String playerName, Location newLocation) {
		playerLocations.replace(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers (String [] playerNames, Location[] newLocations) {
		GamePiece gamePiece1 = this.getPlayerGamePiece(playerNames[1]);
		GamePiece gamePiece2 = this.getPlayerGamePiece(playerNames[2]);
		
		GamePiece firstPiece = GamePiece.movesFirst(gamePiece1, gamePiece2);
		String temp = getPlayerWithGamePiece(firstPiece);
		if (temp.equals(playerNames[2])) {
			playerNames[2] = playerNames[1];
			playerNames[1] = temp;
		}
		this.movePlayer(playerNames[1], newLocations[1]);
		this.movePlayer(playerNames[2], newLocations[2]);
		
		return playerNames;
		
	}
	
	public Location getPlayersLocation (String player) {
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc) {
		
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc) {
		
	}
	
	public Set<String> getPlayers() {
		
	}
	
	public Set<Location> getPlayerLocations() {
		
	}
	
	public Set<GamePieces> getPlayerPieces() {
		
	}
}
