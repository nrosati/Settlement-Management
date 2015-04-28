package model;

import static org.junit.Assert.assertEquals;

public class World {
	private static int totalFood;
	private static int totalWater;
	private static int totalWood;
	private static int totalFavor;
	private static Agent agent = new AgentWarrior("Socrates", 1, 1);
	private static Building commandCenter = new Building("Command Center");
	
	public World() {
		
	}
	
	public static int getTotalFood() {
		int food = 0;
		totalFood += food;
		return totalFood;
	}
	
	public static int getTotalWater(int water) {
		totalWater += water;
		return totalWater;
	}
	
	public static int getTotalWood(int wood) {
		totalWood += wood;
		return totalWood;
	}
	
	public static int getTotalFavor(int favor) {
		totalFavor += favor;
		return totalFavor;
	}
	 
	public static void main(String[] args) throws InterruptedException {
		
		// creates a new random map
		// every number generated represents a different obstacle/terrain of the map
		// 0 == grassland
		// 1 == tree
		// 2 == water
		// 3 == food
		// 4 == gold
		// 7 == agent (placed at 1,1)
		// 8 == location of nearest resource (destination)
		
		
		ResourceFinder path = new ResourceFinder();
		Tile testField[][] = path.getField();

		// for loop for testing game map 
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(testField[i][j].getResourceType() + " ");
			}
			System.out.println();
			
		}
		
		//tests what happens if an agent does not eat, they will become philosophers, which in this game world is no better than death
		agent.slowlyDie();
		agent.buildBuilding(resources, x, y)
		
	}
	
}