/**
 * 
 */
package com.codility.example.Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author romiljain
 * Implementation of Fibonacci series using Dynamic Programming
 * f(n) = 1 1 2 3 5 8 13 21 34 55 .....
 * 
 * 				 f(n)
 * 				/	\
 * 			f(n-1)  f(n-2)
 * 			/	\	/	\
 * 	    f(n-2)  f(n-3)  f(n-4)
 * 
 *
 */
public class FibonacciUsingDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciUsingDP fud = new FibonacciUsingDP();
		// Using Map for memoization
		long startTime =  System.nanoTime();
		fud.fibonacciUsingDP(10);
		long endTime =  System.nanoTime();
		System.out.println(endTime-startTime);
		// Using array for memoization
		startTime =  System.nanoTime();
		fud.fibonacciUsingDPII(10);
		endTime =  System.nanoTime();
		System.out.println(endTime-startTime);
	}
	
	public void fibonacciUsingDP(int number) {
		// Fibonacci Using Dynamic Programming
		// Dynamic Programming used memoization
		int[] array = new int[number];
		FibonacciUsingDP fud = new FibonacciUsingDP();
		for(int i=0; i<number; i++ ){
			System.out.println(fud.fibonacciRecursion(i, array));
		}
	}
	

	public int fibonacciRecursion(int number, int[] array) {
		// Instead of calculating the values again
		//memoizing the values which we have already calculated.
		if(array[number] !=0 ){
			return array[number];
		}
		// number for which we need to calculate fibonacci series
		// if number is 1 or 2 return 1;
		if(number<2){
			//System.out.println(number);
			array[number] = 1;
			return 1;
		}else {
			// if number is >2 return fibonacciRecursion(n-1) + fibonacciRecursion(n-2)
			int sum = fibonacciRecursion(number-1, array) + fibonacciRecursion(number-2, array);
			array[number] = sum;
			return sum;
		}
		
	}

	public void fibonacciUsingDPII(int number) {
		// Fibonacci Using Dynamic Programming
		// Dynamic Programming used memoization
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		FibonacciUsingDP fud = new FibonacciUsingDP();
		for(int i=1; i<=number; i++ ){
			System.out.println(fud.fibonacciRecursionII(i, map));
		}
	}

	public int fibonacciRecursionII(int number, Map<Integer, Integer> map) {
		// Instead of calculating the values again
		//memoizing the values which we have already calculated.
		if(map.containsKey(number)){
			return map.get(number);
		}
		// number for which we need to calculate fibonacci series
		// if number is 1 or 2 return 1;
		if(number<3){
			//System.out.println(number);
			map.put(number, 1);
			return 1;
		}else {
			// if number is >2 return fibonacciRecursion(n-1) + fibonacciRecursion(n-2)
			int sum = fibonacciRecursionII(number-1, map) + fibonacciRecursionII(number-2, map);
			map.put(number, sum);
			return sum;
		}
		
	}
	
}
