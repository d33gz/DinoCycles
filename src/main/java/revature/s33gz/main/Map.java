package revature.s33gz.main;

public class Map {
	char valid = 'F';
	char invalid = 'E';
	
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
		for (int r = 0; r < island.length; r++) {
			System.out.println("\n");
			for (int c = 0; c < island[r].length; c++) {
				System.out.println("Row: " + r +". Column: " + c +". Value: " + island[r][c] + ".");
			}
		}
		
		
		char beginning = 'B';
		char destination = 'D';
		
		//Starting from Top Left
		island[0][4] = beginning;
		island[2][9] = destination;
		
		System.out.println("\nB has to navigate to D");
		printIsland(island);
		
		//First it needs to know where it is
		int[] whereAmI = currentLocation(island, beginning, destination);
		//Then it needs to move
		whereAmI = moveLocation(island, whereAmI);
		//B needs to reach destination
	}
	
	public static void printIsland(char[][] map) {
		for (int r = 0; r < map.length; r++) {
			if (r > 0) System.out.print("\n");
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
		}
	}
	public static int[] currentLocation(char[][] map, char start, char end) {
		int[] location = new int[2]; 
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == start) {
					int currentRow = r;
					int currentColumn = c;
					location[0] = currentRow;
					location[1] = currentColumn;
				}
				if (map[r][c] == end) {
					System.out.println("Oh wow... you are already there!");
				}
			}
		}
		return location;
	}
	public static int[] moveLocation(char[][] map, int[] location) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				//Try to move right
				//Check if it's an legit space
				if (island[r][c] == '')
			}
		}
	}
}
