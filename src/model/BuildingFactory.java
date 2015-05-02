package model;

public class BuildingFactory extends Factory {

	public BuildingFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Depending on the type of building selected
	 * builds a new kind of that building
	 * Author Nick Rosati
	 */
	public Building buildBuilding(String kindOfBuilding) {
		if(kindOfBuilding.equals("Town Center"))
			return new Building("Town Center");
		else if(kindOfBuilding.equals("Temple"));
			return new Building("Temple");
		
	}

}
