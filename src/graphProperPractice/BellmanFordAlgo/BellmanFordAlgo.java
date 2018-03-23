package graphProperPractice.BellmanFordAlgo;

import java.util.ArrayList;
import java.util.List;
public class BellmanFordAlgo {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	
	public BellmanFordAlgo(List<Edge> edgeList, List<Vertex> vertexList){
		this.edgeList = edgeList;
		this.vertexList = vertexList;
	}
	
	//Significance of n-1 and then nth computation to be checked again
	public void computePath(Vertex sourceVertex){
		sourceVertex.setDistance(0);
		
		for(int i = 0; i< vertexList.size()-1; i++){
			for(Edge edge: edgeList){
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				if(u.getDistance() == Double.MAX_VALUE)
					continue;
				
				double dist = edge.getWeight() + u.getDistance();
				if(v.getDistance()<dist){
					v.setPreviousVertex(u);
					v.setDistance(dist);
				}
			}
		}
		//nth time
		for(Edge edge: edgeList){
			Vertex u = edge.getStartVertex();
			if(u.getDistance() != Double.MAX_VALUE){
				if(hasCycle(edge)){
					System.out.println("Cycle detection- negative cycle present in the graph");
					return;
				}
			}
		}
		
	}
	
	public boolean hasCycle(Edge edge){
		return edge.getStartVertex().getDistance()+edge.getWeight() < edge.getTargetVertex().getDistance();
	}
	
	public List<Vertex> getLeastPath(Vertex targetVertex){
		
		if(targetVertex.getDistance() == Double.MAX_VALUE){
			System.out.println("There is no path to this vertex");
		}
		List<Vertex> leastPathList = new ArrayList<Vertex>();
		Vertex looper = targetVertex;
		while(looper.getPreviousVertex()!=null){
			System.out.print(looper+" - ");
			leastPathList.add(looper);
			looper = looper.getPreviousVertex();
		}
		return leastPathList;
	}


}
