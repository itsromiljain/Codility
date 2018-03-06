/**
 * 
 */
package com.codility.example.TimeComplexity;

/**
 * @author romiljain
 *
 */
public class PermMissingElem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2,6,8,4,5,3,1,9,10,7};
		long N = 10;
		System.out.println(anotherSolution(A, N));
	}
	
	public static int anotherSolution(int A[], long N) {
		long sum = 0;
		for(int i = 0; i< A.length; i++){
			sum+=A[i];
		}
		long actualSum = (N+1)*(N+2)/2;
		int missingElement = (int) (actualSum -sum);
		return missingElement;
	}

}
