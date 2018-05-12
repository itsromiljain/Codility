/**
 * 
 */
package com.example.Algorithm;

import java.util.Scanner;

/**
 * @author romiljain
 * Enter any String and reverse that String using Recursion
 *
 */
public class StringReversalUsingRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String to reverse: ");
		String str = scan.nextLine();
		scan.close();
		StringReversalUsingRecursion srr = new StringReversalUsingRecursion();
		System.out.print(srr.stringReversal(str));
	}
	
	public String stringReversal(String str) {
		
		if(str == null || str.length()<=1){
			return str;
		}
		return stringReversal(str.substring(1)) + str.charAt(0);
	}

}
