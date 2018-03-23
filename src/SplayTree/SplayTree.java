package SplayTree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

	private int size;
	private Node<T> rootNode;
	
	@Override
	public void insert(T data) {
		
		Node<T> temp = this.rootNode;
		Node<T> parentNode = null;
		
		//Finding the right position in the binary Tree
		while(null != temp){
			parentNode = temp;
			if(temp.getData().compareTo(data)<0){
				temp = temp.getRightNode();
			}
			else{
				temp = temp.getLeftNode();
			}
		}
		temp = new Node<T>(data);
		temp.setParentNode(parentNode);
		
		if(parentNode == null){
			this.rootNode = temp;
		}
		else if(parentNode.getData().compareTo(temp.getData())<0){
			parentNode.setRightNode(temp);
		}
		else{
			parentNode.setLeftNode(temp);
		}
		//Using splay process
		splayTree(temp);
		size++;
	}
	
	@Override
	public void getTraversal() {
		if(!isEmpty())
			inOrderTraversal(this.rootNode);
	}
	
	private void inOrderTraversal(Node<T> node){
		if(node.getLeftNode()!=null)
			inOrderTraversal(node.getLeftNode());
		
		System.out.println(node);
		
		if(node.getRightNode()!=null)
			inOrderTraversal(node.getRightNode());	
	}
	
	/**
	 * Splay algorithem for BST to cache recently accessed/ recently inserted items.
	 * @param node
	 */
	private void splayTree(Node<T> node){
		
	}

	/** 
	 * Search and make the item a forerunner for cacheing - Splaying
	 * @see SplayTree.Tree#find(java.lang.Comparable)
	 */
	@Override
	public Node<T> find(T data) {
		// Normal binary search find criteria in iterative approach instaed of recursive.
		Node<T> temp = this.rootNode;

		while(temp !=null){
			if(temp.getData().compareTo(data)<0){
				temp = temp.getLeftNode();
			}
			else if(temp.getData().compareTo(data)>0){
				temp = temp.getRightNode();
			}
			else{
				splayTree(temp);
				return temp;
			}
		}
		
		//Why splay at this point? Just to verify that whatever was root remains root if we do not find anything.
		splayTree(temp);
		return null;
	}
	
	/**
	 * This rotation takes into consideration the parent of the present node as well.
	 * @param node
	 * @return
	 */
	private Node<T> rotateRight(Node<T> node){
		
		return null;
	}
	
	private Node<T> rotateLeft(Node<T> node){
		return null;
	}

/*	
 	private Node<T> rotateRight(Node<T> node){
		Node<T> tempLeftNode= node.getLeftNode();
		Node<T> t = tempLeftNode.getRightNode();
		
		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);
		
		return tempLeftNode;
	}
	
	private Node<T> rotateLeft(Node<T> node){
		Node<T> tempRightNode = node.getRightNode();
		Node<T> t = node.getLeftNode();
		
		tempRightNode.setLeftNode(node);
		node.setRightNode(t);
		return tempRightNode;
	}
*/

	@Override
	public T getMin() {
		if(isEmpty())
			return null;
		else
			return getMinValue(this.rootNode);
	}
	
	private T getMinValue(Node<T> node){
		
		if(node.getLeftNode()!=null)
			return getMinValue(node.getLeftNode());
		else
			return node.getData();
	}

	@Override
	public T getMax() {
		if(this.rootNode == null)
			return null;
		else
			return getMaxValue(this.rootNode);
	}
	
	private T getMaxValue(Node<T> node){
		if(node.getRightNode()!=null)
			return getMaxValue(node.getRightNode());
		else
			return node.getData();
	}
	
	private boolean isEmpty(){
		return (this.rootNode==null) ;
	}
	
	private int getSize(){
		return this.size;
	}
	
	//private 

}
