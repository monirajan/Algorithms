package knapsack.unbounded;

// Cut the rod in such a way to maximize the profit
// Another way of portraying unbounded knapsack. How??
// wt[] = length [] && val[] = price[] && W = length of the rod
// Why it is unbounded knapsack ?? because multiple same size pieces can be included in solution 

public class RodCutting {
	
	static int maximizeProfit(int len[], int price[], int rodLength, int n)
	{
		// n --> size of array
		int dp[][] = new int[n+1][rodLength+1];
		for(int i=0;i<=n;i++)			// initialization part
		{
			for(int j=0;j<=rodLength;j++)
			{
				if(i==0 || j==0)		// result is 0, either if array length is 0 or rod length is 0
					dp[i][j] = 0;		
			}							
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=rodLength;j++)
			{
				if(len[i-1]<=j) // if current length is less than rod length, we have 2 choices i)include ii)exclude
					dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
				else			// if current length > rodLength, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][rodLength];
	}
	
	public static void main(String args[])
	{
		int len[] =  { 1, 2, 3, 4, 5, 6, 7, 8 };
	    int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
	    int N = 8;		// length of rod
	    
	    // output = 22 ---> (2) + (6) ---> 5 + 17
	    System.out.println("Maximum profit " + maximizeProfit(len, price, N, price.length));
	}


}
