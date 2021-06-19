package knapsack.zerooneKnapsack;

// Steps to identify DP problems
// 1. Choice 	2. Optimal
// Recursion forms the basis to arrive at a dp solution
// Here we will see the recursive solution first

public class ZeroOneKnapsackRecursive {
	
	static int knapsack(int wt[], int val[], int W, int n)
	{
		// To write a recursive solution
		// 1. identify base condition		2. choice diagram
		// base condition - smallest valid input
		
		if(n==0 || W==0)
			return 0;
		
		if(wt[n-1]<=W) // if current weight is less than capacity, we have 2 choices i)include ii)exclude
			return Math.max(val[n-1] + knapsack(wt, val, W-wt[n-1], n-1), knapsack(wt, val, W, n-1));
		else			// if current wt > W, do not include the item
			return knapsack(wt, val, W, n-1);
	}
	
	public static void main(String args[])
	{
		int wt[] =  { 10, 20, 30 };
	    int val[] = { 60, 100, 120 };
	    int W = 50;
	    System.out.println("Maximum value " + knapsack(wt,val,W,wt.length));
	}

}
