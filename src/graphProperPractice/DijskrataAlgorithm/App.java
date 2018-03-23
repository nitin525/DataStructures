package graphProperPractice.DijskrataAlgorithm;

import java.util.List;

public class App {

	
	public static void main(String[] args) {
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertex0.addNeighbour(new Edge(1,vertex0,vertex1));
		vertex0.addNeighbour(new Edge(1,vertex0,vertex2));
		vertex1.addNeighbour(new Edge(1,vertex1,vertex2));
		
		DijskrataAlgo da = new DijskrataAlgo();
		
		da.computePath(vertex0);
		List<Vertex> list = da.shortestPathToTarget(vertex2);
		
		System.out.println(list);
	}
}
