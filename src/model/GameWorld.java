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
				//System.out.print(field[i][j].getResourceType() + " ");
			}
			//System.out.println();
		}
		
		System.out.println("Are the maps equal? " + same);
		Agent agent = new Agent("Test", 0,0);
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				field[i][j].setResourceType(0);
			}
		}
		
		agent.setAgent(0,0);
		boolean built = agent.buildBuilding(agent.getStorage(), 1, 1);
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				System.out.print(field[i][j].getResourceType() + " ");
			}
			System.out.println();
		}
		System.out.println("Did the building get built? " + built);
	}

}
