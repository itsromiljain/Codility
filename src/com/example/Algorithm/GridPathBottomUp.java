/**
 * 
 */
package com.example.Algorithm;

/**
 * @author romiljain
 * Given a grid of size m * n, let us assume you are starting at (m, n) and your goal is to reach (1, 1). 
 * At any instance, if you are on (x, y), you can either go to (x-1, y) or (x, y-1).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 */
public class GridPathBottomUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int row = 4;
		int column = 4;
		int[][] gridBottom = new int[row][column];
		GridPathBottomUp gpb = new GridPathBottomUp();
		System.out.println(gpb.countPathsBottomToTop(row - 1, column - 1, gridBottom));
	}

	public int countPathsBottomToTop(int row, int column, int[][] paths) {
		if(!validSquare(row, column)) return 0;
		if (isAtEnd(row, column)){
			return 1;
		}
		// Memoization of already visited grid
		if (paths[row][column] != 0) {
			System.out.println("Memoized Row & Column : "+row +column);
			return paths[row][column];
		}
		int count = countPathsBottomToTop(row - 1, column, paths) + countPathsBottomToTop(row, column - 1, paths);
		paths[row][column] = count;
		return count;
	}
	
	public boolean validSquare(int row, int column) {
		if ((row < 0 || column < 0) || (row == 1 && column == 1) || (row == 2 && column == 2)) {
			return false;
		}
		return true;
	}
	
	public boolean isAtEnd(int row, int column){
		if (row==0 && column==0){
			return true;
		}
		return false;
	}
}
