package graphProperPractice.BellmanFordAlgo;

import graphProperPractice.DijskrataAlgorithm.Edge;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private double distance;
	private boolean visited; // not used for Bellman or Dijskrata Algo
	private List<Edge> adjacentEdges;
	private Vertex previousVertex;	
	
	public Vertex(String name){
		this.name = name;
		this.distance = Double.MAX_VALUE;
		this.adjacentEdges = new ArrayList<Edge>();
	}
	
	public void addNeighbour(Edge e){
		this.adjacentEdges.add(e);
	}
	
	@Override
	public String toString(){
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}

	public void setAdjacentEdges(List<Edge> adjacentEdges) {
		this.adjacentEdges = adjacentEdges;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	
}
