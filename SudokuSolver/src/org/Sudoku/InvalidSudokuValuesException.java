package org.Sudoku;

public class InvalidSudokuValuesException extends Exception {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1821164955723668038L;
	
	public InvalidSudokuValuesException() {
		
	}
	
	public String toString() {
		return "Sudoku has been initialized with invalid values";
	}

}
