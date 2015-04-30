package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DijkstraTest {

  private List<Vertex> nodes;
  private List<Edge> edges;

  private ResourceFinder resourcefinder;
  private int nodeCounter = 1;
  private int[][] arrayAt = new int[100][100];
  
  private Vertex vertices;

  @Test
  public void testExcute() {
    nodes = new ArrayList<Vertex>();
    edges = new ArrayList<Edge>();
    //arrayAt = new int[10000][10000];
    
    Map map = Map.getMap();
	Tile[][] field = map.getField();
    
	for(int i = 0; i < 100; i++){
		for(int j = 0; j < 100; j++){
			int tile = field[i][j].getResourceType();
			Vertex location = new Vertex("Location_" + i + "," + j, "Location_" + i + "," + j);
			nodes.add(location);
			//System.out.print(location + " ");
			//System.out.print(nodes.size() + " ");
			//System.out.print(nodeCounter + " ");
			arrayAt[i][j] = nodeCounter;
			nodeCounter++;
			//if(i == 49 && j == 49) System.out.println(nodes.size());
		}
		//System.out.println();
	}
	
	

    
    //for (int i = 0; i < 11; i++) {
      //Vertex location = new Vertex("Node_" + i, "Node_" + i);
      //nodes.add(location);
    //}
	
	int Edge_num = 0;
	

	
	//addLane("Edge_0", finalSource, finalDest, 1);
	//addLane("Edge_1", finalSource-1, finalDest-1, 1);
	//addLane("Edge_2", finalSource-1, finalDest+1, 1);
	//addLane("Edge_3", finalSource+1, finalDest+1, 1);
	//addLane("Edge_4", finalSource+1, finalDest-1, 1);
	
	//for(int i : vertex) {
	//	addLane("Edge_" + i, vertex, verte)
	//}
	
	//Vertex source = nodes[iSource][jSource];
	//Vertex dest = nodes[iDest][jDest];
	
	//int distance = Dijkstra.getDistance(finalSource, finalDest);
	
	
	
	//for(int i = 0; i < 100; i++) {
	//	for(int j = 0; j < 100; j++) {
	//		addLane("Edge_" + Edge_num, finalSource, finalDest, getDistance());
	//	}
	//}

	/*
    addLane("Edge_0", 0, 1, 85);
    addLane("Edge_1", 0, 2, 217);
    addLane("Edge_2", 0, 4, 173);
    addLane("Edge_3", 2, 6, 186);
    addLane("Edge_4", 2, 7, 103);
    addLane("Edge_5", 3, 7, 183);
    addLane("Edge_6", 5, 8, 250);
    addLane("Edge_7", 8, 9, 84);
    addLane("Edge_8", 7, 9, 167);
    addLane("Edge_9", 4, 9, 502);
    addLane("Edge_10", 9, 10, 40);
    
    */
    //addLane("Edge_11", 1, 10, 600);
	
	/*for(int i = 0; i < 100; i++){
		for(int j = 0; j < 100; j++){
			int tile = field[i][j].getResourceType();
			addLane(field[i][j].getName(), i, j, 1);
		} 
	}*/
	addEdge();
	testEdges();
	
	Agent agent = new Agent("Issak", 0, 0);
	Resources resource = new Resources("Food", 50, 50, true);
	
	int iSource = agent.getXLoc();
	int jSource = agent.getYLoc();
	
	int iDest = resource.getLocationX();
	int jDest = resource.getLocationY();
	
	int finalSource = getNode(iSource, jSource);
	int finalDest = getNode(iDest, jDest);

    // Lets check from location Loc_1 to Loc_10
    Graph graph = new Graph(nodes, edges);
    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(nodes.get(finalSource)/*nodes.get(1)*/);
    LinkedList<Vertex> path = dijkstra.getPath(nodes.get(finalDest-1)/*nodes.get(4)*/);
    
    assertNotNull(path);
    assertTrue(path.size() > 0);
    
    for (Vertex vertex : path) {
      System.out.println(vertex);
    }
    
   //System.out.println(nodes.get(9999));
  }

  private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
    Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    edges.add(lane);
  }
  private int getNode(int i, int j) {
		return arrayAt[i][j];
  }
  
  private void addEdge() {
	  int weight = 1;
	  for(int i = 0; i < 99; i++) {
		  for(int j = 0; j < 99; j++) {
			  if(i> 0 && (i-1) <= 99) {
				  addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i-1][j], weight);
			  }
			  if(j>0 && j <= 99) {
				  addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i][j-1], weight);
			  }
			  
			  if(i>=0 && i < 99) {
				  addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i+1][j], weight);
			  }
			  if(j>=0 && j < 99) {
				  addLane("edge_" + i + j, arrayAt[i][j], arrayAt[i][j+1], weight);
			  }
			  weight++;
		  }
	  }
	  System.out.println(arrayAt[99][99]);
  }
  
  private void testEdges(){ 
	  System.out.println(edges.size());
  }
  
  


  
  
 /* private Vertex getNode(int i, int j) {
	  return location[i][j];
  }*/
	//private int testArray(int i, int j) {
		
		//return getNode(i,j);
	//}
} 



	