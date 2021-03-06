package advanced;

import java.util.ArrayDeque;
import java.util.Queue;


public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		BNode root  = new BNode(1);
		  root.left         = new BNode(2);
		  root.right        = new BNode(3);
		  root.left.left   = new BNode(4);
		  System.out.println(isBinaryTreeComplete(root));

	}
	
	public static boolean isBinaryTreeComplete(BNode root){
		if (root == null)
			return true;
		Queue<BNode> queue =  new ArrayDeque<BNode>();
		boolean gotNotFullNode = false;
		queue.add(root);
		
		while(!queue.isEmpty()){
			BNode temp = queue.remove();
			if(temp.left!= null){
				if (gotNotFullNode == true)
					return false;
				queue.add(temp.left);
			}else {
				gotNotFullNode = true;
			}
				
			if(temp.right!= null){
				if (gotNotFullNode == true)
					return false;
				queue.add(temp.right);
			}else{
				gotNotFullNode = true;
			}
		}
		return true;		
	}

}
