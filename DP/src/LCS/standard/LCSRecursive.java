package LCS.standard;

// In this problem, we are going to solve standard LCS problem in recursive approach

public class LCSRecursive {
	
	
	public static void main(String args[])
	{
		String X = "abcdgh";
		String Y = "abedfhr";
		
		// Expected op - 4 (abdh)
		System.out.println(" Length of Longest Common Subsequence : " + lcs(X,Y,X.length(),Y.length()));
	}

	// This function returns the length of longest common subsequence
	public static int lcs(String X, String Y, int m, int n) {
		
		// Recursive approach
		// 1. Base condition (smallest valid input)
		// 2. Choice diagram
		
		if(m==0 || n==0)
			return 0;			// if any of the string is null, then length of LCS will be 0
		
		// Choice diagram
		// 1. If the characters are equal, increase the LCS length by 1 and recur for X.length-1 and Y.length-1
		// 2. If they are not equal, keep the length of X as constant and recur for Y.length-1 &
		//							 keep the length of Y as constant and recur for X.length-1
		// 3. Return the maximum length among the above 2
		
		if(X.charAt(m-1) == Y.charAt(n-1))
			return 1+lcs(X, Y, m-1, n-1);
		
		return Math.max(lcs(X, Y, m-1, n), lcs(X, Y, m, n-1));
	}

}
