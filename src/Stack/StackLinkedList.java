package Stack;

public class StackLinkedList<T extends Comparable<T>> {
	
	private Node<T> rootNode;
	private int size = 0;
	
	//O(1)
	public void push(T newData){
		this.size++;
		if(this.size == 0)
			this.rootNode = new Node<T>(newData);
		else{
			Node<T> oldNode = rootNode;
			this.rootNode = new Node<T>(newData);
			this.rootNode.setNext(oldNode);
		}
		
	}
	
	//O(1)
	public T peek(){
		return (size!=0)?rootNode.getData():null;
	}
	
	//O(1)
	public T pop(){
		T itemToPop = this.rootNode.getData();
		this.rootNode = rootNode.getNext();
		size--;
		return itemToPop;
	}
	
	//O(1)
	public boolean isEmpty(){
		return this.rootNode==null;
	}
	
	public Node<T> getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node<T> rootNode) {
		this.rootNode = rootNode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
