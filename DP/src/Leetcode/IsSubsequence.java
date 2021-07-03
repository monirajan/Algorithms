package Leetcode;

public class IsSubsequence {

	 public static void main(String args[])
	 {
	       String s = "abc";
	       String t = "ahjypsbc";
	       if(isSubsequence(s,t))
	    	   System.out.println("YES");
	       else
	    	   System.out.println("NO");
	 }
	 
	 public static boolean isSubsequence(String s, String t) {
	        
	        // find the LCS and check whether its length is equal to s.length
	        
	        int m,n;
	        m=s.length();
	        n=t.length();
	        
	        int dp[][] = new int[m+1][n+1];
	        
	        for(int i=0;i<=m;i++)
	        {
	            for(int j=0;j<=n;j++)
	            {
	                if(i==0 || j==0)
	                    dp[i][j] = 0;
	                else if(s.charAt(i-1)==t.charAt(j-1))
	                    dp[i][j] = 1 + dp[i-1][j-1];
	                else
	                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	        
	        return dp[m][n] == m?true:false;
	        
	    }
}
