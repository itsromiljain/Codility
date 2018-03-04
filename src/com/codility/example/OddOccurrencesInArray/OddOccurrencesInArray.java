/**
 * 
 */
package com.codility.example.OddOccurrencesInArray;

import java.util.HashSet;
import java.util.Set;

/**
 * @author romiljain
 *
 */
public class OddOccurrencesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OddOccurrencesInArray occurence = new OddOccurrencesInArray();
		System.out.println(occurence.solution(new int[] { 9, 3, 9, 3, 9, 7, 9, 7, 7, 1, 1, 4, 7 }));
	}
	
	public int solution(int[] A) {
        Set<Integer> arraySet = new HashSet<Integer>(A.length/2);
        
        for(int i=0; i<A.length; i++){
        	if(arraySet.contains(A[i])){
        		arraySet.remove(A[i]);
        	}else{
        		arraySet.add(A[i]);
        	}
        }
        
        return (int)arraySet.toArray()[0];
    }

}
