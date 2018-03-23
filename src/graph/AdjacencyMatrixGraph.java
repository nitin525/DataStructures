package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class AdjacencyMatrixGraph implements Graph{
	
	private int[][] adjacencyMatrix;
	private int numVertices = 0;
	private GraphType graphType = GraphType.DIRECTED;


	public AdjacencyMatrixGraph(int numVertices, GraphType graphTYpe){
		this.numVertices = numVertices;
		this.graphType = graphTYpe;
		adjacencyMatrix = new int[numVertices][numVertices];
		for(int i=0;i<numVertices;i++){
			for(int j=0; j<numVertices; j++){
				adjacencyMatrix[i][j]=0;
			}
		}		
	}


	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		if(v1>=numVertices || v2 >=numVertices 
				|| v1 < 0 || v2 <0){
			throw new IllegalArgumentException("addEdge::Vertex number is invalid");
		}

		adjacencyMatrix[v1][v2]=1;
		if(graphType==GraphType.UNDIRECTED)
			adjacencyMatrix[v2][v1]=1;
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if(v>=numVertices || v<0)
			throw new IllegalArgumentException("getAdjacentVertices::Vertex number is invalid");
		
		List<Integer> adjList = new ArrayList<Integer>();
		for(int i =0; i<numVertices ; i++){
			if(adjacencyMatrix[v][i]==1)
				adjList.add(i);
		}
		//Always return the vertices in ascending order.
		Collections.sort(adjList);
		return adjList;
	}
	
	public  void depthFirstTraversal(Graph graph, int[] visited, int currentVertex ){
		if(visited[currentVertex] ==1)
			return;
		visited[currentVertex] = 1;
		List<Integer> listAdjacencies = getAdjacentVertices(currentVertex);
		for(Integer i : listAdjacencies){
			if(visited[i] != 1)
				depthFirstTraversal(graph, visited, i);
		}
		
		System.out.println(currentVertex + "->");
	}
	
	public static void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex){
		
		//Queue<Integer> queue = new Queue<>(Interger.class);
	}

}
