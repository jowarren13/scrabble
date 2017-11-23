package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SplashPageListener implements ActionListener {
	private Console frame;
	private JPanel splash;
	
	public SplashPageListener(Console frame) {
		this.frame = frame;
		this.splash = frame.getSplash(frame);
	}
	
	public void actionPerformed(ActionEvent event) {
		splash.setVisible(false);
		frame.getBoard(frame).setVisible(true);
	}

}
