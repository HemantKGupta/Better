
public class PermCheck {

	public static void main(String[] args) {
		int[]  A =  {1,1};
		System.out.println(solution(A));
	}
	
	 public static int solution(int[] A) {
		 int n = A.length;
		 if (n == 1){
			 if (A[0]==1){
				 return 1;
			 } else {
				 return 0;
		     }
		 }	 
		 int[] count = new int[n];
		 for (int i=0;i< A.length;i++){
			 if(A[i] > n ){
				 return 0;
			 }
			 if(count[A[i]-1] == 0){
				 count[A[i]-1]= 1;
			 }else if (count[A[i]-1] != 0){
				 return 0;
			 }
		 }		 
		 for (int i=0;i<count.length;i++){
			 if(count[i] == 1)
				 return 1;
	    }
		 return 0;

}
	 
}
	 
	 
