package graphProperPractice.dfs;

import java.util.ArrayList;
import java.util.List;

public class mainApp {
	
	public mainApp() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Vertex v1 = new Vertex("first");
		Vertex v2 = new Vertex("second");
		Vertex v3 = new Vertex("third");
		Vertex v4 = new Vertex("fourth");
		Vertex v5 = new Vertex("fifth");
		
		List<Vertex> list = new ArrayList<Vertex>();
		v1.addNeighbour(v3); 
		v1.addNeighbour(v2);
		v3.addNeighbour(v4);
		v4.addNeighbour(v5);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		
		DFS dfs = new DFS();
		dfs.dfs(list);
	}
}
