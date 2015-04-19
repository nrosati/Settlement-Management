import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WorldTest {
	
	@Test
	public void getResourcesTest() throws InterruptedException {

		Agent agent1 = new AgentWarrior("gatherer", 0, 0);
		Resources food = new ResourcesFood("food", 0,0, true);


		agent1.gatherResources(food);
		
		assertEquals(20, World.getTotalFood(agent1.depositResources()));
		
		agent1.gatherResources(food);
		
		assertEquals(40, World.getTotalFood(agent1.depositResources()));
		
		agent1.gatherResources(food);
		
		assertEquals(60, World.getTotalFood(agent1.depositResources()));
		
		agent1.gatherResources(food);
		assertEquals(80, World.getTotalFood(agent1.depositResources()));
		
		agent1.gatherResources(food);
		assertEquals(100, World.getTotalFood(agent1.depositResources()));

	}
}