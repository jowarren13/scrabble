package objects;

import java.awt.Point;

import javax.swing.JPanel;

import Main.Info;

public class BoardSpace extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private int id;
	private Boolean status;
	private Tile boardTile;
	private Point loc;
	
	public BoardSpace(String type, int id, Boolean status, int locx, int locy) {
		this.type = type;
		this.id = id;
		this.status = status;
		this.boardTile = null;
		this.loc = new Point();
		this.loc.setLocation(locx, locy);
	}
	
	public static BoardSpace [][] setBoardSpaces(BoardSpace [][] spaces) {
		// Set star
		spaces[7][7] = new BoardSpace(Info.STAR, 97, !Info.TAKEN, 7, 7);
		
		// Set Double letter spaces
		spaces[0][3] = new BoardSpace(Info.DOUBLELETTER, 3, !Info.TAKEN, 0, 3);
		spaces[0][11] = new BoardSpace(Info.DOUBLELETTER, 11, !Info.TAKEN, 0, 11);
		spaces[2][6] = new BoardSpace(Info.DOUBLELETTER, 36, !Info.TAKEN, 2, 6);
		spaces[2][8] = new BoardSpace(Info.DOUBLELETTER, 38, !Info.TAKEN, 2, 8);
		spaces[3][0] = new BoardSpace(Info.DOUBLELETTER, 45, !Info.TAKEN, 3, 0);
		spaces[3][7] = new BoardSpace(Info.DOUBLELETTER, 52, !Info.TAKEN, 3, 7);
		spaces[3][14] = new BoardSpace(Info.DOUBLELETTER, 59, !Info.TAKEN, 3, 14);
		spaces[6][2] = new BoardSpace(Info.DOUBLELETTER, 92, !Info.TAKEN, 6, 2);
		spaces[6][6] = new BoardSpace(Info.DOUBLELETTER, 96, !Info.TAKEN, 6, 6);
		spaces[6][8] = new BoardSpace(Info.DOUBLELETTER, 98, !Info.TAKEN, 6, 8);
		spaces[6][12] = new BoardSpace(Info.DOUBLELETTER, 102, !Info.TAKEN, 6, 12);
		spaces[7][3] = new BoardSpace(Info.DOUBLELETTER, 108, !Info.TAKEN, 7, 3);
		spaces[7][11] = new BoardSpace(Info.DOUBLELETTER, 116, !Info.TAKEN, 7, 11);
		spaces[8][2] = new BoardSpace(Info.DOUBLELETTER, 122, !Info.TAKEN, 8, 2);
		spaces[8][6] = new BoardSpace(Info.DOUBLELETTER, 126, !Info.TAKEN, 8, 6);
		spaces[8][8] = new BoardSpace(Info.DOUBLELETTER, 128, !Info.TAKEN, 8 , 8);
		spaces[8][12] = new BoardSpace(Info.DOUBLELETTER, 132, !Info.TAKEN, 8, 12);
		spaces[11][0] = new BoardSpace(Info.DOUBLELETTER, 165, !Info.TAKEN, 11, 0);
		spaces[11][7] = new BoardSpace(Info.DOUBLELETTER, 172, !Info.TAKEN, 11, 7);
		spaces[11][14] = new BoardSpace(Info.DOUBLELETTER, 179, !Info.TAKEN, 11, 14);
		spaces[12][6] = new BoardSpace(Info.DOUBLELETTER, 186, !Info.TAKEN, 12, 6);
		spaces[12][8] = new BoardSpace(Info.DOUBLELETTER, 188, !Info.TAKEN, 12, 8);
		spaces[14][3] = new BoardSpace(Info.DOUBLELETTER, 213, !Info.TAKEN, 14, 3);
		spaces[14][11] = new BoardSpace(Info.DOUBLELETTER, 221, !Info.TAKEN, 14, 11);
		
		// Double word spaces
		spaces[1][1] = new BoardSpace(Info.DOUBLEWORD, 16, !Info.TAKEN, 1, 1);
		spaces[2][2] = new BoardSpace(Info.DOUBLEWORD, 32, !Info.TAKEN, 2, 2);
		spaces[3][3] = new BoardSpace(Info.DOUBLEWORD, 48, !Info.TAKEN, 3, 3);
		spaces[4][4] = new BoardSpace(Info.DOUBLEWORD, 64, !Info.TAKEN, 4, 4);
		spaces[13][13] = new BoardSpace(Info.DOUBLEWORD, 28, !Info.TAKEN, 13, 13);
		spaces[12][12] = new BoardSpace(Info.DOUBLEWORD, 42, !Info.TAKEN, 12, 12);
		spaces[11][11] = new BoardSpace(Info.DOUBLEWORD, 56, !Info.TAKEN, 11, 11);
		spaces[10][10] = new BoardSpace(Info.DOUBLEWORD, 70, !Info.TAKEN, 10, 10);
		spaces[13][1] = new BoardSpace(Info.DOUBLEWORD, 196, !Info.TAKEN, 13, 1);
		spaces[12][2] = new BoardSpace(Info.DOUBLEWORD, 182, !Info.TAKEN, 12, 2);
		spaces[11][3] = new BoardSpace(Info.DOUBLEWORD, 168, !Info.TAKEN, 11, 3);
		spaces[10][4] = new BoardSpace(Info.DOUBLEWORD, 154, !Info.TAKEN, 10, 4);
		spaces[13][13] = new BoardSpace(Info.DOUBLEWORD, 208, !Info.TAKEN, 13, 13);
		spaces[12][12] = new BoardSpace(Info.DOUBLEWORD, 192, !Info.TAKEN, 12, 12);
		spaces[11][11] = new BoardSpace(Info.DOUBLEWORD, 176, !Info.TAKEN, 11, 11);
		spaces[10][10] = new BoardSpace(Info.DOUBLEWORD, 160, !Info.TAKEN, 10, 10);
		
		// Triple letter spaces
		spaces[1][5] = new BoardSpace(Info.TRIPLELETTER, 20, !Info.TAKEN, 1, 5);
		spaces[1][9] = new BoardSpace(Info.TRIPLELETTER, 24, !Info.TAKEN, 1, 9);
		spaces[5][1] = new BoardSpace(Info.TRIPLELETTER, 76, !Info.TAKEN, 5, 1);
		spaces[5][5] = new BoardSpace(Info.TRIPLELETTER, 80, !Info.TAKEN, 5, 5);
		spaces[5][9] = new BoardSpace(Info.TRIPLELETTER, 84, !Info.TAKEN, 5, 9);
		spaces[5][13] = new BoardSpace(Info.TRIPLELETTER, 88, !Info.TAKEN, 5, 13);
		spaces[9][1] = new BoardSpace(Info.TRIPLELETTER, 136, !Info.TAKEN, 9, 1);
		spaces[9][5] = new BoardSpace(Info.TRIPLELETTER, 140, !Info.TAKEN, 9, 5);
		spaces[9][9] = new BoardSpace(Info.TRIPLELETTER, 144, !Info.TAKEN, 9, 9);
		spaces[9][13] = new BoardSpace(Info.TRIPLELETTER, 148, !Info.TAKEN, 9, 13);
		spaces[13][5] = new BoardSpace(Info.TRIPLELETTER, 200, !Info.TAKEN, 13, 5);
		spaces[13][9] = new BoardSpace(Info.TRIPLELETTER, 204, !Info.TAKEN, 13, 9);
		
		// Triple word spaces
		spaces[0][0] = new BoardSpace(Info.TRIPLEWORD, 0, !Info.TAKEN, 0, 0);
		spaces[0][7] = new BoardSpace(Info.TRIPLEWORD, 7, !Info.TAKEN, 0, 7);
		spaces[0][14] = new BoardSpace(Info.TRIPLEWORD, 14, !Info.TAKEN, 0, 14);
		spaces[7][0] = new BoardSpace(Info.TRIPLEWORD, 105, !Info.TAKEN, 7, 0);
		spaces[7][14] = new BoardSpace(Info.TRIPLEWORD, 119, !Info.TAKEN, 7, 14);
		spaces[14][0] = new BoardSpace(Info.TRIPLEWORD, 210, !Info.TAKEN, 14, 0);
		spaces[14][7] = new BoardSpace(Info.TRIPLEWORD, 217, !Info.TAKEN, 14, 7);
		spaces[14][14] = new BoardSpace(Info.TRIPLEWORD, 224, !Info.TAKEN, 14 ,15);
		
		// All other spaces
		int spaceNum = 0;
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				if (spaces[i][j] == null || spaces[i][j].equals(null)) {
					spaces[i][j] = new BoardSpace(Info.NORMAL, spaceNum, !Info.TAKEN, i, j);
				}
				
				spaceNum++;
			}
		}
		
		return spaces;
	}
	
	public static BoardSpace [][] setPlayerSpaces(BoardSpace [][] spaces) {
		int spaceID = 225;
		// Set player spaces
		for (int j = 0; j<7; j++) {
			spaces[0][j] = new BoardSpace(Info.PLAYERSPACE, spaceID, !Info.TAKEN, 0, j);
			spaceID++;
		}
		
		return spaces;
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
		space.add(selectedTile);
		BoardSpace.setStatus(space, Info.TAKEN);
		space.revalidate();
		space.repaint();
	}
	
	public static void removeTile(BoardSpace space, Tile t) {
		space.boardTile = null;
		space.remove(t);
		BoardSpace.setStatus(space, !Info.TAKEN);
		space.revalidate();
		space.repaint();
	}
	
	public static void setStatus(BoardSpace space, Boolean status) {
		space.status = status;
	}
	
	public static Point getPoint(BoardSpace space) {
		return space.loc;
	}
	
}
