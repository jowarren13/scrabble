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
		
		// Set 2 BLANK tiles
		for (int i = 0; i < 2; i++) {
			letter = createTile("BLANK", tileCounter, 0);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 16 A's
		for (int i = 0; i < 16; i++) {
			letter = createTile("A", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 B's
		for (int i = 0; i < 2; i++) {
			letter = createTile("B", tileCounter, 3);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 C's
		for (int i = 0; i < 2; i++) {
			letter = createTile("C", tileCounter, 3);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 4 D's
		for (int i = 0; i < 4; i++) {
			letter = createTile("D", tileCounter, 2);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 12 E's
		for (int i = 0; i < 12; i++) {
			letter = createTile("E", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 F's
		for (int i = 0; i < 2; i++) {
			letter = createTile("F", tileCounter, 4);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 3 G's
		for (int i = 0; i < 3; i++) {
			letter = createTile("G", tileCounter, 2);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 H's
		for (int i = 0; i < 2; i++) {
			letter = createTile("H", tileCounter, 4);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 9 I's
		for (int i = 0; i < 9; i++) {
			letter = createTile("I", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 1 J
		for (int i = 0; i < 1; i++) {
			letter = createTile("J", tileCounter, 8);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 1 K
		for (int i = 0; i < 1; i++) {
			letter = createTile("K", tileCounter, 5);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 4 L's
		for (int i = 0; i < 4; i++) {
			letter = createTile("L", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 M's
		for (int i = 0; i < 2; i++) {
			letter = createTile("M", tileCounter, 3);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 6 N's
		for (int i = 0; i < 6; i++) {
			letter = createTile("N", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 8 O's
		for (int i = 0; i < 8; i++) {
			letter = createTile("O", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 P's
		for (int i = 0; i < 2; i++) {
			letter = createTile("P", tileCounter, 3);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 1 Q
		for (int i = 0; i < 1; i++) {
			letter = createTile("Q", tileCounter, 10);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 6 R's
		for (int i = 0; i < 6; i++) {
			letter = createTile("R", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 4 S's
		for (int i = 0; i < 4; i++) {
			letter = createTile("S", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 6 T's
		for (int i = 0; i < 6; i++) {
			letter = createTile("T", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 4 U's
		for (int i = 0; i < 4; i++) {
			letter = createTile("U", tileCounter, 1);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 V's
		for (int i = 0; i < 2; i++) {
			letter = createTile("V", tileCounter, 4);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 W's
		for (int i = 0; i < 2; i++) {
			letter = createTile("W", tileCounter, 4);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 1 X
		for (int i = 0; i < 1; i++) {
			letter = createTile("X", tileCounter, 8);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 2 Y's
		for (int i = 0; i < 2; i++) {
			letter = createTile("Y", tileCounter, 4);
			box.add(letter);

			tileCounter++;
		}
		
		// Set 1 Z
		for (int i = 0; i < 1; i++) {
			letter = createTile("Z", tileCounter, 10);
			box.add(letter);

			tileCounter++;
		}

	}

	
	static Tile createTile(String letter, int id, int points) throws IOException {
		String imgLoc = "/" + letter + ".png";
		int location = -1;
		ImageIcon letterImg = new ImageIcon(SetGamePieces.class.getResource(imgLoc));
		Tile tile = new Tile(letter, id, location, letterImg, points);
		tile.setIcon(letterImg);
		
		// Add mouse listener
		/*
		tile.addMouseListener(new MouseInput(tile));
		tile.addMouseMotionListener(new MouseInput(tile)); */
		return tile;
	}
}
