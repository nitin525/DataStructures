package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph{

		private int numVertices = 0;
		private GraphType graphType = GraphType.DIRECTED;
		List<GNode> vertexList = new ArrayList<GNode>();
		
		public AdjacencySetGraph(int numVertices, GraphType graphType) {
			this.numVertices = numVertices;
			this.graphType = graphType;
			for(int i=0; i<numVertices ; i++){
				vertexList.add(new GNode(i));
			}
		}
		
		@Override
		public void addEdge(int v1, int v2) {
			if(v1>=numVertices || v1<0
					|| v2>= numVertices || v2<0){
				throw new IllegalArgumentException("addEdge::Invalid Vertex");
			}
			vertexList.get(v1).addEdge(v2);
			if(GraphType.UNDIRECTED==graphType)
				vertexList.get(v2).addEdge(v1);
		}
		@Override
		public List<Integer> getAdjacentVertices(int v) {
			return vertexList.get(v).getAdjacentVertices();
		}
}
