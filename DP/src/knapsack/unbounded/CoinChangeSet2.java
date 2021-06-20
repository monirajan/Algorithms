package knapsack.unbounded;

// Here we find out the minimum # of coins in which sum can be formed

public class CoinChangeSet2 {
	
	
	static int coinChange(int coin[], int sum, int n)
	{
		int dp[][] = new int[n+1][sum+1];
		
		for(int j=0;j<=sum;j++)
			dp[0][j] = Integer.MAX_VALUE - 1;
		for(int i=1;i<=n;i++)
			dp[i][0] = 0;
		
		for(int j=1;j<=sum;j++)
		{
			if(coin[0]%j != 0)
				dp[1][j] = Integer.MAX_VALUE - 1;
		}
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
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
	    System.out.println("Minimum # of coins " + coinChange(coin , sum, coin.length));
	}


}
