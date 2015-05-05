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
	protected int foodCount;
	protected int woodCount;
	protected int goldCount;
	protected int waterStorage;
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

	private int resource; // the current resource that the agent i
								// carrying. null if none.
	
	private int dx;
	private int dy;
	
	private Timer test;


	private Image image;
	/**
	 * Creates an agent with the given name at the given coordinates.
	 * Starte the agents off with 20 health, 5 food, 20 wood, 10 gold
	 * and 5 water.
	 * @param name
	 * @param locationX
	 * @param locationY
	 */
	public Agent(String name, int locationX, int locationY/* , Image image */) {
		this.name = name;
		map = Map.getMap();
		health = 20;
		strength = 0;
		faith = 0;
		storage = 20;//Food Count essentially;
		foodCount = 5;
		woodCount = 20;
		goldCount = 10;
		waterStorage = 5;
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
	/**
	 * Returns the agents name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Returns the health of the agent
	 * @return
	 */
	public Integer getHealth() {
		return this.health;
	}
	/*
	public Integer getStrength() {
		return this.strength;
	}

	/*public Integer getStorage() {
		return this.storage;
	}

	public Integer getFaith() {
		return this.faith;
	}*/
	/**
	 * Returns the X and Y location of the Agent
	 * @return
	 */
	public String getLocation() {
		return (locationX + ", " + locationY);
	}
	
	/**
	 * Returns the X coordinate of the location
	 * @return
	 */
	public int getXLoc() {
		// TODO Auto-generated method stub
		return this.locationX;
	}
	/**
	 * Returns the Y coordinate of the location
	 * @return
	 */
	public int getYLoc() {
		return this.locationY;
	}

	/*
	 * public Image getImage() { return this.image; }
	 */
	/*
	public boolean isBusy() {
		return this.busy;
	}*/
	/**
	 * Returns the boolean if Agent is hungry or not
	 * @return
	 */
	public boolean isHungry() {
		return this.hungry;
	}
	/**
	 * Agents are dense returns its boolean
	 * @return
	 */
	public boolean isDense() {
		return this.dense;
	}
	/*
	public boolean isSelected() {
		return this.selected;
	}
	
	public int getResource() {
		return this.resource;
	}*/
	/**
	 * Sets an agent on the map field at the given location
	 * @param i
	 * @param j
	 */
	public void setAgent(int i, int j){
		field[i][j].setResourceType(7);
	}


	

	/**
	 * Tells the agent to find the nearest given resource,
	 * find the resource, move to it, and collect it
	 * @param resource
	 * @return
	 * @throws InterruptedException
	 */
	/*
	 * Heres what needs to happen in this method.
	 * It needs to take an int, indicating what kind of resource to find.
	 * It needs to find the nearest one and move to it.
	 * When it gets there increase the storage count of the agent by 1.
	 * I think they should have a count for each resource would be easier.
	 * Then make sure you take the tile(field[i][j] and use setResourceType(0)
	 * to set it to 0, this will change it to a default terrain tile and 
	 * update the map.
	 */
		public int gatherResources(int resource) throws InterruptedException {
			this.resource = resource;
			int closestDistance = 0;
			int min = Integer.MAX_VALUE;
			DistanceFormula calculateDistance = new DistanceFormula();
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (field[i][j].getResourceType() == resource) {
						closestDistance = calculateDistance.distanceFormula(getXLoc(), getYLoc(), i, j);
						if (closestDistance < min) {
							min = closestDistance;
							this.dx = i;// These may need to be switched around
							this.dy = j;// These may need to be switched around
						}

					}

				}

			}
			ShortestPath path = new ShortestPath(getXLoc(),getYLoc(),dx,dy);
			/*for (int i = 0; i < capacity; i++) {
				//Thread.sleep(1000); // I want to incorporate the Timer library
									// later because it uses
				this.storage++;
				System.out.println(this.storage); // less resources. For now
													// this should be good.
			}*/
			return this.storage;
		}
	/**
	 * Survival AI, checks the Agents needs and if one isn't meant begins taking health away
	 * work ceases on given tasks until all needs are fulfilled
	 * @throws InterruptedException
	 */
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
				//Need to set the resource type of the tile to 8
			}

		}
	}
	/*This should take a building, whichever building they are close to
	 * you should get the count for that resource you are depositing and add the 
	 * agents current storage of that resource type to the buildings corresponding storage.
	 * Then set the agents storage to 0.
	 */
	/**
	 * Takes a building and a resource to deposit.
	 * Depending on the type of resource the Agent deposits
	 * his current resources at the given building
	 * @param resourceType
	 * @param building
	 * @return
	 */
	public boolean depositResources(int resourceType, Building building) { 
		boolean deposited = false;
		if(resourceType == 1){
			building.depositResources(1, woodCount);
			deposited = true;
			woodCount = 0;
		}
		else if(resourceType == 3){
			building.depositResources(3, foodCount);
			deposited = true;
			foodCount = 0;
		}
		else if(resourceType == 4){
			building.depositResources(4, goldCount);
			deposited = true;
			goldCount = 0;
		}

		
		return deposited;
	}
	/**
	 * Builds a building at the current location.  
	 * Uses the building factory to build a building depending
	 * on the given String.
	 * @param name
	 * @param x
	 * @param y
	 * @return
	 */
	public Building buildBuilding(String name, int x, int y){
		boolean built = false;
		int build =5;
		Building building = new Building(name);
		if(building.getCost() > storage) built = false;
		else if(building.getCost() <= storage){
			//map.addBuilding(building, x, y);
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
				map.addBuilding(building);
				built = true;
			}
		}
		return building;
	}

}
