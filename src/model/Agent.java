/*
 * 
 * Abstract Agent Class. In order to test this class, remove the abstract
 * in "public abstract class Agent". This abstract class will be used when the 
 * specific agents are created. As of now, the standard agent is created with a given
 * name, health, strength, and other simple/common agent variables.
 * 
 */
package model;
import java.awt.Image;
import java.util.Timer;

public class Agent {//Removed abstract for testing purposes
	private String name;
	// private List<Resources> resources;
	protected int strength;
	protected int storage;
	protected int health;
	protected int faith;
	private Map map;
	private Tile[][] field;
	protected int capacity;

	private int locationX;
	private int locationY;

	private boolean dense;
	private boolean busy;
	private boolean hungry;
	private boolean selected;
	
	private boolean isPhilosopher;

	protected boolean isGatherer;
	protected boolean isWarrior;
	protected boolean isPriest;

	private Resources resource; // the current resource that the agent i
								// carrying. null if none.

	private Image image;

	public Agent(String name, int locationX, int locationY/* , Image image */) {
		this.name = name;
		map = Map.getMap();
		health = 20;
		strength = 0;
		faith = 0;
		storage = 20;
		field = map.getField();
		capacity = 20;				//EVERETT WE ADDED THIS!!!
		this.locationX = locationX;
		this.locationY = locationY;

		// this.image = image;
		this.dense = true;
		this.busy = false;
		this.hungry = false;
		this.selected = false;

		this.isGatherer = false;
		this.isWarrior = false;
		this.isPriest = false;
	}

	/*
	 * public List<Resources> getResources() { return this.resources; }
	 */

	public String getName() {
		return this.name;
	}

	public Integer getHealth() {
		return this.health;
	}

	public Integer getStrength() {
		return this.strength;
	}

	public Integer getStorage() {
		return this.storage;
	}

	public Integer getFaith() {
		return this.faith;
	}

	public String getLocation() {
		return (locationX + ", " + locationY);
	}
	
	
	public int getXLoc() {
		// TODO Auto-generated method stub
		return this.locationX;
	}
	
	public int getYLoc() {
		return this.locationY;
	}

	/*
	 * public Image getImage() { return this.image; }
	 */

	public boolean isBusy() {
		return this.busy;
	}

	public boolean isHungry() {
		return this.hungry;
	}

	public boolean isDense() {
		return this.dense;
	}

	public boolean isSelected() {
		return this.selected;
	}
	
	public Resources getResource() {
		return this.resource;
	}
	
	public void setAgent(int i, int j){
		field[i][j].setResourceType(7);
	}

	public int gatherResources(Resources resource) throws InterruptedException {
		this.resource = resource;
		for (int i = 0; i < capacity; i++) {
			//Thread.sleep(1000); // I want to incorporate the Timer library
								// later because it uses
			this.storage++;
			System.out.println(this.storage); // less resources. For now
												// this should be good.
		}
		return this.storage;
	}
	
	public void slowlyDie() throws InterruptedException {
		
		for(int i = this.health; i > 0; i--) {
			Thread.sleep(100);
			this.health--;
			System.out.println("health: " + this.health);
			if(this.health <= 5) {
				System.out.println("Your health is getting low. Eat something!");
				this.hungry = true;
				//Walk Towards Either Building that stores food to eat or to nearest food resource
				if(this.storage > 0) {
					System.out.println("Agent stops work to eat.");
					System.out.println("Eating...");
					this.health += this.storage;
					if(this.health >= 20) {
						int remainder = (this.health-this.storage);
						this.health = 20;
						this.storage = remainder;
						i=(this.health+1);
					}
					else {
						this.storage = 0;
						i=(this.health+1);
					}
					
				}
				
			}
			
			if(this.health == 0) {
				System.out.println("Due to a lack of energy, " + this.name + " has sat down and dedicated his life to philosophy");
				this.hungry = false;
				this.isPhilosopher = true;
			}

		}
	}
	
	public boolean depositResources(int resourceType, Building building) { 
		boolean deposited = false;
		storage = 0;
		deposited = true;
		building.depositResources(resourceType);
		
		return deposited;
	}
	
	public Building buildBuilding(String name, int x, int y){
		boolean built = false;
		int build =5;
		Building building = new Building(name);
		if(building.getCost() > storage) built = false;
		else if(building.getCost() <= storage){
			map.addBuilding(building, x, y);
			if(name.equals("StoreHouse"))build = 5;
			if(name.equals("Barracks"))build = 6;
			if(field[x][y].getPassable() && field[x+1][y].getPassable() 
					&& field[x][y+1].getPassable() && field[x+1][y+1].getPassable()){
				field[x][y].makeImpassable();
				field[x][y].setResourceType(build);
				field[x+1][y].makeImpassable();
				field[x+1][y].setResourceType(build);
				field[x][y+1].makeImpassable();
				field[x][y+1].setResourceType(build);
				field[x+1][y+1].makeImpassable();
				field[x+1][y+1].setResourceType(build);
				this.storage = this.storage - building.getCost();
				built = true;
			}
		}
		return building;
	}

}
