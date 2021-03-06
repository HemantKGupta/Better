package basic;

public class T28PopulateInorderSuccessorAllNodes {

	public static void main(String[] args) {

		TBNode root = new TBNode(5);
		root.left = new TBNode(3);
		root.right = new TBNode(9);
		root.left.left = new TBNode(1);
		root.left.right = new TBNode(4);
		root.right.left = new TBNode(6);
		addInorderLink(root);
		//addInorderLink2(root, null);
		System.out.println(root.left.left.data);
		System.out.println(root.left.left.next.data);
		System.out.println(root.left.next.data);
		System.out.println(root.left.right.next.data);
		System.out.println(root.next.data);
		System.out.println(root.right.next.data);
	}

	public static TBNode temp = null;
	
	public static void addInorderLink(TBNode tree) {

		if (tree == null)
			return;

		addInorderLink(tree.right);
		tree.next = temp;
		temp = tree;
		addInorderLink(tree.left);

	}

	public static void addInorderLink2(TBNode tree, TBNode old) {

		if (tree != null) {

			addInorderLink2(tree.right, old);
			tree.next = old;
			old = tree;
			addInorderLink2(tree.left, old);
		}

	}

}
