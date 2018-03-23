package graph;

import java.util.List;

/**
 * Adjacency Matrix, Adjacency List and Set can
 * implement this class and use the abstract methods.
 * */
public interface Graph {

	enum GraphType{
		DIRECTED,
		UNDIRECTED
	}
	
	void addEdge(int v1, int v2);
	List<Integer> getAdjacentVertices(int v);
	
}
