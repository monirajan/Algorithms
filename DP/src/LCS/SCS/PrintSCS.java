package LCS.SCS;

import java.util.Arrays;

import LCS.standard.LCSTopDown;

// In this problem, we are going to print the ShortestCommonSubesequence
// This is just a variation of PrintLCS
// We ll use the same dp table constructed in LCS

public class PrintSCS {
	
	public static void main(String args[])
	{
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		// SCS for the above data is AGGXTXAYB
		System.out.println("Shortest Common Subsequence : " + printScs(X,Y,X.length(),Y.length()));
	}

	public static String printScs(String X, String Y, int m, int n) {
		
		int dp[][] = new int[m+1] [n+1];
		
		// Build the dp table for LCS
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
		
		// We already know SCS = X + Y - LCS
		int i = m;
		int j = n;
		
		StringBuffer sb = new StringBuffer();
		while(i>0 && j>0)
		{
			if(X.charAt(i-1) == Y.charAt(j-1))		// if the characters are equal, then it forms part of LCS
			{
				sb.append(X.charAt(i-1));			// insert it once and move to next char in both strings
				i--; j--;
			}
			else if(dp[i-1][j]>dp[i][j-1])			// append the character in specific direction before moving   
			{
				sb.append(X.charAt(i-1));			
				i--;
			}
			else
			{
				sb.append(Y.charAt(j-1));
				j--;
			}
		}
		
		// Consider the case where X = "ab", Y = "" ==> SCS = "ab"
		// If any of the string is null and other is not null, we need to append those characters too in result
		
		while(i>0)		// if X is not null and Y becomes null
		{
			sb.append(X.charAt(i-1));			
			i--;
		}
		
		while(j>0)		// if Y is not null and X becomes null
		{
			sb.append(Y.charAt(j-1));
			j--;
		}
		
		return sb.reverse().toString();		//reverse the characters as we processed from right
	}

}
