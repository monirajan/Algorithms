package BS.Pattern;

/*
 * 1. Find the index of Peak Element
 * Peak Element ?? 
 * 		Element in array which is greater than both of its neighbors
 * Array can be sorted/unsorted
 * 
 * The same problem can be otherwise stated as 
 * 2. Find the max element in Bitonic array
 * Bitonic array ??
 * Bitonic array is one which increases and then decreases montonically
 * So ideally max element in Bitonic array is the one which is greater than both of its neighbours
 */
public class PeakElement {
	
	public static void main(String args[])
	{
		int arr[] = {5,10,20,15};		// 20 is the peak element
		System.out.println("Index of Peak element : "+ indexOfPeakElement(arr, arr.length));
		
		int arr1[] = {10,20,30,40,50};		// 50 is the peak element
		System.out.println("Index of Peak element : "+ indexOfPeakElement(arr1, arr1.length));
		
		int arr2[] = {50,40,30,20,10};		// 50 is the peak element
		System.out.println("Index of Peak element : "+ indexOfPeakElement(arr2, arr2.length));
	}

	private static int indexOfPeakElement(int[] arr, int arrLength) {
		
		int start = 0;
		int end = arrLength-1;
		
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			
			// We have corner cases. For leftmost and rightmost elements, criteria is only upon one neighbor as they dont have the other
			if(mid>0 && mid<arrLength-1)		 // this is only for elements which has both the neighbors
			{
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])		// if the element is greater than both of its neighbors
					return mid;
				else if(arr[mid]<arr[mid+1])		// move in the direction of possible candidates
					start = mid+1;		// as we know that our peak element should be greater, we are moving in the direction of greater element
				else
					end = mid-1;
			}
			else if(mid==0)		// If possible answer doesnt return from the above part, check for the leftmost element
			{
				if(arr[0]>arr[1])
					return 0;
				else
					return 1;
			}
			else if(mid == arrLength-1)		// check for the rightmost element
			{
				if(arr[arrLength-1]>arr[arrLength-2])
					return arrLength-1;
				else
					return arrLength-2;
			}
			
		}
		return -1;
	}

}
