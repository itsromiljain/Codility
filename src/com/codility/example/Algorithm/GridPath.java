/**
 * 
 */
package com.codility.example.Algorithm;

/**
 * @author romiljain
 * 
 * Given a grid of size m * n, let us assume you are starting at (1, 1) and your goal is to reach (m, n). 
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 *
 */
public class GridPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 4*4 matrix starting at top and reaching at bottom
		// grid[1][1], grid[2][2] are obstacles
		int row = 4;
		int column = 4;
		int[][] grid = new int[row][column];
		GridPath gp = new GridPath();
		System.out.println(gp.countPaths(0, 0, grid));
	}
	
	public int countPaths(int row, int column, int[][] grid) {
		if(!validSquare(row, column, grid.length)) return 0;
		if (isAtEnd(row, column, grid.length)){
			return 1;
		}
		// Memoization of already visited grid
		if (grid[row][column] != 0) {
			System.out.println("Memoized Row & Column : "+row +column);
			return grid[row][column];
		}
		int count = countPaths(row, column+1, grid) + countPaths(row+1, column, grid);
		grid[row][column] = count;
		return count;
	}
	
	public boolean validSquare(int row, int column, int gridLength) {
		// grid[1][1], grid[2][2] are obstacles
		if ((row > gridLength-1 || column > gridLength-1) || (row == 1 && column == 1) || (row == 2 && column == 2)) {
			return false;
		}
		return true;
	}
	
	public boolean isAtEnd(int row, int column, int gridLength){
		if (row==gridLength-1 && column==gridLength-1){
			return true;
		}
		return false;
	}
}
