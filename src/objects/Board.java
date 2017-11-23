package objects;
import Main.*;

public class Board {
	private BoardSpace[][] spaces;

	public Board() {
		spaces = new BoardSpace[15][15];
	}
	
	public void set() {
		// Set star
		spaces[7][7] = new BoardSpace(Info.STAR, 97, !Info.TAKEN);
		
		// Set Double letter spaces
		spaces[0][3] = new BoardSpace(Info.DOUBLELETTER, 3, !Info.TAKEN);
		spaces[0][11] = new BoardSpace(Info.DOUBLELETTER, 11, !Info.TAKEN);
		spaces[2][6] = new BoardSpace(Info.DOUBLELETTER, 36, !Info.TAKEN);
		spaces[2][8] = new BoardSpace(Info.DOUBLELETTER, 38, !Info.TAKEN);
		spaces[3][0] = new BoardSpace(Info.DOUBLELETTER, 45, !Info.TAKEN);
		spaces[3][7] = new BoardSpace(Info.DOUBLELETTER, 52, !Info.TAKEN);
		spaces[3][14] = new BoardSpace(Info.DOUBLELETTER, 59, !Info.TAKEN);
		spaces[6][2] = new BoardSpace(Info.DOUBLELETTER, 92, !Info.TAKEN);
		spaces[6][6] = new BoardSpace(Info.DOUBLELETTER, 96, !Info.TAKEN);
		spaces[6][8] = new BoardSpace(Info.DOUBLELETTER, 98, !Info.TAKEN);
		spaces[6][12] = new BoardSpace(Info.DOUBLELETTER, 102, !Info.TAKEN);
		spaces[7][3] = new BoardSpace(Info.DOUBLELETTER, 108, !Info.TAKEN);
		spaces[7][11] = new BoardSpace(Info.DOUBLELETTER, 116, !Info.TAKEN);
		spaces[8][2] = new BoardSpace(Info.DOUBLELETTER, 122, !Info.TAKEN);
		spaces[8][6] = new BoardSpace(Info.DOUBLELETTER, 126, !Info.TAKEN);
		spaces[8][8] = new BoardSpace(Info.DOUBLELETTER, 128, !Info.TAKEN);
		spaces[8][12] = new BoardSpace(Info.DOUBLELETTER, 132, !Info.TAKEN);
		spaces[11][0] = new BoardSpace(Info.DOUBLELETTER, 165, !Info.TAKEN);
		spaces[11][7] = new BoardSpace(Info.DOUBLELETTER, 172, !Info.TAKEN);
		spaces[11][14] = new BoardSpace(Info.DOUBLELETTER, 179, !Info.TAKEN);
		spaces[12][6] = new BoardSpace(Info.DOUBLELETTER, 186, !Info.TAKEN);
		spaces[12][8] = new BoardSpace(Info.DOUBLELETTER, 188, !Info.TAKEN);
		spaces[14][3] = new BoardSpace(Info.DOUBLELETTER, 213, !Info.TAKEN);
		spaces[14][11] = new BoardSpace(Info.DOUBLELETTER, 221, !Info.TAKEN);
		
		// Double word spaces
		spaces[1][1] = new BoardSpace(Info.DOUBLEWORD, 16, !Info.TAKEN);
		spaces[2][2] = new BoardSpace(Info.DOUBLEWORD, 32, !Info.TAKEN);
		spaces[3][3] = new BoardSpace(Info.DOUBLEWORD, 48, !Info.TAKEN);
		spaces[4][4] = new BoardSpace(Info.DOUBLEWORD, 64, !Info.TAKEN);
		spaces[13][13] = new BoardSpace(Info.DOUBLEWORD, 28, !Info.TAKEN);
		spaces[12][12] = new BoardSpace(Info.DOUBLEWORD, 42, !Info.TAKEN);
		spaces[11][11] = new BoardSpace(Info.DOUBLEWORD, 56, !Info.TAKEN);
		spaces[10][10] = new BoardSpace(Info.DOUBLEWORD, 70, !Info.TAKEN);
		spaces[13][1] = new BoardSpace(Info.DOUBLEWORD, 196, !Info.TAKEN);
		spaces[12][2] = new BoardSpace(Info.DOUBLEWORD, 182, !Info.TAKEN);
		spaces[11][3] = new BoardSpace(Info.DOUBLEWORD, 168, !Info.TAKEN);
		spaces[10][4] = new BoardSpace(Info.DOUBLEWORD, 154, !Info.TAKEN);
		spaces[13][13] = new BoardSpace(Info.DOUBLEWORD, 208, !Info.TAKEN);
		spaces[12][12] = new BoardSpace(Info.DOUBLEWORD, 192, !Info.TAKEN);
		spaces[11][11] = new BoardSpace(Info.DOUBLEWORD, 176, !Info.TAKEN);
		spaces[10][10] = new BoardSpace(Info.DOUBLEWORD, 160, !Info.TAKEN);
		
		// Triple letter spaces
		spaces[1][5] = new BoardSpace(Info.TRIPLELETTER, 20, !Info.TAKEN);
		spaces[1][9] = new BoardSpace(Info.TRIPLELETTER, 24, !Info.TAKEN);
		spaces[5][1] = new BoardSpace(Info.TRIPLELETTER, 76, !Info.TAKEN);
		spaces[5][5] = new BoardSpace(Info.TRIPLELETTER, 80, !Info.TAKEN);
		spaces[5][9] = new BoardSpace(Info.TRIPLELETTER, 84, !Info.TAKEN);
		spaces[5][13] = new BoardSpace(Info.TRIPLELETTER, 88, !Info.TAKEN);
		spaces[9][1] = new BoardSpace(Info.TRIPLELETTER, 136, !Info.TAKEN);
		spaces[9][5] = new BoardSpace(Info.TRIPLELETTER, 140, !Info.TAKEN);
		spaces[9][9] = new BoardSpace(Info.TRIPLELETTER, 144, !Info.TAKEN);
		spaces[9][13] = new BoardSpace(Info.TRIPLELETTER, 148, !Info.TAKEN);
		spaces[13][5] = new BoardSpace(Info.TRIPLELETTER, 200, !Info.TAKEN);
		spaces[13][9] = new BoardSpace(Info.TRIPLELETTER, 204, !Info.TAKEN);
		
		// Triple word spaces
		spaces[0][0] = new BoardSpace(Info.TRIPLEWORD, 0, !Info.TAKEN);
		spaces[0][7] = new BoardSpace(Info.TRIPLEWORD, 7, !Info.TAKEN);
		spaces[0][14] = new BoardSpace(Info.TRIPLEWORD, 14, !Info.TAKEN);
		spaces[7][0] = new BoardSpace(Info.TRIPLEWORD, 105, !Info.TAKEN);
		spaces[7][14] = new BoardSpace(Info.TRIPLEWORD, 119, !Info.TAKEN);
		spaces[14][0] = new BoardSpace(Info.TRIPLEWORD, 210, !Info.TAKEN);
		spaces[14][7] = new BoardSpace(Info.TRIPLEWORD, 217, !Info.TAKEN);
		spaces[14][14] = new BoardSpace(Info.TRIPLEWORD, 224, !Info.TAKEN);
		
		// All other spaces
		int spaceNum = 0;
		for (int i = 0; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				if (spaces[i][j] == null || spaces[i][j].equals(null)) {
					spaces[i][j] = new BoardSpace(Info.NORMAL, spaceNum, !Info.TAKEN);
				}
				
				spaceNum++;
			}
		}
		

	}
	
	
	public String getSpaceType(Board gameBoard, int loc) {
		int i = 0; 
		int j = 0;
		
		outloop:
		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				if (BoardSpace.getID(gameBoard.spaces[i][j]) == loc)
				break outloop;
			}
		}
		
		return BoardSpace.getType(gameBoard.spaces[i][j]);
	}
	
	public Boolean spaceTaken(Board gameBoard, int loc) {
		int i = 0; 
		int j = 0;
		
		outloop:
		for (i = 0; i < 15; i++) {
			for (j = 0; j < 15; j++) {
				if (BoardSpace.getID(gameBoard.spaces[i][j]) == loc)
				break outloop;
			}
		}
		
		return BoardSpace.Taken(gameBoard.spaces[i][j]);
	}

	public BoardSpace[][] getBoardSpaces(Board gameBoard) {
		return gameBoard.spaces;
	}

}
