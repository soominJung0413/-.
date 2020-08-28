package www.study.com.model;
/**
 * 대포.
 * @author admin
 *
 */
public class Cannon extends LocatableObject{
	/** 최소 및 최대 발사 각도 안전 범위 */
	private static final double MIN_ANGLE =10.0d, MAX_ANGLE=80.0d;
	
	
	/** 발사속도 m/sec */
	private final static double FIRE_SPEED  = 500.0d;
	
	
	private Bullet bullet;
	
	public Cannon(double xPosition) {
		super(xPosition, 0);
	}

	public void 장전(Bullet bullet) {
		super.cloneLocation(bullet);
		this.bullet=bullet;
		
	}
	/**
	 * 안전 각도 검사
	 * @param fireAngle
	 * @return
	 */
	public static boolean isValidateAngle(double fireAngle) {
		return fireAngle >= MIN_ANGLE && fireAngle <= MAX_ANGLE;
	}
	
	public static void guideToUser() {
		System.out.println("포의 각도 범위는 "+MIN_ANGLE+" 부터 "+MAX_ANGLE+" 까지 입니다.");
		
	}
	
	/**
	 * 
	 * @param fireAngle2 발사각도 0~360
	 */
	public void shoot(double fireAngle) {
		//각도를 통해 발사속도를 벡터분해해서 포탄의 속도로 변환해줍니다.
		double radians = Math.toRadians(fireAngle);
		double ySpeed = Math.sin(radians)* FIRE_SPEED;
		double xSpeed = Math.cos(radians)* FIRE_SPEED;
		bullet.setSpeed(xSpeed,ySpeed);
	}
}
