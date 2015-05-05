package model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.junit.Test;

public class ActionsTest {

	@Test
	public void gatherResourcesTest() {
		Agent agent1 = new Agent("Scrappy", 5, 5);
		Resources food = new Resources("food", 60, 60, true);
		Actions gather = new Actions(agent1, food);
		System.out.println(gather.gatherResources(agent1, food));
	}

}
