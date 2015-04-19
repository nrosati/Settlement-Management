


public class AgentCollector extends Agent {
	public AgentCollector(String name, int locationX, int locationY/*, Image image*/) {
		super(name, locationX, locationY);
		capacity = 20;
		isGatherer = true;
	}
}
