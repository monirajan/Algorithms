package LCS;

// In this program we are going to discuss about the length of Longest Repeating Subsequence in a string
public class LongestRepeatingSequence {
	
	public static void main(String args[])
	{
		String X = "AABEBCDD";
		
		// Output - 3 (ABD)
		System.out.println("Longest Repeating Subsequence " + longestRepeatingSequence(X, X.length()));
	}

	private static int longestRepeatingSequence(String X, int m) {
		
		// Find LCS for the string with self
		// If it forms part of repeating subsequence, then it should occur in some other index other than its index
		// AABEBCDD - i
		// AABEBCDD - j
		// A - 0,1 (i)     ** cross matching will be present **
		// A - 0,1 (j)
		// E - 3 (i)		** there is no cross matching **
		// E - 4 (j)
		
		int dp[][] = new int[m+1][m+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0 || j==0)		// base condition in recursion becomes initialization here
					dp[i][j] = 0;
				else if(X.charAt(i-1) == X.charAt(j-1) && i!=j)		// add the additional condition of i!=j to LCS code
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][m];
	}

}
