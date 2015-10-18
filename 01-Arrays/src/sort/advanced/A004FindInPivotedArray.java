package sort.advanced;

public class A004FindInPivotedArray {

	public static void main(String[] args) {
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.println(binarySearchInPivoted(arr1, 2));
	}

	public static int binarySearchInPivoted(int arr[], int no) {
		int len = arr.length;
		int pivot = findPivot(arr, 0, len - 1);

		if (pivot == -1)
			return binarySearch(arr, 0, len - 1, no);

		if (arr[pivot] == no)
			return pivot;
		if (arr[0] <= no)
			return binarySearch(arr, 0, pivot - 1, no);
		else
			return binarySearch(arr, pivot + 1, len - 1, no);
	}

	public static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;

		// check if pivot at around mid
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);

		// recursive call to find pivot
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		else
			return findPivot(arr, mid + 1, high);
	}

	/* Standard Binary Search function */
	public static int binarySearch(int arr[], int low, int high, int no) {
		// base case
		if (high < low)
			return -1;

		int mid = (low + high) / 2;

		// check if we got number at mid
		if (no == arr[mid])
			return mid;

		// recursive call
		if (no > arr[mid])
			return binarySearch(arr, (mid + 1), high, no);
		else
			return binarySearch(arr, low, (mid - 1), no);
	}

}