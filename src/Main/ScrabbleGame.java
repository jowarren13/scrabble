package Main;
import java.io.IOException;
import java.util.ArrayList;

import objects.*;

public class ScrabbleGame {
	
	public static void main(String [] args) throws IOException {
		
		// Build the frame and launch the game
		Console frame = new Console();
		
		// Create tileBox -- Start with 100 tiles
		ArrayList<Tile> TileBox = new ArrayList<Tile>();
		SetGamePieces.createGameTiles(TileBox);
		
		// Create new player and add tiles
		Player p1 = new Player(Info.HUMAN, true);
		Player.setPlayerTiles(frame, p1, TileBox);
		//ArrayList<Tile> playerTiles = new ArrayList<Tile>();
		//GameActions.AddToPlayerBox(frame.getSouth(frame), frame.getPlayerBox(frame), playerTiles, TileBox.remove(0));
		//GameActions.AddToPlayerBox(frame.getSouth(frame), frame.getPlayerBox(frame), playerTiles, TileBox.remove(1));

		
		// Test adding tiles to board
		ArrayList<Tile> boardTiles = new ArrayList<Tile>();
		GameActions.AddTileToBoard(frame.getBoardSpaces(frame), boardTiles, TileBox.remove(1), 3, 7);
		
	}

}
