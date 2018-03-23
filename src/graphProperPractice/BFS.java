package graphProperPractice;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void bfs(Vertex root){
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		root.setVisited(true);
		queue.add(root);
		while(!queue.isEmpty()){
			Vertex current = (Vertex)queue.remove();
			System.out.println(current.getData());
			for(Vertex v : current.getNeighbourList()){
				if(!v.isVisited()){
					queue.add(v);
					v.setVisited(true);
				}
			}
		}
		
		
	}
}
