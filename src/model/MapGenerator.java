package model;
import java.util.Random;

public class MapGenerator {
	private int biomeType;
	private Tile[][] field;
	
	
	public MapGenerator(String difficulty) {
		 int biomeType = randomGen();//Generate the biome type, random number between 0 and 3
		 field = new Tile[100][100];
		 generateMap(difficulty, biomeType);
	}
	/**
	 * Returns an integer representation of the Biome type.
	 * This number is randomly generated.
	 * Author Nick Rosati
	 * @return
	 */
	public int getBiome(){
		return biomeType;
		
	}
	/**
	 * Returns the 2D Tile array representation
	 * of the Map
	 * Author Nick Rosati
	 * @return
	 */
	public Tile[][] getField(){
		return field;
	}
	/**
	 * Returns a string representation of the Biome
	 * Author Nick Rosati
	 * @return
	 */
	public String getBiomeString(){
		String biome = "";
		int biomeNumber = getBiome();
		if(biomeNumber == 0) return biome = "Desert";
		else if(biomeNumber == 1) return biome = "Forest";
		else if(biomeNumber == 2) return biome = "Tundra";
		else if(biomeNumber == 3) return biome = "Grassland";
		else return biome = "Something went wrong";		
	}
	/**
	 * Generates the map.  Takes a string represents a difficulty
	 * and the integer biome type.  It first loops through the 2D tile array
	 * and initializes all the tiles.  Then depending on the difficulty string 
	 * calls generate resources and generates a map with varying numbers of 
	 * resources.
	 * @param difficulty
	 * @param biomeType
	 * @return
	 */
	public Tile[][] generateMap(String difficulty, int biomeType){
		//Initializing tiles only done once
		for(int k = 0; k < 100; k++){
			for(int l = 0; l < 100; l++){
				field[k][l] = new Tile(biomeType);//Call new to place a new tile at location
				field[k][l].setChords(k,l);//Set coordinates of tile 
			}
		}
		
		if(difficulty.equals("easy")){
			generateResources(10000, 1);//Generate 2000 tree tiles
			generateResources(8000, 2);//Generate 3000 water tiles
			generateResources(8000, 3);//Generate 2000 food tiles
			generateResources(5000, 4);//Generate 1000 gold tiles
		}
		
		if(difficulty.equals("medium")){
			generateResources(7000, 1);//Generate 2000 tree tiles
			generateResources(5000, 2);//Generate 3000 water tiles
			generateResources(5000, 3);//Generate 2000 food tiles
			generateResources(3000, 4);//Generate 1000 gold tiles
		}
		
		if(difficulty.equals("hard")){
			generateResources(5000, 1);//Generate 2000 tree tiles
			generateResources(10000, 2);//Generate 3000 water tiles
			generateResources(3000, 3);//Generate 2000 food tiles
			generateResources(2000, 4);//Generate 1000 gold tiles
		}
		
		for(int i = 0; i < 25; i++){
			for(int j = 0; j < 25; j++){
				field[i][j].setResourceType(0);
			}
		}
		for(int i = 0; i < 100; i++){
			field[i][0].setResourceType(2);
			field[i][99].setResourceType(2);
		}
		for(int j = 0; j < 100; j++){
			field[0][j].setResourceType(2);
			field[99][j].setResourceType(2);
		}
		return field;
	}
	/**
	 * Generates the resources and puts them on the map field.
	 * @param numResource Is a count of how many of this resource you want
	 * @param kindResource Is a number representing what resource you want to place
	 * 1 is wood.  2 is water. 3 is food. 4 is gold.
	 */
	public void generateResources(int numResource, int kindResource){
		
		
		int count = numResource;//how many of these resources
		int what = kindResource;//what resource
	
		int i = 50;//Start in the middle of the map
		int j = 50;
		
		while(count > 0){
			int random = randomGen();
			//Move North, place a resource
			if(random == 0 && i < 99){//Out of bounds check
				i++;//Move North
				if(field[i][j].getResourceType() == 0) field[i][j].setResourceType(what); //biomeType); //If empty place
				count--;
			}
			else if(random == 1 && i >0){//So we don't go into a negative part of the array
				i--;
				if(field[i][j].getResourceType() == 0) field[i][j].setResourceType(what);//, biomeType);//If Empty place
				count--;
			}
			else if(random == 2 && j < 99){//Out of bounds check
				j++;//Move east
				if(field[i][j].getResourceType() == 0) field[i][j].setResourceType(what);//, biomeType);//If Empty place
				count--;
			}
			
			else if(random == 3 && j > 0){//So we don't subtract from zero and go out of bounds
				j--;//Move West
				if(field[i][j].getResourceType() == 0) field[i][j].setResourceType(what);//, biomeType);//If empty place
				count--;
			}
				
		}
		
	}
	
	public static void main(String[] args){
		MapGenerator map = new MapGenerator("hard");
		String biome = map.getBiomeString();
		int biomeNum = map.getBiome();
		Tile[][] field = map.getField();
		
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				int tile = field[i][j].getResourceType();
				System.out.print(tile + " ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Generates a random number between 0 and 3
	 * @return
	 */
	public static int randomGen(){
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
