package Main;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import objects.*;

public class ScrabbleGame {
	
	public static void main(String [] args) throws IOException {
		// Create game pieces
		Board gameBoard = new Board();
		//TileBox gameTiles = new TileBox();
		
		// Build the frame and launch the game
		Console frame = new Console();
		//Console.launchGame(frame, frame.getSplash(frame), frame.getStart(frame));	
		
		
		// Setup the board spaces -- Spaces range from 0 - 224
		gameBoard.set();
		
		// Create tileBox -- Start with 100 tiles
		ArrayList<Tile> TileBox = new ArrayList<Tile>();
		SetGamePieces.createGameTiles(TileBox);
		
		// Add tiles to player box  -- Max 7 tiles
		ArrayList<Tile> playerTiles = new ArrayList<Tile>();
		GameActions.AddToPlayerBox(frame.getPlayerBox(frame), playerTiles, TileBox.remove(0));

		
		// Test adding tiles to board
		ArrayList<Tile> boardTiles = new ArrayList<Tile>();
		GameActions.AddTileToBoard(frame.getGridLocations(frame), boardTiles, gameBoard.getBoardSpaces(gameBoard), TileBox.remove(1), 6, 10);
		//boardTiles.add(TileBox.remove(1));
		
		
		
		// Place tile on screen
		//Console.showTile(get)
		
	}

}
