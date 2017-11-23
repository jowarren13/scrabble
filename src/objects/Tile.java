package objects;

import javax.swing.ImageIcon;

public class Tile {
	private String letter;
	private int id;
	private int location;
	private ImageIcon img;
	private int points;
	
	public Tile (String letter, int id, int location, ImageIcon img, int points) {
		this.letter = letter;
		this.id = id;
		this.location = location;
		this.img = img;
		this.points = points;
	}
	
	
	public static String getLetter(Tile t) {
		return t.letter;
	}
	
	public static int getID(Tile t) {
		return t.id;
	}
	
	public static int getLocation(Tile t) {
		return t.location;
	}
	
	public static ImageIcon getImg(Tile t) {
		return t.img;
	}
	
	public static int getPoints(Tile t) {
		return t.points;
	}
	
}
