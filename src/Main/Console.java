package Main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import objects.Board;
import objects.Tile;

import javax.imageio.ImageIO;

public class Console {
	private JFrame frame; 
	private JLayeredPane north;
	private JLayeredPane south;
	private JLayeredPane east;
	private JLayeredPane west;
	private JLayeredPane center;
	//private JPanel center;
	private JPanel splash;
	private JPanel playerBox;
	private JPanel boardGrid;
	private JPanel boardImage;
	private JButton start;
	private JPanel [][] gridPanels;
	
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
		north = new JLayeredPane();
		south = new JLayeredPane();
		east = new JLayeredPane();
		west = new JLayeredPane();
		center = new JLayeredPane();
		
		north.setBounds(0,0,0,0);
		south.setBounds(0,0,810,100);
		east.setBounds(0,0,0,0);
		west.setBounds(0,0,0,0);
		center.setBounds(0,0,810,810);
		
		// Add panels to frame
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.SOUTH);
		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);
		//center.setBounds(0,0,800,800);
		
		/*// Create Splash panel and start button
		splash = new JPanel();
		splash.setLayout(new GridBagLayout());
		splash.setPreferredSize(new Dimension(800,800));
		
		// Create constraints
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 75;
		c.ipadx = 200;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		
		start = new JButton("New Game");
		start.setSize(new Dimension(50,100));
		
		// Add Start button to splash panel
		splash.add(start,c);

		
		// Add splash panel to center panel
		center.add(splash);*/
		
		// Create board image label and add to JPanel
		BufferedImage scrabbleImage = ImageIO.read(Console.class.getResource("/board.jpg"));	
		JLabel background = new JLabel(new ImageIcon(scrabbleImage));
		boardImage = new JPanel();
		boardImage.setBounds(0, 0, 810, 810);
		boardImage.add(background);
		boardImage.setOpaque(true);
		
		
		// create JPanel with gridBagLayout
		boardGrid = new JPanel();
		boardGrid.setBounds(0, 3, 810, 810);
		boardGrid.setLayout(new GridBagLayout());
		boardGrid.setOpaque(false);
		//boardGrid.setPreferredSize(new Dimension(800,800));
		
		// Create panels to add to boardGrid
		gridPanels = new JPanel [15][15];
		// Set grid constraints
		GridBagConstraints cGrid = new GridBagConstraints();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				// panel constraints
				cGrid.gridx = i; 				// grid x location
				cGrid.gridy = j; 				// grid y location
				cGrid.gridheight = 1;			// spans 1 row
				cGrid.gridwidth = 1;			// spans 1 column
				//cGrid.ipadx = (int) Info.GRIDSIZE;
				//cGrid.ipady = (int) Info.GRIDSIZE;
				cGrid.weightx = 0.0;
				cGrid.weighty = 0.0;
				cGrid.fill = GridBagConstraints.BOTH;	// Resize veritically & horizontally
				
				// Create square panels to add to boardGrid
				JPanel gridSquare = new JPanel();
				//gridSquare.setBounds(i * ((int) Info.GRIDSIZE), j * ((int) Info.GRIDSIZE), (int) Info.GRIDSIZE, (int) Info.GRIDSIZE);
				gridPanels[i][j] = gridSquare;
				//gridPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				gridPanels[i][j].setOpaque(false);
				gridPanels[i][j].setPreferredSize(new Dimension((int) Info.GRIDSIZE,(int) Info.GRIDSIZE));
				boardGrid.add(gridPanels[i][j], cGrid);
			}
		}
		
		// Add board image and boardGrid to 3rd panel
		/*board = new JPanel();
		board.add(boardImage);
		boardImage.setBounds(0, 0, 800, 800);
		board.add(boardGrid);
		boardGrid.setBounds(0, 0, 800, 800);*/
		
		// Add to center pane
		center.add(boardImage, new Integer(0),0);
		center.add(boardGrid, new Integer(1),0);
		
		
		// Create player box panel
		playerBox = new JPanel();
		playerBox.setLayout(new GridLayout(1,7, 10, 0));
		playerBox.setBackground(Color.blue);
		playerBox.setBounds(0, 0, 810, 100);
		
		
		// Add player box to south panel
		south.add(playerBox);
		
		// Add board to center panel

		//board.setVisible(false);
		
		
		frame.pack();
		
		// Make frame visible
		frame.setVisible(true);
	}
	
	public JFrame getConsole(Console frame) {
		return frame.getConsole(frame);
	}
	
	public JLayeredPane getNorth(Console frame) {
		return frame.north;
	}
	
	public JLayeredPane getSouth(Console frame) {
		return frame.south;
	}
	
	public JLayeredPane getEast(Console frame) {
		return frame.east;
	}
	
	public JLayeredPane getWest(Console frame) {
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
	
	public JPanel[][] getGridLocations(Console frame) {
		return frame.gridPanels;
	}
	
	// Creates the GUI frame with splash page
	static void launchGame(Console frame, JPanel splash, JButton start) {
		ActionListener startGame = new SplashPageListener(frame);
		start.addActionListener(startGame);
	}
	
}
