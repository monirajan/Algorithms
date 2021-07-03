package Leetcode;

/*
 * Minimum cost required to travel everyday in the given list of days
 * The cost array contains the pass amount corresponding to 1 day, 7 days and 30 days
 */
public class MinTicketCost {
	
	public static int mincostTickets(int[] days, int[] costs) {
        
	       int[] dp = new int[days[days.length-1]+1];
	        dp[0] = 0;
	        int d=0;
	        for(int i=1;i<dp.length;i++){
	            if(days[d] == i){
	                int min=Integer.MAX_VALUE;
	                min = Math.min(min,dp[Math.max(0,(i-1))]+costs[0]);
	                min = Math.min(min,dp[Math.max(0,(i-7))]+costs[1]);
	                min = Math.min(min,dp[Math.max(0,(i-30))]+costs[2]);
	                dp[i] = min;
	                d++;
	            } else {
	                dp[i] = dp[i-1];
	            }
	        }
	        return dp[dp.length-1];
	    }

		public static void main(String args[])
		{
			int days[] = {1,2,3,4,5,6,7,8,9,10,30,31};
			int costs[] = {2,7,15};
			System.out.println("Minimum ticket cost : " + mincostTickets(days, costs));
			
		}
}
