package Main;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import objects.BoardSpace;
import objects.Tile;

public class MouseInput extends Component implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component mouseArea;
	private boolean dragging;
	private Tile draggingTile;
	private BoardSpace currentSpace;
	private int dragWidth;
	private int dragHeight;

	public MouseInput(Component mouseArea) {
		// TODO Auto-generated constructor stub
		super();
		mouseArea = this.mouseArea;
	}
	

    void eventOutput(String eventDescription, MouseEvent e) {
    	Point p = e.getPoint();
        System.out.println(eventDescription
                + " (" + p.getX() + "," + p.getY() + ")"
                + " detected on "
                + e.getComponent().getClass().getName()
                + "\n");
    }
    
    public void mouseMoved(MouseEvent e) {
        //eventOutput("Mouse moved", e);
    }
    
    public void mouseDragged(MouseEvent e) {
        if (dragging == false) 
        	return;
        
        System.out.println("Dragging " + Tile.getLetter(draggingTile));
        int x = e.getPoint().x - dragWidth;
		int y = e.getPoint().y - dragHeight;
		draggingTile.setLocation(x, y);
		
		draggingTile.repaint();
		currentSpace.repaint();
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//eventOutput("Mouse Clicked", e);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().getClass().getSimpleName().equals("BoardSpace")) {
			currentSpace = (BoardSpace) e.getSource();
		} else {
			System.out.println("Unknown space");
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//eventOutput("Mouse Exited", e);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		currentSpace = (BoardSpace) e.getSource();

		if (!BoardSpace.Taken(currentSpace)) {
			System.out.println("No Tile Available");
			return;
		} else {
			dragging = true;
			draggingTile = BoardSpace.getTile(currentSpace);
			System.out.println("Dragging Tile: " + Tile.getLetter(draggingTile));
			dragWidth = draggingTile.getWidth() / 2;
			dragHeight = draggingTile.getHeight() / 2;
			int x = e.getPoint().x - dragWidth;
			int y = e.getPoint().y - dragHeight;
			draggingTile.setLocation(x, y);
			BoardSpace.removeTile(currentSpace, draggingTile);
			draggingTile.repaint();
			draggingTile.revalidate();
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!BoardSpace.Taken(currentSpace)) {
			System.out.println("No Tile Available");
			return;
		} else {
			dragging = false; 
			BoardSpace.setTile(currentSpace, draggingTile);
			draggingTile = null;
			currentSpace.repaint();
			currentSpace.revalidate();
		}
	}

}
