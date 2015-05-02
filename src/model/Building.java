package model;
import java.awt.Image;
import java.util.Arrays;

public class Building {
	private Image buildingImage;
	private boolean dense;
	private Tile [][] size;
	private int storage;
	private String buildingType;
	
	private int cost;
	
	public Building(String building) {
		cost = 10;
		this.size = size;           //formatted incorrectly for now jsut to get something started
		this.dense = dense;
		buildingType = building;
		storage = 0;
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
	public void depositResources(/*int resource,*/ int numResources){
		storage += numResources;
	}
	/**
	 * Returns the current number of resources stored in this building
	 * @return
	 */
	public int getStorage() {
		return this.storage;
	}
	

}
