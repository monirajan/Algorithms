package knapsack.subsetSum;

// Variation of EqualSumPartition + Count Of subset sum
// In EqualSumPartition, |S1-S2| will be 0. Here |S1-S2| = given difference

public class CountOfSubsetSumWithGivenDiff {
	
	
	public static void main(String args[])
	{
		int arr[] = {1, 1, 2, 3};
		int diff = 1;
		System.out.println("Subsets with given diff " + noOfSubsetsWithGivenDiff(arr, diff, arr.length));
	}

	public static int noOfSubsetsWithGivenDiff(int[] arr, int diff, int length) {
		
	//   S1 + S2 = total sum of array
	//   S1 - S2 = given difference
	//-------------------------------
	//  2S1 = sum + diff  ==> S1 = (sum + diff)/2 ==> diff is given and sum can be calculated

	// Now problem is reduced to count of subsetSum with target sum as S1
		
		int sum = 0;
		// calculate the total array sum
		for(int i=0;i<length;i++)
			sum += arr[i];
		
		// find the target sum with the above formula
		int targetSum = (sum+diff)/2;
		return CountOfSubsetSum.countSubsetSum(arr, targetSum, length);
	}

}
