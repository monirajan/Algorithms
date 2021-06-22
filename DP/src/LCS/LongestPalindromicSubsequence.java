package LCS;

import LCS.standard.LCSBottomUp;

// This is also a pattern of LCS
// in both cases, we are gng to return the longest sequence

public class LongestPalindromicSubsequence {
	
	public static void main(String args[])
	{
		String X = "agbcba";
		
		// Output - abcba
		System.out.println(longestPalindromicSubseq(X, X.length()));
	}

	public static int longestPalindromicSubseq(String X, int m) {
		
		// We know that palindrome is nothing but we get the same string if we process from both left and right
		// Find the LCS for given string and reverse of it. We get the longest palindromic subseq :)
		
		StringBuilder sb = new StringBuilder();
		sb.append(X);
		sb.reverse();
		String reverse = sb.toString();
		return LCSBottomUp.lcs(X, reverse, m, m);
		
	}

}
