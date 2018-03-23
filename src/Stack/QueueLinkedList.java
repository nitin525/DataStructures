package Stack;

public class QueueLinkedList<T extends Comparable<T>> {

	private Node<T> headNode;
	private Node<T> lastNode;
	private int count;
	
	// O(1)
	public void enqueue(T newData){
		Node<T> oldLastNode = lastNode;
		lastNode = new Node<T>(newData);
		lastNode.setNext(null);		
		
		if(isEmpty())
			this.headNode = this.lastNode;
		else
			oldLastNode.setNext(lastNode);
		
		count++;
	}
	
	//O(1)
	public T dequeue(){
		
		T dataToDequeue = headNode.getData();
		headNode = headNode.getNext();	
		count--;
		
		if(isEmpty())
			this.lastNode = null;
		
		return dataToDequeue;
	}
	
	public boolean isEmpty(){
		return (headNode==null);
	}
	
	public int size(){
		return this.count;
	}
	
	
}
