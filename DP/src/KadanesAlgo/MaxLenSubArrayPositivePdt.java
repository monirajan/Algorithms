package KadanesAlgo;

// Find the maxlength of subarray with positive product

public class MaxLenSubArrayPositivePdt {

	public static void main(String args[])
	{
		int arr[] =  {-1, 2, -3, 4};
		System.out.println("Max Length sub array with Positive product "+ getMaxLen(arr));
	}
	
	public static int getMaxLen(int[] nums) {

        int n = nums.length;
        int res, pos, neg;
        res = pos = neg = 0;
        
        for(int i=0;i<n;i++)
        {
        	if(nums[i] == 0)		// Reset the values as 0 does not contribute to a positive product
        		pos = neg = 0;
        	else if(nums[i]>0)   // +ve element
        	{
        		pos+=1;		//increment the positive count by 1
        		
        		//if there is already a -ve element in subarray, then multiplying with the +ve no. will also become -ve
        		if(neg!=0)
        			neg+=1;		
        		
        		res = Math.max(res, pos);		//update the result with max length positive product
        	}
        	else		// -ve element
        	{
        		/*swap both pos and neg. why ?
        		  multiplying a -ve no. to a +ve product will make it as negative &
        		  multiplying a -ve no. to a -ve product will make it as positive
        		 */
        		int temp = neg;
        		neg = pos;
        		pos = temp;
        		
        		neg+=1;		//increment the negative count by 1
        		
        		// pos now holds the count of prev -ve values which has now become +ve on multiplying with the current no
        		if(pos!=0)
        			pos+=1;			//increment the positive count by 1 as the product now becomes +ve 
        		
        		res = Math.max(res, pos);		//update the result with max length positive product
        	}
        		
        }
        
        return res;
    }
}
