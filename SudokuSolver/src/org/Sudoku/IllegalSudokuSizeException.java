package org.Sudoku;

public class IllegalSudokuSizeException extends Exception {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3191061925780516949L;
	
	public IllegalSudokuSizeException() {
		
	}
	
	public String toString() {
		return "Tried to initialize Sudoku with illegal value-matrix";
	}

}
