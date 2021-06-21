package knapsack.subsetSum;

import java.util.ArrayList;

// Variation of EqualSumPartition. In ESP, |S1-S2| = 0. 
// In this problem, |S1-S2| should be minimum
// S2-S1 = (Range-S1)-S1 = Range - 2*S1 should be min where Range is nothing but sum of elements in array 
// find the candidates for S1 --> how ?? S1 should somewhere lie between 0 and range/2
// form the dp table for subsetSum considering Range as the target sum
// pick the last row in dp table, consider only the part of sum/2 to find the eligible candidates for S1

public class SubsetSumWithMinimumDiff {
	
	public static int subsetSumWithMinDiff(int arr[], int sum, int n)
	{
		// i --> array size, j --> sum
		boolean dp[][] = new boolean[n+1][sum+1];
		
		//base case
		for(int j=0;j<=sum;j++)
			dp[0][j] = false;		// if array is empty and there is a particular sum, no subset can be formed
		
		for(int i=0;i<=n;i++)
			dp[i][0] = true;		// when sum is 0, then an empty subset {} can be formed
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(arr[i-1]<=j)  // if current elt is less than sum, we have 2 choices i)include ii)exclude
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				else				// if current elt > sum, do not include the item
					dp[i][j] = dp[i-1][j];
			}
		}
		
		ArrayList<Integer> candidates = new ArrayList<>();
		for(int col=0;col<=sum/2;col++)
			if(dp[n][col] == true)		//identify the candidates from first half
				candidates.add(col);
		
		// we already know that for |S2-S1| to be min, Range - 2*S1 should be min
		
		int minDiff = Integer.MAX_VALUE;
		for(int i=0;i<candidates.size();i++)
			minDiff = Math.min(minDiff, sum-2*candidates.get(i));		//find the minimum difference
		
		return minDiff;
	}
	
	public static void main(String args[])
	{
		int arr[] = {1,2,7};
		int sum = 0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		System.out.println(subsetSumWithMinDiff(arr,sum,arr.length));
	}

}
