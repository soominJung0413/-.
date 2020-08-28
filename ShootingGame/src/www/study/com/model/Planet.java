package www.study.com.model;

/**
 * 행성. 대포 목표물 포탄이 이 안에서 움직입니다.
 * @author admin
 *
 */
public class Planet {
	/**  중력 가속도, m/sec  */
	private double gravity;
	
	private Cannon cannon;
	
	private Target target;
	
	public Planet(double gravity) {
		this.gravity = gravity;
	}

	public void setCannon(Cannon myCannon) {
		this.cannon = myCannon;
	}

	/**
	 * ㄴ
	 * @param enemy
	 */
	public void setEnemy(Target enemy) {
		this.target = enemy;
	}

	/**
	 * 목표물까지의 거리를 산출
	 * @return
	 */
		public double operatedDistance() {
			return cannon.operatedDistance(target);
		}

	public double getGravity() {
		return gravity;
	}

	public boolean 땅에닿았니(Bullet myBullet) {
		return myBullet.getyPosition() < 0;
	}
	
	

}
