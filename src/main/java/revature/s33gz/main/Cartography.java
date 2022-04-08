package revature.s33gz.main;

import java.util.Arrays;

public class Cartography {
	char[][] map;
	int[] location;

	//Constructor
	public Cartography(char[][] map, int[] location) {
		super();
		this.map = map;
		this.location = location;
	}
	
	//Getters
	public char[][] getMap() {
		return map;
	}
	public int getLocationRow() {
		return location[0];
	}
	public int getLocationColumn() {
		return location[1];
	}
	
	//Setters
	public void setMap(char[][] map) {
		this.map = map;
	}
	public void setLocation(int[] location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Cartography [map=" + Arrays.toString(map) + ", location=" + Arrays.toString(location) + "]";
	}
	
	public String stringifyLocation() {
		return "Location\nColumn: " + location[0] + ". Row: " + location[1];
	}
	
}