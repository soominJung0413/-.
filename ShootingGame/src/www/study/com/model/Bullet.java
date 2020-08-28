package www.study.com.model;
/**
 * 포탄
 * @author admin
 *
 */
public class Bullet extends LocatableObject{

	/**  수평속도 m/sec   */
	private double xSpeed;
	/** 수직속도 m/sec */
	private double ySpeed;
	
	public void setSpeed(double xSpeed2, double ySpeed2) {
		this.xSpeed= xSpeed2;
		this.ySpeed = ySpeed2;
	}
	
	/**
	 * 
	 * @param simulPeriod milSec
	 * @param gravity
	 */
	public void timeElapsed(int simulPeriod,double gravity) {
		double periodInSec = simulPeriod / 1000.0d;
		// 등속운동 s = s1 + vt
		super.changeXPos(xSpeed * periodInSec);
		//등가속도운동 v1 = v0 +  at; s1 = s0 + v1 * t
		ySpeed += periodInSec *  gravity;
		super.changeYPos(ySpeed * periodInSec);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
