package dev.shashanksridhar;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * A class to read/write numerical CSV Files and allow easy access
 * @author Shashank
 *
 */
public class CSVDATA {
	private double[][] data;
	private String[] columnNames;
	private String filePathToCSV;
	private int numRows;
	
	public CSVDATA(String filepath, String[] columnNames, int startRow) {
		 this.filePathToCSV = filepath;

		 String dataString = readFileAsString(filepath);
		 String[] lines = dataString.split("\n");

		 // number of data points
		 int n = lines.length - startRow;
		 this.numRows = n;
		 int numColumns = columnNames.length;

		 // create storage for column names
		 this.columnNames = columnNames;

		 // create storage for data
		 this.data = new double[n][numColumns];
		 for (int i = 0; i < lines.length - startRow; i++) {
		 String line = lines[startRow + i];
		 String[] coords = line.split(",");
		 for (int j = 0; j < numColumns; j++) {
		 if (coords[j].endsWith("\n")) coords[j] = coords[j].substring(0, coords[j].length()-1);
		 double val = Double.parseDouble(coords[j]);
		 data[i][j] = val;
		 }
		 }
		 }

		private String readFileAsString(String filepath) {
		 StringBuilder output = new StringBuilder();
		 try (Scanner scanner = new Scanner(new File(filepath))) {
		 while (scanner.hasNext()) {
		 String line = scanner.nextLine();
		 output.append(line + System.getProperty("line.separator"));
		 }
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 return output.toString();
		 }
	public static CSVDATA readCSVFile(String filename, int numLinesToIgnore, String[] comlumnNames) {
		return null;	
	}
	/***
	 * Returns a new CSV data object for a file ignoring lines at the top.
	 * It uses the first row as the column name. All other data is stored as doubles.
	 * 
	 * @param filename
	 * @param numLinesToIgnore
	 * @return a CSV object for that file
	 */
	public CSVDATA readCSVFile(String filename, int numLinesToIgnore) {
		return null;
	}
	/***
	 * returns an individual row
	 * @param row
	 * @return
	 */
	public double[] getIndividualRow( int row) {
		return data[row];
	}
	/***
	 * returns an individual column
	 * @param col
	 * @return
	 */
	public double[] getIndividualCol( int col) {
		double [] colArr = new double[data.length];
		for(int r = 0; r < data.length; r++) {
			colArr[r]=data[r][col];
		}
		return colArr;
	}
	/***
	 * returns multiple rows given start row and end row 
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public double[][] getMultipleRows(int startRow, int endRow) {
		double [][] outputArr = new double [endRow - startRow][];
		int rowNum=0;
		for (int i= startRow; i < endRow; i++) {
			for (int j= 0; j < outputArr[0].length; j++) {
			outputArr[rowNum][j]= data [i][j];
		}
			rowNum++;
		}
		return outputArr;
			
	}
	/***
	 * returns multiple columns given start column and end column
	 * @param startCol
	 * @param endCol
	 * @return
	 */
	public double[][] getMultipleCols( int startCol, int endCol) {
		double [][] outputArr = new double [endCol - startCol][data.length];
		int colNum=0;
		for (int i= startCol; i < endCol; i++) {
			for (int j= 0; j < outputArr[0].length; j++) {
			outputArr[colNum][j]= data [j][i];
		}
			colNum++;
		}
		return outputArr;
			
	}
	/***
	 * sets a column with certain values
	 * @param colIndex
	 * @param vals
	 */
	public void setCol(int colIndex, double[] vals) {
		for (int row = 0; row < data.length; row++) {
				data[row][colIndex] = vals[row];
				
			
		}
	}
	/***
	 * sets a row with certain values
	 * @param rowIndex
	 * @param vals
	 */
	public void setRow(int rowIndex, double[] vals) {
		for (int col = 0; col < data[0].length; col++) {
			data[rowIndex][col] = vals[col];
		
		
	}
	}

	/***
	 * sets an individual entry in a chosen place
	 * @param colIndex
	 * @param rowIndex
	 */
	public void setIndividualEntry( int colIndex, int rowIndex, double value) {
		data[rowIndex][colIndex]= value;
	}
	/***
	 * gets the title of the columns in an array
	 */
	public void getTitleCol() {
		
	}
	/***
	 * Updates the CSV File
	 */
	public static void updateCSVFile() {
		
	}
 	
	
}
