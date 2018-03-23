package Trees;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

	private Node<T> rootNode;
	
	@Override
	public void insert(T insertData) {	
		if(rootNode == null)
			rootNode = new Node<T>(insertData);
		
		else
			insertNode(insertData, rootNode);
	}
	
	@Override
	public T getMaxValue() {
		if(rootNode == null)
			return null;
		
		return getMax(rootNode);
	}

	@Override
	public T getMinValues() {
		if(rootNode == null)
			return null;
		return getMin(rootNode);
	}
	
	/**
	 * Get the proper position to insert this node.
	 * */
	private void insertNode(T insertData, Node<T> node){

		if(insertData.compareTo(node.getData())<0){
			if(node.getLeftNode()!=null)
				insertNode(insertData,node.getLeftNode());
			else
				node.setLeftNode(new Node<T>(insertData));
		}
		else{
			
			if(node.getRightNode()!=null)
				insertNode(insertData,node.getRightNode());
			else
				node.setRightNode(new Node<T>(insertData));
		}
	}

	
	/**
	 * @see Trees.Tree#traversal()
	 */
	@Override
	public void traversal() {
		if(rootNode != null)
			inorderTraversal(rootNode);       
	}
	
	/**
	 * @param rootNode
	 */
	private void inorderTraversal(Node<T> rootNode){
		if(rootNode.getLeftNode()!=null)
			inorderTraversal(rootNode.getLeftNode());
		
		System.out.println(rootNode.getData());
		
		if(rootNode.getRightNode()!=null)
			inorderTraversal(rootNode.getRightNode());
	}
	
	@Override
	public void delete(T deleteData) {
		if(rootNode!=null)
			rootNode = deleteNode(deleteData,rootNode);
	}
	
	/**
	 * The node we want to remove might be a leaf node
	 * The node we want to remove might has a single child
	 * The node we want to remove might have 2 children
	 * */
	private Node<T> deleteNode(T deleteData, Node<T> node){
		if(node == null) 
			return null;
		
		if(deleteData.compareTo(node.getData())<0)
			node.setLeftNode(deleteNode(deleteData, node.getLeftNode()));
		else if(deleteData.compareTo(node.getData())>0)
			node.setRightNode(deleteNode(deleteData, node.getRightNode()));
		
		else{
			//Found a match
			if(node.getLeftNode()==null && node.getRightNode()==null){
				System.out.println("Returning leaf node..");
				node = null;
			}
			else if(node.getLeftNode()==null){
				Node<T> temp = node.getRightNode();
				System.out.println("Removing child");
				node = node.getRightNode();
			}
			else if(node.getRightNode()==null){
				Node<T> temp = node.getLeftNode();
				System.out.println("Removing child");
				node = node.getLeftNode();
			}
			else{
				//has both left and right child // complex case
				Node<T> tempNode = getPredecessor(node.getLeftNode());	
				node.setData(tempNode.getData());
				node.setLeftNode(deleteNode(tempNode.getData(),node.getLeftNode()));
			}
		}
		return node;
	}
	
	
	private Node<T> getPredecessor(Node<T> node){
		if(node.getRightNode()!=null)
			return getPredecessor(node.getRightNode());

		return node;
	}
	
	private T getMax(Node<T> headNode) {
		Node<T> curr = headNode;
			while(curr!=null){
				if(curr.getRightNode()!=null)
					curr = curr.getRightNode();
				else
					break;
			}
		return curr.getData();
	}

	private T getMin(Node<T> headNode) {
		Node<T> curr = headNode;
		while(curr!=null){
			if(curr.getLeftNode()!=null)
				curr = curr.getLeftNode();
			else
				break;
		}
	return curr.getData();
	}

}
