package Trees.AVLTree;

/**
 * @author nitin525
 * AVL tree is a self-balanced tree.
 * Insertion takes the following steps:
 * - Setting the height for a tree
 * - Finding the right position of the element in the tree
 * - Checking the tree is balanced and if not, rectifying the violation
 * Maintaining O(log n) time in searching for any element in any situation
 * Deleting an element and still maintaining the integrity of the tree.
 * 
 * Key Helper methods:
 * 
 * getHeight() - return -1 for the null nodes, useful for most other opertions
 * rotation methods
 * violation rectification
 * insert
 * delete
 * if required, size can be set.
 * Math.max to get the proper height of any node.
 * 
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> implements Tree<T>{

	private Node<T> rootNode;
	
	@Override
	public void insertNode(T newData) {
		rootNode = insertNewNode(rootNode, newData); //important
	}

	/**
	 * 
	 * Involves finding the 
	 * a)proper node to insert data 
	 * b)set the height proper
	 * c)check for balanced tree property
	 * d)perform rotation if required
	 * e)backtrack till the root node
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private Node<T> insertNewNode(Node<T> node, T data){
		if(node == null){
			return new Node<T>(data);
		}
		if(node.getData().compareTo(data)<0)
			node.setLeftChildNode(insertNewNode(node.getLeftChildNode(), data));		
		else
			node.setRightChildNode(insertNewNode(node.getRightChildNode(), data));
		
		node.setHeight(Math.max(height(node.getLeftChildNode()),height(node.getRightChildNode()))+1);
		node = settleViolation(data, node);
		
		return node;
	}
	
	/**
	 * This checks for the 4 rotation conditions possible for an AVL tree
	 * This involes data which is the grandchild data, 
	   its immediate patent data and the grandparent data(which is the variable node in this case)
	 * @param data
	 * @param node
	 * @return
	 */
	private Node<T> settleViolation(T data, Node<T> node){
		int balance = getBalance(node);
		//This is left-left heavy situation - One right rotation
		if(balance>1 && data.compareTo(node.getLeftChildNode().getData())<0)
			return rightRotation(node);
		
		//This is right-right heavy situation - One left rotation
		else if(balance<-1 && data.compareTo(node.getRightChildNode().getData())>0)
			return leftRotation(node);
		
		//This is left-right situation - One  left, one right rotation
		else if(balance>1 && data.compareTo(node.getLeftChildNode().getData())>0){
			node.setLeftChildNode(leftRotation(node.getLeftChildNode()));
			return rightRotation(node);
		}	
		//This is right-left situation- one right, and then one left rotation
		else if(balance<-1 && data.compareTo(node.getRightChildNode().getData())<0){
			node.setRightChildNode(rightRotation(node.getRightChildNode()));
			return leftRotation(node);
		}
		return node;
	}
	
	@Override
	public void deleteNode(T deleteData) {
		
	}

	private int height(Node<T> node){
		if(node == null)
			return -1;
		return node.getHeight();
	}
	
	
	// To check if the right and the left of parent do not differ more/less by a 1
	private int getBalance(Node<T> node){
		if(node == null)
			return 0;
		
		return height(node.getLeftChildNode()) - height(node.getRightChildNode());
	}
	
	private Node<T> rightRotation(Node<T> node){
		
		System.out.println("Rotating to the right...");
		Node<T> tempLeftNode = node.getLeftChildNode();
		Node<T> t = tempLeftNode.getRightChildNode();
		tempLeftNode.setRightChildNode(node);
		node.setLeftChildNode(t);
		
		node.setHeight(Math.max(height(node.getLeftChildNode()),height(node.getRightChildNode()))+1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftChildNode()),height(tempLeftNode.getRightChildNode()))+1);
		
		return tempLeftNode;
	}
	
	private Node<T> leftRotation(Node<T> node){
		System.out.println("Roataing to the left");
		Node<T> tempRightNode = node.getRightChildNode();
		Node<T> t = tempRightNode.getLeftChildNode();
		tempRightNode.setLeftChildNode(node);
		node.setRightChildNode(t);
		
		node.setHeight(Math.max(height(node.getLeftChildNode()),height(node.getRightChildNode()))+1);
		tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftChildNode()),height(tempRightNode.getRightChildNode()))+1);
		
		return tempRightNode;
	}
	
	
	@Override
	public void traversal() {
		if(rootNode!=null)
			inOrderTraversal(rootNode);
		return;
	}
	
	/**
	 * @param node
	 */
	private void inOrderTraversal(Node<T> node){
		if(node.getLeftChildNode()!=null)
			inOrderTraversal(node.getLeftChildNode());
		
		System.out.println(node.getData());
		
		if(node.getRightChildNode()!=null)
			inOrderTraversal(node.getRightChildNode());
	}

	@Override
	public T getMax() {
		if(rootNode != null)
			return getMaxValue(rootNode).getData();
		
		return null;
	}

	private Node<T> getMaxValue(Node<T> node){
		if(node.getRightChildNode()!=null)
			return getMaxValue(node.getRightChildNode());
	
		return node;
	}

	@Override
	public T getMin() {
		if(rootNode != null)
			return getMinValue(rootNode).getData();
		return null;
	}
	
	private Node<T> getMinValue(Node<T> node){
		if(node.getLeftChildNode()!=null)
			return getMinValue(node.getLeftChildNode());
		return node;
	}
	
}
