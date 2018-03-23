import java.util.Stack;

public class BinaryTreePracticeStructure {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10= new TreeNode(10);

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		node5.setLeft(node8);
		node5.setRight(node9);
		node7.setRight(node10);

		//preOrder(root);
		//inOrder(root);
		postOrder(root);
		//preOrder_nonR(root);
		//inOrder_nonR(root);
		System.out.println(findMaxInTree(root));
		
	}

	static int findMaxInTree(TreeNode root){
		int root_value,left=0, right=0, max = 0;
		if(null!=root){
			root_value = root.getData();
			left = findMaxInTree(root.getLeft());
			right = findMaxInTree(root.getRight());

			if(left>max)
				max = left;
			else
				max = right;

			if(root_value > max)
				max = root_value;
		}
		return max;
	}

	static void preOrder_nonR(TreeNode root){
		TreeNode temp = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(true){
			while(temp!=null){
				System.out.println(temp.getData());
				s.push(temp);
				temp = temp.getLeft();
			}
			if(s.isEmpty())
				break;
			temp = (TreeNode)s.pop();
			temp = temp.getRight();
		}
		return;
	}

	static void inOrder_nonR(TreeNode rootNode){
		TreeNode root = rootNode;
		Stack<TreeNode> s = new Stack<TreeNode>();

		while(true){
			while(root!=null){
				s.push(root);
				root = root.getLeft();
			}
			if(s.isEmpty())
				break;
			root = s.pop();
			System.out.println(root.getData());
			root = root.getRight(); 
		}
		return;
	}

	static void postOrder_nonR(TreeNode rootNode){
		TreeNode root = rootNode;
		Stack<TreeNode> s = new Stack<TreeNode>();

	}

	static  void levelOrder(TreeNode rootNode){
		//	Queue<TreeNode> q = new <TreeNode>();		
	}

	static void preOrder(TreeNode root){
		if(root!=null){
			System.out.println(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	static void postOrder(TreeNode root){
		if(root!=null){
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	static void inOrder(TreeNode root){
		if(root!=null){
			inOrder(root.getLeft());
			System.out.println(root.getData());
			inOrder(root.getRight());
		}
	}

}
