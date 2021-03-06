package basic;


public class T11LevelOrderTraversalSpiralUsingRecursion {

	public static void main(String[] args) {
		BNode root = new BNode(1);
		
		root.left = new BNode(2);
		root.right = new BNode(3);
		
		root.left.left = new BNode(7);
		root.left.right = new BNode(6);
		root.right.left = new BNode(5);
		root.right.right= new BNode(4);
		printLevelOrderSpiral(root);
	}
	/* Function to print level order traversal a tree */
	public static void printLevelOrderSpiral(BNode root) {
		
		 int h = height(root);
		 boolean order = false;
		 for (int i = 1; i <= h; i++){
			 System.out.println("\nThe level "+ i+ " is : ");			 
			 printGivenLevel(root, i, order);
			 order = !order;
		 }
	}

	/* Print nodes at a given level */
	private static void printGivenLevel(BNode root, int level, boolean order) {
		if (root == null)
			return;
		if (level == 1)
			System.out.format("%d ", root.data);
		else if (level > 1) {
			if (order){
				printGivenLevel(root.left, level - 1, order);
				printGivenLevel(root.right, level - 1, order);
			} else {
				printGivenLevel(root.right, level - 1, order);
				printGivenLevel(root.left, level - 1, order);
			}
		}
	}
	
	/* Function to calculate height of a tree */
	public static int height(BNode root) {

		if (root == null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight) {
			return lheight + 1;
		} else
			return rheight + 1;
	}

}
