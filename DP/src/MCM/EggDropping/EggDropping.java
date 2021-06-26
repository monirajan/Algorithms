package MCM.EggDropping;

/*
  Find the minimum # of attempts in which we can find the critical floor in worst case
  Critical floor - Above which the egg will break
  				 - Below which the egg will not break
  				 
  e - # of eggs,   f - # of floors
  				
  				solve(e,f)
 				/       \
 			break       not break
 			  |            |
 		solve(e-1,k-1)  solve(e,f-k)	    e ==> as the egg didn't break
  e-1 ==> as egg broke                    f-k ==> check for the above floors
  f-1 ==> bcos anyway egg will break in above all floors		
 */
public class EggDropping {

	public static void main(String args[])
	{
		int egg = 3;
		int floor = 5;
		System.out.println("Min # of attempts : " + minNoOfattempts(egg, floor));
	}

	private static int minNoOfattempts(int egg, int floor) {
		
		// 1. Base condition
		if(egg == 1 || floor == 0 || floor ==1)		// if there is only one egg, we ll try to drop it off from 1st floor until total # of floors
			return floor;
		
		int min = Integer.MAX_VALUE;
		
		// 2. k values - we have floor starting from 1 until total # of floors
		for(int k=1;k<=floor;k++)
		{
			int temp = 1 + Math.max(minNoOfattempts(egg-1, k-1), minNoOfattempts(egg, floor-k));		// find the worst case
			min = Math.min(min, temp);		// 3. min # of attempts in worst case
		}
		return min;
	}
}
