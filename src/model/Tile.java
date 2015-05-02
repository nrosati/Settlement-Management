package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends JPanel{
	private int x;
	private int y;
	private int resourceType;
	private boolean passable;
	private boolean agent;
	private String picName;
	private static BufferedImage img;
	public Tile(){
		passable = true;
		agent = false;
		resourceType = 0;
		picName = "src/model/dirtTile.png";
		img = null;
	
	}
	public String getName(){
		return picName;
	}
	public void setChords(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setXChord(int x){
		this.x = x;
	}
	
	public void setYChord(int y){
		this.y = y;
	}
	
	public int getXChord(){
		return x;
	}
	
	public int getYChord(){
		return y;
	}
	
	public int getResourceType(){
		return resourceType;
	}
	
	public void setResourceType(int r){
		resourceType = r;
	}
	
	public void setResourceType(int resourceType, int biomeNum){
		this.resourceType = resourceType;
		String biome = "";
		if(biomeNum == 0) biome = "grassLand";
		if(biomeNum == 1) biome = "jungle";
		if(biomeNum == 2) biome = "desert";
		if(biomeNum == 3) biome = "tundra";
		
		if(resourceType == 0) picName = "src/model/dirtTile.png";//biome + "Dirt";
		else if(resourceType == 1) picName = "src/model/treeTile.png";
		else if(resourceType == 2) picName = "src/model/waterTile.png";
		else if(resourceType == 3) picName = "src/model/foodTile.png";
		else if(resourceType == 4) picName = "src/model/goldTile.png";
	}
	
	public boolean getAgent(){
		return agent;
	}
	
	public boolean setAgent(){
		//May want a check in here to make sure that
		//This is a tile an Agent can be placed
		if(passable = true){
			agent = true;
			picName = "Agent";
			return agent;
			
		}
		else return false;
	}
	
	public void makePassable(){
		passable = true;
	}
	
	public void makeImpassable(){
		passable = false;
	}
	
	public boolean getPassable(){
		return passable;		
	}
	public void drawTile(Graphics g){
		try{
			img = ImageIO.read(new File(picName));
		}catch (IOException e){
			e.printStackTrace();
		}
		g.drawImage(img, this.getXChord()*15, this.getYChord()*15,null);
		
				
		
		
	}
	
	
	
}
