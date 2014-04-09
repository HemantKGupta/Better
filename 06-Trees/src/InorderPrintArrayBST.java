
public class InorderPrintArrayBST {

	public static void main(String[] args) {
		int[] ar = {4, 2, 5, 1, 3}; 
		printInorder(ar, 0);
	}
	
	public static void printInorder(int[] ar, int index){
		
		int n = ar.length-1;
		int leftChildIndex = 2*index+1;
		if (leftChildIndex <= n){
			printInorder(ar,leftChildIndex );
		}
		System.out.println(ar[index]+" ");
		int rightChildIndex = 2*index+2;
		if (rightChildIndex <= n){
			printInorder(ar,rightChildIndex );
		}
	}
		

}
