package MCM.ScrambledString;

/* 
 Given two strings we need to find whether one is scrambled form of another
 
 Scrambled ???
 1. A string is said to be scrambled if it is represented as a binary tree and children of non-leaf nodes are swapped
 2. There should be no empty child. For example, consider the below scenario
 	     great
 		 /  \
 		" "  great			---> this cannot happen
 3. There can be zero or more swaps
 
 Example
 --------
 		 great     ---> Non-leaf
 		  / \
 		 g   reat  ---> Non-leaf (if swapped the children of "great", it would be "reatg")
 		      / \
             r  eat---> Non-leaf (if swapped the children of "reat", it would be "geatr")
 	             /\
 	            e at -->Non-leaf (if swapped the children of "eat", it would be "grate")
 	              /\ --> (if swapped the children of "at", it would be "greta")
 	             a  t 
 
 Variation of MCM. How ??
 As partition can be done in any position from 1 to (n-1) and we need to check whether the string is scrambled or not
 
 Why position is from 1 to n-1 ?? 
 |great --> as we cannot do partition at 0 th position. If we do so, we will have an empty child which is not allowed. similar for (n-1)
 
 Approach:
 ---------
 As there may be zero swaps, it means that the children may be swapped or may not. So consider each possible case and check whether we get the other string
 Case 1 :- [Swapped]  
 
    0 1   2 3 4       0 1 2   3 4
 	g r | e a t ----- e a t | g r
     \________________________/
     
    Here the children are swapped. Hence check whether 
    a)first half of a is scrambled string of second part of b &&
    b)second half of a is scrambled string of first part of b 
    
    solve(a.substring(0,i),  b.substring(n-i,i)) == true   ------> (1)
    solve(a.substring(i,n-i),b.substring(0,n-i)) == true   ------> (2)
    
    Case 1 ---------->  both (1) and (2) must be true 
    
  Case 2 :- [Not-swapped]
  
    0 1   2 3 4       0 1   2 3 4
 	g r | e a t       g r | e t a
    \_______\__________/      /
    		 \_______________/
    		 
    In this case, check with the corresponding halves of both the strings. 
    solve(a.substring(0,i),  b.substring(0,i))   == true   ------> (3)
    solve(a.substring(i,n-i),b.substring(i,n-i)) == true   ------> (4)
    
    Case 2 ------------> both (3) and (4) must be true
    
    So for the strings to be scrambled, either Case 1 OR Case 2 must be true
    
*/

public class ScrambledStringRecursive {
	
	public static void main(String args[])
	{
		String a = "great";
		String b = "reatg";
		
		// 1.Base case
		if(a.length()!=b.length())		// whatever swaps we do, we can't increase the length
			System.out.println("NO");
		
		if(a.length()==0 && b.length()==0)		// if both the strings are null, then they are scrambled
			System.out.println("YES");
			
		if(scrambledOrNot(a,b))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean scrambledOrNot(String a, String b) {
		
		// if both the strings are equal, then there is no swap and hence they are scrambled of each other
		if(a.equals(b)==true)
			return true;
		
		if(a.length()<=1)		// if string length is 1, then both a and b should be equal and should have returned from the above stmt
			return false;
		
		int n = a.length();
		for(int i=1;i<=n-1;i++)
		{
			// Case 1
			boolean swapped = scrambledOrNot(a.substring(0, i), b.substring(n-i,n)) && scrambledOrNot(a.substring(i, n), b.substring(0,n-i));
			// Case 2
			boolean notSwapped = scrambledOrNot(a.substring(0,i), b.substring(0,i)) && scrambledOrNot(a.substring(i,n), b.substring(i,n));
			
			if(swapped || notSwapped)		//return if either of the case is true
				return true;
		}
		
		return false;		//return false when both the case also fails for all possible combinations
	}
	
}
