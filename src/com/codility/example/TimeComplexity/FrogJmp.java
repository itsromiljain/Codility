/**
 * 
 */
package com.codility.example.TimeComplexity;

/**
 * @author romiljain
 *
 */
public class FrogJmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(30, 135, 10));
	}

	public static int solution(int X, int Y, int D) {
		int distance = Y-X;
		return (distance/D) + (distance%D !=0 ? 1:0);
	}
}
