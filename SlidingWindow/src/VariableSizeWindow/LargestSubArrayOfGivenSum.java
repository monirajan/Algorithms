package VariableSizeWindow;

public class LargestSubArrayOfGivenSum {
	
	public static void main(String args[])
	{
		int arr[] = { 10, 5, 2, 7, 1, 9 };
		int sum = 15;
		
		System.out.println("Maximum length subarray of given sum : " + largestSubArrayOfGivenSum(arr, arr.length, sum));
	}

	/*
	 * Here we need to find the max window size and sum is given
	 * In Fixed Window, window size will be given and we need to find the max sum
	 * This approach will not work when -ve elements present in array because when array sum > target sum, we are reducing window size
	 * assuming that the same sum cannot be obtained on increasing the window size
	 */
	private static int largestSubArrayOfGivenSum(int[] arr, int size, int sum) {
		
		int maxWindow = 0;
		int start, end, arrSum;
		start = end = arrSum = 0;
		
		while(end<size)
		{
			if(arrSum<sum)		// if current array sum is less than target sum
			{
				arrSum+=arr[end];		// add the current element and increase the window size
				end++;
			}
			else if(arrSum==sum)
			{
				maxWindow = Math.max(maxWindow, end-start);		// update the max window size when sum is equal to target
				arrSum-=arr[start];		// remove the start element as we have processed the current subarray
				start++;				// move the window
			}
			else		// this means current array sum is greater than target, hence slide the window
			{
				arrSum-=arr[start];		// remove the start element as array sum is greater than target sum
				start++;		// reduce window size
			}
		}
		
		return maxWindow;
	}

}
