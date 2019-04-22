package plantaEnsambladora;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Linea extends JPanel{
	private int lineNumber;
	private Vector<Estacion> stations;
	
	private JLabel[][] lineRows;
	private final String[] IMAGE_NAMES = {"robot.png","car_step1.png","car_step2.png","car_step3.png","car_step4.png","car_step5.png"};
	
	public Linea(int lineNumber) {
		setLayout(new GridLayout(0,7,10,10));this.lineNumber = lineNumber;
		lineRows = new JLabel[2][7];
		initializeView();
		initializeStations();
		Estacion.updateRobots();
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
				add(lineRows[i][j]);
				lineRows[i][j].setBorder((new LineBorder(Color.black)));
			}		
		}
		
	}
	
	public void updateLineStation(int station) {
		lineRows[1][station].setIcon(null);
		lineRows[1][station+1].setIcon(Rutinas.changeSize(IMAGE_NAMES[station], 50, 50));
	}
	
	public void setInitialRobots() {
		 Vector<Vector<Robot>> robots = Estacion.getRobots();
		 for(int i = 0; i < stations.size(); i++) {
			 if(lineNumber <= robots.get(i).size()) {
//				 System.out.println(stations.get(i).getStationNumber() +"  | "+robots.get(i).size()+"\n");
				 lineRows[0][i].setIcon(Rutinas.changeSize(IMAGE_NAMES[0], 30, 30));
			 }
		 }
	}
	
}
