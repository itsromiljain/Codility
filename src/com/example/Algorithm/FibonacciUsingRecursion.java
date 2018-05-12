/**
 * 
 */
package com.example.Algorithm;

/**
 * @author romiljain
 * Implementation of Fibonacci series using Recursion (top to bottom approach)
 *
 */
public class FibonacciUsingRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciUsingRecursion fur = new FibonacciUsingRecursion();
		System.out.println(fur.fibonacciRecursion(7));
	}
	
	public int fibonacciRecursion(int number) {
		// number for which we need to calculate fibonacci series
		// if number is 1 or 2 return 1;
		if(number<3){
			//System.out.println(number);
			return 1;
		}else {
			// if number is >2 return fibonacciRecursion(n-1) + fibonacciRecursion(n-2)
			return fibonacciRecursion(number-1) + fibonacciRecursion(number-2);
		}
		
	}

}
