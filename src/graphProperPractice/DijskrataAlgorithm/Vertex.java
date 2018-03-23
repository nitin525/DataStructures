package graphProperPractice.DijskrataAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
	
	private String name;
	private boolean visited;
	private List<Edge> adjacentList;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String name){
		this.name = name;
		adjacentList = new ArrayList<Edge>();
	}
	
	public void addNeighbour(Edge e){
		this.adjacentList.add(e);
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

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(List<Edge> adjacentList) {
		this.adjacentList = adjacentList;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Vertex otheVertex) {
		return Double.compare(this.distance, otheVertex.getDistance());
	}
		
	
}
