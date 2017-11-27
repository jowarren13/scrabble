package objects;
import java.util.ArrayList;
import java.util.Random;

import Main.GameActions;


public class Player {
	
	private String type;
	private boolean isTurn;
	private ArrayList<Tile> playerTiles;
	private static Random rand = new Random();
	
	public Player (String type, boolean isTurn) {
		this.type = type;
		this.isTurn = isTurn;
		playerTiles = new ArrayList<Tile>();
	}
	
	public static void setPlayerTiles (Main.Console frame, Player player, ArrayList<Tile> TileBox) {
		try {
			int randomTile;
			Tile selectedTile;
			while (player.playerTiles.size() < 7 || player.playerTiles == null ) { 
				randomTile = rand.nextInt(TileBox.size());
				selectedTile = TileBox.remove(randomTile);
				GameActions.AddToPlayerBox(frame.getSouth(frame), frame.getPlayerBox(frame), player.playerTiles, selectedTile);
			}
		} catch (Exception EmptyTileBox) {
			System.out.println("The TileBox is empty.");
		}
	
	}
	
	public static ArrayList<Tile> getPlayerTiles (Player player) {
		return player.playerTiles;
	}
	
	public static boolean getTurn(Player player) {
		return player.isTurn;
	}
	
	public static void setTurnFalse(Player player) {
		player.isTurn = false;
	}
	
	public static void setTurnTrue(Player player) {
		player.isTurn = true;
	}
	
	public static String getType(Player player) {
		return player.type;
	}
}
