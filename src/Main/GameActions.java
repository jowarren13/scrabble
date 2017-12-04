package Main;

import java.util.ArrayList;

import objects.BoardSpace;
import objects.Tile;

public class GameActions {

	public static void AddToPlayerBox(Main.Console frame, BoardSpace[][] playerSpaces, ArrayList<Tile> playerTiles, Tile newTile) {
		// Add tile to player tiles array
		playerTiles.add(newTile);
		
		// Determine which space to put tile
		int Location = playerTiles.lastIndexOf(newTile);

		// Add tile to player space & change status
		BoardSpace.setTile(playerSpaces[0][Location], newTile);

		// Repaint the space
		playerSpaces[0][Location].repaint();
		playerSpaces[0][Location].validate();

	}
	
	// Add tile to board
	static void AddTileToBoard(BoardSpace [][] spaces, ArrayList<Tile> boardTiles, Tile newTile, int locx, int locy) {
		// Set board space tile
		BoardSpace.setTile(spaces[locx][locy], newTile);
		
		// Add tile to boardTiles array
		boardTiles.add(newTile);

		// Repaint the board space
		spaces[locx][locy].repaint();
		spaces[locx][locy].validate();
	}

}
