package advanced;

import java.util.Arrays;


public class RearrangeElements {

	public static void main(String[] args) {
		int arr[] = {3, 2, 0, 1};
		System.out.println(Arrays.toString(arr));
		rearrange(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}
	// The function to rearrange an array in-place so that arr[i]
	// becomes arr[arr[i]].
	public static void rearrange(int arr[], int n)
	{
	    // First step: Increase all values by (arr[arr[i]]%n)*n
	    for (int i=0; i < n; i++)
	        arr[i] += (arr[arr[i]]%n)*n;
	 
	    // Second Step: Divide all values by n
	    for (int i=0; i<n; i++)
	        arr[i] /= n;
	}

}
