package advanced;

public class BSTtoDLL {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		
		convertBSTtoDLL2(root);
		System.out.println(head);

	}
	
	private static BNode head;
	private static BNode tail;
	
	// A function to convert given BST to Doubly Linked List. The function
	// sets *head to point to first and *tail to point to last node of converted DLL
	public static void convertBSTtoDLL(BNode root)
	{
	    // Base case
	    if (root == null)
	        return;
	 
	    // First convert the left subtree
	    if (root.left!=null)
	        convertBSTtoDLL(root.left);
	 
	    // Then change left of current root as last node of left subtree
	    root.left = tail;
	 
	    // If tail is not NULL, then set right of tail as root, else current
	    // node is head
	    if (tail!=null)
	        tail.right = root;
	    else
	        head = root;
	 
	    // Update tail
	    tail = root;
	 
	    // Finally, convert right subtree
	    if (root.right!=null)
	        convertBSTtoDLL(root.right);
	}
	
	// A function to convert given BST to Doubly Linked List. The function
		// sets *head to point to first and *tail to point to last node of converted DLL
		public static void convertBSTtoDLL2(BNode root)
		{
		    // Base case
		    if (root == null)
		        return;
		 
		    // First convert the left subtree
		    if (root.left!=null)
		        convertBSTtoDLL(root.left);
		 
		        head = root;
		 
		 
		    // Finally, convert right subtree
		    if (root.right!=null)
		        convertBSTtoDLL(root.right);
		}

}
