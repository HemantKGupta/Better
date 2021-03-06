package advanced;

public class BuildFBTPrePost {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int[] post = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		BNode root = null;
		root = constructTree(pre, post);
		printInorder(root);
		// System.out.println(root);

	}

	// construct Full Binary Tree from preorder and postorder
	public static BNode constructTree(int pre[], int post[]) {
		int size = pre.length;
		return constructTreeUtil(pre, post, 0, size - 1, size);
	}

	public static int preIndex;

	//construct Full from pre[] and post[], preIndex is for pre[]
	// l is low index and h is high index for post[]
	public static BNode constructTreeUtil(int pre[], int post[], int l, int h,
			int size) {

		if (preIndex >= size || l > h)
			return null;

		BNode root = new BNode(pre[preIndex]);
		++preIndex;

		if (l == h)
			return root;

		// Search the next element of pre[] in post[]
		int i;
		for (i = l; i <= h; ++i)
			if (preIndex < size && pre[preIndex] == post[i])
				break;

		// Use index to divide postorder array
		if (i <= h) {
			root.left = constructTreeUtil(pre, post, l, i, size);
			root.right = constructTreeUtil(pre, post, i + 1, h, size);
		}

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
