/*import java.util.Deque;
import java.util.LinkedList;


public class TheCelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean MATRIX[][] = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
	 
	public static boolean HaveAcquiantance(int a, int b) { return MATRIX[a][b]; }
	
	int CelebrityUsingStack(int size)
	{
	   // Handle trivial case of size = 2
	 
	   Deque<Integer> stack =  new LinkedList<Integer>(); // Careful about naming
	   int i;
	   int C; // Celebrity
	 
	   i = 0;
	   while( i < size )
	   {
	      stack.push(i);
	      i = i + 1;
	   }
	 
	   int A = stack.back();
	   stack.pop();
	 
	   int B = stack.back();
	   stack.pop();
	 
	   while( stack.size() != 1 )
	   {
	      if( HaveAcquiantance(A, B) )
	      {
	         A = stack.back();
	         stack.pop_back();
	      }
	      else
	      {
	         B = stack.back();
	         stack.pop_back();
	      }
	   }
	 
	   // Potential candidate?
	   C = stack.back();
	   stack.pop_back();
	 
	   // Last candidate was not examined, it leads one excess comparison (optimise)
	   if( HaveAcquiantance(C, B) )
	      C = B;
	 
	   if( HaveAcquiantance(C, A) )
	      C = A;
	 
	   // I know these are redundant,
	   // we can simply check i against C
	   i = 0;
	   while( i < size )
	   {
	      if( C != i )
	      stack.push_back(i);
	      i = i + 1;
	   }
	 
	   while( !stack.empty() )
	   {
	      i = stack.back();
	      stack.pop_back();
	 
	      // C must not know i
	      if( HaveAcquiantance(C, i) )
	         return -1;
	 
	      // i must know C
	      if( !HaveAcquiantance(i, C) )
	         return -1;
	   }
	 
	   return C;
	}

}
*/