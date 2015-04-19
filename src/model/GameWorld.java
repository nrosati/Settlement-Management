package model;

public class GameWorld {
	//Map map = Map.getMap();
	//int [][] field = map.getField();
	
	public static void main(String[] args){
		Map map = Map.getMap();
		Map map2 = Map.getMap();
		int [][] field = map.getField();
		int [][] field2 = map2.getField();
		boolean same = true;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(field[i][j] != field2[i][j]) same = false;
				//System.out.print(field[i][j] + " ");
			}
			//System.out.println();
		}
		
		System.out.print("Are the maps equal? " + same);
	}

}
