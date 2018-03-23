package graphProperPractice.DijskrataAlgorithm;

public class Edge {
	
	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;
	
	public Edge(double weight, Vertex sVertex, Vertex targetVertex){
		this.startVertex = sVertex;
		this.targetVertex = targetVertex;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	
}
