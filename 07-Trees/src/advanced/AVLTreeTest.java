package advanced;

public class AVLTreeTest {

	public static void main(String[] args) {
		 ABNode root = null;
		 root = insert(root, 10);
		  root = insert(root, 20);
		  root = insert(root, 30);
		  root = insert(root, 40);
		  root = insert(root, 50);
		  root = insert(root, 25);
		  printInorder(root);
		  

	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	public static ABNode rightRotate(ABNode y) {
		ABNode x = y.left;
		ABNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	public static ABNode leftRotate(ABNode x) {
		ABNode y = x.right;
		ABNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	public static int getBalance(ABNode N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	public static ABNode insert(ABNode node, int key) {
		/* 1. Perform the normal BST rotation */
		if (node == null)
			return (new ABNode(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);

		/* 2. Update height of this ancestor node */
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this
		 * node became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	// A utility function to get height of the tree
	public static int height(ABNode N) {
		if (N == null)
			return 0;
		return N.height;
	}
	
	public static void printInorder(ABNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.key);
		printInorder(node.right);
	}


}
