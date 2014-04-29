public class BuildBSTFromPre {

	public static void main(String[] args) {
		int pre[] = { 10, 5, 1, 7, 40, 50 };
		BNode root = constructTree(pre, pre.length);
		printInorder(root);

	}

	public static int preIndex;
	
	// function to construct BST from given preorder traversal.
	// This function mainly uses constructTreeUtil()
	public static BNode constructTree(int pre[], int size) {
			return constructTreeUtil(pre, 0, size - 1, size);
	}

	// A recursive function to construct Full from pre[]. preIndex is used
	// to keep track of index in pre[].
	public static BNode constructTreeUtil(int pre[], int low, int high, int size) {
		// Base case
		if (preIndex >= size || low > high)
			return null;

		// The first node in preorder traversal is root. So take the node at
		// preIndex from pre[] and make it root, and increment preIndex
		BNode root = new BNode(pre[preIndex]);
		preIndex = preIndex + 1;

		// If the current subarry has only one element, no need to recur
		if (low == high)
			return root;

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i)
			if (pre[i] > root.data)
				break;

		// Use the index of element found in postorder to divide postorder array
		// in
		// two parts. Left subtree and right subtree
		root.left = constructTreeUtil(pre, preIndex, i - 1, size);
		root.right = constructTreeUtil(pre, i, high, size);

		return root;
	}

	

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
