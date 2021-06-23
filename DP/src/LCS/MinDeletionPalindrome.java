package LCS;


// This problem is to find the minimum # of deletions to form a palindrome
// This also caters minimum # of insertions to form a palindrome
// This is also a variation of LCS. we will see how

public class MinDeletionPalindrome {
	
	public static void main(String args[])
	{
		String X = "agbcba";
		
		// Output - 1
		System.out.println("Min # of Deletion to form a palindrome " + minNoOfDelToFormPalindrome(X, X.length()));
	}

	public static int minNoOfDelToFormPalindrome(String X, int m) {
		
		// Input - agbcba
		// Possible Palindromes - abcba (1 deletion)
		//                      - bcb   (3 deletion)
		//						- c     (5 deletion)
		// We can see that, # of deletion is inversely proportional to Palindrome length
		// Therefore, min # of deletion to form palindrome = X.length - length of longest palindromic equence
		
		return m - LongestPalindromicSubsequence.longestPalindromicSubseq(X, m);
	}

}
