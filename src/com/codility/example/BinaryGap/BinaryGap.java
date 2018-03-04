/**
 * 
 */
package com.codility.example.BinaryGap;

/**
 * @author romiljain
 *
 */
public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 328;	
		System.out.println(basicSolution (a));
		System.out.println(solution(a, 0, 0, 0));
				
	}
	
	static int basicSolution (int a) {
		String str = Integer.toBinaryString(a);
		char[] characters = str.toCharArray();
		int currentCount = 0;
		int maxCount = 0;
		for(Character c : characters){
			if(c =='1'){
				if(currentCount>maxCount){
					maxCount = currentCount;
				}
				currentCount=0;
			}else{
				currentCount++;
			}
		}
		return maxCount;
	}

	static int solution(int n, int max, int current, int index) {
	    if (n == 0)
	        return max;
	    else if (n % 2 == 0 && index == 0)
	    	return 0;
	    else if (n % 2 == 0 && index > 0)
	        return solution(n / 2, max, current + 1, index+1);
	    else
	        return solution(n / 2, Math.max(max, current), 0, index+1);
	}
}
