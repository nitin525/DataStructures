package Trees;

public class appCustom {

	public static void main(String[] args) {
		
		Tree<Person> bst = new BinarySearchTree<Person>();
		
		bst.insert(new Person("nitin", 28));
		bst.insert(new Person("computer", 50));
		bst.insert(new Person("neo", 27));
		bst.insert(new Person("alice", 30));
		
		bst.traversal();
	}
}
