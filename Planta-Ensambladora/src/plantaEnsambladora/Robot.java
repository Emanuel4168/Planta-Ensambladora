package plantaEnsambladora;

public class Robot {
	private boolean isReady;
	private Semaforo semaphore;
	private Linea lastLine;
	private int robotType;
	public static final int TYPE_CHASIS = 1;
	public static final int TYPE_MOTOR = 2;
	public static final int TYPE_TRANSMISION = 3;
	public static final int TYPE_CARROCERIA = 4;
	public static final int TYPE_INTERIORES = 5;
	public static final int TYPE_LLANTAS = 6;
	public static final int TYPE_PRUEBAS = 7;
	
	public Robot(int robotType) {
		this.isReady = true;
		semaphore = new Semaforo(1);
		this.robotType = robotType;
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
	
	public Linea getLastLine() {
		return lastLine;
	}

	public void setLastLine(Linea motherLine) {
		this.lastLine = motherLine;
	}
	
	public int getType() {
		return robotType;
	}
}
