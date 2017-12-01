package Main;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.BoardSpace;
import objects.Tile;

public class GameActions {
	//private boolean dragging = false;

	// Add tile to player's box
	public static void AddToPlayerBox(JPanel southPanel, JPanel playerPanel, ArrayList<Tile> playerTiles, Tile newTile) {
		playerTiles.add(newTile);
		JLabel tileImage = new JLabel();
		tileImage.setIcon(Tile.getImg(playerTiles.get(playerTiles.size()-1)));
		playerPanel.add(tileImage);
		playerPanel.repaint();
		playerPanel.validate();
		southPanel.repaint();
		southPanel.validate();
	}
	
	// Add tile to board
	static void AddTileToBoard(BoardSpace [][] spaces, ArrayList<Tile> boardTiles, Tile newTile, int locx, int locy) {
		// Create label to add to board space panel
		JLabel tileImage = new JLabel();
		tileImage.setIcon(Tile.getImg(newTile));
		
		// Add label to boardSpace
		spaces[locx][locy].add(tileImage);
		
		// Add tile to boardTiles array
		boardTiles.add(newTile);
		
		// Set the board space tile and status
		BoardSpace.setTile(spaces[locx][locy], newTile);
		//BoardSpace.setTileImage(spaces[locx][locy], newTile);
		BoardSpace.setStatus(spaces[locx][locy], Info.TAKEN);
		//spaces[locx][locy].add(BoardSpace.getTileImage(spaces[locx][locy]));
		spaces[locx][locy].repaint();
		spaces[locx][locy].validate();
	}

}
