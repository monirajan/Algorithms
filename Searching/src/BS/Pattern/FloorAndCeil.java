package BS.Pattern;

/* Floor and Ceil element in an array
 * Floor = greatest elt smaller than search element
 * Ceil = smallest elt greater than search element 
 */
public class FloorAndCeil {
	
	public static void main(String args[])
	{
		int arr[] = {1, 2, 3, 4, 8, 10, 10, 12, 19};
		int element = 5;
		int floor  = floorElement(arr, 0, arr.length-1, element);
		System.out.println("Floor element : "+ floor);
		
		int ceil = ceilElement(arr, 0, arr.length-1, element);
		System.out.println("Ceil element : "+ ceil);
		
		char carr[] = {'a', 'd', 'e', 'f', 'h', 'm'};
		char elt = 'f';
		System.out.println("" + nextAlphabet(carr, 0, carr.length-1, elt));
		
	}

	private static char nextAlphabet(char[] carr, int start, int end, char elt) {
		
		char res = '#';
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(carr[mid] ==  elt)
				start = mid+1;			// we need the next alphabet, hence move towards right
			if(carr[mid] > elt)			// if mid elt > search elt, it is a possible candidate
			{
				res = carr[mid];
				end = mid-1;		//we need smallest elt greater than search elt, so move towards left
			}
			else
				start = mid+1;
		}
		return res;
	}

	private static int ceilElement(int[] arr, int start, int end, int element) {
		// Smallest element GREATER than search element
		
		int res = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid] ==  element)
				return arr[mid];
			if(arr[mid] >= element)		// if mid elt > search elt, it is a possible candidate
			{
				res = arr[mid];
				end = mid-1;		//we need smallest elt greater than search elt, so move towards left
			}
			else
				start = mid+1;
		}
		return res;
	}

	private static int floorElement(int[] arr, int start, int end, int element) {
		
		// Greatest element smaller than search element
		
		int res = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(arr[mid] ==  element)
				return arr[mid];
			if(arr[mid] <= element)		// if mid element < search element, then it is a possible candidate
			{
				res = arr[mid];		// store the possible candidate
				start = mid+1;		// we need the greatest element smaller than search element, so move right
			}
			else		// if mid elt > search elt, then we need smallest element, so move towards left
				end = mid-1;		
		}	
		return res;
	}


}
