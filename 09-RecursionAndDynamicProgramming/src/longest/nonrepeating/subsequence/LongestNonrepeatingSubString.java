package longest.nonrepeating.subsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestNonrepeatingSubString {

	public static void main(String[] args) {
		System.out.println(getNonrepeatingSubstring("ABDEFGABEF"));
	}
	public static int getNonrepeatingSubstring(String str){
		char[] string = str.toCharArray();
		Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
		int maxLen = 1;
		int currLen = 1;
		int currIndex = 0;
		charIndexMap.put(str.charAt(0), 0);
		for (int i = 1; i < string.length; i++) {
			char c = str.charAt(i);
			if(charIndexMap.containsKey(c)){
				int prevIndex = charIndexMap.get(c);
				if (prevIndex >= currIndex){
					currIndex = prevIndex+1;
					currLen = i-currIndex+1;
					charIndexMap.put(c, i);
				}else{
					currLen++;
					charIndexMap.put(c, i);
				}
			}else{
				currLen++;
				charIndexMap.put(c, i);
			}
			if (maxLen < currLen ){
				maxLen = currLen;
			}			
		}		
		return maxLen;
	}

}