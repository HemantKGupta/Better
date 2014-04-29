import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeByLL {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		queue.offer(root);
		insert(root, 4);
		insert(root, 6);
		System.out.println(root);
	}

	private static Queue<BNode> queue = new LinkedList<BNode>();

	// Function to insert a new node in complete binary tree
	public static void insert(BNode root, int data) {

		// Create a new node for given data
		BNode temp = new BNode(data);

		// If the tree is empty, initialize the root with new node.
		if (root == null)
			root = temp;

		else {
			// get the front node of the queue.
			BNode front = queue.peek();

			// If the left child of this front node doesn’t exist, set the
			// left child as the new node
			if (front.left == null)
				front.left = temp;

			// If the right child of this front node doesn’t exist, set the
			// right child as the new node
			else if (front.right == null)
				front.right = temp;

			// If the front node has both the left child and right child,
			// Dequeue() it.
			if (front.left != null && front.right != null)
				queue.poll();

		}
		queue.offer(temp);
	}

}
