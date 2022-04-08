package revature.s33gz.main;

public class Map {
	//Map Spaces
	static char valid = 'F';
	static char invalid = 'E';
	static char start = 'S';
	static char destination = 'B';
	static char newLocation = 'L';
	static char oldLocation = 'X';
	//Did we solve it?
	static boolean solved = false;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Island!\n");
		char[][] island = {
			{'E', 'E', 'E', 'E', 'F', 'F', 'F', 'E', 'E', 'E'},
			{'E', 'E', 'F', 'F', 'F', 'F', 'F', 'E', 'F', 'E'},
			{'E', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F'}
		};
		//Basic View
		printIsland(island);
		
		//Technical View
		//printIslandTechnical(island);
		
		//Starting from Top Left
		island[0][4] = start;
		island[2][9] = destination;
		
		System.out.println("\nB has to navigate to D");
		printIsland(island);
		
		//First it needs to know where it is
		int[] whereAmI = currentLocation(island);
		//How to keep track of the Map and Location
		Cartography cartographersWork = new Cartography(island, whereAmI);
		//Then it needs to move to the destination
		while (!solved) {
			cartographersWork = moveLocation(island, whereAmI);
			whereAmI[0] = cartographersWork.getLocationRow();
			whereAmI[1] = cartographersWork.getLocationColumn();
		}
	}
	
	public static char[][] printIsland(char[][] map) {
		System.out.println("Current Map");
		char[][] updatedMap = new char[10][10];
		for (int r = 0; r < map.length; r++) {
			if (r > 0) System.out.print("\n");
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == valid) updatedMap[r][c] = valid;
				else if (map[r][c] == start) updatedMap[r][c] = start;
				else if (map[r][c] == destination) updatedMap[r][c] = destination;
				else if (map[r][c] == newLocation) updatedMap[r][c] = newLocation;
				else if (map[r][c] == oldLocation) updatedMap[r][c] = oldLocation;
				else updatedMap[r][c] = invalid;
				System.out.print(map[r][c] + " ");
			}
		}
		System.out.print("\n");
		return updatedMap;
	}
	public static void printIslandTechnical(char[][] map) {
		for (int r = 0; r < map.length; r++) {
			System.out.println("\n");
			for (int c = 0; c < map[r].length; c++) {
				System.out.println("Row: " + r +". Column: " + c +". Value: " + map[r][c] + ".");
			}
		}
	}
	public static int[] currentLocation(char[][] map) {
		int[] location = new int[2]; 
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == start) {
					int currentRow = r;
					int currentColumn = c;
					location[0] = currentRow;
					location[1] = currentColumn;
				}
				if (map[r][c] == destination && map[r][c] == start) {
					System.out.println("Oh wow... you are already there!");
				}
			}
		}
		return location;
	}
	public static Cartography moveLocation(char[][] map, int[] location) {
		Cartography cartographersPride = new Cartography(map, location); 
		int[] newLocation = new int[2];
		int currentRow = location[0];
		int currentColumn = location[1];
		//Try to move right
		//Check if it's an legit space
		if (map[currentRow][currentColumn+1] == valid || map[currentRow][currentColumn+1] == destination) {
			newLocation[0] = currentRow; newLocation[1] = currentColumn+1;
			//Before moving Check if it's the Destination
			if (checkIfDesination(map, newLocation)) {
				cartographersPride.setLocation(newLocation);
				return cartographersPride;
			}
			map[currentRow][currentColumn] = 'X';
			map[currentRow][currentColumn+1] = 'L';
		} else {
			//Now try to move down
			if (map[currentRow+1][currentColumn] == valid || map[currentRow+1][currentColumn] == destination) {
				newLocation[0] = currentRow+1; newLocation[1] = currentColumn;
				if (checkIfDesination(map, newLocation)) {
					cartographersPride.setLocation(newLocation);
					return cartographersPride;
				}
				map[currentRow][currentColumn] = 'X';
				map[currentRow+1][currentColumn] = 'L';
			}
		}
		char[][] newMap = printIsland(map);
		cartographersPride.setMap(newMap);
		cartographersPride.setLocation(newLocation);
		return cartographersPride;
	}
	public static boolean checkIfDesination(char[][] map, int[] location) {
		if (map[location[0]][location[1]] == destination) {
			System.out.println("You found the TREASURE!!");
			solved = true;
			return true;
		} else {
			return false;
		}
	}
}
