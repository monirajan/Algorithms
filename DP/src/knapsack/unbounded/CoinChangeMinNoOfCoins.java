package knapsack.unbounded;

// Here we find out the minimum # of coins in which sum can be formed
// Variation of unbounded knapsack in a way that
// 1. we are given coin array (equal to wt[] in knapsack) and a sum (W)
// 2. each coin can be taken any # of times ==> unbounded

public class CoinChangeMinNoOfCoins {
	
	
	static int coinChange(int coin[], int sum, int n)
	{
		int dp[][] = new int[n+1][sum+1];
		
		// initialization
		// if we have no coin, then for any sum, infinite coins will be required
		// but why initializing to MAX_VALUE - 1, bcos adding 1 to it will become MAX_VALUE
		// else adding 1 to MAX_VALUE will cause overflow error
		
		for(int j=0;j<=sum;j++)					
			dp[0][j] = Integer.MAX_VALUE - 1;		
		
		// if the sum is 0, then min no of coins becomes 0
		for(int i=1;i<=n;i++)
			dp[i][0] = 0;
				
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				// as we require only the minimum no, we will calculate minimum among two
				
				if(coin[i-1]<=j) // if current coin is less than sum, we have 2 choices i)include ii)exclude
					dp[i][j] = Math.min(1+dp[i][j-coin[i-1]], dp[i-1][j]);
				else			// if current coin > sum, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
	
	public static void main(String args[])
	{
		int coin[] =  { 1, 2, 3};
	    int sum = 5;
	    // Expected output = 2 as (2+3 = 5)
	    System.out.println("Minimum # of coins " + coinChange(coin , sum, coin.length));
	}


}
