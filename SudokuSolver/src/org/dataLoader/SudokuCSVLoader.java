package org.dataLoader;
import java.io.*;

import org.Sudoku.Sudoku;
import java.util.ArrayList;

/**
 * This class is used to import Sudokus from a CSV-File. The File used for training purposes was downloaded from https://www.kaggle.com/bryanpark/sudoku
 * @author Marco
 *
 */
public class SudokuCSVLoader {
	
	/**
	 * The CSV-File containing Sudokus and their Solutins
	 */
	private File file;
	
	/**
	 * BufferedReader used to read the File
	 */
	private BufferedReader br;
	
	/**
	 * Generates a FileLoader to read the CSV-File
	 * @param filepath The absolute path of the CSV-File to read
	 */
	public SudokuCSVLoader(String filepath) {
		try {
			file = new File(filepath);
			br = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("Invalid Filepath");
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads the CSV-File and returns all the Sudokus and their Solutions in a Matrix
	 * @return A matrix containing each Sudoku with its solution
	 */
	public Sudoku[][] readFile(){
		ArrayList<Sudoku> sudokus = new ArrayList<Sudoku>();
		ArrayList<Sudoku> solutions = new ArrayList<Sudoku>();
		try {
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				sudokus.add(new Sudoku(values[0]));
				solutions.add(new Sudoku(values[1]));
			}
			Sudoku[][] data = new Sudoku[sudokus.size()][2];
			for(int i = 0; i < sudokus.size(); i++) {
				data[i][0] = sudokus.get(i);
				data[i][1] = solutions.get(i);
			}
			return data;
		} catch(Exception e) {
			System.out.println("An unknown exception occured while reading the file.");
			e.printStackTrace();
			return null;
		}
	}

}
