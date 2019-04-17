package plantaEnsambladora;

import java.util.Vector;

public class Linea {
	private int lineNumber;
	private Vector<Estacion> stations;
	
	public Linea(int lineNumber) {
		this.lineNumber = lineNumber;
		initializeStations();
	}
	
	private void initializeStations() {
		stations.add(new Estacion("Chasis y cableado",2000,true));
		stations.add(new Estacion("Motor-Transmision",1000,true));
		stations.add(new Estacion("Carroceria",1000,true));
		stations.add(new Estacion("Interiores",500,true));
		stations.add(new Estacion("Llantas",500,true));
		stations.add(new Estacion("Puertas",1000,true));
	}
}
