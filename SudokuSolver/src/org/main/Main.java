package org.main;

import org.Sudoku.Sudoku;

public class Main {

	public static void main(String[] args) {
		int[][] solvedSudoku = {{8,2,7,1,5,4,3,9,6},
								{9,6,5,3,2,7,1,4,8},
								{3,4,1,6,8,9,7,5,2},
								{5,9,3,4,6,8,2,7,1},
								{4,7,2,5,1,3,6,8,9},
								{6,1,8,9,7,2,4,3,5},
								{7,8,6,2,3,5,9,1,4},
								{1,5,4,7,9,6,8,2,3},
								{2,3,9,8,4,1,5,6,7}};
		
		try {
			Sudoku s = new Sudoku(3, solvedSudoku);
			System.out.println(s.isSolved());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Check complete!");
	}

}
