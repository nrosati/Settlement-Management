package model;

public class GameWorld {
	//Map map = Map.getMap();
	//int [][] field = map.getField();
	
	public static void main(String[] args){
		Map map = Map.getMap();
		Map map2 = Map.getMap();
		Tile [][] field = map.getField();
		Tile [][] field2 = map2.getField();
		boolean same = true;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(field[i][j].getResourceType() != field2[i][j].getResourceType()) same = false;
				System.out.print(field[i][j].getResourceType() + " ");
			}
			System.out.println();
		}
		
		System.out.print("Are the maps equal? " + same);
	}

}
