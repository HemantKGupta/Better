public class MedianTwoSortedArray {

	public static void main(String[] args) {
		 int ar1[] = {1, 2, 3, 6};
		    int ar2[] = {4, 6, 8, 10};
		    System.out.println(getMedian(ar1, ar2, 4));
	}
	
	/* This function returns median of ar1[] and ar2[].
	   Assumptions in this function:
	   Both ar1[] and ar2[] are sorted arrays
	   Both have n elements */
	public static int getMedian(int ar1[], int ar2[], int n)
	{
		int m1; 
	    int m2; 
	 
	    
	    if (n <= 0)
	        return -1;
	 
	    if (n == 1)
	        return (ar1[0] + ar2[0])/2;
	 
	    if (n == 2)
	        return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
	 
	    m1 = median(ar1,n); /* get the median of the first array */
	    m2 = median(ar2,n); /* get the median of the second array */
	    System.out.println("Median of first array is : "+ m1);
	    System.out.println("Median of second array is : "+ m2);
	 
	    /* If medians are equal then return either m1 or m2 */
	    if (m1 == m2)
	        return m1;
	 
	     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
	    if (m1 < m2)
	    {
	        if (n % 2 == 0)
	            return getMedian(ar1, ar2, n - n/2 +1);
	        else
	            return getMedian(ar1, ar2, n - n/2);
	    }
	 
	    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
	    else
	    {
	        if (n % 2 == 0)
	            return getMedian(ar2, ar1, n - n/2 + 1);
	        else
	            return getMedian(ar2, ar1, n - n/2);
	    }
	}
	 
	/* Function to get median of a sorted array */
	public static int median(int arr[], int n)
	{
		if (n%2 == 0)
	        return (arr[n/2] + arr[n/2-1])/2;
	    else
	        return arr[n/2];
	}

}
