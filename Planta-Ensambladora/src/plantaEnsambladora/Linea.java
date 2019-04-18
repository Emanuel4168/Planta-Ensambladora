package plantaEnsambladora;

import java.util.Vector;

public class Linea {
	private int lineNumber;
	private Vector<Estacion> stations;
	
	public Linea(int lineNumber) {
		this.lineNumber = lineNumber;
		initializeStations();
		Estacion.updateRobots();
		
	}
	
	private void initializeStations() {
		stations.add(new Estacion("Chasis y cableado",1,2000,true));
		stations.add(new Estacion("Motor",2,600,true));
		stations.add(new Estacion("Transmision",3,400,true));
		stations.add(new Estacion("Carroceria",3,1000,true));
		stations.add(new Estacion("Interiores",4,500,true));
		stations.add(new Estacion("Llantas",5,500,true));
		stations.add(new Estacion("Puertas",6,1000,true));
	}
	
}
