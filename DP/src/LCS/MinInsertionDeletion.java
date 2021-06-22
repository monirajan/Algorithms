package LCS;

import LCS.standard.LCSBottomUp;

// Problem to return the # of minimum number of insertion & deletion to convert a-->b
// where a and b are 2 strings
// LCS pattern - How ??
// Input - 2 strings, output - integer

public class MinInsertionDeletion {
	
	public static void main(String args[])
	{
		String X = "heap";
		String Y = "pea";
		
		int m = X.length();
		int n = Y.length();
		
		minNoOfInsertionDeletion(X, Y, m, n);
	}

	public static void minNoOfInsertionDeletion(String X, String Y, int m, int n) {
		
		// We are going to use the concept of LCS to find the # of insertion/deletion
		//     heap -----> pea
		// Del  \        / Ins
		//        ea(lcs)
		// # of deletions = X.length - LCS
		// # of insertion = Y.length - LCS
		
		int minDel = m - LCSBottomUp.lcs(X, Y, m, n);
		int minIns = n - LCSBottomUp.lcs(X, Y, m, n);
		System.out.println("Min # of Deletions "+ minDel + " Min # of Insertions " + minIns);
	}

}
