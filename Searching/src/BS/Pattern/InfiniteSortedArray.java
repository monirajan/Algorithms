package BS.Pattern;

// Find the 1 st occurence of 1 in a Binary infinite sorted array
 
public class InfiniteSortedArray {
	
	public static void main(String args[])
	{
		int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
		System.out.println("Position of first 1 : " + searchInInfiniteSorted(arr));
	}

	private static int searchInInfiniteSorted(int[] arr) {
		/*
		 * This is an infinite sorted array. hence we will not know the length.
		 * Try to reduce this into a known problem and solve
		 */
		int res, start, end, key;
		start = 0;
		end = 1;		// initially set the end position as 1
		key = 1;		// here the key is 1 as we are gng to find the first occurence of 1
		while(arr[end]<key)		// the end should lie beyond key
		{
			start = end;
			end = end*2;		// keep on doubling until we find the end index
		}
		// at the end of this loop, we will have a start and end. We have the key already
		
		res = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid]==key)
			{
				res = mid;
				end = mid-1;		//as we need the first occurence, try to search in left part
			}
			else if(arr[mid]>key)
				end = mid-1;
			else
				start = mid+1;
		}
		return res;
	}

}
