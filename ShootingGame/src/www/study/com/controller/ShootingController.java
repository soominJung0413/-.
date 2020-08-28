package www.study.com.controller;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import www.study.com.model.Bullet;
import www.study.com.model.Cannon;
import www.study.com.model.Planet;
import www.study.com.model.Target;
import www.study.com.view.ShootingWin;

public class ShootingController {
	/** 초당 30번 계산해서 스무드하게 시뮬레이트할 것임 */
	private static final int SIMUL_PER_SEC =30;
	
	private static final int SIMUL_PERIOD =   1000 / SIMUL_PER_SEC;
	
			//지구를 만들자
			private  Planet earth ;
			//포를 만들자
			private  Cannon myCannon ;
			//포탄을 만들자
			private  Bullet myBullet;
			//목표물을 만들자
			private Target enemy ;
			//타이머를 만들자
			Timer timer;
			
			ShootingWin shootingWin;
			

	public static void main(String[] args) {
		ShootingController controller = new ShootingController();
		controller.setUpEnvironment();
		
		double fireAngle = guideGameHintToGammer();
		
		controller.myCannon.shoot(fireAngle);
		
		//시간이 흐름에 따라 포탄이 날아가서 땅에 닿을 때까지 시뮬레이트
		 controller.timer = new Timer(); 
		controller.timer.scheduleAtFixedRate(controller.new TimeElapser(), 0, SIMUL_PERIOD);
	}
	
	/**
	 * 사용자로 부터 안절 발사각 입력받기
	 * @return
	 */
	private static double guideGameHintToGammer() {
		Scanner scanner = new Scanner(System.in);
		double fireAngle;
		do {
			Cannon.guideToUser();
			fireAngle = scanner.nextDouble();
		} while(!Cannon .isValidateAngle(fireAngle));
		return fireAngle;
	}
	
	/**
	 * 각종 필요한 객체를 만드는 초기화 과정
	 * @return
	 */
	private  void setUpEnvironment() {
		shootingWin  = new ShootingWin();
		
		//지구를 만들자
	earth = new Planet (-9.8d);
		//포를 만들자
		myCannon =  new  Cannon(0);
		earth.setCannon(myCannon); 
		//포탄을 만들자
		myBullet =new Bullet ();
		myCannon.장전(myBullet);
		//목표물을 만들자
		enemy = new Target(20000) ;
		earth.setEnemy(enemy);

		shootingWin.getMyPanel().setData(myCannon,myBullet,enemy);
		
		//목표물 까지의 거리를 산출하여 게이머에게 알려주세요
		double distanToEnemy = earth.operatedDistance();
		
		System.out.println("목표물 까지의 거리는 : "+distanToEnemy+"meter 입니다.");
		System.out.println("발사각도를 입력하여 쏘세요!");
	}
	
	private class TimeElapser extends TimerTask{
		private int outOn = 0;

		@Override
		public void run() {
			myBullet.timeElapsed(SIMUL_PERIOD, earth.getGravity());
			outOn++;
			shootingWin.repaint();
			if(outOn >= SIMUL_PER_SEC * 10) {
				outOn =0;
				System.out.println(myBullet);
			}
			if(earth.땅에닿았니(myBullet)) {
				double targetDistance = enemy.operatedDistance(myBullet);
				System.out.println("목표물과 떨어진 거리는 "+targetDistance+" 미터입니다.");
				timer.cancel();
			};
		}
		
	}

}
