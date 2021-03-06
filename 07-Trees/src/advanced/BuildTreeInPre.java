package advanced;

public class BuildTreeInPre {
	
	static int preIndex = 0;
	
	public static void main(String[] args) {
		int[] in = {4,2,5,1,6,3};
		int[] pre = {1,2,4,5,3,6};
		BNode root = buildTree(in, pre);
		printInorder(root);
	}
	
	public static BNode buildTree(int[] in, int[] pre){
		BNode root = null;
		return build(root, in, 0, in.length-1, pre);
	}
	
	public static BNode build (BNode root, int[] in, int inStart, int inEnd, int[] pre){
		
		if(inStart > inEnd)
		     return null;
		System.out.println("preIndex is : "+ preIndex);
		int rootData = pre[preIndex];
		root = new BNode(rootData);
		
		preIndex = preIndex + 1;
		
		
		if(inStart == inEnd)
			return root;
		
		int rootIndexIn=-1;
		for (int i = inStart; i<= inEnd; i++){
			if (in[i] == rootData){
				rootIndexIn=i;
				break;
			}
		}
		
		root.left = build(root.left,in, inStart, rootIndexIn-1, pre);
		root.right = build(root.right,in, rootIndexIn+1, inEnd, pre);
		
		
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
