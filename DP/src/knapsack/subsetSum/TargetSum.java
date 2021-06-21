package knapsack.subsetSum;

// Problem statement : Find the number of possible ways in which the target sum can be achieved by placing +/- to array elements 
// Ex: i/p = {1, 1, 2, 3}, targetSum = 1
// {+1, -1, -2, +3}  {+1, +1, +2, -3}  {-1, +1, -2, +3} ------> o/p = 3

public class TargetSum {
	
	public static void main(String args[])
	{
		int arr[] = {1, 1, 2, 3};
		int sum = 1;
		System.out.println(targetSum(arr,sum, arr.length));
	}

	public static int targetSum(int[] arr, int sum, int length) {
		
		// If we look into the problem deeply, we can understand that all +ve nos are gng to be grouped into one subset
		// all -ve nos are gng to to be grouped into another
		// so it is nothing but countOfSubsetSum with given difference where difference = target sum
		
		return CountOfSubsetSumWithGivenDiff.noOfSubsetsWithGivenDiff(arr, sum, length);
		
	}

}
