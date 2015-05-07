package model;
import java.awt.Image;
import java.util.Arrays;

public class Building {
	private Image buildingImage;
	private boolean dense;
	private Tile [][] size;
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	private int goldCount;
	private int foodCount;
	private int woodCount;
	private int waterCount;
	private int resourcesCount;
	private Agent agent;
	private String buildingType;
	
	private int cost;
	private int dx;
	private int dy;
	/**
	 * Builds a building based on the passed name
	 * @param building
	 */
	public Building(String building) {
		cost = 10;
		this.size = size;           //formatted incorrectly for now jsut to get something started
		this.dense = dense;
		buildingType = building;
		waterCount = 0;
		goldCount = 0;
		foodCount = 0;
		woodCount = 0;
	}
	/**
	 * Returns the name of the building
	 * this is also the type of the building
	 * @return
	 */
	public String getName(){
		return buildingType;
	}
	/**
	 * Returns the food storage of the building
	 * @return
	 */
	public int getFoodCount(){
		return foodCount;
	}
	
	/**
	 * Returns the cost or the number of 
	 * resources needed to build this building.
	 * Author 
	 * @return
	 */
	public int getCost() {
		return this.cost;
	}
	/**
	 * Returns thes size required for this building
	 * Author 
	 * @return
	 */
	public Tile [][] getSize() {
		return this.size;
	}
	/**
	 * Returns if this building is passable or not
	 */
	public boolean isDense() {
		return this.dense;
	}
	/**
	 * Allows an agent to deposit resources adding them to
	 * this buildings resource count
	 * @param numResources
	 * @throws InterruptedException 
	 */
	/*
	 * This should take an int representing what kind of resource is being deposited.
	 * Then the second int is the number of resources being deposited.
	 * It should then increase the corresponding resource count.
	 */
	public void depositResources(Agent agent1, int resourceType, int numResources) throws InterruptedException{
		int closestDistance = 0;
		int min = Integer.MAX_VALUE;
		DistanceFormula calculateDistance = new DistanceFormula();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (field[i][j].getResourceType() == 5) {
					closestDistance = calculateDistance.distanceFormula(agent1.getXLoc(), agent1.getYLoc(), i, j);
					if (closestDistance < min) {
						min = closestDistance;
						dx = i;
						dy = j;
					}

				}

			}

		}
		ShortestPath path = new ShortestPath(agent1, agent1.getXLoc(),agent1.getYLoc(),dx,dy);
		agent1.setAgentWalkingTrue();
			if(resourceType == 1) {
				woodCount += numResources;
				map.addWood(numResources);
				agent.setDepositing(false);
				agent.setWoodCarry(numResources);
			}
			else if (resourceType == 2) {
				waterCount += numResources;
				map.addWater(numResources);
				agent.setDepositing(false);
				agent.setWaterCarry(numResources);
			}
			
			else if(resourceType == 3){
				foodCount += numResources;
				map.addFood(numResources);
				agent.setDepositing(false);
				agent.setFoodCarry(numResources);
			}
			else if(resourceType == 4) {
				goldCount += numResources;
				map.addGold(numResources);
				agent.setDepositing(false);
				agent.setGoldCarry(numResources);
		}

	}
	
	/**
	 * Returns the current number of resources stored in this building
	 * @return
	 */
	/*public int getStorage() {
		return this.storage;
	}*/
	

}
