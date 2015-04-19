package model;
import java.awt.Image;

public abstract class Resources {
	
	private String name;
	private Image resourceImage;
	private int locationX;
	private int locationY;
	private boolean dense;
	
	public Resources(String name, int locationX, int locationY, boolean dense/*,Image image*/) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
		this.dense = dense;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return (this.locationX + ", " + this.locationY);
	}
	
	public Integer getLocationX() {
		return this.locationX;
	}
	
	public Integer getLocationY() {
		return this.locationY;
	}
	
	
	public boolean isDense() {
		return this.dense;
	}

}
