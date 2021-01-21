package com.sparkvio.codechallenges.bit;

public class BitManipulationOfDouble {

	public static void main(String[] args) {
		for (double count = 0; count < 1; count += 0.01) {
			System.out.println("count = " + count + " Binary = " + printBinary(count));
		}
	}
	
	
	private static String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (binary.length() >= 32) {
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
}
