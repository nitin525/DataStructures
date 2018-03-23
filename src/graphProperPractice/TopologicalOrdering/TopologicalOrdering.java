package graphProperPractice.TopologicalOrdering;

import java.util.Stack;

public class TopologicalOrdering {
	
	private Stack<Vertex> stack;
	
	public TopologicalOrdering() {
		this.stack = new Stack<Vertex>();
	}
	
	//Very important topological mechanism
	@SuppressWarnings("unused") 
	void dfs(Vertex root){
		root.setVisited(true);
		for(Vertex looper: root.getNeighbourList()){
			if(!looper.isVisited()){
				dfs(looper);
			}
		}
		stack.push(root);
	}

	public Stack<Vertex> getStack() {
		return stack;
	}

	
}
