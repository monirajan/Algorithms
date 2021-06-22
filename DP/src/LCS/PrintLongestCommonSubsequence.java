package LCS;

// DP bottom up solution for printing longest common subsequence

public class PrintLongestCommonSubsequence {
	
	public static void main(String args[])
	{
		String X = "abcdgh";
		String Y = "abedfhr";
		
		System.out.println("Longest Common Subsequence : " + lcs(X,Y,X.length(),Y.length()));
	}

	private static String lcs(String X, String Y, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];		//declare a dp array of size m+1, n+1
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)		//if length of any of the string is 0, then lcs becomes 0
					dp[i][j] = 0;		// initialization
				else if(X.charAt(i-1)==Y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];		//increase the result by 1 if characters are equal
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		//dp[m][n] contains the length of LCS
		//from the above code, we can identify that if characters are equal then result will be 1 + val at (i-1)(j-1)
		//if not equal, then res would come from max among 2 values ([i-1][j], [i][j-1])
		
		StringBuffer res = new StringBuffer();
		int i=m;
		int j=n;
		while(i>0 && j>0)
		{
			if(X.charAt(i-1)==Y.charAt(j-1))
			{
				res.append(X.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;
		}
		
		//as we are traversing from last, reverse the result to get the LCS
		return res.reverse().toString();		
	}

}
