package BinarySearch;

// Standard binary search algorithm for searching an element in a sorted array

public class BinarySearchStandard {

	public static void main(String args[])
	{
		int arr[] = {1,5,8,9,10};
		int ele = 5;
		int elePos = binarySearch(arr,arr.length,ele);
		if(elePos !=-1)
			System.out.println("Found at pos : "+elePos);
		else
			System.out.println("Not found");
	}

	private static int binarySearch(int[] arr, int n, int searchElt) {
		
		int start = 0;
		int end = n-1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;		// to avoid Integer overflow
			if(arr[mid] == searchElt)				// check if mid element is equal to search element
				return mid;
			else if(arr[mid]<searchElt)				//if search element is greater than mid elt, then search in right part
				start = mid+1;
			else									//else search in left part of the array
				end = mid-1;
		}
		return -1;
	}
}
