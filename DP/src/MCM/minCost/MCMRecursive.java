package MCM.minCost;

// Minimum cost for matrix chain multiplication
// Pattern for MCM
// if there is an array and if it requires intermediate results
// i to j, k moves from i to j
// What to do ??
// 1. Find the value for i and j
// 2. Find base condition
// 3. Move k from i to j
//		a) loop k=i    k=j-1      fn(i to k)      fn(k+1 to j)     
//      b) loop k=i+1  k=j        fn(i to k-1)    fn(k to j)
// Choose any one scheme for moving k

public class MCMRecursive {
	
	public static void main(String args[])
	{
		int arr[] = {40, 20, 30, 10, 30};
		
		// 1. Find the value for i and j
		// We will access the matrix as MatrixA = arr[i-1] * arr[i] 
		// i = 1 because the index of first matrix is in 0 & 1  
		
		System.out.println(" Minimum Cost : " + minCostOperations(arr, 1, arr.length-1)); 
	}

	private static int minCostOperations(int[] arr, int i, int j) {
		
		// i = left end, j = right end
		// 2. Base condition
		// There should be atleast 2 index to form a matrix (so return 0 when i==j)
		// i cannot be greater than j at any instance since i is the left end. so i>j is the first invalid input
		if(i>=j)
			return 0;
		
		int minCost = Integer.MAX_VALUE;  // since we are gng to find the minimum
		
		// To calculate the extra cost of ((AB)(CD))
		// arr[] 40 20 30 10 30
		//           i  k     j
		
		//  40*20*30 (AB)  =======> 40*30
		//  30*10*30 (CD)  =======> 30*30
		//  arr[i-1]*arr[k]*arr[j]  ==========> from the above example
		
		// 3. Move k from i to j
		for(int k=i;k<=j-1;k++)
		{
			int temp = minCostOperations(arr, i, k) +
					   minCostOperations(arr, k+1, j) +
					   arr[i-1]*arr[k]*arr[j];
			if(temp<minCost)
				minCost = temp;			// update the minimum cost value
				
		}	
		return minCost;
	}

}
