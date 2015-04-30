package model;

import java.awt.*;

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
	public Tile(){
		passable = true;
		agent = false;
		resourceType = 0;
		picName = "dirt";
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
		
		if(resourceType == 0) picName = biome + "Dirt";
		else if(resourceType == 1) picName = biome +"Tree";
		else if(resourceType == 2) picName = biome +"Water";
		else if(resourceType == 3) picName = biome + "Food";
		else if(resourceType == 4) picName = biome + "Gold";
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
	public void drawTile(Graphics g, int height, int width){
		File file = new File("src/model/tileTest.png");
		super.paintComponent(g);
		try{
			InputStream is = new BufferedInputStream(new FileInputStream("src/model/tileTest.png"));
			Image image = ImageIO.read(is);
			int x = this.getXChord();
			int y = this.getYChord();
			g.drawImage(image, x, y, height, width, null);//Null is something called ImageObserver?
		} catch (IOException e){e.printStackTrace();}
		
		
			
		
		
	}
	
	
	
}
