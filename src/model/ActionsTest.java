package model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Test;

public class ActionsTest {

	@Test
	public void gatherResourcesTest() throws InterruptedException {
		Map map = Map.getMap(); 
		Tile[][] field = map.getField();
		
		Agent agent1 = new Agent("Scrappy", 5, 5);
		agent1.gatherResources(3);
		
		System.out.println(agent1.getFoodCount());
		System.out.println(map.getWorldFood());
		agent1.gatherResources(3);
		System.out.println(agent1.getFoodCount());
		System.out.println(map.getWorldFood());
	}

}
