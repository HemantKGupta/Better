package advanced;

public class BuildTreeInPost {

	public static void main(String[] args) {
		int[] in = { 4, 2, 5, 1, 6, 7, 3, 8 };
		int[] post = { 4, 5, 2, 6, 7, 8, 3, 1 };
		printInorder(buildTree(in, post));

	}

	public static BNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;

		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public static BNode buildTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootValue = postorder[postEnd];
		BNode root = new BNode(rootValue);
 
		// shouldn't this loop have limit inStart to inEnd
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k
				- inStart, postEnd - 1);

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
