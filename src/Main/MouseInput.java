package Main;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;

import objects.BoardSpace;
import objects.Tile;

public class MouseInput extends MouseAdapter {
	/**
	 * 
	 */
	private Component mouseArea;
	private boolean dragging;
	private Tile draggingTile;
	private BoardSpace currentSpace;
	private BoardSpace startingSpace;
	private Component selectedObject;
	Component [] panelObjects;
	private JLayeredPane dragLayer;
	private Point dragPoint;
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
    	
    	if (dragging) {
			System.out.println("Dragging");
		}
    	
        if (!dragging) {
        	return;
        } else {
        	System.out.println("Dragging " + Tile.getLetter(draggingTile));
            int x = e.getPoint().x - dragWidth;
    		int y = e.getPoint().y - dragHeight;
    		draggingTile.setLocation(x, y);
    		
    		draggingTile.repaint();
        }
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//eventOutput("Mouse Clicked", e);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		dragPoint = e.getPoint();
		selectedObject = e.getComponent().getComponentAt(dragPoint);
		// Get the current space

		while (!selectedObject.getClass().getSimpleName().equals("BoardSpace")) {
			try {
				dragPoint = selectedObject.getMousePosition();
				selectedObject = selectedObject.getComponentAt(dragPoint);
			} catch (NullPointerException illegalSpace){
				currentSpace = startingSpace;
				break;
			}
		}
		
		if (selectedObject.getClass().getSimpleName().equals("BoardSpace")) {
			currentSpace = (BoardSpace) selectedObject;
			System.out.println(BoardSpace.getID(currentSpace));
		} */
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//eventOutput("Mouse Exited", e);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		dragLayer = (JLayeredPane) e.getSource();
		dragPoint = e.getPoint();
		selectedObject = e.getComponent().getComponentAt(dragPoint);
		
		// Get the current space
		while (!selectedObject.getClass().getSimpleName().equals("BoardSpace")) {
			try {
				dragPoint = selectedObject.getMousePosition();
				selectedObject = selectedObject.getComponentAt(dragPoint);
			} catch (NullPointerException illegalSpace){
				return;
			}
		}
		
		currentSpace = (BoardSpace) selectedObject;
		startingSpace = (BoardSpace) selectedObject;
		
		// If the boardspace has a tile, remove Tile from boardspace and add to dragging layer
		if (BoardSpace.Taken(currentSpace)) {
			// get dragging tile
			draggingTile = BoardSpace.getTile(currentSpace);
			dragging = true;
			
			// remove tile and repaint space
			BoardSpace.removeTile(currentSpace, draggingTile);
			currentSpace.revalidate();
			currentSpace.repaint();
			
			// Add tile to dragging layer
			dragWidth = draggingTile.getWidth() / 2;
			dragHeight = draggingTile.getHeight() / 2;
			int x = e.getPoint().x - dragWidth;
			int y = e.getPoint().y - dragHeight;

			draggingTile.setLocation(x, y);
			dragLayer.add(draggingTile, JLayeredPane.DRAG_LAYER);
			draggingTile.revalidate();
			draggingTile.repaint();
			
			System.out.println("Selected Tile " + Tile.getLetter(draggingTile));
		} else {
			return;
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		/*
		// TODO Auto-generated method stub
		if (!BoardSpace.Taken(currentSpace)) {
			return;
		} else {
			dragging = false; 
			BoardSpace.setTile(currentSpace, draggingTile);
			draggingTile = null;
			currentSpace.repaint();
			currentSpace.revalidate();
		} */
	}

}
