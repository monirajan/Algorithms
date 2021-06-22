package LCS;

// Longest common substring is just a variant of LCSubsequence in the way that
// discontinuity is allowed in longest common subsequence
// In substring, we will only look for longest continuous matching strings

public class PrintLongestCommonSubstring {
	
	public static void main(String args[])
	{
		String X = "abcdgh";
		String Y = "abedfhr";
		
		// Expected output : ab
		System.out.println("Longest Common Substring : " + lcs(X,Y,X.length(),Y.length()));
	}

	private static String lcs(String X, String Y, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];		//declare a dp array of size m+1, n+1
		int res_i,lcsLen;
		lcsLen= 0;
		res_i = 0;
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)		// if length of any of the string is 0, then lcs becomes 0
					dp[i][j] = 0;		// initialization
				else if(X.charAt(i-1)==Y.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];		//increase the result by 1 if characters are equal
					if(dp[i][j]>lcsLen)
					{
						res_i = i;			// this is just to print the longest common substring
						lcsLen = dp[i][j];
					}
				}
				else
					dp[i][j] = 0; // this is the only change in LCS code
			}
		}
		
		// we know that the longest common substring will end at res_i and has the length lcsLen
		
		StringBuffer res = new StringBuffer();
		int pos = res_i - lcsLen;		//find the start position
		while(lcsLen > 0) {
			res.append(X.charAt(pos++));
			lcsLen--;
		}

		return res.toString();
	}


}
