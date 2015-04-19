import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AgentTest {
	
	@Test
	public void gathererTest(){
		Agent agent1 = new AgentWarrior("gatherer", 0, 0);
		assertEquals("gatherer", agent1.getName());
	}
	
	@Test
	public void gatherResourcesTest() throws InterruptedException {
		Agent agent1 = new AgentWarrior("gatherer", 0, 0);
		Resources food = new ResourcesFood("food", 0,0, true);
		agent1.gatherResources(food);
		assertEquals((Integer)20, agent1.getStorage());
		assertEquals(food, agent1.getResource());
		assertEquals(food, agent1.getResource());
		//System.out.println("food count: " + agent1.gatherResources(food));  
		
	}
	
	@Test
	public void depositResourcesTest() throws InterruptedException{
		Agent agent1 = new AgentWarrior("gatherer", 0, 0);
		Resources food = new ResourcesFood("food", 0,0, true);

		agent1.gatherResources(food);
		assertEquals((Integer)20, agent1.getStorage());
		assertEquals(food, agent1.getResource());
		
		agent1.depositResources();
		assertEquals((Integer)0, agent1.getStorage());
		assertEquals(null, agent1.getResource());
	
		/*
		
		assertEquals(20, World.getTotalFood(0));
		
		agent1.gatherResources(food);
		agent1.depositResources();
		
		assertEquals(40, World.getTotalFood(0));
		
		agent1.gatherResources(food);
		agent1.depositResources();
		
		assertEquals(60, World.getTotalFood(0));
		
		agent1.gatherResources(food);
		agent1.depositResources();
		
		assertEquals(80, World.getTotalFood(0));
		
		agent1.gatherResources(food);
		agent1.depositResources();
		
		assertEquals(100, World.getTotalFood(0));
		*/
	}
	
	
	
}






/*
 * 
 * TEST CASE IS COMMENTED OUT DUE TO AGENT CLASS BEING ABSTRACT
 * IN ORDER TO TEST AGENT AS IT IS NOW, REMOVE ABSTRACT FROM AGENT CLASS
 * 
 * 
 */


/*import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AgentTest {

	@Test
	public void testGetName() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals("Kassimiro", agent1.getName());
		//assertEquals("harrold", agent1.getName()); 		//should output error
	}

	@Test
	public void testGetHealth() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals((Integer) 20, agent1.getHealth());
		//assertEquals((Integer) 19, agent1.getHealth()); 		//should output error
		//assertEquals((Integer) 21, agent1.getHealth()); 		//should output error
	}

	@Test
	public void testGetStrength() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals((Integer) 0, agent1.getStrength());
		//assertEquals((Integer) 1, agent1.getStrength()); 			//should output error
		//assertEquals((Integer) (-1), agent1.getStrength()); 		//should output error 
	}

	@Test
	public void testGetStorage() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals((Integer) 0, agent1.getStrength());
		//assertEquals((Integer) 1, agent1.getStrength()); 		    //should output error
		//assertEquals((Integer) (-1), agent1.getStrength());  		//should output error
	}

	@Test
	public void testGetFaith() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals((Integer) 0, agent1.getStrength());
		//assertEquals((Integer) 1, agent1.getStrength());			//should output error
		//assertEquals((Integer) (-1), agent1.getStrength()); 		//should output error 
	}

	@Test
	public void testGetLocation() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertEquals("10, 10", agent1.getLocation());
		//assertEquals("IDontHaveAPenis", agent1.getLocation()); 		//should output error
		//assertEquals("1, 5", agent1.getLocation()); 					//should output error
	}

/*	@Test
	public void testGetImage() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
	}*/
/*
	@Test
	public void testIsBusy() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertFalse(agent1.isBusy());
	}

	@Test
	public void testIsHungry() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertFalse(agent1.isHungry());
	}

	@Test
	public void testIsDense() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertTrue(agent1.isDense());
	}

	@Test
	public void testIsSelected() {
		Agent agent1 = new Agent("Kassimiro", 10, 10);
		assertFalse(agent1.isSelected());
	}

}
*/