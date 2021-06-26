package MCM.booleanParanthesization;

import java.util.HashMap;
import java.util.Map;

// Memoization dp approach for Boolean Paranthesization

public class BooleanParanthesizationMemoization {
	
	public static void main(String args[])
	{
		String expression = "T|T&F^T";
		
		// as there are 3 variables for this problem, we need a 3D array for dp table. so for ease, we are gng for a map
		Map<String, Integer> mp = new HashMap<>();		// map to store the intermediate results
		mp.clear();
		
		// Variation of MCM
		// 1. Find value of i and j --> 0 to n-1
		System.out.println("# of ways " + waysToParanthesize(expression, 0, expression.length()-1, true, mp));
	}

	private static int waysToParanthesize(String expression, int i, int j, boolean isTrue, Map<String, Integer> mp) {
		
		// 2.Base condition
		if(i>j)				// empty string		
			return 0;
		
		if(i==j)			// single character
		{
			if(isTrue == true)			// check whether truthy or falsy result is expected
				return expression.charAt(i) == 'T'? 1 : 0;
			else
				return expression.charAt(i) == 'F'? 1 : 0;
		}
		
		String key = Integer.toString(i) + Integer.toString(j) + Boolean.toString(isTrue);
		if(mp.get(key)!=null)
			return mp.get(key);
		
		// Remember k as to track symbols
				int ways = 0;			// # of ways
				for(int k=i+1;k<=j-1;k=k+2)
				{
					int leftTrue   = waysToParanthesize(expression, i, k-1, true, mp);		// ways in which left expression can be evaluated to true
					int leftFalse  = waysToParanthesize(expression, i, k-1, false, mp);
					int rightTrue  = waysToParanthesize(expression, k+1, j, true, mp);		// ways in which right expression can be evaluated to true
					int rightFalse = waysToParanthesize(expression, k+1, j, false, mp);
					
					if(expression.charAt(k) == '&')
					{
						if(isTrue == true)
							ways = ways + leftTrue * rightTrue;			// # of ways in which AND expression can be evaluated to true
						else											// # of ways in which AND expression can be evaluated to false
							ways = ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
							
					}
					
					if(expression.charAt(k) == '|')
					{
						if(isTrue == true)
							ways = ways + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
						else
							ways = ways + leftFalse * rightFalse;
					}
					
					if(expression.charAt(k) == '^')
					{
						if(isTrue == true)
							ways = ways + (leftTrue * rightFalse) + (leftFalse * rightTrue);
						else
							ways = ways + (leftFalse * rightFalse) + (leftTrue * rightTrue);
					}
				}
				mp.put(key, ways);
				return ways;
			}
	}

