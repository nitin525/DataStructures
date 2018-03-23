package graphProperPractice.dfs;

import java.util.List;
import java.util.Stack;

public class DFS {
	
	public void dfs(List<Vertex> list){
		
		for(Vertex v: list){
			if(!v.isVisited()){
				//dfsWithStack(v);
				dfsWithRecursive(v);
			}
		}
		
		
	}
	
//	private void dfsWithRecursive(Vertex root){
//		
//		if(root.isVisited())
//			return;
//		
//		root.setVisited(true);
//		System.out.println(root.toString());
//		
//		for(Vertex looper : root.getNeighbourList()){
//			if(!looper.isVisited()){
//				looper.setVisited(true);
//				dfsWithRecursive(looper);
//			}
//		}
//	} 
	
	private void dfsWithRecursive(Vertex root){
		
		if(!root.isVisited()){
			System.out.println(root.getData());
			root.setVisited(true);
			for(Vertex v: root.getNeighbourList()){
				if(!v.isVisited()){
					dfsWithRecursive(v);
				}
			}
		}
		
	}
	
	private void dfsWithStack(Vertex root){
		
		Stack<Vertex> s = new Stack<Vertex>();
		
		s.push(root);
		root.setVisited(true);
		
		while(!s.isEmpty()){
			Vertex curr = s.pop();
			System.out.println(curr.toString());
			
			for(Vertex looper : curr.getNeighbourList()){
				if(!looper.isVisited())
					looper.setVisited(true);
					s.push(looper);
			}
		}
	}
}
