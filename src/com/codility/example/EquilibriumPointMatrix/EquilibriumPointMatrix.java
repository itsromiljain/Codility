/**
 * 
 */
package com.codility.example.EquilibriumPointMatrix;

/**
 * @author romiljain
 *
 */
public class EquilibriumPointMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EquilibriumPointMatrix equilibriumPointMatrix = new EquilibriumPointMatrix();
		equilibriumPointMatrix.solution();
	}
	
	public void solution() {
        // write your code in Java SE 8
	 	int A[][] = {{2,7,5},{3,1,1},{2,1,-7},{0,2,1},{1,6,8}}; 
	 
        int rows = A.length;
        int cols = A[0].length;
        
        int[] rowSum = new int[rows];
        for (int i = 0; i < rows; i++){   
            for (int j = 0; j < A[i].length; j++){                
                rowSum[i] += A[i][j];
            }
        }
        
        int[] colSum = new int[cols];
        for (int j = 0; j < cols; j++){   
            for (int i = 0; i < rows; i++){                
            	colSum[j] += A[i][j];
            }
        }

        int totalSum = 0;
        for(int k=0;k<rowSum.length;k++){
        	totalSum += rowSum[k];  
        }
        
        int leftSum = 0;
        int rightSum = totalSum;
        int sumAbove = 0;
        int sumBelow = totalSum;
        int count = 0;
        for (int i=0; i<rows ; i++){
        	sumBelow -= rowSum[i];
        	rightSum = totalSum;
        	leftSum = 0;
        	for (int j=0; j<cols; j++){
        		rightSum -= colSum[j];
        	    	if (sumBelow == sumAbove && leftSum == rightSum){
        	    		System.out.println(++count);
        	    		System.out.println(i + "<--->" +j);
        	    		System.out.println(A[i][j]);
        	    	}
        	    	leftSum += colSum[j];
        	}
        	sumAbove += rowSum[i];
        }
         
    }

}
