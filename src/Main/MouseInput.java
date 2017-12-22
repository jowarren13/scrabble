package Main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;

import objects.BoardSpace;
import objects.Tile;
import objects.BoardPane;

public class MouseInput implements MouseMotionListener, MouseListener {
	/**
	 * 
	 */

	private BoardPane dragLayer;

    void eventOutput(String eventDescription, MouseEvent e) {
    	Point p = e.getPoint();
        System.out.println(eventDescription
                + " (" + p.getX() + "," + p.getY() + ")"
                + " detected on "
                + e.getComponent().getClass().getName()
                + "\n");
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        //eventOutput("Mouse moved", e);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
    	// Set dragLayer
		dragLayer = BoardPane.getDragLayer((BoardPane) e.getSource());
		
    	System.out.println("Dragging is " + BoardPane.getDragStatus(dragLayer));
    	
    	// Drag tile across board
    	if (BoardPane.getDragStatus(dragLayer)) {
			int x = e.getPoint().x - BoardPane.getDragWidth(dragLayer);
			int y = e.getPoint().y - BoardPane.getDragHeight(dragLayer);
			BoardPane.getDragTile(dragLayer).setLocation(x, y);
			BoardPane.getDragTile(dragLayer).repaint();
			
            System.out.println("Dragging Tile " + Tile.getLetter(BoardPane.getDragTile(dragLayer)));
    	}
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Clicked", e);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		eventOutput("Mouse entered", e);

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Exited", e);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		eventOutput("Mouse Pressed", e);
		
		// Set dragLayer, dragPoint, and selectedObject
		BoardPane.setDragLayer((BoardPane) e.getSource());
		dragLayer = (BoardPane) e.getSource();
		BoardPane.setDragPoint(dragLayer, e.getPoint());
		BoardPane.setSelectedObj(dragLayer, e.getComponent().getComponentAt(BoardPane.getDragPoint(dragLayer)));

		// Find the current board space
		while (!BoardPane.getSelectedObj(dragLayer).getClass().getSimpleName().equals("BoardSpace")) {
			try {
				BoardPane.setDragPoint(dragLayer, BoardPane.getSelectedObj(dragLayer).getMousePosition());
				BoardPane.setSelectedObj(dragLayer, BoardPane.getSelectedObj(dragLayer).getComponentAt(BoardPane.getDragPoint(dragLayer)));
			} catch (NullPointerException illegalSpace){
				return;
			}
		}
		
		// Set the current board space & starting space
		BoardPane.setCurrentSpace(dragLayer, (BoardSpace) BoardPane.getSelectedObj(dragLayer));
		BoardPane.setStartingSpace(dragLayer, BoardPane.getCurrentSpace(dragLayer));
		
		// If the board space has a tile, remove Tile from board space then add to dragging layer
		if (BoardSpace.Taken(BoardPane.getCurrentSpace(dragLayer))) {
			// get dragging tile
			BoardPane.setDragTile(dragLayer, BoardSpace.getTile(BoardPane.getCurrentSpace(dragLayer)));
			BoardPane.setDragStatus(dragLayer, true);
			
			// remove tile and repaint space
			BoardSpace.removeTile(BoardPane.getCurrentSpace(dragLayer), BoardPane.getDragTile(dragLayer));
			BoardPane.getCurrentSpace(dragLayer).revalidate();
			BoardPane.getCurrentSpace(dragLayer).repaint();
			
			// Add tile to dragging layer at specified location
			int x = e.getPoint().x - BoardPane.getDragWidth(dragLayer);
			int y = e.getPoint().y - BoardPane.getDragHeight(dragLayer);
			BoardPane.getDragTile(dragLayer).setLocation(x, y);
			dragLayer.add(BoardPane.getDragTile(dragLayer), JLayeredPane.DRAG_LAYER);
			BoardPane.getDragTile(dragLayer).revalidate();
			BoardPane.getDragTile(dragLayer).repaint();
			
			System.out.println("Selected Tile " + Tile.getLetter(BoardPane.getDragTile(dragLayer)));
		} else {
			return;
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Released", e);
	}

}
