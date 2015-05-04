package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Tile[][] field;
	private ArrayList agents;
	private ArrayList buildings;
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
		agents = new ArrayList<Agent>();
		buildings = new ArrayList<Building>();
		
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
	public ArrayList getBuildings(){
		return buildings;
	}
	/**
	 * Increments the building count by 1
	 * Author Nick Rosati
	 */
	public void addBuilding(Building building, int x, int y){
		buildings.add(building);
		field[x][y].setResourceType(5);//Left Corner
		//field[x+1][y].setResourceType(6);//Right Corner
		//field[x][y+1].setResourceType(9);
		//field[x+1][y+1].setResourceType(10);
	}
	/**
	 * Adds an Agent to the Map
	 * Author Nick Rosati
	 */
	public void addAgent(String name, int x, int y){
		Agent agent = new Agent(name, x, y);
		agents.add(agent);
		field[x][y].setResourceType(7);
	}
	/**
	 * Removes an Agent from the map
	 * Author Nick Rosati
	 */
	public void removeAgent(Agent agent){
		agents.remove(agent);
	}
	/**
	 * Returns the number of agents on the map
	 * Author Nick Rosati
	 * @return
	 */
	public ArrayList getAgents(){
		return agents;
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
	public int getBiome() {
		// TODO Auto-generated method stub
		return biomeType;
	}
	
	
	
	

	
	
	

}
