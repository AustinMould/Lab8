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
		for(String person : playerPieces.keySet()) {
			if (gamePiece.equals(getPlayerGamePiece(person))) {
				return person;
			}
		}
		return null;
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
		ArrayList<String> peopleAtLoc = new ArrayList<String>();
		for(String person : playerLocations.keySet()) {
			if (loc.equals(getPlayersLocation(person))) {
				peopleAtLoc.add(person);
			}
		}
		return peopleAtLoc;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc) {
		ArrayList<GamePiece> piecesAtLoc = new ArrayList<GamePiece>();
		ArrayList<String> playersAtLoc = this.getPlayersAtLocation(loc);
		for(String person : playersAtLoc) {
			piecesAtLoc.add(this.getPlayerGamePiece(person));
		}
		return piecesAtLoc;
	}
	
	public Set<String> getPlayers() {
		return playerPieces.keySet();
	}
	
	public Set<Location> getPlayerLocations() {
		return (Set<Location>) playerLocations.values();
	}
	
	public Set<GamePiece> getPlayerPieces() {
		return (Set<GamePiece>) playerPieces.values();
	}
}
