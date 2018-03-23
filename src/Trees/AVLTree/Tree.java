package Trees.AVLTree;

public interface Tree<T> {
	
	public void insertNode(T newData);
	public void deleteNode(T deleteData);
	public void traversal();
	public T getMax();
	public T getMin();

}
