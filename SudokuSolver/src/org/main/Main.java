package org.main;

import org.Sudoku.Sudoku;
import org.dataLoader.SudokuCSVLoader;

public class Main {

	public static void main(String[] args) {
		SudokuCSVLoader loader = new SudokuCSVLoader("D:\\Dokumente\\SudokuTraining\\sudoku.csv");
		Sudoku[][] data = loader.readFile();
		data[0][0].display();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		data[0][1].display();
	}

}
