package BS.Pattern;

/* Search in a nearly sorted array. What is meant by nearly sorted array ??
 * The element which should be present in pos in array can be present either at pos-1 or pos+1
 */
public class SearchNearlySortedArray {
	
	public static void main(String args[])
	{
		int arr[] = {10, 3, 40, 20, 50, 80, 70};
		int searchElt = 80;
		int pos = searchInNearlySortedArray(arr, arr.length, searchElt);
		System.out.println("Element found at pos : "+ pos);
	}

	private static int searchInNearlySortedArray(int[] arr, int n, int searchElt) {
		
		int start = 0;
		int end = n-1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid] ==  searchElt)
				return mid;
			if((mid-1 >= start) && arr[mid-1] == searchElt)		// check for mid-1 and mid+1 in addition to mid
				return mid-1;
			if(mid+1 <= end && arr[mid+1] == searchElt)
				return mid+1;
			if(searchElt<arr[mid])		// as we have checked mid-1 and mid+1 already, set start and end value accordingly
				end = mid-2;
			else
				start = mid+2;
		}
		return -1;
	}

}
