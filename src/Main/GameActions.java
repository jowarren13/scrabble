package Main;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.BoardSpace;
import objects.Tile;

public class GameActions {

	// Add tile to player's box
	static void AddToPlayerBox(JPanel playerPanel, ArrayList<Tile> tiles, Tile newTile) {
		tiles.add(newTile);
		JLabel tileImage = new JLabel();
		tileImage.setIcon(Tile.getImg(tiles.get(tiles.size()-1)));
		playerPanel.add(tileImage);
		playerPanel.repaint();
		playerPanel.validate();
	}
	
	// Add tile to board
	static void AddTileToBoard(JPanel [][] gridPanels, ArrayList<Tile> boardTiles, BoardSpace[][]spaces, Tile newTile, int locx, int locy) {
		boardTiles.add(newTile);
		BoardSpace.setTile(spaces[locx][locy], newTile);
		BoardSpace.setTileImage(spaces[locx][locy], newTile);
		BoardSpace.setStatus(spaces[locx][locy], Info.TAKEN);
		gridPanels[locx][locy].add(BoardSpace.getTileImage(spaces[locx][locy]));
		gridPanels[locx][locy].repaint();
		gridPanels[locx][locy].validate();
	}

}
