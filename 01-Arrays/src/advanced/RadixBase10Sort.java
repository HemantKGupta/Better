package advanced;

import java.util.Arrays;

public class RadixBase10Sort {

	public static void main(String[] args) {
		int[] arr = { 40, 12, 45, 332, 33, 1, 20, 18, 34, 65, 21, 83, 42 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int arr[]) {
		int j, m = arr[0], exp = 1, n = arr.length;
		int[] output = new int[n];
		int[] count = new int[n];

		for (j = 1; j < n; j++)
			if (arr[j] > m)
				m = arr[j];
		
		while (m / exp > 0) {

			int i;
			for (i = 0; i < n; i++)
				count[i] = 0;

			for (i = 0; i < n; i++)
				count[(arr[i] / exp) % n]++;

			for (i = 1; i < n; i++)
				count[i] += count[i - 1];

			// Build the output array
			for (i = n - 1; i >= 0; i--) {
				
				int elementDigit = (arr[i] / exp) % n;
				int locationInOutput = count[elementDigit] - 1;
				
				output[locationInOutput] = arr[i];
				
				count[elementDigit]--;
			}

			for (i = 0; i < n; i++)
				arr[i] = output[i];
			
			exp *= 10;

		}
	}
}
