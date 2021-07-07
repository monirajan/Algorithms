package BS.Pattern;

/*
 * Given number of pages in n different books and k students. 
 * The books are arranged in ascending order of number of pages. 
 * Every student is assigned to read some CONSECUTIVE books. Every student must be allocated atleast one book. No sharing of books between students.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
 */
public class AllocateMinNoOfPages {
	
	public static void main(String args[])
	{
		int arr[] = {10, 20, 30, 40};
		int k = 2;
		System.out.println("Maximum # of page read by a student : " + minimiseStressForStudents(arr,arr.length,k));
	}

	private static int minimiseStressForStudents(int[] arr, int n, int k) {
		
		/*
		 * Consider the array above : 10, 20, 30, 40
		 * The books can be distributed in 3 ways to 2 students
		 * s1 - 10 		s1 - 30		s1 - 60
		 * s2 - 90		s2 - 70		s2 - 40
		 * -----------------------------------
		 * Max  90           70          60  -------> minimise the max # of pages. so here it is 60.
		 * 
		 * Possible values for max # of pages will lie in the timeline
		 * 
		 * |_________________________________________________________|
		 * start = max elt									     end = sum of array
		 * 
		 * start = max element as atleast one book should be read by each student
		 * Find mid and consider it as the max pages allowed and check whether that can be accompanied with given list of students
		 * If yes, try to minimise it further by going left. If no, check in the the right subarray
		 */
		int maxElementInArray = arr[0];
		int arraySum = arr[0];
		for(int i=1;i<n;i++)
		{
			arraySum += arr[i];
			if(arr[i]>maxElementInArray)
				maxElementInArray = arr[i];
		}
		
		int start = maxElementInArray;		// initialize start as maximum element in array
		int end = arraySum;					// end as total array sum
		
		int maxNoOfPages = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(isValid(arr, n, k, mid) == true)		// check whether books can be distributed with this max range
			{
				maxNoOfPages = mid;		// store the result and try to minimise it further
				end = mid-1;
			}
			else
				start = mid+1;
		}
		return maxNoOfPages;
	}

	// Function to check whether the distribution can be achieved with the given max Range
	private static boolean isValid(int[] arr, int n, int k, int maxNoOfPages) {
		
		int students = 1;
		int sum = 0;
		for(int i=0;i<n;i++)
		{
			sum = sum + arr[i];		// add the current element to sum
			if(sum > maxNoOfPages)	// if sums exceeds the max range
			{
				students ++;		// then we need one more student
				sum = arr[i];		// re-initialise the sum
			}
			if(students>k)			//if it cannot be accomodated with the given student count, then return false
				return false;
		}
		
		return true;
	}

}
