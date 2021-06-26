package MCM.booleanParanthesization;

// Number of ways in which the boolean expression can be paranthesized so that the result will be true
// This is a variation of MCM
// We are given a string. Paranthesis needs to be placed at different places between i and j & it needs to be evaluated

public class BooleanParanthesizationRecursive {

	public static void main(String args[])
	{
		String expression = "T|T&F^T";
		
		// Variation of MCM
		// 1. Find value of i and j --> 0 to n-1
		System.out.println("# of ways " + waysToParanthesize(expression, 0, expression.length()-1, true));
	}

	private static int waysToParanthesize(String expression, int i, int j, boolean isTrue) {
		
		// 2. Base condition
		if(i>j)				// empty string		
			return 0;
		
		if(i==j)			// single character
		{
			if(isTrue == true)			// check whether truthy or falsy result is expected
				return expression.charAt(i) == 'T'? 1 : 0;
			else
				return expression.charAt(i) == 'F'? 1 : 0;
		}
		
		// 3. Partition scheme
		// (T | F) & (T)
		//  i k    k  j
		// k can always start from i+1 and should be moved by +2 bcos symbols are present one apart  (i+1 to j-1)
		// function needs to be called in (i to k-1) and (k+1 to j) interval bcos k is the symbol
		
		// Remember k as to track symbols
		int ways = 0;			// # of ways
		for(int k=i+1;k<=j-1;k=k+2)
		{
			int leftTrue   = waysToParanthesize(expression, i, k-1, true);		// ways in which left expression can be evaluated to true
			int leftFalse  = waysToParanthesize(expression, i, k-1, false);
			int rightTrue  = waysToParanthesize(expression, k+1, j, true);		// ways in which right expression can be evaluated to true
			int rightFalse = waysToParanthesize(expression, k+1, j, false);
			
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
		return ways;
	}
	
	// why we are multiplying ???
	// Consider expr1  xor expr2
	//           T(2)  xor  F(4)
	// 2 ways in which expr1 can be evaluated to True, 4 ways in which expr2 can be evaluated to False
	// so total ways = 2 * 4 = 8
	// T _____ F
	//  \______F
	//	\______F
	//	\______F
}
