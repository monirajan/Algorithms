package knapsack.unbounded;

// This is same as that of 0-1 knapsack except the only difference in that an item can be included more than once
// In 0-1 knapsack, we will consider an item as processed whether it is taken or not taken
// In unbounded knapsack, we will not consider the item as processed if it is taken as again the same item can be fetched

public class UnboundedKnapsack {
	
	static int knapsack(int wt[], int val[], int W, int n)
	{
		int dp[][] = new int[n+1][W+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=W;j++)
			{
				if(wt[i-1]<=j) // if current weight is less than capacity, we have 2 choices i)include ii)exclude
					dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
				else			// if current wt > W, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][W];
	}
	
	public static void main(String args[])
	{
		int wt[] =  { 1, 2, 3 };
	    int val[] = { 4, 3, 2 };
	    int W = 5;
	    System.out.println("Maximum value " + knapsack(wt,val,W,wt.length));
	}

}
