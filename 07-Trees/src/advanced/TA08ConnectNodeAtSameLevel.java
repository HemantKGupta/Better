package advanced;

public class TA08ConnectNodeAtSameLevel {

	public static void main(String[] args) {
		

		TBNode root = new TBNode(5);
		root.left = new TBNode(3);
		root.right = new TBNode(9);
		root.left.left = new TBNode(1);
		root.left.right = new TBNode(4);
		root.right.left = new TBNode(6);
		connectNodes(root);
		System.out.println(root.left.data);
		System.out.println(root.left.next.data);
		
		System.out.println(root.left.left.data);
		System.out.println(root.left.left.next.data);
		System.out.println(root.left.left.next.next.data);
		
	}
	
	public static void connectNodes (TBNode root){
		if (root == null)
			return;
		if (root.left!=null){
			root.left.next = root.right;
		}
		connectNodes(root.right);
		if (root.right != null){
			if( root.next!= null){		
				root.right.next = root.next.left;
			}else {
				root.right.next = null;
			}
		}
		connectNodes(root.left);
	}
}

class TBNode {
	int data;
	TBNode left;
	TBNode right;
	TBNode next;

	public TBNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
	}

}
