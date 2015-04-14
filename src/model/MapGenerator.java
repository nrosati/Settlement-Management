package model;
import java.util.Random;

public class MapGenerator {
	private int biomeType;
	private int[][] field;
	
	
	public MapGenerator() {
		 int biomeRandom = randomGen();
		 field = new int[100][100];
		 generateMap();
	}
	
	public int getBiome(){
		return biomeType;
		
	}
	public int[][] getField(){
		return field;
	}
	public String getBiomeString(){
		String biome = "";
		int biomeNumber = getBiome();
		if(biomeNumber == 0) return biome = "Desert";
		else if(biomeNumber == 1) return biome = "Forest";
		else if(biomeNumber == 2) return biome = "Tundra";
		else if(biomeNumber == 3) return biome = "Grassland";
		else return biome = "Something went wrong";		
	}
	public int[][] generateMap(){
		generateResources(10000, 1);//Generate 2000 tree tiles
		generateResources(8000, 2);//Generate 3000 water tiles
		generateResources(8000, 3);//Generate 2000 food tiles
		generateResources(5000, 4);//Generate 1000 gold tiles
		
		return field;
	}
	/**
	 * Generates the resources and puts them on the map field.
	 * @param numResource Is a count of how many of this resource you want
	 * @param kindResource Is a number representing what resource you want to place
	 * 0 is wood.  1 is water. 2 is food. 3 is gold.
	 */
	public void generateResources(int numResource, int kindResource){
		
		int count = numResource;
		int what = kindResource;
	
		int i = 50;
		int j = 50;
		
		while(count > 0){
			int random = randomGen();
			//Move North, place a resource
			if(random == 0 && i < 99){//Out of bounds check
				i++;//Move North
				if(field[i][j] == 0) field[i][j] = what;//If empty place
				count--;
			}
			else if(random == 1 && i >0){//So we don't go into a negative part of the array
				i--;
				if(field[i][j] == 0) field[i][j] = what;//If Empty place
				count--;
			}
			else if(random == 2 && j < 99){//Out of bounds check
				j++;//Move east
				if(field[i][j] == 0) field[i][j] = what;//If Empty place
				count--;
			}
			
			else if(random == 3 && j > 0){//So we don't subtract from zero and go out of bounds
				j--;//Move West
				if(field[i][j] == 0) field[i][j] = what;//If empty place
				count--;
			}
				
		}
		
	}
	
	public static void main(String[] args){
		MapGenerator map = new MapGenerator();
		String biome = map.getBiomeString();
		int biomeNum = map.getBiome();
		int field[][] = map.getField();
		
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				System.out.print(field[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	public int randomGen(){
		Random gen = new Random();
		int min = 0;
		int max =4;
		int random = gen.nextInt((max - min)) + min;
		return random;
	}
	
	public void Draw(){
		//Not going to be void
		//Will do something in GUI
	}
	
	
	

}
