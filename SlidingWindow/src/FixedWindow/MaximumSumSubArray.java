package FixedWindow;

/*
 * Find the sub array of given size k with maximum sum
 * In Brute force, we are doing same calculations again. so to avoid repetition, we are going for sliding window concept
 */
public class MaximumSumSubArray {
	
	public static void main(String args[])
	{
		int arr[] = {2, 5, 1, 8, 2, 9, 1};
		int windowSize = 3;
		System.out.println("Maximum sum subarray of given window size : " + maxSumSubArray(arr, arr.length, windowSize));
	}

	private static int maxSumSubArray(int[] arr, int size, int windowSize) {
		
		int start, end, sum, maxSum;
		start = end = sum= 0;		// initially both start and end will point to 0 index
		maxSum = Integer.MIN_VALUE;		// initialise max Sum to min value
		while(end<size)
		{
			sum = sum+arr[end];		// compute the sum
			if(end-start+1 < windowSize)		// if window size is not attained
				end++;		//increase the end pointer alone
			else if(end-start+1 == windowSize)
			{
				maxSum = Math.max(sum, maxSum);			// calculation required for result
				sum = sum - arr[start];					// slide the window
				start++;			
				end++;
			}
		}
		return maxSum;
	}

}
