package plantaEnsambladora;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Linea extends Thread{
	private int lineNumber;
	private JPanel panel;
	private Vector<Estacion> stations;	
	private static Vector<Vector<Robot>> robots;
	private static int[] robotsPerStation = {5,4,2,3,3,0,0};
	private JLabel[][] lineRows;
	
	private static int totalCars = 0;
	private final String[] IMAGE_NAMES = {"robot.png","car_step1.png","car_step2.png","car_step3.png","car_step4.png","car_step5.png","car_step6.png"};

	public Linea(int lineNumber) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,7,10,10));
		this.lineNumber = lineNumber;
		lineRows = new JLabel[2][7];
		if(robots == null)
			initializeRobots();
		initializeView();
		initializeStations();
		updateRobots();
	}

	private void initializeStations() {
		stations = new Vector<Estacion>();
		stations.add(new Estacion("Chasis y cableado",1,2000,true));
		stations.add(new Estacion("Motor",2,600,true));
		stations.add(new Estacion("Transmision",3,400,true));
		stations.add(new Estacion("Carroceria",4,1000,true));
		stations.add(new Estacion("Interiores",5,500,true));
		stations.add(new Estacion("Llantas",6,500,true));
		stations.add(new Estacion("Puertas",7,1000,true));
	}

	private void initializeView() {
		for(int i = 0; i < lineRows.length; i++) {
			for(int j = 0; j < lineRows[i].length; j++) {
				lineRows[i][j] = new JLabel();
				panel.add(lineRows[i][j]);
				lineRows[i][j].setBorder((new LineBorder(Color.black)));
			}		
		}
	}

	public void updateLineStation(int station) {
		if(station >= 7) {
			lineRows[1][station-1].setIcon(null);
			return;
		}
		lineRows[1][station-1].setIcon(null);
		lineRows[1][station].setIcon(Rutinas.changeSize(IMAGE_NAMES[station], 50, 50));
	}

	public void setInitialRobots() {
		for(int i = 0; i < stations.size(); i++) {
			if(lineNumber <= robots.get(i).size()) {
				//				 System.out.println(stations.get(i).getStationNumber() +"  | "+robots.get(i).size()+"\n");
				lineRows[0][i].setIcon(Rutinas.changeSize(IMAGE_NAMES[0], 50, 50));
			}
		}
	}
	
	@Override
	public void run() {
		Vector<Robot> currentStationsRobots;
		Robot robot = null;
		Estacion station;
		while(totalCars < 100) {
			for(int i = 0; i < stations.size(); i++) {
				currentStationsRobots = robots.get(i);
				station = stations.get(i);
				
				for(int j = 0; j < currentStationsRobots.size(); j++) {
					robot = currentStationsRobots.get(j);
					robot.getSemaphore().Espera();
					if(!robot.isReady()) {
						robot.getSemaphore().Libera();
						robot = null;
						continue;
					}
					robot.setReady(false);
					robot.getSemaphore().Libera();
					break;
				}
				
				if(robot == null) {
					i--;
					continue;
				}
				
				if(robot.getLastLine() != null)
					robot.getLastLine().putRobot(station.getStationNumber(), false);
				robot.setLastLine(this);
				putRobot(station.getStationNumber(),true);
				robot.operate(station.getOperationTime(),this);
				updateLineStation(station.getStationNumber());
				robot.setReady(true);
				if(station.getStationNumber() == 7)
					totalCars++;
			}
		}
	}
	
	public JPanel getView(){
		return this.panel;
	}
	
	private void  initializeRobots() {
		robots = new Vector<Vector<Robot>>();
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
	
	public void putRobot(int pos, boolean putOrDelete) {
		lineRows[0][pos-1].setIcon((putOrDelete)? Rutinas.changeSize(IMAGE_NAMES[0], 50, 50):null);
	}

	
}

