package plantaEnsambladora;

public class Robot {
	
	public void operate(int time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}

}
