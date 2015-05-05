package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {

	private List<Vertex> nodes = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();

	
	private List<String> walk = new ArrayList<String>();
	private int nodeCounter = 1;
	private int[][] arrayAt = new int[100][100];
	private static  Map map = Map.getMap(); 
	private static Tile[][] field = map.getField();
	private static Tile[][] walkPath;

	LinkedList<Vertex> path;

	public ShortestPath(int sourceX, int sourceY, int destX, int destY) {
		placeVertices();
		placeEdges(sourceX, sourceY, destX, destY);

		int finalSource = getNode(sourceX, sourceY);
		int finalDest = getNode(destX, destY);

		Graph graph = new Graph(nodes, edges);
		Dijkstra dijkstra = new Dijkstra(graph);

		dijkstra.execute(nodes.get(finalSource));
		path = dijkstra.getPath(nodes.get(finalDest-1));
		
		int i;
		int j;
		String[] str = new String[1000];
		
	    for (Vertex vertex : path) {
	        System.out.println(vertex);
	        String tempString = vertex.toString();
	        str = tempString.split("[^\\d]+");
	        i = Integer.parseInt(str[1]);
	        j = Integer.parseInt(str[2]);
	        
	        //int temp = field[i][j].getResourceType();
	        //field[i][j].setResourceType();
	        //walk();
	        field[i][j].setAgent();
	        
	        //System.out.println(getPath().length);
	        walkPath[i][j].setResourceType(4);
	        
	       // System.out.println(walkPath[i][j]);
	        
	        //System.out.print(walkPath[i][j]);
	     
	        }
	    System.out.print(getPathInt());
	    }
	    
	   //for(int s = 0; s < str.length; s++) {
	//	   System.out.println(str[s]);
	   //}
	    
		//System.out.println(nodes.get(0));
	//}
	
	/*public LinkedList<Vertex> getPath() {
		for (Vertex vertex : path) {
			return vertex;
		}
		return " ";

	}*/

	public void placeVertices() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// int tile = field[i][j].getResourceType();
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
				if (i > 0 && (i - 1) <= 100 && field[i][j].getPassable()) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i - 1][j],
							weight);
				}
				if (j > 0 && (j) <= 99 && field[i][j].getPassable()) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i][j - 1],
							weight);
				}

				if (i >= 0 && i < 99 && field[i][j].getPassable()) {
					addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i + 1][j],
							weight);
				}
				if ((j) >= 0 && j < 99 && field[i][j].getPassable()) {
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
	
	/*public array getPath() {
		
	}*/
	
	public static void main(String[] args) {
		ShortestPath path = new ShortestPath(5,5,20,1);
		//System.out.println("Starting....");
		//path.getPath();
		//System.out.println("Finished!");
		
	}

}
