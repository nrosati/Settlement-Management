package model;

public class DistanceFormula {
	
	public int distanceFormula(int Ax, int Ay, int Rx, int Ry) {
        int distance = 0;
       
        double subX = Ax-Rx;
        double squareX = Math.pow(subX, 2);
       
        double subY = Ay-Ry;
        double squareY = Math.pow(subY, 2);
       
        double sum = squareX + squareY;

        distance = (int) Math.sqrt(sum);
       
        return distance;
    }

}
