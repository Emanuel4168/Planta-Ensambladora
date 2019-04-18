package plantaEnsambladora;

public class Robot {
	private boolean isReady;
	private Semaforo semaphore;
	
	public Robot() {
		this.isReady = true;
		semaphore = new Semaforo(1);
	}
	
	public void operate(int time, Thread t) {
		try {
			t.sleep(time);
		}catch(Exception e) {}
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public Semaforo getSemaphore() {
		return semaphore;
	}
}
