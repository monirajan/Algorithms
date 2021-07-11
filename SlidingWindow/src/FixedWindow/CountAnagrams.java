package FixedWindow;

import java.util.HashMap;
import java.util.Map;

// Given a word and a pattern, return the count of the occurrences of anagrams of the pattern in the word
public class CountAnagrams {

	public static void main(String args[])
	{
		String str = "aabaabaa";
		String pattern = "aaba";
		System.out.println("# of occurences of anagrams : " + countOccurencesOfAnagrams(str, pattern));
	}

	private static int countOccurencesOfAnagrams(String str, String pattern) {
		
		Map<Character, Integer> mp = new HashMap<>();		// maintain a map to keep track of count of characters
		int count = 0;		// to avoid traversing the entire map repeatedly, maintain a count variable
		int answer = 0;		// variable for anagrams count
		
		int start, end, windowSize, size;
		start = end = 0;
		windowSize = pattern.length();
		size = str.length();
		
		for(int index=0;index<windowSize;index++)
			mp.put(pattern.charAt(index), mp.getOrDefault(pattern.charAt(index), 0)+1);
		count = mp.size();
		
		while(end<size)
		{
			if(mp.containsKey(str.charAt(end)))
				mp.put(str.charAt(end), mp.getOrDefault(str.charAt(end), 0)-1);
			if(mp.get(str.charAt(end)) == 0)
				count--;
			
			if(end-start+1 < windowSize)
				end++;
			else if(end-start+1 == windowSize)
			{
				if(count == 0)
					answer++;
				if(mp.containsKey(str.charAt(start)))
					mp.put(str.charAt(start), mp.get(str.charAt(start))+1);
				if(mp.get(str.charAt(end)) == 1)
					count++;
				start++;
				end++;
			}
		}
		
		return answer;
	}
	
}
