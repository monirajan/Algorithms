package MCM.minCost;

import java.util.Arrays;

// Top down dp approach for MCM, just a minor variation in recursion approach
// store the result in dp table before returning
public class MCMTopDown {
	
	public static void main(String args[])
	{
		int arr[] = {40, 20, 30, 10, 30};

		int dp[][] = new int[6][6];
		for(int i=0;i<6;i++)
			Arrays.fill(dp[i], -1);
		
		// Output - 26000
		System.out.println(" Minimum Cost : " + minCostOperations(arr, 1, arr.length-1, dp)); 
	}
	
	private static int minCostOperations(int[] arr, int i, int j, int[][] dp) {

		// Base condition
		if(i>=j)
			return 0;
		
		if(dp[i][j] != -1)
			return dp[i][j];		// if the subproblem is already solved
		
		int minCost = Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			int temp = minCostOperations(arr, i, k, dp) +
					   minCostOperations(arr, k+1, j, dp) +
					   arr[i-1]*arr[k]*arr[j];
			if(temp<minCost)
				minCost = temp;	// update the minimum cost
		}
		
		return dp[i][j] = minCost;
	}

}
