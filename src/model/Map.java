package model;

import java.util.Random;

public class Map {
	private int[][] field;
	private int countAgents;
	private int countBuildings;
	private int countResources;
	private int biomeType;
	private boolean occupied;
	private MapGenerator mapGen;
	private static Map map = new Map();
	
	public static Map getMap(){
		return map;
	}
	private Map(){
		mapGen = new MapGenerator("easy");
		//countAgents = 1;
		//countBuildings = 0;
		//countResources = resourceCounter();
		//occupied = false;
		//biomeType = mapGen.getBiome();
		field = mapGen.getField();
	}
	
	


	public int resourceCounter() {
		int resources = 0;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(field[i][j] != 0) countResources++;
			}
		}
		
		return resources;
	}
	
	public int[][] getField(){
		return field;
	}
	
	public int getBuildings(){
		return countBuildings;
	}
	
	public void addBuilding(){
		countBuildings++;
	}
	
	public void addAgent(){
		countAgents++;
	}
	
	public void removeAgent(){
		countAgents--;
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
