package knapsack.unbounded;

// Problem to count the number of ways in which the sum can be obtained from given set of coins
// similar to unbounded knapsack in a way that
// 1. we are given coin array (equal to wt[] in knapsack) and a sum (W)
// 2. each coin can be taken any # of times ==> unbounded
// 3. Number of ways - so add all possibilities

public class CoinChangeMaxWays {
	
	static int coinChange(int coin[], int sum, int n)
	{
		int dp[][] = new int[n+1][sum+1];
		
		// initialization
		for(int j=1;j<=sum;j++)
			dp[0][j] = 0;			// if the array size is 0, then there is no way
		for(int i=0;i<=n;i++)
			dp[i][0] = 1;			// if the sum is 0, then there can be an empty set
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(coin[i-1]<=j) // if current coin is less than sum, we have 2 choices i)include ii)exclude
					dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
				else			// if current coin > sum, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
	
	public static void main(String args[])
	{
		int coin[] =  { 1, 2, 3, 5 };
	    int sum = 5;
	    System.out.println("# of ways " + coinChange(coin , sum, coin.length));
	}


}
