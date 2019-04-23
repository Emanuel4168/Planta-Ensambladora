package plantaEnsambladora;

import java.util.*;

public class Estacion{

	private String stationName;
	private int stationNumber;
	private int operationTime;
	private boolean produce;
	private Linea motherLine;
	
	public Estacion(String name, int stationNumber, int operationTime, boolean produce, Linea motherLine) {
		this.stationName = name;
		this.stationNumber = stationNumber;
		this.operationTime = operationTime;
		this.produce = produce;
		this.motherLine = motherLine;
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
	
//	public int[] getInitialRobots() {
//		int [] initialRobots = new int[7];
//		for(int i = 0; i <initialRobots.length; i++) {
//			if(stationNumber <= robots.get(i).size()) {
//				initialRobots[i] = 1;
//				continue;
//			}
//			initialRobots[i] = 0;
//		}
//		return initialRobots;
//	}
	
}