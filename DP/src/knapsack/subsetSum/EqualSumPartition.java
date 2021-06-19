package knapsack.subsetSum;

// Equal sum partition is just a variant of subset sum problem

public class EqualSumPartition {

	public static boolean equalSumPartition(int arr[], int n)
	{
		int sum = 0;	// variable to hold the array sum
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		if(sum%2!=0)		//if sum is odd, then there can be no equal partition as the array contains integer values
			return false;
		else			//if sum is even, check if subset with sum/2 is present
			return SubsetSumTopDown.isSubsetSumPresent(arr, sum/2, n);
	}
	
	public static void main(String args[])
	{
		int arr[] = {1, 5, 11, 5};
		System.out.println(equalSumPartition(arr,arr.length));
	}
}
