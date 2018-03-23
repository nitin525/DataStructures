package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	private Node<T> root;
	private int listLength;


	@Override
	public void insert(T data) {
		this.listLength++;

		if(root == null){
			root = new Node(data);
			return;
		}
		else{
			insertDataAtStart(data);
			//insertDataAtEnd(data);
		}

	}
	
	private void insertDataAtStart(T data){
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(root);
		this.root = newNode;
	}
	
	private void insertDataAtEnd(T data){
		//incomplete
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traverseList() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		int count = 0;
		Node<T> temp = root;
		while(temp!=null){
			count++;
			temp = temp.getNextNode();
		}
		return count;
	}

}
