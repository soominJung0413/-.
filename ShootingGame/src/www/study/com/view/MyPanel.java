package www.study.com.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import www.study.com.model.Bullet;
import www.study.com.model.Cannon;
import www.study.com.model.Target;

public class MyPanel extends JPanel {
	private  Cannon myCannon ;
	//포탄을 만들자
	private  Bullet myBullet;
	//목표물을 만들자
	private Target enemy;

	@Override
	protected void paintComponent(Graphics g) {
		//수평은 왼쪽에서 10정도 마진을 줘야함.
		//넓이 1000은 100km로 환산할 것임.
		
		/*this.getWidth()*/
		this.getHeight();
		super.paintComponent(g);
		g.drawRect((int) (myCannon.getxPosition() / 1000 * 10 + 10), 
				(int) (this.getHeight() - myCannon.getyPosition() / 1000 - 10), 50, 50);
		g.drawRect((int) (enemy.getxPosition() / 1000 * 10 + 10), 
				(int) (this.getHeight() - enemy.getyPosition() / 1000 - 10), 50, 50);
		g.drawOval((int) (myBullet.getxPosition() / 1000 * 10 + 10), 
				(int) (this.getHeight() - myBullet.getyPosition() / 1000 - 10), 50, 50);
	}

	public void setData(Cannon myCannon, Bullet myBullet, Target enemy) {
		this.myCannon = myCannon;
		this.myBullet = myBullet;
		this.enemy = enemy;
	}

	
}
