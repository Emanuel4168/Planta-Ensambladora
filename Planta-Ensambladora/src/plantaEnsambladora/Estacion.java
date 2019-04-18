package plantaEnsambladora;

import java.util.*;

public class Estacion extends Thread{

	private String stationName;
	private int stationNumber;
	private int operationTime;
	private boolean produce;
	private static Vector<Vector<Robot>> robots;
	
	private static int[] robotsPerStation = {5,4,2,3,3,0,0};
	
	public Estacion(String name, int stationNumber, int operationTime, boolean produce) {
		this.stationName = name;
		this.stationNumber = stationNumber;
		this.operationTime = operationTime;
		this.produce = produce;
		robots = new Vector<Vector<Robot>>();
		if(robots.size() < 1)
			initializeRobots();
	}
	
	//private static final int[] NUMBER_ROBOTS = {5,6,3,3};
	
	private void  initializeRobots() {
		Vector<Robot> temp;
		for(byte i = 0; i < robotsPerStation.length ; i++) {
			temp = new Vector<Robot>();
			for(byte j = 0;j < robotsPerStation[i]; j++)
				temp.add(new Robot());
			robots.add(temp);
		}
		robots.add(new Vector<Robot>());
		robots.add(new Vector<Robot>());
	}
	
	public static void updateRobots() {
		robots.get(robotsPerStation.length-2).addElement(new Robot());
		robots.get(robotsPerStation.length-1).addElement(new Robot());
		robotsPerStation[robotsPerStation.length-2]++;
		robotsPerStation[robotsPerStation.length-1]++;
	}
	
	@Override
	public void run() {
		Vector<Robot> stationsRobots = robots.get(stationNumber-1);
		Robot robot = null;
		while(produce) {
			for(byte i = 0; i < stationsRobots.size(); i++) {
				robot = stationsRobots.get(i);
				robot.getSemaphore().Espera();
				if(!robot.isReady()) {
					robot = null;
					robot.getSemaphore().Libera();
					continue;
				}
				robot.setReady(false);
				robot.getSemaphore().Libera();
			}
			if(robot == null)
				continue;
			
			robot.operate(operationTime, this);
			robot.setReady(true);
		}
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
