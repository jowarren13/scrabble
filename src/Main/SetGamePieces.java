package Main;
import objects.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.ImageIcon;

public class SetGamePieces {
	
	static void createGameTiles(ArrayList<Tile> box) throws IOException {
		// Create array of tiles
		Tile letter;
		
		// Create tile counter for tile ID
		int tileCounter = 0;
		
		// Set 16 A's
		for (int i = 0; i < 16; i++) {
			letter = createTile("A", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}

	}

	
	static Tile createTile(String letter, int id, int points) throws IOException {
		String imgLoc = "/" + letter + ".png";
		int location = -1;
		ImageIcon icon = new ImageIcon(SetGamePieces.class.getResource(imgLoc));
		//ImageIcon img = ImageIO.read(SetGamePieces.class.getResource(imgLoc));
		Tile tile = new Tile(letter, id, location, icon, points);
		
		return tile;
	}
}
