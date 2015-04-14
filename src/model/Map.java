package model;

import java.util.Random;

public class Map {
	private int[][] field;
	private int countAgents;
	private int countBuildings;
	private int countResources;
	private int biomeType;
	private boolean occupied;
	private MapGenerator map;
	
	public Map(){
		map = new MapGenerator();
		countAgents = 1;
		countBuildings = 0;
		countResources = 8000;
		occupied = false;
		biomeType = map.getBiome();
		field = map.getField();
	}
	
	
	
	public int getBuildings(){
		return countBuildings;
	}
	
	public int getAgents(){
		return countAgents;
	}
	public int getResources(){
		return countResources;
	}
	public boolean isOccupied(){
		return occupied;
	}
	

	
	
	

}
