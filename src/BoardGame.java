import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame {
	protected LinkedHashMap<String, GamePiece> playerPieces;
	
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		
	}
	
	public boolean addPlayer (String playerName, GamePiece gamePiece, Location initialLocation) {
		
	}

	public GamePiece getPlayerGamePiece (String playerName) {
		
	}
	
	public String getPlayerWithGamePiece (GamePiece gamePiece) {
		
	}
	
	public void movePlayer (String playerName, Location newLocation) {
		
	}
	
	public String[] moveTwoPlayers (String [] playerNames, Location[] newLocations) {
		
	}
	
	public Location getPlayersLocation (String player) {
		
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
