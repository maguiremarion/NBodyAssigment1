import java.util.Random;

public class Planet {

	String name;
	double mass;
	int x_coordinate;
	int y_coordinate;
	double x_direction_velocity;
	double y_direction_velocity;
	int size;
	
	int col1;
	int col2;
	int col3;
	
	public Planet(String name,  double mass, int x_coordinate, int y_coordinate, double x_direction_velocity, double y_direction_velocity, int size) {
		this.name = name;
		this.mass = mass;
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
		this.x_direction_velocity = x_direction_velocity;
		this.y_direction_velocity = y_direction_velocity;
		this.size = size;
		Random rand = new Random();	 //randomly creates color for planet
		col1 = rand.nextInt(255);
		col2 = rand.nextInt(255);
		col3 = rand.nextInt(255);
	}
	

	public String getName(){
		return name;
	}
	
	public double getMass() {
		return mass;
	}
	
	public int getXCoordinate() {
		return x_coordinate;
	}
	
	public int getYCoordinate() {
		return y_coordinate;
	}
	
	public double getXDirectionVelocity() {
		return x_direction_velocity;
	}
	
	public double getYDirectionVelocity() {
		return y_direction_velocity;
	}

	public int getCol1() {
		return col1;
	}
	
	public int getCol2() {
		return col2;
	}
	
	public int getCol3() {
		return col3;
	}
	
	public int getSize() {
		return size;
	}
	
	public void updateXCoordinate(double x) {
		x_coordinate += x;
	}
	
	public void updateYCoordinate(double y) {
		y_coordinate += y;
	}
	
	public void updateXDirectionVelocity(double x) {
		x_direction_velocity = x;
	}
	
	public void updateYDirectionVelocity(double y) {
		y_direction_velocity = y;
	}
	
	public void updateAll(double dt, double ax, double ay) {
		
		x_direction_velocity = ax * dt;
		y_direction_velocity = ay * dt;
		
		x_coordinate += x_direction_velocity * dt;
		y_coordinate += y_direction_velocity * dt;
	}
	
}
