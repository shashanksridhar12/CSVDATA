package dev.shashanksridhar;
/***
 * A class to read/write numerical CSV Files and allow easy access
 * @author Shashank
 *
 */
public class CSVDATA {
	private double[][] data;
	private String[] columnNames;
	
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
	public static CSVDATA readCSVFile(String filename, int numLinesToIgnore) {
		return null;
	}
}
