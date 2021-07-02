package KadanesAlgo;

public class LargestSumContiguousSubArray {
	
	public static void main(String args[])
	{
		int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Largest Sum Contiguous Subarray "+ kadanesAlgo(arr, arr.length));
	}

	public static int kadanesAlgo(int[] arr, int n) {
		
		int max_ending_here,max_so_far;
		
		max_ending_here = max_so_far = arr[0];
		
		for(int i=1;i<n;i++)
		{
			//max sum is obtained whether by adding the previous sum to the current elt or the curr elt alone is greater 	
			max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);	
			max_so_far = Math.max(max_so_far, max_ending_here);			// update max_so_far in each step
		}
		
		return max_so_far;
	}

}
