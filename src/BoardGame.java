import java.util.ArrayList;
import java.util.HashSet;
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
		GamePiece gamePiece1 = this.getPlayerGamePiece(playerNames[0]);
		GamePiece gamePiece2 = this.getPlayerGamePiece(playerNames[1]);
		
		GamePiece firstPiece = GamePiece.movesFirst(gamePiece1, gamePiece2);
		String temp = getPlayerWithGamePiece(firstPiece);
		if (temp.equals(playerNames[1])) {
			playerNames[1] = playerNames[0];
			playerNames[0] = temp;
		}
		this.movePlayer(playerNames[0], newLocations[0]);
		this.movePlayer(playerNames[1], newLocations[1]);
		
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
		Set<Location> result = new HashSet<Location>();
		for(String person : playerLocations.keySet()) {
			result.add(playerLocations.get(person));
		}
		return result;
	}
	
	public Set<GamePiece> getPlayerPieces() {
		Set<GamePiece> result = new HashSet<GamePiece>();
		for(String person : playerPieces.keySet()) {
			result.add(playerPieces.get(person));
		}
		return result;
	}
}
