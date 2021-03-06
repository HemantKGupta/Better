package basic;

public class T32TrieTest {

	public static void main(String[] args) {
		TrieNode root = new TrieNode();

		insert(root, "TEST");
		insert(root, "TATTER");
		System.out.println(has(root, "TESTW"));
		System.out.println(has(root, "TEST"));
		delete(root, "TEST");
		System.out.println(has(root, "TEST"));
	}

	public static void insert(TrieNode root, String word) {
		int val = word.charAt(0) - 64;
		if (root.c[val] == null) {
			root.c[val] = new TrieNode();
		}
		if (word.length() > 1) {
			insert(root.c[val], word.substring(1));
		} else {
			root.c[val].flag = true;
		}
	}

	public static boolean has(TrieNode root, String word) {
		int val = word.charAt(0) - 64;
		if (root.c[val] != null && word.length() > 1) {
			return has(root.c[val], word.substring(1));
		} else if (root.c[val] == null) {
			return false;
		} else if (root.c[val].flag == true && word.length() == 1) {
			return true;
		}
		return false;
	}

	public static void delete(TrieNode root, String word) {
		int val = word.charAt(0) - 64;
		if (root.c[val] != null && word.length() > 1) {
			delete(root.c[val], word.substring(1));
		} else if (root.c[val] == null) {
			return;
		} else if (root.c[val].flag == true && word.length() == 1) {
			root.c[val].flag = false;
		}
	}

   static class TrieNode {
        public TrieNode[] c;
        public boolean flag = false;

        public TrieNode() {
            c = new TrieNode[26];
        }
    }

}
