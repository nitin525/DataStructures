
public class CLList {

	private ListNode headNode;	
		
	public ListNode getHeadNode() {
		return headNode;
	}

	public void setHeadNode(ListNode headNode) {
		this.headNode = headNode;
	}

	/**
	 * @param headNode
	 * @return
	 */
	public int listLength(ListNode headNode){
		int count=0;
		ListNode currentNode = headNode;
		while(currentNode!=null){
			count++;
			if(currentNode.getNext() == headNode)
				break;
		}
		return count;
	}
	
	public void printList(ListNode headNode){
		ListNode currentNode = headNode;
		System.out.println("Circular List Elements:");
		while(currentNode != null){
			System.out.println("Node :"+currentNode.getData());
			currentNode = currentNode.getNext();
			if(currentNode == headNode)
				break;
		}
		
	}
	
	public void insertNodeAtLast(ListNode headNode, ListNode nodeToInsert){
		if(headNode==null){
			nodeToInsert.setNext(nodeToInsert);
			headNode = nodeToInsert;
			//return headNode;
		}
		
		ListNode currentNode = headNode;
		while(currentNode.getNext() != headNode){
			currentNode = currentNode.getNext();
		}
			
		currentNode.setNext(nodeToInsert);
		nodeToInsert.setNext(headNode);
		//return headNode;
	}
	
	public void insertNodeAtFirst(ListNode headNode, ListNode nodeToInsert){
		if(headNode==null){
			nodeToInsert.setNext(nodeToInsert);
			headNode = nodeToInsert;
		}
		ListNode currentNode = headNode;
		
		while(currentNode.getNext()!= headNode){
			currentNode = currentNode.getNext();
		}
		
		nodeToInsert.setNext(headNode);
		currentNode.setNext(nodeToInsert);
		headNode = nodeToInsert;
	}
}
