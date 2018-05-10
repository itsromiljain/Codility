/**
 * 
 */
package com.codility.example.Algorithm;

/**
 * @author romiljain
 * Implementation of Fibonacci series using Bottom Up Approach
 *
 */
public class FibonacciUsingBottomUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciUsingBottomUp fub = new FibonacciUsingBottomUp();
		long startTime =  System.nanoTime();
		fub.fibonacciUsingBottomUp(10);
		long endTime =  System.nanoTime();
		System.out.println(endTime-startTime);
	}
	
	public void fibonacciUsingBottomUp(int number) {
		FibonacciUsingRecursion fur = new FibonacciUsingRecursion();
		for(int i=1; i<=number; i++ ){
			System.out.println(fur.fibonacciRecursion(i));
		}
	}
}
