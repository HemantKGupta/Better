package basic;

import java.util.Arrays;

/**
 *Merge two sorted arrays
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 * Created by hemant on 17/10/15.
 */
public class AB02MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6 };
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    /**
     * It merge two given sorted arrays by using a temp array
     * and return the result array
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArr = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Copy the minimum value
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k] = arr1[i];
                i++;
            } else {
                mergedArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        // If first array is not over
        while (i < m) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
        // If seconcd array is not over
        while (j < n) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArr;
    }

}
