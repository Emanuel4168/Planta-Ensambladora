package plantaEnsambladora;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PlantaEnsambladoraView extends JFrame{
	
	private int totalLines;
	private Vector<Linea> lineas;
	private final Color[] COLORS = {null,Color.BLUE,Color.CYAN,Color.YELLOW,Color.red,Color.GREEN,Color.ORANGE,Color.WHITE,Color.PINK};
	
	public PlantaEnsambladoraView() {
		super("Planta Ensambladora");
		totalLines = 8;//Rutinas.nextInt(8,15);
		
		lineas = new Vector<Linea>();
		for(int i = 1; i <= totalLines; i++) {
			Linea l = new Linea(i);
			l.getView().setBackground(COLORS[i]);
			lineas.add(l);
		}
		
		createCenterPane();
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		lineas.forEach(linea ->{
			linea.start();
		});
	}
	
	private void createCenterPane() {
		JPanel centerPane = new JPanel(new GridLayout(0,2));
		lineas.forEach(linea ->{
//			System.out.println("XXX");
			linea.setInitialRobots();
			centerPane.add(linea.getView());
		});
		add(centerPane,BorderLayout.CENTER);
	}
}
