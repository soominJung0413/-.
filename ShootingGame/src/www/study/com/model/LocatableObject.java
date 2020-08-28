package www.study.com.model;
/**
 * 공통된 위치정보를 추상화함.
 * @author admin
 *
 */
public abstract class LocatableObject {
	/** 수직위치 meter */
	private double xPosition;
	/** 수평위치 meter */
	private double yPosition;
	
	public LocatableObject() {
	}
	
	public LocatableObject(double xPosition, double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	/* 상위 클래스의 함수 작성 시 하위 클래스 이름은 사용하지 않습니다. */
	public void cloneLocation(LocatableObject other) {
		other.xPosition = this.xPosition;
		other.yPosition = this.yPosition;
	}
	
	/**
	 * 거리를 산출
	 * @param other
	 * @return
	 */
	public double operatedDistance(LocatableObject other) {
		return Math.sqrt((this.xPosition - other.xPosition )* (this.xPosition - other.xPosition ) +  (this.yPosition - other.yPosition) * (this.yPosition - other.yPosition));
	}

	/**
	 * 
	 * @param distanceDelta 수평 거리 변화량
	 */
	public void changeXPos(double distanceDelta) {
		this.xPosition += distanceDelta;
	}

	public void changeYPos(double distanceDelta) {
		this.yPosition += distanceDelta;
	}

	@Override
	public String toString() {
		return "Loc [xPosition=" + xPosition + ", yPosition=" + yPosition + "]";
	}
	
	public double getxPosition() {
		return xPosition;
	}
	
	public double getyPosition() {
		return yPosition;
	}
	

	
	
	
}
