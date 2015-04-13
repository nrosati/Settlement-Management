package model;
import java.util.Random;

public abstract class MapGenerator {
	private int mapType;

	public MapGenerator() {
		Random gen = new Random();
		int min = 0;
		int max =4;
		mapType = gen.nextInt((max - min)) + min;
		
	}
	
	public int generateMap(){
		return mapType;
		
	}
	
	public void Draw(){
		//Not going to be void
		//Will do something in GUI
	}
	
	
	

}
