public class MissingAndRepeating {

	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		printTwoElements(arr, arr.length);
	}

	public static void printTwoElements(int arr[], int size) {
		System.out.printf("\n The repeating element is");

		for (int i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			else
				System.out.printf(" %d ", Math.abs(arr[i]));
		}

		System.out.printf("\nand the missing element is ");
		for (int i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.printf("%d", i + 1);
		}
	}

}
