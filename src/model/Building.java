package model;
import java.awt.Image;
import java.util.Arrays;

public class Building {
	private Image buildingImage;
	private boolean dense;
	private Tile [][] size;
	private int goldCount;
	private int foodCount;
	private int woodCount;
	private String buildingType;
	
	private int cost;
	/**
	 * Builds a building based on the passed name
	 * @param building
	 */
	public Building(String building) {
		cost = 10;
		this.size = size;           //formatted incorrectly for now jsut to get something started
		this.dense = dense;
		buildingType = building;
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
	 */
	/*
	 * This should take an int representing what kind of resource is being deposited.
	 * Then the second int is the number of resources being deposited.
	 * It should then increase the corresponding resource count.
	 */
	public void depositResources(int resourceType, int numResources){
		if(resourceType == 1) woodCount += numResources;
		else if(resourceType == 3) foodCount += numResources;
		else if(resourceType ==4) goldCount += numResources;
	}
	/**
	 * Returns the current number of resources stored in this building
	 * @return
	 */
	/*public int getStorage() {
		return this.storage;
	}*/
	

}
