package LCS.standard;

import java.util.Arrays;

// In this problem, we are going to solve standard LCS problem in DP bottom up approach
// To completely avoid recursion call, we are going for this approach

public class LCSBottomUp {
	
	public static void main(String args[])
	{
		String X = "abcdgh";
		String Y = "abedfhr";
		
		int m = X.length();
		int n = Y.length();
		
		// Expected op - 4 (abdh)
		System.out.println(" Length of Longest Common Subsequence : " + lcs(X,Y,m,n));
	}

	// This function returns the length of longest common subsequence
	public static int lcs(String X, String Y, int m, int n) {
		
		// declare a dp table
		int dp[][] = new int[m+1][n+1];
				
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)		// base condition in recursion becomes initialization here
					dp[i][j] = 0;
				else if(X.charAt(i-1) == Y.charAt(j-1))		// convert the choice diagram into interactive code here
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];	
	}
}
