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
import java.util.Observable;
import java.util.Timer;

public class Agent {//extends Observable{//Removed abstract for testing purposes
	private String name;
	// private List<Resources> resources;
	protected int strength;
	protected int storage;
	protected int health;
	protected int thirst;
	protected int gold;
	protected int faith;
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	protected int capacity;

	private int locationX;
	private int locationY;

	private boolean dense;
	private boolean busy;
	private boolean hungry;
	private boolean thirsty;
	private boolean paidTax;

	private boolean selected;
	
	private boolean isPhilosopher;

	protected boolean isGatherer;
	protected boolean isWarrior;
	protected boolean isPriest;
	private boolean gatheringFood;
	private boolean gatheringWater;
	private boolean gatheringWood;
	private boolean gatheringGold;
	private boolean walking;
	private boolean depositing;
	
	private int foodCarry;
	private int woodCarry;
	private int goldCarry;
	private int waterCarry;

	private int resource; // the current resource that the agent i
								// carrying. null if none.
	
	private int dx;
	private int dy;
	
	protected int foodCount;
	protected int woodCount;
	protected int goldCount;
	protected int waterStorage;
	
	
	/**
	 * Creates an agent with the given name at the given coordinates.
	 * Starte the agents off with 20 health, 5 food, 20 wood, 10 gold
	 * and 5 water.
	 * @param name
	 * @param locationX
	 * @param locationY
	 */
	public Agent(String name, int locationX, int locationY) {
		this.name = name;
		map = Map.getMap();
		health = 20;
		thirst = 20;
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
		isPhilosopher = false;
		this.walking  = false;
		try {
			this.slowlyDie();
			this.slowlyDehydrate();
			//map.payTaxes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


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

	public Integer getStrength() {
		return this.strength;
	}

	public Integer getStorage() {
		return this.storage;
	}

	public Integer getFaith() {
		return this.faith;
	}

	
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
		return this.locationX;
	}
	
	/**
	 * Returns the Y coordinate of the location
	 * @return
	 */
	public int getYLoc() {
		return this.locationY;
	}

	public boolean isBusy() {
		return this.busy;
	}

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

	public boolean isSelected() {
		return this.selected;
	}
	
	public int getResource() {
		return this.resource;
	}
	
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

	public void gatherResources(int resource) throws InterruptedException {
		if(!this.depositing)
		{
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
							this.setDx(i);
							this.setDy(j);
						}

					}

				}

			}
			this.walking = true;
			ShortestPath path = new ShortestPath(this, getXLoc(),getYLoc(),getDx(),getDy());
			locationX = dx;
			locationY = dy;
			if(resource == 3) {
				this.busy = true;
				for(int i = 0; i <= 20; i++){
					storage = i;
					foodCarry++;	
				}
				if(this.hungry) {
					this.eat();
				}
				this.gatheringFood = true;
			}
			if(resource == 1) {
				this.busy = true;
				for(int i = 0; i <= 20; i++){
					storage = i;
					woodCarry++;	
				}

				this.gatheringWood = true;
			}
			
			if(resource == 2) {
				this.busy = true;
				for(int i = 0; i <= 20; i++){
					storage = i;
					waterCarry++;	
				}
				if(this.thirsty) {
					this.drink();
				}
				this.gatheringWater = true;
			}
			
			if(resource == 4) {
				this.busy = true;
				for(int i = 0; i <= 20; i++){
					storage = i;
					goldCarry++;	
				}
				this.gatheringGold = true;
			}
			
			//setAgent(locationX, locationY);
		}
		else return;

	}
	
	public void setFoodCarry(int d) {
		this.foodCarry -= d;
	}
	
	
	public void setWoodCarry(int d){
		this.woodCarry -= d;
	}
	public void setWaterCarry(int d) {
		this.waterCarry -= d;
	}
	
	public void setGoldCarry(int d) {
		this.goldCarry -= d;
	}
	
	/**
	 * Survival AI, checks the Agents needs and if one isn't meant begins taking health away
	 * work ceases on given tasks until all needs are fulfilled
	 * @throws InterruptedException
	 */
	
	
	public void slowlyDie() throws InterruptedException {
		
		//setChanged();
		//notifyObservers(this);
		
		Thread die = new Thread() {

			public void run() {
				
				for(int i = health; i > 0; i--) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					health--;
					//System.out.println(name + "'s health: " + health);
					if(health <= 5) {
						System.out.println("Your health is getting low. Eat something!");
						hungry = true;
						try {
							gatherResources(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					if(health <= 0) {
						
						System.out.println("Due to a lack of energy, " + name + " has sat down and dedicated his life to philosophy");
						hungry = false;
						isPhilosopher = true;
						//Need to set the resource type of the tile to 8
						int x = locationX;
						int y = locationY;
						field[x][y].setResourceType(8);	
						break;
					}

				}
				//setChanged();
				//notifyObservers();
			}
		};
			
		die.start();
	}
	
	public void slowlyDehydrate() throws InterruptedException {
		
		//setChanged();
		//notifyObservers(this);
		
		Thread dehydrate = new Thread() {

			public void run() {
				
				for(int i = thirst; i > 0; i--) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					thirst--;
					//System.out.println(name + "'s health: " + health);
					if(thirst <= 5) {
						System.out.println("You are dehydrated! Drink water!");
						thirsty = true;
						//Walk Towards Either Building that stores food to eat or to nearest food resource
						try {
							gatherResources(2);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
					
					if(thirst <= 0) {
						
						System.out.println("Due to dehydration, " + name + " has sat down and dedicated his life to philosophy");
						thirsty = false;
						isPhilosopher = true;
						//Need to set the resource type of the tile to 8
						int x = locationX;
						int y = locationY;
						field[x-1][y].setResourceType(8);	
					}
					//setChanged();
					//notifyObservers(this);
				}
		};
			
		dehydrate.start();

	}
	

	
	public boolean isPhilosopher() {
		return this.isPhilosopher;
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
	 * @throws InterruptedException 
	 */
	public boolean depositResources(int resourceType, Building building) throws InterruptedException {
		int closestDistance = 0;
		int min = Integer.MAX_VALUE;
		DistanceFormula calculateDistance = new DistanceFormula();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (field[i][j].getResourceType() == 5) {
					closestDistance = calculateDistance.distanceFormula(getXLoc(), getYLoc(), i, j);
					if (closestDistance < min) {
						min = closestDistance;
						dx = i;
						dy = j;
					}

				}

			}

		}
		ShortestPath path = new ShortestPath(this, getXLoc(),getYLoc(),dx,dy);
		boolean deposited = false;
		if(resourceType == 1){
			locationX = dx;
			locationY = dy;
			building.depositResources(this, 1, woodCarry);
			deposited = true;
			woodCount = 0;
		}
		if(resourceType == 2) {
			locationX = dx;
			locationY = dy;
			building.depositResources(this, 2, waterCarry);
			deposited = true;
			waterCarry = 0;
		}
		if(resourceType == 3){
			locationX = dx;
			locationY = dy;
			building.depositResources(this, 3, foodCarry);
			deposited = true;
			foodCount = 0;
		}
		if(resourceType == 4){
			locationX = dx;
			locationY = dy;
			building.depositResources(this, 4, goldCarry);
			deposited = true;
			goldCount = 0;
		}
		

		//field[dx][dy].setResourceType(5);
		
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
				field[x+1][y].makeImpassable();
				field[x+1][y].setResourceType(build);
				field[x+2][y].makeImpassable();
				field[x+2][y].setResourceType(build);
				field[x+1][y+1].makeImpassable();
				field[x+1][y+1].setResourceType(build);
				field[x+2][y+1].makeImpassable();
				field[x+2][y+1].setResourceType(build);
				this.storage = this.storage - building.getCost();
				map.addBuilding(building);
				built = true;
			}
		}
		return building;
		//
	}
	
	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void eat() {
		if(this.foodCarry != 0) {
			health += foodCarry;
			foodCarry = 0;
		}
		else
			return;
	}
	
	public void drink() {
		if(this.waterCarry != 0) {
			thirst += waterCarry;
			waterCarry = 0;
		}
		else
			return;
	}
	
	public void payTaxes() {
		if(this.goldCarry != 0) {
			gold += goldCarry;
		}
		else
			return;
	}
	
	public int getFoodCount() {
		return this.foodCarry;
	}
	
	public int getGoldCount() {
		return this.goldCarry;
	}
	public int getWoodCount() {
		return this.woodCarry;
	}
	public int getWaterCount() {
		return this.waterCarry;
	}
	
	public void setAgentWalkingFalse() {
		this.walking = false;
	}
	
	public void setAgentWalkingTrue() {
		this.walking = true;
	}
	public boolean isGatheringFood() {
		return this.gatheringFood;
	}
	public boolean isGatheringWood() {
		return this.gatheringWood;
	}
	public boolean isGatheringWater() {
		return this.gatheringWater;
	}
	public boolean isGatheringGold() {
		return this.gatheringGold;
	}
	
	public boolean isDepositing() {
		return this.depositing;
	}
	
	public void setGatheringFood(boolean bool) {
		this.gatheringFood = bool;
	}
	public void setGatheringWood(boolean bool) {
		this.gatheringWood = bool;
	}
	public void setGatheringWater(boolean bool) {
	this.gatheringWater = bool;
	}
	public void setGatheringGold(boolean bool) {
		this.gatheringGold = bool;
	}
	public void setDepositing(boolean bool) {
		this.depositing = bool;
	}


	public int getThirst() {
		return this.thirst;
	}
}
