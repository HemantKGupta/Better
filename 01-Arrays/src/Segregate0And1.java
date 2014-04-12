
public class Segregate0And1 {

	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 1, 1};
		segregate0and1(arr,arr.length);
		printArray(arr);
	}
	public static void segregate0and1(int arr[], int size)
	{
	  /* Initialize left and right indexes */
	  int left = 0, right = size-1;     
	 
	  while(left < right)
	  {
	     /* Increment left index while we see 0 at left */
	     while(arr[left] == 0 && left < right)
	        left++;
	 
	     /* Decrement right index while we see 1 at right */
	     while(arr[right] == 1 && left < right)
	        right--;
	 
	    /* If left is smaller than right then there is a 1 at left
	      and a 0 at right.  Exchange arr[left] and arr[right]*/
	     if(left < right)
	     {
	       arr[left] = 0;
	       arr[right] = 1;
	       left++;
	       right--;
	     }
	  }
	}
	
	public static void printArray(int[] arr){
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}

}