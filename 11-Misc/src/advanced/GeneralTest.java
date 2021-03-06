package advanced;

import java.util.ArrayList;
import java.util.List;

public class GeneralTest {

	public static void main(String[] args) {
		BNode root1 = new BNode(100);
		root1.left = new BNode(50);
		root1.right = new BNode(300);
		root1.left.left = new BNode(20);
		root1.left.right = new BNode(70);
		List<Integer> first = new ArrayList<Integer>();
		storeInorder(root1, first);
		System.out.println(first);
	}

	public static void storeInorder(BNode node, List<Integer> list) {
		if (node == null)
			return;

		storeInorder(node.left, list);

		list.add(node.data);

		storeInorder(node.right, list);
	}

}
