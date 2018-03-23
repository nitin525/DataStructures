package graphProperPractice.DijskrataAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijskrataAlgo {
	
	public void computePath(Vertex sourceVertex){
		
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.add(sourceVertex);
		
		while(!q.isEmpty()){
			Vertex acutalVertex = (Vertex)q.poll();
			for(Edge e : acutalVertex.getAdjacentList()){		
				Vertex neighbourVertex = e.getTargetVertex();
				Double newDistance = acutalVertex.getDistance() +e.getWeight();
				if(neighbourVertex.getDistance()>newDistance){
					//q.remove(acutalVertex);
					neighbourVertex.setPredecessor(acutalVertex);
					neighbourVertex.setDistance(newDistance);
					q.add(neighbourVertex);
				}
			}
			q.remove(acutalVertex);
		}
	}
	
	public List<Vertex> shortestPathToTarget(Vertex targetVertex){
		List<Vertex> shortestPath = new ArrayList<Vertex>();
		for(Vertex vertex = targetVertex; vertex != null ; vertex = vertex.getPredecessor()){
			shortestPath.add(vertex);
		}
		return shortestPath;
	}

}
