package FixedWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Find the first negative number in every window of given size k
 */
public class FirstNegativeNo {
	
	public static void main(String args[])
	{
		int arr[] = {-8, 2, 3, -6, 10};
		int windowSize = 2;
		
		ArrayList<Integer> res = new ArrayList<>();
		res = getNegativeNosInEachWindow(arr, arr.length, windowSize);
		
		System.out.println("Negatives nos in each window : " + res.toString());
		
	}

	private static ArrayList<Integer> getNegativeNosInEachWindow(int[] arr, int size, int windowSize) {
		
		Queue<Integer> negativeNumsList = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		int start, end;
		start = end = 0;
		
		while(end<size)
		{
			if(arr[end]<0)				// add all the -ve nos encountered to the list
				negativeNumsList.add(arr[end]);
			
			if(end-start+1 < windowSize)		// if window size is not met, just move the end pointer
				end++;
			else if(end-start+1 == windowSize)		// if window size is attained
			{
				if(negativeNumsList.isEmpty())		// check if any negative number is present in the current window
					result.add(0);					// add the result as 0 when no -ve num is present
				else
				{
					result.add(negativeNumsList.peek());		// add the front element in the queue to the result
					if(arr[start] == negativeNumsList.peek())				// if the -ve num is equal to the start element, then remove it from list while sliding window
						negativeNumsList.poll();
				}
				start++;			// slide the window
				end++;
			}
		}
		
		return result;
	}

}
