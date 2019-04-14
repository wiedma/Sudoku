package org.Sudoku;

import java.util.ArrayList;

public class Sudoku {
	
	/**
	 * Size of the Sudoku \n
	 * The Sudoku will be initialized with size^4 fields grouped into size^2 squares each with a size of size^2.\n
	 * The maximum value of each field is determined by size^2.
	 */
	private int size;
	
	/**
	 * An Integer Matrix representing the values in each field of the Sudoku.
	 */
	private int[][] values;
	
	/**
	 * The standard value which represents an empty field in the Sudoku.
	 */
	public static final int STANDARD_VALUE = 0;
	
	/**
	 * Creates an empty Sudoku
	 * @param size the size of the Sudoku
	 */
	public Sudoku(int size) {
		this.size = size;
		values = new int[size*size][size*size];
		for(int i = 0; i < size*size; i++) {
			for(int j = 0; j < size*size; j++) {
				values[i][j] = STANDARD_VALUE;
			}
		}
	}
	
	/**
	 * Creates a Sudoku
	 * @param size The size of the Sudoku
	 * @param values The values the Sudoku should be filled with. The matrix must have the dimensions size^2 and size^2 
	 */
	public Sudoku(int size, int[][] values) throws Exception {
		this.size = size;
		if(values.length == size*size && values[0].length == size*size) {
			this.values = values;			
		}
		else {
			throw new IllegalSudokuSizeException();
		}
		if(!validate()) {
			throw new InvalidSudokuValuesException();
		}
	}
	
	/**
	 * Checks if a Sudoku is valid.\n
	 * A Sudoku is valid, when where is no duplicate number in any column, row or square, except for the standard value.\n
	 * A valid Sudoku is not neccesarily solved, but is in principle solvable. However there is no guarantee that there is only one valid solution.
	 * @return boolean indicating if this Sudoku is valid.
	 */
	public boolean validate() {
		for(int i = 0; i < size * size; i++) {
			//Check Sudoku rows
			if(!validateSubset(values[i])) {
				return false;
			}
			
			//Check Sudoku columns and squares
			int[] column = new int[size * size];
			int[] square = new int[size * size];
			for(int j = 0; j < size*size; j++) {
				column[j] = values[j][i];
				square[j] = values[(i%size) * size + (j%size)][(i/size) * size + (j/size)];
			}
			if(!validateSubset(column) || !validateSubset(square)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a Subset of this Sudoku is valid.\n
	 * A Subset is valid if it contains no duplicate number, except for the default number.\n
	 * A valid Subset is not neccesarily solved. 
	 * @param subset An Integer Array containig the Subset of the Sudoku which is to be checked.\n
	 * It has to have the length of size^2. A Subset can be a row, column or square.
	 * @return boolean indicating if this Subset is valid.
	 */
	private boolean validateSubset(int[] subset) {
		if(subset.length != size*size) {
			return false;
		}
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
		for(int i : subset) {
			if(i == STANDARD_VALUE) {
				break;
			}
			if(i < 1 || i > size*size) {
				return false;
			}
			if(usedNumbers.contains(i)) {
				return false;
			}
			usedNumbers.add(i);
		}
		return true;
	}
	
	/**
	 * Checks if this Sudoku is solved.\n
	 * A Sudoku is considered solved when each Subset of the Sudoku is solved. A Subset can be a column, row or square within the Sudoku.\n
	 * A solved Sudoku is always valid.
	 * @return boolean indicating if this Sudoku is solved
	 */
	public boolean isSolved() {
		for(int i = 0; i < size * size; i++) {
			//Check Sudoku rows
			if(!isSubsetSolved(values[i])) {
				return false;
			}
			
			//Check Sudoku columns and squares
			int[] column = new int[size * size];
			int[] square = new int[size * size];
			for(int j = 0; j < size*size; j++) {
				column[j] = values[j][i];
				square[j] = values[(i%size) * size + (j%size)][(i/size) * size + (j/size)];
			}
			if(!isSubsetSolved(column) || !isSubsetSolved(square)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a Subset of the Sudoku is solved.\n
	 * A Subset is considered solved if it contains each Integer from 1 to size^2 exactly once.
	 * @param subset The Subset which is to be checked. A Subset can be a column, row or square within the Sudoku.
	 * @return boolean indicating if this Subset is solved.
	 */
	private boolean isSubsetSolved(int[] subset) {
		if(subset.length != size*size) {
			return false;
		}
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
		for(int i : subset) {
			if(i == STANDARD_VALUE) {
				return false;
			}
			if(i < 1 || i > size*size) {
				return false;
			}
			if(usedNumbers.contains(i)) {
				return false;
			}
			usedNumbers.add(i);
		}
		return true;
	}
	
	/**
	 * Returns a unique String for each Sudoku which can be compared alphanumerically.\n
	 * Two equal Sudokus will always return the same String.
	 * @return the String representing this Sudoku
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < size*size; i++) {
			for(int j = 0; j < size*size; j++) {
				s += values[i][j];
			}
		}
		return s;
	}

}
