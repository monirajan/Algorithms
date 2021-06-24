package MCM.palindromePartitioning;

import java.util.Arrays;

// Dp memoized optimisation approach

public class PalindromePartitioningOptimized {
	
	public static void main(String args[])
	{
		String s = "nitik";
		
		int dp[][] = new int[6][6];
		for(int i=0;i<6;i++)
			Arrays.fill(dp[i], -1);
		
		// This is a variation of MCM
		// 1. Find value of i and j --> 0 to n-1
		System.out.println("Min # of partitions required "+minNoOfPartitions(s,0,s.length()-1,dp));
	}

	private static int minNoOfPartitions(String s, int i, int j, int[][] dp ) {
		
		// 2. Base Condition
		if(i>=j)			// if string length is 1, no partition is required
			return 0;
		
		if(isPalindrome(s,i,j) == true)			//if the string is already a palindrome, no partition is required
			return 0;
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		int min = Integer.MAX_VALUE;
		int left, right;
		
		// 3. Partition scheme
		for(int k=i;k<=j-1;k++)
		{
			if(dp[i][k]!=-1)
				left = dp[i][k];
			else
				left = minNoOfPartitions(s, i, k, dp);
			
			if(dp[k+1][j]!=-1)
				right = dp[k+1][j];
			else
				right = minNoOfPartitions(s, k+1, j, dp);
			
			int temp = left + right + 1;	
			if(temp<min)
				min = temp;
		}
		return dp[i][j] = min;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		
		if(i==j || i>j)
			return true;
		
		while(i<j)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
