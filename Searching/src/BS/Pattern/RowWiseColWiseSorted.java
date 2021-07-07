package BS.Pattern;

/*
 * Search an element in row wise and column wise sorted array.
 * 
 * In BS, we will compare the mid element with the key and based on the value we will move either left or right
 * Likewise, for this problem start from the rightmost element in 1 st row of matrix
 * Decide whether to go DOWN or LEFT based on the key and element
 * Worst Case TC : O(m+n)
 */
public class RowWiseColWiseSorted {
	
	static class Pair
	{
		int i;
		int j;
	}
	
	public static void main(String args[])
	{
		int arr[][] = {{10,20,30,40},
						{15,25,35,45},
						{27,29,37,46},
						{32,33,39,50}};
		
		int searchKey = 29;
		Pair res = searchInRowColSortedArray(arr,4,4,searchKey);
		System.out.println("Element found at position : " + res.i + " " + res.j);
	}

	private static Pair searchInRowColSortedArray(int[][] arr, int row, int col, int searchKey) {
		
		int rowIndex = 0;
		int colIndex = col-1;		//start from rightmost element in 1st row
		
		while(rowIndex >= 0 && colIndex >= 0 && rowIndex <= row-1 && colIndex <= col-1)
		{
			if(arr[rowIndex][colIndex] == searchKey)
			{
				Pair p = new Pair();
				p.i = rowIndex;
				p.j = colIndex;
				return p;
			}
			else if(arr[rowIndex][colIndex] > searchKey)	// if the current element is greater than search key, then ignore the elements in down
				colIndex--;			// move towards left as all the elements will be greater than the current element in down direction
			else
				rowIndex++;		// move towards down when the current element is less than search element
		}
		return new Pair();			// return -1 if search key is not found
	}

}
