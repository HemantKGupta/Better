import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
		printNGE(arr, arr.length);

	}

	/*
	 * prints element and NGE pair for all elements of arr[] of size n
	 */
	public static void printNGE(int arr[], int n) {
		int i = 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int element, next;

		/* push the first element to stack */
		stack.push(arr[0]);

		// iterate for rest of the elements
		for (i = 1; i < n; i++) {
			next = arr[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				/*
				 * If the popped element is smaller than next, then a) print the
				 * pair b) keep popping while elements are smaller and stack is
				 * not empty
				 */
				while (element < next) {
					System.out.printf("\n %d --> %d", element, next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					stack.push(element);
			}

			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);
		}

		/*
		 * After iterating over the loop, the remaining elements in stack do not
		 * have the next greater element, so print -1 for them
		 */
		while (!stack.isEmpty()) {
			element = stack.pop();
			next = -1;
			System.out.printf("\n %d --> %d", element, next);
		}
	}

}
