
public class DoubleLinkedList {

	public int listLength(DLLNode headNode){
	//	if(headNode==null)
	//		return 0;
		int count = 0;
		DLLNode currentNode = headNode;
		while(currentNode != null){
			currentNode = currentNode.getNext();
			count++;
		}
		return count;
	}
	
	/**
	 * @param headNode
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	public DLLNode insertNodeToList(DLLNode headNode, DLLNode nodeToInsert, int position){
		int size = listLength(headNode);
		
		if(position < 1 || position>size+1)
			return headNode;
		
		if(position==1){
			nodeToInsert.setNext(headNode);
			headNode.setPrev(nodeToInsert);
			return nodeToInsert;
		}
		
		if(headNode!=null){
			DLLNode previousNode = headNode;
			int count=1;
			
			while(count<position-1){
				previousNode = previousNode.getNext();
				count++;
			}
			DLLNode currentNode = previousNode.getNext();
			previousNode.setNext(nodeToInsert);
			nodeToInsert.setNext(currentNode);
			nodeToInsert.setPrev(previousNode);
			if(currentNode != null)
				currentNode.setPrev(nodeToInsert);
		}
		return headNode;
	}
	
	
	/**
	 * @param headNode
	 * @param position
	 * @return
	 */
	public DLLNode deleteNodeFromList(DLLNode headNode, int position){
		int size = listLength(headNode);
		if(position < 1 || position>size+1)
			return headNode;
		
		if(position==1){
			DLLNode currentNode = headNode.getNext();
			headNode = null;
			currentNode.setPrev(null);
			return currentNode;
		}
		
		if(headNode!=null){
			DLLNode previousNode = headNode;
			int count=1;
			
			while(count<position-1){
				previousNode = previousNode.getNext();
				count++;
			}
			DLLNode currentNode = previousNode.getNext();
			DLLNode laterNode = currentNode.getNext();
			
			if (laterNode!=null)
				laterNode.setPrev(previousNode);
			
			previousNode.setNext(laterNode);
			currentNode = null;
		}
		return headNode;
	}
}
