package model;

public class Actions {

	private Agent agent;
	private Tile[][] field;
	private Tile[][] updatedField;
	private ResourceFinder distance;
	
	//private int ax;
	//private int ay;
	private int dx;
	private int dy;

	public Actions(Agent agent, Resources resource) {
		Map map = Map.getMap();
		field = map.getField();
		this.agent = agent;
		//placeAgent();
		//gatherResources(3);
		//gatherResources(agent, resource);
		//ShortestPath path = new ShortestPath(0,0,5,5);
	}
	
	public void placeAgent() {
		updatedField = this.field;
		//updatedField[1][1].setResourceType(7, 0);
		this.field = this.updatedField;
		//updatedField[1][1].setAgent();
	}

	
	public Tile[][] getField() {
		return updatedField;
	}
		
	public String gatherResources(Agent agent, int resource) {
		int closestDistance = 0;
		int min = Integer.MAX_VALUE;
		DistanceFormula calculateDistance = new DistanceFormula();
		
		/*if (agent.isBusy())
			return (agent.getName() + " is doing something else");
		if (agent.isHungry())
			return (agent.getName() + " is too hungry to go look for your shiet");
		if (agent.isPhilosopher())
			return (agent.getName() + " has dedicated his shitty starving life to philosophy");
		else {*/
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (field[i][j].getResourceType() == resource) {
						closestDistance = calculateDistance.distanceFormula(agent.getXLoc(), agent.getYLoc(), i, j);
						if (closestDistance < min) {
							min = closestDistance;
							this.dx = i;// These may need to be switched around
							this.dy = j;// These may need to be switched around
						}

					}

				}

			}

			//return (agent.getName() + " has gone to collect " + resource);

		//}
			
			//field[x][y].setResourceType(8, 0);
			System.out.println(agent.getName() + " has gone to collect some food"  + " agentX: " + agent.getXLoc() + " agentY: " + agent.getYLoc() + " Destx: " + dx + " DestY: " + dy);
			ShortestPath path = new ShortestPath(agent.getXLoc(),agent.getYLoc(),dx,dy);
			
			return (agent.getName() + " has gone to collect some food " +  " agentX: " + agent.getXLoc() + " agentY: " + agent.getYLoc() + " Destx: " + dx + " DestY: " + dy);

	}
	
	/*public static void main(String[] args) {
		DistanceFormula test = new DistanceFormula();
		int distance = test.distanceFormula(3, 5, 4, 20);
		System.out.print(distance);
	}*/
	
	//public static void main(String[] args) {
		// MapGenerator path = new MapGenerator();
		//Actions action = new Actions();
		//Tile testField[][] = action.getField();
		
		//ShortestPath path = new ShortestPath(0,0,5,5);
		//path.getPath();

		/*for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(testField[i][j].getResourceType() + " ");
			}
			System.out.println();*/
		//}
		
		
	//}
	
}
