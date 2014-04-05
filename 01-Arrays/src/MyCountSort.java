import java.util.Arrays;


public class MyCountSort {

	public static void main(String[] args) {
		char[] arr  = "geeksforgeeks".toCharArray();
		printArray(countSort(arr));
	}
	
	public static char[] countSort(char[] str)
	{
	    // The output character array that will have sorted str
	    char[] output = new char[str.length];
	 
	    // Create a count array to store count of inidividul characters and
	    // initialize count array as 0
	    int[] count= new int[256];
	    
	   
	 
	    // Store count of each character
	    int i;
	    for(i = 0; i< str.length; ++i){
	    	System.out.println("Char at: "+ i+" is: "+str[i]+" and int value is: "+(int)str[i]);
	    	++count[str[i]];
	    }
	    System.out.println("count array: "+Arrays.toString(count));    
	 
	    // Change count[i] so that count[i] now contains actual position of
	    // this character in output array
	    for (i = 1; i <= 255; ++i)
	        count[i] += count[i-1];
	 
	    System.out.println("cumm count array: "+Arrays.toString(count));    
	    
	    // Build the output character array
	    for (i = 0; i< str.length; ++i)
	    {
	        output[count[str[i]]-1] = str[i];
	        --count[str[i]];
	    }
	 
	    // Copy the output array to str, so that str now
	    // contains sorted characters
	    for (i = 0; i< str.length; ++i)
	        str[i] = output[i];
	    
	    return output;
	}
	
	public static void printArray(char[] arr){
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}

}
