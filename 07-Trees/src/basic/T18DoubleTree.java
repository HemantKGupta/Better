package basic;


public class T18DoubleTree {

	public static void main(String[] args) {
		BNode root = new BNode(2);
		root.left = new BNode(1);
		root.right = new BNode(3);
		// doubleTree2(root);
		//doubleTree1(root);
		//printInorder(root);

		BNode root2 = new BNode(1);
		root2.left = new BNode(2);
		root2.right = new BNode(3);
		root2.left.left = new BNode(4);
		root2.left.right = new BNode(5);

		// doubleTree2(root2);
		doubleTree1(root2);
		printInorder(root2);

	}

	public static void doubleTree1(BNode root) {
		if (root == null)
			return;

		doubleTree1(root.left);
		doubleTree1(root.right);

		BNode temp = root.left;
		root.left = new BNode(root.data);
		root.left.left = temp;
	}

	public static void doubleTree2(BNode root) {
		if (root == null)
			return;
		
		if (root != null) {
			BNode temp = new BNode(root.data);
			temp.left = root.left;
			root.left = temp;
			doubleTree2(temp.left);
		}
		doubleTree2(root.right);
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
