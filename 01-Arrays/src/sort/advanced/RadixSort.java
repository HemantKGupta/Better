package sort.advanced;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {40, 12, 45, 32, 33, 1, 22};
		 countSort(arr, 7, 1);
		 countSort(arr, 7, 7);
		 printArray(arr);
		 
	}

	public static void countSort(int arr[], int n, int exp) {

		int[] output = new int[n];
		int[] count = new int[n];
		
		
		
		
		
		int i;
		for (i = 0; i < n; i++)
			count[i] = 0;

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % n]++;

		// Change count[i] so that count[i] now contains actual
		// position of this digit in output[]
		for (i = 1; i < n; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % n] - 1] = arr[i];
			count[(arr[i] / exp) % n]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
		
		

	}
	
	public static void printArray(int[] arr){
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}

}