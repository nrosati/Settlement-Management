import java.awt.Image;
import java.util.Arrays;

public abstract class Building {
	private Image buildingImage;
	private boolean dense;
	private Arrays [][] size;
	
	private int cost;
	
	public Building(int cost, Arrays[][] size, boolean dense) {
		this.cost = cost;
		this.size = size;           //formatted incorrectly for now jsut to get something started
		this.dense = dense; 
	}
	
	
	public int getCost() {
		return this.cost;
	}
	
	public Arrays[][] size() {
		return this.size;
	}
	
	public boolean isDense() {
		return this.dense;
	}
	
	
	

}
