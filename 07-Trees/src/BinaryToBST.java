import java.util.List;

public class BinaryToBST {

	public static void main(String[] args) {

	}

	public static void storeInorder(BNode node, List<Integer> list) {
		if (node == null)
			return;
		storeInorder(node.left, list);
		list.add(node.data);
		storeInorder(node.right, list);
	}

}