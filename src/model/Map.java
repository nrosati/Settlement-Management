package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Map {
	private Tile[][] field;
	private int countAgents;
	private int countBuildings;
	private int countResources;
	private int biomeType;
	private boolean occupied;
	private MapGenerator mapGen;
	private static Map map = new Map();
	private final String difficulty = ("easy");
	private BufferedImage mapImage;
	
	/**
	 * We use the singleton design pattern to create our map.
	 * This class uses MapGenerator to actually generate the
	 * map.
	 * Author Nick Rosati  
	 * @return
	 */
	public static Map getMap(){
		return map;
	}
	private Map(){
		mapGen = new MapGenerator(difficulty);
		field = mapGen.getField();
		biomeType = mapGen.getBiome();	
		countAgents = 1;
		countBuildings = 0;
		countResources = resourceCounter();
		occupied = false;		
		drawMap();
	}
	
	

	/**
	 * Counts the number of resources on the map.
	 * Author Nick Rosati
	 * @return
	 */
	public int resourceCounter() {
		int resources = 0;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(field[i][j].getResourceType() != 0) countResources++;
			}
		}
		
		return resources;
	}
	/**
	 * Returns the 2D Tile array representation of the Map
	 * Author Nick Rosati
	 * @return
	 */
	public Tile[][] getField(){
		return field;
	}
	/**
	 * Returns the number of buildings on the map
	 * Author Nick Rosati
	 * @return
	 */
	public int getBuildings(){
		return countBuildings;
	}
	/**
	 * Increments the building count by 1
	 * Author Nick Rosati
	 */
	public void addBuilding(){
		countBuildings++;
	}
	/**
	 * Adds an Agent to the Map
	 * Author Nick Rosati
	 */
	public void addAgent(){
		countAgents++;
	}
	/**
	 * Removes an Agent from the map
	 * Author Nick Rosati
	 */
	public void removeAgent(){
		countAgents--;
	}
	/**
	 * Returns the number of agents on the map
	 * Author Nick Rosati
	 * @return
	 */
	public int getAgents(){
		return countAgents;
	}
	/**
	 * Returns the number of resources on the map
	 * Author Nick Rosati
	 * @return
	 */
	public int getResources(){
		return countResources;
	}
	/**
	 * Draws the tile images to one large bufferedImage
	 */
	public void drawMap(){
		
		mapImage = new BufferedImage(3200,3200, Image.SCALE_SMOOTH);
		Graphics2D g = (Graphics2D) mapImage.getGraphics();
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				field[i][j].drawTile(g, i*32, j*32);
			}
		}
	}
	/**
	 * Returns the mapImage containing all of the tiles painted to 
	 * one large BufferedImage
	 * @return
	 */
	public BufferedImage getMapImage(){
		return mapImage;
	}
	
	
	
	

	
	
	

}
