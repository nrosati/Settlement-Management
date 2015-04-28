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
		storage = 100;
	}
	
	
	public int getCost() {
		return this.cost;
	}
	
	public Tile [][] getSize() {
		return this.size;
	}
	
	public boolean isDense() {
		return this.dense;
	}
	public void depositResources(int resource, int numResources){
		storage += numResources;
	}
	
	

}
