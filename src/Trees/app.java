package Trees;

public class app {

	
	public static void main(String[] args) {
		Tree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(-10);
		bst.insert(-50);
		bst.insert(30);
		bst.insert(-55);
		bst.insert(-20);
		bst.insert(-30);
		bst.insert(-5);
		bst.insert(10);
		bst.insert(40);
		bst.insert(35);
		bst.insert(45);
		bst.insert(5);
		bst.insert(15);
		
		System.out.println(bst.getMaxValue());
		System.out.println(bst.getMinValues());
		System.out.println();
		bst.delete(-10);
		System.out.println();
		bst.traversal();
	}
}
