package LCS.SCS;

import LCS.standard.LCSBottomUp;

// Program to print the # of SCS

public class ShortestCommonSubsequence {
	
	public static void main(String args[])
	{
		String X = "AGGXTAB";
		String Y = "GXTXAYB";
		
		// SCS for the above data is AGGXTXAYB
		System.out.println("Shortest Common Subsequence : " + scs(X,Y,X.length(),Y.length()));
	}

	private static int scs(String X, String Y, int m, int n) {
		
		// SCS should contain characters in both string X and Y in sequence
		// In worst case, we will append both the strings X and Y
		// as we need SHORTEST string, LCS among both X and Y can be present only once in the result so that length can be minimised
		// Therefore SCS = X + Y - LCS
		
		return m + n - LCSBottomUp.lcs(X, Y, m, n);
	}

}
