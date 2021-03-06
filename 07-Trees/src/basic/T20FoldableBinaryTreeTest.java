package basic;


public class T20FoldableBinaryTreeTest {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(9);
		root.right = new BNode(8);
		
		root.left.left = new BNode(7);
		root.right.right = new BNode(4);
		
		root.left.right = new BNode(6);
		root.right.left = new BNode(5);
		
		root.left.right.left = new BNode(3);
		//root.right.left.right = new advanced.BNode(2);
		System.out.println(foldableTreeTest(root));
	}
	
	public static boolean foldableTreeTest(BNode root){
		
		if(root == null)
			return true;
		
		return testFoldable(root.left, root.right);
	}
	
	private static boolean testFoldable (BNode l, BNode r){
		if (l == null & r == null)
			return true;
		if (l == null && r != null)
			return false;
		if (l != null && r == null)
			return false;
		return testFoldable(l.left, r.right) &&
				testFoldable(l.right,r.left);
	}

}
