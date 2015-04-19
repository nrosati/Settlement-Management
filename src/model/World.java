
public class World {
	private static int totalFood;
	private static int totalWater;
	private static int totalWood;
	private static int totalFavor;
	
	public World() {
		
	}
	
	public static int getTotalFood(int food) {
		totalFood += food;
		return totalFood;
	}
	
	public static int getTotalWater(int water) {
		totalWater += water;
		return totalWater;
	}
	
	public static int getTotalWood(int wood) {
		totalWood += wood;
		return totalWood;
	}
	
	public static int getTotalFavor(int favor) {
		totalFavor += favor;
		return totalFavor;
	}

}
