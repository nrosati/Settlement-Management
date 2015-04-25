package model;

import java.util.ArrayList;

public class Move {
	
	protected ArrayList<Integer> moveList; //private List<ICritterMemoryEvent> memories;
	//memories = new LinkedList<ICritterMemoryEvent>();
	protected Tile[][] tile;
	protected ResourceFinder map;
	private MapGenerator map;
	
	public Move(){
		moveList = new ArrayList<Integer>(); 
		tile = map.getField();
		map.placeAgent();
		map.searchResource(3);
	}
	
	public Tile[][] getMap(){
		return tile;
	}
	
	public void placeAgent() {
		updatedField = this.field;
		updatedField[1][1].setResourceType(7);
		//updatedField[1][1].setAgent();
	}

	public Tile[][] getField() {
		return updatedField;
		
	}
	/*public ArrayList updateAgentList() {
		int a;
		int b;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 7){
					a == 7;
				}
			}
		}
		return moveList;
		
	}*/
	
	/*public ArrayList getAgentList() {
		
		return moveList;

		}*/

	public static void main(String[] args) {
		ResourceFinder move = new ResourceFinder();
		Tile[][] testField = move.getField();

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(testField[i][j].getResourceType() + " ");
			}
			System.out.println();
		}
	}
}

