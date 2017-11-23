package objects;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardSpace extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private int id;
	private Boolean status;
	private Tile boardTile;
	private JLabel tileImage;
	
	public BoardSpace(String type, int id, Boolean status) {
		this.tileImage = new JLabel();
		this.type = type;
		this.id = id;
		this.status = status;
		this.boardTile = null;
	}
	
	public static int getID(BoardSpace space) {
		return space.id;
	}
	
	public static String getType(BoardSpace space) {
		return space.type;
	}
	
	public static boolean Taken(BoardSpace space) {
		return space.status;
	}
	
	public static Tile getTile(BoardSpace space) {
		return space.boardTile;
	}
	
	public static void setTile(BoardSpace space, Tile selectedTile) {
		space.boardTile = selectedTile;
	}
	
	public static JLabel getTileImage(BoardSpace space) {
		return space.tileImage;
	}
	
	public static void setTileImage(BoardSpace space, Tile selectedTile) {
		// Set label image
		space.tileImage.setIcon(Tile.getImg(selectedTile));
	}
	
	public static void setStatus(BoardSpace space, Boolean status) {
		space.status = status;
	}
}
