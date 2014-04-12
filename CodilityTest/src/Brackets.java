import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {

	public static void main(String[] args) {
		String S = "{}(";
		System.out.println(solution(S));
	}

	public static int solution(String S) {
		if (S.isEmpty()){
			return 1;
		}else if(S.length()==1){
			return 0;
		}
		Deque<Character> stack = new ArrayDeque<Character>();
		char[] chars = S.toCharArray();
		int len = chars.length;
		int i=0;
		for (i = 0; i < len; i++) {
			char c = chars[i];
			if (c == '{' || c == '[' || c == '(') {
				stack.push(c);
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return 0;
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return 0;
				}
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return 0;
				}
			}
		}
		if(!stack.isEmpty())
			return 0;
		return 1;
	}

}
