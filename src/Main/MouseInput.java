package Main;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MouseInput extends Component implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame gameBoard;

	public MouseInput(JFrame gameBoard) {
		// TODO Auto-generated constructor stub
		super();
		gameBoard = this.gameBoard;
	}
	

    void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription
                + " (" + e.getX() + "," + e.getY() + ")"
                + " detected on "
                + e.getComponent().getClass().getName()
                + "\n");
    }
    
    public void mouseMoved(MouseEvent e) {
        eventOutput("Mouse moved", e);
    }
    
    public void mouseDragged(MouseEvent e) {
        eventOutput("Mouse dragged", e);
    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Clicked", e);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Entered", e);
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Exited", e);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Pressed", e);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		eventOutput("Mouse Released", e);
	}

}
