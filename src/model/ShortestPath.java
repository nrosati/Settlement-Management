package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ShortestPath {

	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();

	
	private List<String> walk = new ArrayList<String>();
	private int nodeCounter = 1;
	private int[][] arrayAt = new int[100][100];
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	private static Tile[][] walkPath;
	private int lastX;
	private int lastY;
	private int firstX;
	private int firstY;
	private Agent agent;


	LinkedList<Vertex> path;

	public ShortestPath(Agent agent1, int sourceX, int sourceY, int destX, int destY) {
		this.agent = agent1;
		placeVertices();
		placeEdges(sourceX, sourceY, destX, destY);

		int finalSource = getNode(sourceX, sourceY);
		int finalDest = getNode(destX, destY);

		Graph graph = new Graph(nodes, edges);
		Dijkstra dijkstra = new Dijkstra(graph);

		dijkstra.execute(nodes.get(finalSource));
		if(dijkstra.getPath(nodes.get(finalDest-2)) != null)
			path = dijkstra.getPath(nodes.get(finalDest-2));
		else if(dijkstra.getPath(nodes.get(finalDest-1)) != null)
			path = dijkstra.getPath(nodes.get(finalDest-1));
		else
			path = dijkstra.getPath(nodes.get(finalDest));
		
		lastX = sourceX;
		lastY = sourceY;
		firstX = sourceX;
		firstY = sourceY;
		
		Thread one = new Thread() {
		    public void run() {
			int i;
			int j;
			int lastResource = 3;
			String[] str = new String[1000];
		    for (Vertex vertex : path) {
		    	
		    	try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        System.out.println(vertex);
		        String tempString = vertex.toString();
		        str = tempString.split("[^\\d]+");
		        if(field[lastX][lastY] != null){
		        	lastResource = field[lastX][lastY].getResourceType();
		        }
		        
		        i = Integer.parseInt(str[1]);
		        j = Integer.parseInt(str[2]);
		        
		        if(field[i][j].getResourceType()==3) {
		        	
		        }
		        
		        field[i][j].setAgent();
		        
		        
		        
		       /* if(field[i-1][j].getResourceType() == 7)
		        	field[i-1][j].setResourceType(0);
		        
		        if(field[i][j-1].getResourceType() == 7 ) 
		        	field[i][j-1].setResourceType(0);
		        
		        if(field[i+1][j].getResourceType() == 7)
		        	field[i+1][j].setResourceType(0);
		        
		        if(field[i][j+1].getResourceType() == 7)
		        	field[i][j+1].setResourceType(0);*/
		        
		        if(field[lastX][lastY] != null && 
		        		 field[lastX][lastY].getResourceType() != 5 )
		        	field[lastX][lastY].setResourceType(0);
		        if(field[lastX][lastY].getResourceType() == 5)
		        	field[lastX][lastY].setResourceType(5);
		        lastX = i;
		        lastY = j;

		        
		        }
	        agent.setAgentWalkingFalse();
		    }
		};
		
		
		
		
		one.start();


	    }

	public void placeVertices() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				Vertex location = new Vertex("Location_" + i + "," + j,
						"Location_" + i + "," + j);
				nodes.add(location);
				arrayAt[i][j] = nodeCounter;
				nodeCounter++;
			}
		}
	}

	public void placeEdges(int sourceX, int sourceY, int destX, int destY) {
		int weight = 1;
		if(destX < sourceX) {
			int temp = sourceX;
			sourceX = destX;
			destX = temp;
		}
		if(destY < sourceY) {
			int temp = sourceY;
			sourceY = destY;
			destY = temp;
		}
		
		for (int i = sourceX; i <= destX; i++) {
			for (int j = sourceY; j <= destY; j++) {
				if (i > 0 && (i - 1) <= 100 && field[i][j].getResourceType() != 2) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i - 1][j],
							weight);
				}
				if (j > 0 && (j) <= 99 && field[i][j].getResourceType() != 2) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i][j - 1],
							weight);
				}

				if (i >= 0 && i < 99 && field[i][j].getResourceType() != 2) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i + 1][j],
							weight);
				}
				if ((j) >= 0 && j < 99 && field[i][j].getResourceType() != 2) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i][j + 1],
							weight);
				}
				weight++;
			}
		}
	}
	
	public Tile[][] getPath() {
		return ShortestPath.walkPath;
	}
	
	public int getPathInt() {
		return walkPath.length;
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo,
			int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo),
				nodes.get(destLocNo), duration);
		edges.add(lane);
	}

	private int getNode(int i, int j) {
		return arrayAt[i][j];
	}
	

	public static void main(String[] args) {
		//ShortestPath path = new ShortestPath(5,5,20,20);
	}

}

