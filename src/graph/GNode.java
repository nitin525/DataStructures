package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GNode {
	private int vertexNumber;
	private Set<Integer> adjacencySet = new HashSet<Integer>();
	
	public GNode(int vertexNumer) {
		this.vertexNumber = vertexNumer;
	}
	
	public int getVertexNumber(){
		return vertexNumber;
	}
	
	public void addEdge(int vertexNumber){
		adjacencySet.add(vertexNumber);
	}
	
	public List<Integer> getAdjacentVertices(){
		List<Integer> sortedList = new ArrayList<Integer>(adjacencySet);
		Collections.sort(sortedList);
		return sortedList;
	}
	
}
