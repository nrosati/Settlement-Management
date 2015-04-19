/*
 * 
 * Abstract Agent Class. In order to test this class, remove the abstract
 * in "public abstract class Agent". This abstract class will be used when the 
 * specific agents are created. As of now, the standard agent is created with a given
 * name, health, strength, and other simple/common agent variables.
 * 
 */

import java.awt.Image;
import java.util.Timer;

public abstract class Agent {
	private String name;
	// private List<Resources> resources;
	protected int strength;
	protected int storage;
	protected int health;
	protected int faith;

	protected int capacity;

	private int locationX;
	private int locationY;

	private boolean dense;
	private boolean busy;
	private boolean hungry;
	private boolean selected;

	protected boolean isGatherer;
	protected boolean isWarrior;
	protected boolean isPriest;

	private Resources resource; // the current resource that the agent i
								// carrying. null if none.

	private Image image;

	public Agent(String name, int locationX, int locationY/* , Image image */) {
		this.name = name;

		health = 20;
		strength = 0;
		faith = 0;
		storage = 0;

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

	
	public int depositResources() {
		if(this.resource != null && this.storage > 0) {
			int count = this.storage;
			this.resource = null;
			this.storage = 0;
			return count;
		}
		else return 0;
	}
	
	/*public void depositResource() {

		if (this.resource != null) {
			int test = this.storage;
			World.getTotalFood(test);
			this.resource = null;
			this.storage = 0;
		}
	}*/

	/*
	 * The commented out code in the bottom was me trying to incorporate a
	 * distance formula. But then I realized that it would be better to just
	 * wait for the map formula.
	 */

	// int resourceLocX = resource.getLocationX();
	// int resourceLocY = resource.getLocationY();

	// Timer time = new Timer();

	// return count;
	/*
	 * 
	 * if(this.locationX <= resourceLocX && this.locationY <= resourceLocY) {
	 * for(int i = this.locationX; i < resourceLocX; i++) { for(int j =
	 * this.locationY; j < resourceLocY; j++) {
	 * 
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * else if(this.locationX <= resourceLocX && this.locationY >= resourceLocY)
	 * { for(int i = this.locationX; i < resourceLocX; i++) { for(int j =
	 * this.locationY; j > resourceLocY; j--) {
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * else if(this.locationX >= resourceLocX && this.locationY <= resourceLocY)
	 * { for(int i = this.locationX; i > resourceLocX; i--) { for(int j =
	 * this.locationY; j < resourceLocY; j++) {
	 * 
	 * 
	 * } } }
	 * 
	 * else if(this.locationX >= resourceLocX && this.locationY >= resourceLocY)
	 * { for(int i = this.locationX; i > resourceLocX; i--) { for(int j =
	 * this.locationY; j > resourceLocY; i--) {
	 * 
	 * } }
	 * 
	 * }
	 */

	// return count;

	// }

	/*
	 * public buildWhat(Building building) {
	 * 
	 * }
	 */

}
