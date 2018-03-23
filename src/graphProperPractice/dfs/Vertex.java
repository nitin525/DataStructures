package graphProperPractice.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String data; 
	private boolean visited;
	private List<Vertex> neighbourList;
	
	public Vertex(String data) {
		this.data = data;
		neighbourList = new ArrayList<Vertex>();
	}

	public void addNeighbour(Vertex v){
		neighbourList.add(v);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
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
	
	public String toString(){
		return this.data;
	}


}
