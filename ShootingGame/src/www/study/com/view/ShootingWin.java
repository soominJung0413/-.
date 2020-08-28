package www.study.com.view;

import javax.swing.JFrame;

public class ShootingWin extends JFrame {
	
	private MyPanel myPanel;
	
	public ShootingWin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
		add(myPanel);
		setSize(1000,625);
		setVisible(true);
	}

	public MyPanel getMyPanel() {
		return myPanel;
	}
	
	
	
}
