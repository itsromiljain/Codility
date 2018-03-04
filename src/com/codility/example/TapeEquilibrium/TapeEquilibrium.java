/**
 * 
 */
package com.codility.example.TapeEquilibrium;

/**
 * @author romiljain
 *
 */
public class TapeEquilibrium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TapeEquilibrium equ = new TapeEquilibrium();
		System.out.println(equ.solution());

	}
	
	public int solution() {
		int[] A = {8,3,2,6,7,4,1,2};
		int rightSum = 0;
        for (int i = 0; i < A.length; i++)
        {
        	rightSum += A[i];
        }
        int min = Integer.MAX_VALUE;
        int leftSum = 0;
        for (int p = 0; p < A.length; p++)
        {
        	leftSum += A[p];
        	rightSum -= A[p];
        	int absDiff = Math.abs(rightSum-leftSum);
        	if(absDiff < min){
        		min = absDiff;
        	}	
        }
        return min;     
    }

}
