package knapsack.subsetSum;

// This is just a variation of knapsack problem
// instead of wt[] we have arr[] and Sum instead of W

public class SubsetSumTopDown {
	
	public static boolean isSubsetSumPresent(int arr[], int sum, int n)
	{
		// i --> array size, j --> sum
		boolean dp[][] = new boolean[n+1][sum+1];
		
		//base case
		for(int j=0;j<=sum;j++)
			dp[0][j] = false;		// if array is empty and there is a particular sum, no subset can be formed
		
		for(int i=0;i<=n;i++)
			dp[i][0] = true;		// when sum is 0, then an empty subset {} can be formed
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(arr[i-1]<=j)  // if current elt is less than sum, we have 2 choices i)include ii)exclude
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				else				// if current elt > sum, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[n][sum];
	}
	
	public static void main(String args[])
	{
		int arr[] = {2, 3, 7, 8, 10};
		int sum = 12;
		System.out.println(isSubsetSumPresent(arr,sum,arr.length));
	}
}
