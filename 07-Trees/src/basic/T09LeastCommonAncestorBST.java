package basic;


public class T09LeastCommonAncestorBST {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		System.out.println(getLCARecr(root, 10, 14).data);
		System.out.println(getLCAIter(root, 10, 14).data);
	}

	/*
	 * Function to find LCA of n1 and n2. The function assumes that both n1 and
	 * n2 are present in BST
	 */
	public static BNode getLCARecr(BNode root, int n1, int n2) {
		if (root == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (root.data > n1 && root.data > n2)
			return getLCARecr(root.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (root.data < n1 && root.data < n2)
			return getLCARecr(root.right, n1, n2);

        // Or root is the LCA
		return root;
	}

	/*
	 * Function to find LCA of n1 and n2. The function assumes that both n1 and
	 * n2 are present in BST
	 */
	public static BNode getLCAIter(BNode root, int n1, int n2) {
		while (root != null) {
			if (root.data > n1 && root.data > n2)
				root = root.left;
			else if (root.data < n1 && root.data < n2)
				root = root.right;

			else
				break;
		}
		return root;
	}

}
