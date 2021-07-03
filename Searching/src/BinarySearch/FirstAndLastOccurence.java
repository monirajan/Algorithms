package BinarySearch;

public class FirstAndLastOccurence {
	
	public static void main(String args[])
	{
		int arr[] = {1,5,8,8,8,9,10};
		int ele = 8;
		int firstOccurence = binarySearchFirstOccurence(arr,arr.length,ele);
		if(firstOccurence !=-1)
			System.out.println("First Occurence of the element is at pos "+firstOccurence);
		
		int lastOccurence = binarySearchLastOccurence(arr, arr.length, ele);
		if(lastOccurence != -1)
			System.out.println("Last Occurence of the element is at pos " + lastOccurence);
		
		// element count = last occurence - first occurence + 1
		int elementCnt = lastOccurence - firstOccurence + 1; 
		System.out.println("element count "+elementCnt);
	}

	public static int binarySearchFirstOccurence(int[] arr, int n, int searchElt) {
		
		/* In sorted array we know that if duplicate elements are present, then it will be continuous
		 * so to find the first occurence, first do the binary search as usual and instead of returning the mid position of elt if found,
		 * search for the same element in left subarray as we need FIRST occurence
		 */

		int start = 0;
		int end = n-1;
		int res = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;		// to avoid Integer overflow
			if(arr[mid] == searchElt)				// check if mid element is equal to search element
			{
				res = mid;		// store the index and search in left sub array
				end = mid-1;
			}
			else if(arr[mid]<searchElt)				//if search element is greater than mid elt, then search in right part
				start = mid+1;
			else									//else search in left part of the array
				end = mid-1;
		}
		
		return res;
	}
	
	public static int binarySearchLastOccurence(int[] arr, int n, int searchElt) {
			
	/* To find the last occurence, first do the binary search as usual and instead of returning the mid position of elt if found,
	 * search for the same element in right subarray as we need LAST occurence
	 */
	
		int start = 0;
		int end = n-1;
		int res = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;		// to avoid Integer overflow
			if(arr[mid] == searchElt)				// check if mid element is equal to search element
			{
				res = mid;		// store the index and search in left sub array
				start = mid+1;
			}
			else if(arr[mid]<searchElt)				//if search element is greater than mid elt, then search in right part
				start = mid+1;
			else									//else search in left part of the array
				end = mid-1;
		}
		
		return res;
	}


}
