package knapsack.zerooneKnapsack;

import java.util.Arrays;

// Here we are going to implement memoization approach for knapsack
// To convert a recursive --> DP(Memoization), follow below 3 steps
// 1. create a table, initialize with minimal value
// 2. before solving the subproblem, check whether it is already solved
// 3. store the result of solved problems in table

public class ZeroOneKnapsackMemoization {
	
	static int dp[][] = new int[10][10];		//create a table of size n+1, W+!
	
	static void initialiseTable()
	{
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], Integer.MIN_VALUE); 		//initialize with minimal value
	}
	
	static int knapsack(int wt[], int val[], int W, int n)
	{
		if(n==0 || W==0)		// base case
			return 0;
		
		if(dp[n][W] != Integer.MIN_VALUE)		//before solving the subproblem, check whether it is already solved
			return dp[n][W];
		
		if(wt[n-1]<=W) // if current weight is less than capacity, we have 2 choices i)include ii)exclude
			dp[n][W] = Math.max(val[n-1] + knapsack(wt, val, W-wt[n-1], n-1), knapsack(wt, val, W, n-1));
		else			// if current wt > W, do not include the item
			dp[n][W] = knapsack(wt, val, W, n-1);
		
		return dp[n][W];
		
	}
	
	public static void main(String args[])
	{
		int wt[] =  { 1, 2, 3 };
	    int val[] = { 4, 3, 2 };
	    int W = 5;
	    initialiseTable();
	    System.out.println("Maximum value " + knapsack(wt,val,W,wt.length));
	}

}
