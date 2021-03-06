package backtracking.basic;

import java.util.Arrays;

/**
 * Subset sum problem is to find subset of elements that are selected from a given set
 * whose sum adds up to a given number K.
 * We are considering the set contains non-negative values.
 * It is assumed that the input set is unique (no duplicates are presented).
 */
public class BT08SubsetSum {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		a = new int[]{1, 2, 3, 7, 4, 5, 6};
        visited = new int[a.length];
        Arrays.sort(a);
        desiredSum = 10;
        int totalSum = 0;
        for(int item : a) totalSum += item;
        sumOfSubsets(0, 0, totalSum);
	}
	
	private static int[] a;
    private static int[] visited;
    private static int desiredSum;
 
    public static void sumOfSubsets(int index, int curSum, int remainSum)
    {
        visited[index] = 1;
        if(a[index] + curSum == desiredSum)
        {
            for(int i = 0; i <= index; i++)
            {
                if(visited[i] == 1)
                {
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        }
        else if(index + 1 < a.length && curSum + a[index] + a[index + 1] <= desiredSum)
        {
            sumOfSubsets(index + 1, curSum + a[index], remainSum - a[index]);
        }
        else if(index + 1 < a.length && curSum + a[index + 1] <= desiredSum && curSum + remainSum - a[index] >= desiredSum)
        {
            visited[index] = 0;
            sumOfSubsets(index + 1, curSum, remainSum - a[index]);
        }
    }

}
