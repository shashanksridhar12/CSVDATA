package dev.shashanksridhar;

import java.util.Arrays;

public class CSVDATATESTER {
	public static void main(String[] args) {
		String[] columnNames= {"time", "gyro-x", "gyro-y","gyro-z"};
		CSVDATA data = new CSVDATA("C:/Users/Shashank/Desktop/GyroTest2Out.csv", columnNames, 1);
		
		System.out.println(Arrays.toString(data.getMultipleCols(0, 3)));
	}
}
