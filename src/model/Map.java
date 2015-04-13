package model;

import java.util.Random;

public class Map extends MapGenerator{
	private String[][] field;
	private int countAgents;
	private int countBuildings;
	private int countResources;
	private boolean occupied;
	
			
	public Map() {
		field = new String[100][100];
		countAgents = 1;//Start off with 1 agent?
		countBuildings = 0;
		countResources = 0;//Is this per Agent or for the whole map?
		occupied = false;
		
	}
	
	public String[][] getField(){
		return field;
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
