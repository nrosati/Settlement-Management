package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends Observable{
	private int x;
	private int y;
	private int resourceType;
	private boolean passable;
	private boolean agent;
	private String picName;
	public static Images images = Images.getImageInstance(); // Makes the images
	private static BufferedImage img;

	/**
	 * Tile class.  A tile holds all the information for that piece on the game map.
	 * Mainly x and y coordinates, an image to draw, and what kind of object the tile
	 * is supposed to represent.
	 * Author: Nick Rosati
	 */
	public Tile(){
		passable = true;
		agent = false;
		resourceType = 0;
		picName = "src/model/dirtTile.png";
		img = null;
		
		//setImages();
	}
	

	/**
	 * Returns a string representation of what the tile is 
	 * supposed to represent.
	 * Author: Nick Rosati
	 */
	public String getName(){
		return picName;
	}
	/**
	 * Sets the x and y choordinates of the tile.
	 * These are where in the 2D array this tile is located
	 * Author Nick Rosati
	 * @param x
	 * @param y
	 */
	public void setChords(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Sets the X coordinate of the Tile
	 * Author Nick Rosati
	 * @param x
	 */
	public void setXChord(int x){
		this.x = x;
	}
	/**
	 * Sets the y coordinate of the tile
	 * @param y
	 * Author Nick Rosati
	 */
	public void setYChord(int y){
		this.y = y;
	}
	/**
	 * Returns the X coordinate of the tile
	 * Author Nick Rosati
	 * @return int
	 */
	public int getXChord(){
		return x;
	}
	
	/**
	 * Returns the Y coordinate of the tile
	 * Author Nick Rosati
	 * @return
	 */
	public int getYChord(){
		return y;
	}
	/**
	 * Returns an integer value representing what kind of object
	 * the tile is supposed to represent.
	 * Author Nick Rosati
	 * @return
	 */
	public int getResourceType(){
		return resourceType;
	}
	/**
	 * Sets the integer value for what this tile is supposed to
	 * represent.
	 * Author Nick Rosati
	 * @param r
	 */
	public void setResourceType(int r){
		resourceType = r;
		setChanged();
		notifyObservers(this);
	}
	/**
	 * Sets the integer value for what this tile is supposed to do,
	 * in addition this method take thes random generated
	 * biome number from MapGenerator and changes picName to 
	 * represent the file name for the particular image
	 * for that tile.
	 * @param resourceType
	 * @param biomeNum
	 */
	public void setResourceType(int resourceType, String Name){
		this.resourceType = resourceType;
		
		
	}
	/**
	 * Returns a boolean if the Agent is on this tile or not
	 * Author Nick Rosati
	 * @return
	 */
	public boolean getAgent(){
		return agent;
	}
	/**
	 * Sets the agent on this tile
	 * Author Nick Rosati
	 * @return
	 */
	public boolean setAgent(){
		//May want a check in here to make sure that
		//This is a tile an Agent can be placed
		if(passable = true){
			agent = true;
			picName = "Agent";
			setResourceType(7);
			return agent;
			
		}
		else return false;
	}
	/**
	 * Sets the boolean for this tile to passable,
	 * meaning an Agent can walk on or through this tile
	 * Author Nick Rosati
	 */
	public void makePassable(){
		passable = true;
	}
	/**
	 * Sets the boolean for this Tile to be impassable,
	 * meaning an Agent can not walk through or on this tile
	 * Author Nick Rosati
	 */
	public void makeImpassable(){
		passable = false;
	}
	/**
	 * Returns whether or not this tile is passable
	 * Author Nick Rosati
	 * @return
	 */
	public boolean getPassable(){
		return passable;		
	}
	/**
	 * Changes the image this tile is supposed to have to
	 * match its picName which has been set when the map
	 * is generated.  It then draws this image on a larger image to generate
	 * the visual map
	 * Author Nick Rosati
	 * @param g
	 */
	public void drawTile(Graphics2D g,int x, int y){//(Graphics g)
		if(this.getResourceType() == 1) img = images.getTree();
		else if(this.getResourceType() == 2) img = images.getWater();
		else if(this.getResourceType() == 3) img = images.getFood();
		else if(this.getResourceType() == 4) img = images.getGold();
		else if(this.getResourceType() == 7) img = images.getAgentTile();
		else img = images.getDirt();
		int w = 32;
		int h = 32;
		g.drawImage(img, x, y,32,32,null);
	
		
		
				
		
		
	}
	
	
	
}
