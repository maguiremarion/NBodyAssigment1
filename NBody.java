import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.Timer;

public class NBody {
	
	static String listType;
	static double scale;
	static ArrayList<Planet> arrlist = new ArrayList<>();
	static LinkedList<Planet> llist = new LinkedList<>();
	
	private static final double G = 6.673e-11;
	private static final double S = 0.15;
	private static final double dt = 0.008;
	
	
	static class Visual extends JPanel implements ActionListener {

		Timer tm = new Timer(5, this);	 //timer
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (listType.equals("ArrayList")) {
				for(int i=0; i < arrlist.size(); i++) {   //gets planet parameters
					int col1 = arrlist.get(i).getCol1();
					int col2 = arrlist.get(i).getCol2();
					int col3 = arrlist.get(i).getCol3();
					int x = arrlist.get(i).getXCoordinate();
					int y = arrlist.get(i).getYCoordinate();
					int size = arrlist.get(i).getSize();
					g.setColor(new Color(col1, col2, col3, 200));
					g.fillOval(x, y, size,size);	  //creates oval (planet)
				}
			}
			else {
				for(int i=0; i < llist.size(); i++) {	 //gets planet parameters
					int col1 = llist.get(i).getCol1();
					int col2 = llist.get(i).getCol2();
					int col3 = llist.get(i).getCol3();
					int x = llist.get(i).getXCoordinate();
					int y = llist.get(i).getYCoordinate();
					int size = llist.get(i).getSize();
					g.setColor(new Color(col1, col2, col3, 200));
					g.fillOval(x, y, size, size);	  //creates oval (planet)
				}
			}
			tm.start();
		}
		
		public void actionPerformed(ActionEvent e) {
			
			if (listType.equals("ArrayList")) {
				for(int i=0; i < arrlist.size(); i++) {
					double velx = arrlist.get(i).getXDirectionVelocity();
					double vely = arrlist.get(i).getYDirectionVelocity();
					arrlist.get(i).updateXCoordinate(velx);
					arrlist.get(i).updateYCoordinate(vely);	
					
					
					// if(i < arrlist.size()-1) {     //attempt at gravity
					// 	double dx = arrlist.get(i+1).getXCoordinate() - arrlist.get(i).getXCoordinate();
					// 	double dy = arrlist.get(i+1).getYCoordinate() - arrlist.get(i).getYCoordinate();
					// 	double dist = Math.sqrt(dx*dx + dy*dy);
					// 	double f = ((((G * arrlist.get(i).getMass()) / dist) * dist));
					// 	double ax = (arrlist.get(i).getXCoordinate() - arrlist.get(i+1).getXCoordinate()) * f;
					// 	double ay = (arrlist.get(i).getYCoordinate() - arrlist.get(i+1).getYCoordinate()) * f;
					// 	arrlist.get(i).updateAll(dt, ax, ay);
					// }
				}
			}
			else {
				for(int i=0; i < llist.size(); i++) {
					double velx = llist.get(i).getXDirectionVelocity();
					double vely = llist.get(i).getYDirectionVelocity();
					llist.get(i).updateXCoordinate(velx);
					llist.get(i).updateYCoordinate(vely);
				}
			}
			repaint();
		}
	}
	


	public static void main(String [] args) throws IOException {
		
		try(BufferedReader br = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)){
			listType = br.readLine();
			scale = Double.parseDouble(br.readLine());
			
			while(br.ready()) {
				String[] temp = (br.readLine()).split(",");
        		String name = temp[0];
        		double mass = Double.parseDouble(temp[1]);
        		int x_coordinate = Integer.parseInt(temp[2]);
        		int y_coordinate = Integer.parseInt(temp[3]);
        		double x_direction_velocity = Double.parseDouble(temp[4]);
        		double y_direction_velocity = Double.parseDouble(temp[5]);
        		int size = Integer.parseInt(temp[6]);
        		
        		if(listType.equals("ArrayList"))
        			arrlist.add(new Planet(name, mass, x_coordinate, y_coordinate, x_direction_velocity, y_direction_velocity, size));
        		else if(listType.equals("LinkedList"))
            		llist.add(new Planet(name, mass, x_coordinate, y_coordinate, x_direction_velocity, y_direction_velocity, size));
        		else {
        			System.out.println("Error: ListType " + "'" + listType + "'" + " is invalid\nAcceptable values are 'ArrayList' or 'LinkedList'\nProgram Exited: Exit Code 1");
        			System.exit(1);
        		}
			}
		}
	
		Visual v = new Visual();		//creates JFrame and Visuals for GUI
		JFrame jf = new JFrame();
		jf.setTitle("Visual");
		jf.setSize(768, 768);
		jf.add(v);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
