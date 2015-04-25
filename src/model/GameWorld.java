package model;

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
		int storage = agent.getStorage();
		System.out.println("Agent's resources = " + storage);
		agent.setAgent(0,0);
		//boolean built = agent.buildBuilding(agent.getStorage(), 1, 1);
		//builds building and returns storage
		Building building = agent.buildBuilding(agent.getStorage(), 1, 1);
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
		System.out.println("Depositing resources...........");
		
		//deposits resources
		agent.depositResources(1);
		storage = agent.getStorage();
		
		System.out.println("Agents resources after deposit = " + storage);
		
		//next prove that agent can collect resources
		
		System.out.println("Agent will then collect food.");
		ResourcesFood food = null;
		agent.gatherResources(food);
		
		agent.getStorage();
		
		System.out.println("Agents resources after collecting resources = " + agent.getStorage());
		
		System.out.println("Next, tests what happens if an agent does not eat for too long.");
		//tests what happens if an agent does not eat, they will become philosophers, which in this game world is no better than death
		//also shows 1 fully implemented need, hunger
		Agent dyingAgent = new AgentWarrior("Socrates", 1, 1);		
		dyingAgent.slowlyDie();
				
	}
}
