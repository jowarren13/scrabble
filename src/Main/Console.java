package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import objects.BoardSpace;

import javax.imageio.ImageIO;

public class Console {
	private JFrame frame; 
	private JPanel north;
	private JPanel south;
	private JPanel east;
	private JPanel west;
	private JLayeredPane center;
	private JPanel splash;
	private JPanel playerBox;
	private JPanel boardGrid;
	private JPanel boardImage;
	private JButton start;
	private BoardSpace [][] spaces;
	
	public Console () throws IOException{
		// Create frame
		frame = new JFrame();
		final int frameWidth = 850;
		final int frameHeight = 950;
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.setTitle("Scrabble");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		// Create layout layered panes
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		center = new JLayeredPane();
		
		// Set pane/panel locations and sizes
		south.setPreferredSize(new Dimension(810,75));
		center.setBounds(0,0,810,810);
		
		// Create board image label and add to JPanel
		BufferedImage scrabbleImage = ImageIO.read(Console.class.getResource("/board.jpg"));	
		JLabel background = new JLabel(new ImageIcon(scrabbleImage));
		boardImage = new JPanel();
		boardImage.setBounds(0, 0, 810, 815);
		boardImage.add(background);
		boardImage.setOpaque(true);
		
		
		// create JPanel with gridBagLayout
		boardGrid = new JPanel();
		boardGrid.setBounds(0, 3, 810, 810);
		boardGrid.setLayout(new GridBagLayout());
		boardGrid.setOpaque(false);
		
		// Create panels to add to boardGrid
		spaces = new BoardSpace [15][15];
		BoardSpace.setSpaces(spaces);
		
		// Set grid constraints
		GridBagConstraints cGrid = new GridBagConstraints();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				// panel constraints
				cGrid.gridx = i; 				// grid x location
				cGrid.gridy = j; 				// grid y location
				cGrid.gridheight = 1;			// spans 1 row
				cGrid.gridwidth = 1;			// spans 1 column
				cGrid.weightx = 0.0;
				cGrid.weighty = 0.0;
				cGrid.fill = GridBagConstraints.BOTH;	// Resize veritically & horizontally
				
				// Set size of board space and add to grid
				spaces[i][j].setOpaque(false);
				spaces[i][j].setPreferredSize(new Dimension((int) Info.GRIDSIZE,(int) Info.GRIDSIZE));
				boardGrid.add(spaces[i][j], cGrid);
			}
		}
		
		// Add board image and grid to center pane
		center.add(boardImage, new Integer(0),0);
		center.add(boardGrid, new Integer(1),0);
		
		
		// Create player box panel
		playerBox = new JPanel();
		playerBox.setLayout(new GridLayout(1,7, 10, 0));
		
		
		// Add player box to south panel
		south.add(playerBox);
		
		// Add panels to frame
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.SOUTH);
		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);
		
		frame.pack();
		
		// Make frame visible
		frame.setVisible(true);
	}
	
	public JFrame getConsole(Console frame) {
		return frame.getConsole(frame);
	}
	
	public JPanel getNorth(Console frame) {
		return frame.north;
	}
	
	public JPanel getSouth(Console frame) {
		return frame.south;
	}
	
	public JPanel getEast(Console frame) {
		return frame.east;
	}
	
	public JPanel getWest(Console frame) {
		return frame.west;
	}
	
	public JLayeredPane getCenter(Console frame) {
		return frame.center;
	}
	
	public JPanel getSplash(Console frame) {
		return frame.splash;
	}
	
	public JButton getStart(Console frame) {
		return frame.start;
	}
	
	public JPanel getPlayerBox(Console frame) {
		return frame.playerBox;
	}
	
	/*public JPanel getBoard(Console frame) {
		return frame.board;
	}*/
	
	public BoardSpace[][] getBoardSpaces(Console frame) {
		return frame.spaces;
	}
	
	// Creates the GUI frame with splash page
	static void launchGame(Console frame, JPanel splash, JButton start) {
		ActionListener startGame = new SplashPageListener(frame);
		start.addActionListener(startGame);
	}
	
}
