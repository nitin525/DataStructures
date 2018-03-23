package graphProperPractice;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int data;
	private boolean visited;
	private List<Vertex> neighbourList;
	
	public Vertex(int data){
		this.data = data;
		neighbourList = new ArrayList<Vertex>();
	}
	
	public void addNeighbourVertex(Vertex v){
		this.neighbourList.add(v);
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}
	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
	}
	
	
}
