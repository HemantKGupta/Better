
public class RemoveDuplicatesChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(printAndremoveDuplicateChars("atest"));
	}
	
	public static String printAndremoveDuplicateChars(String str){
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val = str.charAt(i);
			if (char_set[val]) {
				System.out.println(ch);
				str = str.substring(0, i)+ str.substring(i+1);
			}
			char_set[val] = true;
		}		
		return str;
	}

}