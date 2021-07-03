package Leetcode;

// Variation of fibonacci
public class MinCostClimbingStairs {
	
	
	public static void main(String args[])
	{
		int costs[] = {10,15,20};
		System.out.println("Minimum cost climbing stairs : " + mincostClimbingStairs(costs));
		
	}

	private static int mincostClimbingStairs(int[] cost) {
		
		int n = cost.length;
        int dp[] = new int[n+1];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i=2;i<n;i++)
        {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i]; 
        }
        
        // we can reach nth floor either from n-1 or n-2 as we can climb 1 or 2 steps
        return Math.min(dp[n-1],dp[n-2]);  
	}

}
