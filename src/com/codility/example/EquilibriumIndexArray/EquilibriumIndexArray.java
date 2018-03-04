package com.codility.example.EquilibriumIndexArray;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumIndexArray {
 

	public static void main(String[] args) {
		EquilibriumIndexArray indexArray = new EquilibriumIndexArray();
		System.out.println(indexArray.solution());
	}
	
	public Object[] solution() {
		int[] A = {-1,3,-4,5,1,-6,2,1};
		long rightSum = 0;
        for (int i = 0; i < A.length; i++)
        {
        	rightSum += A[i];
        }
        List<Integer> index = new ArrayList<Integer>();
        long leftSum = 0;
        for (int p = 0; p < A.length; p++)
        {
        	leftSum += p - 1 < 0 ? 0: A[p-1];
        	rightSum -= A[p];
            if (leftSum == rightSum)
            {
            	index.add(p);      
            }
        }
        return index.toArray();
    }
	
}
