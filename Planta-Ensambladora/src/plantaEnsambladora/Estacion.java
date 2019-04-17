package plantaEnsambladora;

import java.util.Vector;

public class Estacion extends Thread{

	private String stationName;
	private int stationNumber;
	private int operationTime;
	private boolean produce;
	private static Vector<Vector<Integer>> robots;
	
	public Estacion(String name, int stationNumber, int operationTime, boolean produce) {
		this.stationName = name;
		this.stationNumber = stationNumber;
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
	
	public int getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
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
