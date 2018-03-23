package graphProperPractice.cycleDetection;

import java.util.List;

public class CycleDetection {

	public void cycleDetection(List<Vertex> vertexList){
		for(Vertex v:vertexList){
			if(!v.isVisited())
				dfs(v);
		}
	}
	
	
	public void dfs(Vertex vertex){
		System.out.println("DFS on VERTEX:"+vertex.getName());
		//vertex is not visited from parent function
		vertex.setBeingVisited(true);
		for(Vertex v:vertex.getNeighbourList()){
			System.out.println("Visiting the neighbours of the vertex--->"+vertex.getName());
			if(v.isBeingVisited()){
				System.out.println("BackWard edge, there is a cycle");
				return;
			}
			if(!v.isVisited()){
				//v.setVisited(true);
				System.out.println("Visiting vertex "+v.getName()+" recursively.");
				dfs(v)  ;
				//v.setVisited(true);
			}
		}
		System.out.println("Set vertex"+ vertex.getName() +" being visited is false : visited is true");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}
}
