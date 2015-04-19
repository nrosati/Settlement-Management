package model;

public class Pathfinder {
	private int[][] field;
	private int[][] updatedField;
	private MapGenerator map;
	private boolean collectable;
	private boolean move;

	public Pathfinder() {
		Map map = Map.getMap();
		field = map.getField();
		placeAgent();
		searchResource(3);
		collectable = false;
		move = false;
	}
	
	public double distanceFormula(double Ax, double Ay, double Rx, double Ry) {
        double distance = 0.0;
       
        double subX = Ax-Rx;
        double squareX = Math.pow(subX, 2);
       
        double subY = Ay-Ry;
        double squareY = Math.pow(subY, 2);
       
        double sum = squareX + squareY;

        distance = Math.sqrt(sum);
       
        return distance;
    }

	public void placeAgent() {
		updatedField = this.field;
		updatedField[1][1] = 7;
	}

	public int[][] getField() {
		return updatedField;
	}

	public void searchResource(int resource) { // 3 is food
		// int[][] collectableLocation;
		double min = Double.POSITIVE_INFINITY;
		int i = 0;
		int j = 0;
		int x = 0;
		int y = 0;
		int iterations = 3;
		for (i = 0; i < 100; i++) {
			for (j = 0; j < 100; j++) {
				if (field[i][j] == resource) {
					double distance = distanceFormula(1,1, i, j);
					if(distance < min){
						min = distance;
						x = i;//These may need to be switched around
						y = j;//These may need to be switched around
					}
				}
				
			}
		}
			field[x][y] = 8;
	}

	public static void main(String[] args) {
		// MapGenerator path = new MapGenerator();
		Pathfinder path = new Pathfinder();
		int testField[][] = path.getField();

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(testField[i][j] + " ");
			}
			System.out.println();
		}
	}
}
