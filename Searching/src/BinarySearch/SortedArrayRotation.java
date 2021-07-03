package BinarySearch;

public class SortedArrayRotation {
	
	public static void main(String args[])
	{
		int arr[] = {9,10,15,18,1,5,8};
		int no = numberOfTimesSortedArrRotated(arr,arr.length);
		System.out.println("Number of times array is rotated : "+no);
		
		int searchElement = 15;
		int pos = findElement(arr, 0, arr.length-1, searchElement);
		System.out.println("Element found at position : "+pos);
	}

	private static int findElement(int[] arr, int start, int end, int searchElement) {
		
		/* 1. Compare mid element
		 * 2. Do BS for left subarray
		 * 3. Do BS for right subarray
		 * 4. compare the results and return the index
		 */
		if(start>end)
			return -1;
		
	    int mid = start + (end-start)/2;
	    if(arr[mid]==searchElement)
	    	return mid;
	    int ls = findElement(arr, start, mid-1, searchElement);
	    int rs = findElement(arr, mid+1, end, searchElement);
	    
		return ls>0?ls:rs;
	}

	public static int numberOfTimesSortedArrRotated(int[] arr, int n) {
		
		/* # of times rotated clockwise = index of minimum element
		  
		   Ex: 1 5 8 9 10 15 18 ---> before rotation
		       9 10 15 18 1 5 8 ---> after clockwise rotation
		 index 0  1  2 3  4 5 6
		 
		 How to find minimum element ??
		 	--> min element is less than both of its neighbours 
		 * 
		 */
		
		int start = 0;
		int end = n-1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			int prev = (mid+n-1)%n;			// to avoid array index out of bound 
			int next = (mid+1)%n;
			if(arr[next]<arr[mid])
				return next;
			if(arr[mid]<= arr[prev] && arr[mid]<= arr[next])
				return mid;
			else if(arr[start]<=arr[mid])	// move towards the unsorted sub array, left should always be small, if not then it is unsorted
				start = mid+1;				
			else if(arr[mid]<=arr[end])
				end = mid-1;
		}
		
		return 0;
	}

}
