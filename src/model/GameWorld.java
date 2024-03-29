package model;

import java.util.Arrays;

import javax.annotation.Resource;

public class GameWorld {
	//Map map = Map.getMap();
	//int [][] field = map.getField();
	
	public static void main(String[] args) throws InterruptedException{
		Map map = Map.getMap();
		Map map2 = Map.getMap();
		Tile [][] field = map.getField();
		Tile [][] field2 = map2.getField();
		boolean same = true;
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				if(field[i][j].getResourceType() != field2[i][j].getResourceType()) same = false;
				//System.out.print(field[i][j].getResourceType() + " ");
			}
			//System.out.println();
		}
		
		System.out.println("Are the maps equal? " + same);
		Agent agent = new Agent("Test", 0,0);
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				field[i][j].setResourceType(0);
			}
		}
		
		System.out.println();
		System.out.println("The following will build a building in location (1,1), made into an empty field with an area of 4");
		
		
		
		int storage = agent.getStorage();
		System.out.println("Agent's resources = " + storage);
		agent.setAgent(0,0);
		//boolean built = agent.buildBuilding(agent.getStorage(), 1, 1);
		//builds building and returns storage

		System.out.println();
		
		Building building = agent.buildBuilding("test", 1, 1);
		for(int i = 0; i < 100; i++){
			for(int j = 0; j < 100; j++){
				System.out.print(field[i][j].getResourceType() + " ");
			}
			System.out.println();
		}
		//System.out.println("Did the building get built? " + built);
		storage = agent.getStorage();
		System.out.println("Agent's resources after building = " + storage);
		

		//informs that resource is being deposited
		System.out.println("Depositing...........");
		agent.depositResources(storage, building);
		int worldStorage = 0;
		System.out.println("Total world storage: " + worldStorage);
		storage = agent.getStorage();
		
		System.out.println("Agents resources after deposit = " + storage);
		
		//next prove that agent can collect resources
		System.out.println();
		
		System.out.println("Agent will then collect food.");
		agent.gatherResources(3);
		
		agent.getStorage();
		
		System.out.println("Agents resources after collecting resources = " + agent.getStorage());
		
		System.out.println("Next, tests what happens if an agent does not eat for too long.");
		System.out.println("Next, tests what happens if an agent does not eat for too long.");
		System.out.println();
		
		System.out.println("Next, tests what happens if an agent does not eat for too long. If agent is carrying any resources and hasnt deposited, it will eat it. Otherwise it will become a philosopher for life");
		//tests what happens if an agent does not eat, they will become philosophers, which in this game world is no better than death
		//also shows 1 fully implemented need, hunger
		Agent dyingAgent = new AgentWarrior("Socrates", 1, 1);		
		dyingAgent.slowlyDie();
		
		System.out.println();
		System.out.println("health actually decreases per second, but lowered the timer to quicken the test");
		System.out.println();
		System.out.println("To test for random map generator, run MapGenerator.java");
				
	}
	
}
