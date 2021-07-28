package FixedWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Maximum in all subarrays of size k
 * Given I/P - array, window size k
 * O/P - array with max values in each window
 */
public class MaximumInAllSubArrays {
	
	public static void main(String args[])
	{
		int arr[] = {1,3,-1,-3,-3,5,3,6,7};
		int n = arr.length;
	    int k = 3;		// window size
	    
		maximumInAllSubarraysOfWindowSize(arr,n,k);
	}

	private static void maximumInAllSubarraysOfWindowSize(int[] arr, int n, int k) {
		
		int result[] = new int[n-k+1];
		int start,end, resindex;
		start = end = resindex = 0;
		
		// there is a need to store the possible candidates in order to avoid doing the same calculations again and again
	    // here we are using deque to store the possible result values
		Deque<Integer> queue = new LinkedList<Integer>();
		
		while(end<n)
		{
			// computations
			while(queue.size()>0 && queue.peekLast()<arr[end])		// when the elements already in queue are smaller than the current element
				queue.removeLast();			//remove it as they no longer needed for max computation
			
			queue.addLast(arr[end]);    // add the current element to queue
			if(end-start+1<k)			//less than window size
				end++;
			else if(end-start+1==k)		//when window size is reached
			{
				//calculate answer - the front element will be the maximum for current window as we popped out the min elements if present
				result[resindex++] = queue.peekFirst();
				
				//if the front element is the current maximum, then remove it from queue before sliding window
				if(queue.peekFirst()==arr[start])	// as it will not present in the next window
					queue.removeFirst();
				
				//slide the window
				start++;
				end++;
			}
		}
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i] + " ");

	}

}
