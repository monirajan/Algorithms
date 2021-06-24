package MCM.palindromePartitioning;

// Find the minimum # of partitions so that each partition is a palindrome
// This is a variation of MCM. How ?
// Given a string, the bracket should be placed in each places and we need to verify all the possibilities
// so there is i and j. k can vary between i to j.

public class PalindromePartitioningRecursive {
	
	public static void main(String args[])
	{
		String s = "nitik";
		
		// This is a variation of MCM
		// 1. Find value of i and j --> 0 to n-1
		System.out.println("Min # of partitions required "+minNoOfPartitions(s,0,s.length()-1));
	}

	private static int minNoOfPartitions(String s, int i, int j ) {
		
		// 2. Base Condition
		if(i>=j)			// if string length is 1, no partition is required
			return 0;
		
		if(isPalindrome(s,i,j) == true)			//if the string is already a palindrome, no partition is required
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		// 3. Partition scheme
		for(int k=i;k<=j-1;k++)
		{
			int temp = minNoOfPartitions(s, i, k) + minNoOfPartitions(s, k+1, j) + 1;
			if(temp<min)
				min = temp;
		}
		return min;
	}

	// function to check whether the character sequence between i and j is a palindrome
	private static boolean isPalindrome(String s, int i, int j) {
		
		// base condition
		if(i==j || i>j)
			return true;
		
		while(i<j)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;				//return false when there is a mismatch
			i++;		
			j--;
		}
		return true;		//return true when there is no mismatch
	}

}
