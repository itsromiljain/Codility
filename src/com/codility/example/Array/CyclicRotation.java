/**
 * 
 */
package com.codility.example.Array;

/**
 * @author romiljain
 *
 */
public class CyclicRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {};
		int k = 22;
		System.out.println(solution(A, k));
	}
	
	public static int[] solution(int[] A, int K) {
		
		int[] rotatedArray = new int[A.length];
		
		if(A.length==0 || A.length==1 || K==0 || (K == A.length && A.length % K == 0)){
			return A;
		}else if(K>A.length){
			K = K % A.length;
		}
		
		for(int j=0; j< A.length; j++){
			rotatedArray[(j + K) > (A.length - 1) ? ((j + K) - A.length) : (j + K)] = A[j];
		}
		
        return rotatedArray;
    }

}
