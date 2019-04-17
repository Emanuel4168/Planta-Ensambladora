package plantaEnsambladora;

public class Estacion extends Thread{

	private String stationName;
	private int operationTime;
	private boolean produce;
	
	public Estacion(String name, int operationTime, boolean produce) {
		this.stationName = name;
		this.operationTime = operationTime;
		this.produce = produce;
	}
	
	@Override
	public void run() {
		
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String name) {
		this.stationName = name;
	}

	public int getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(int operationTime) {
		this.operationTime = operationTime;
	}

	public boolean isProduce() {
		return produce;
	}

	public void setProduce(boolean produce) {
		this.produce = produce;
	}
	
	
}
