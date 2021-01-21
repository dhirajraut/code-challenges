package com.sparkvio.companychallenges.dividenconquer;

public class ArrayRotationFindNumber {

	public static void main(String[] args) {
		// find 9 in { 8, 9, 10, 2, 5, 6}
		// find 10 in { 8, 9, 10, 2, 5, 6}
		System.out.println(getIndex(9, new int[] { 8, 9, 10, 2, 5, 6}));
		System.out.println(getIndex(10, new int[] { 8, 9, 10, 2, 5, 6}));
		System.out.println(getIndex(5, new int[] { 8, 9, 10, 2, 5, 6}));
		System.out.println(getIndex(7, new int[] { 8, 9, 10, 2, 5, 6}));
	}
	
	public static int getIndex (int targetNumber, int[] inputArray) {
		
		/* Invalid data exit conditions. */
		if (inputArray == null || inputArray.length == 0) {
			return -1;
		}
		
		/* Valid data exit conditions. */
		//@TODO
		
		/* Valid data split condition */
		return getIndex(targetNumber, inputArray, 0, inputArray.length - 1);
	}
	
	public static int getIndex (int targetNumber, int[] inputArray, int startIndex, int endIndex) {
		
		/* Valid data exit conditions block level. */
		if (targetNumber == inputArray[startIndex]) {
			return startIndex;
		}
		if (targetNumber == inputArray[endIndex]) {
			return endIndex;
		}
		
		/* Unit work */
		if (startIndex + 1 == endIndex && targetNumber == inputArray[startIndex]) {
			return startIndex;
		}
		else if (startIndex + 1 == endIndex && targetNumber == inputArray[endIndex]) {
			return endIndex;
		}
		
		/* Recursion. */
		int intermediateIndex = (startIndex + endIndex) / 2;
		int tempIndex = -1;
		
		if (inputArray[intermediateIndex] == targetNumber) {
			return intermediateIndex;
		}

		/* Sequence is ascending. */
		if (inputArray[startIndex] < inputArray[endIndex]) {
			
			 /* Input number is in the range. */
			if (inputArray[startIndex] < targetNumber && targetNumber < inputArray[endIndex]) {
				//split
				tempIndex = getIndex(targetNumber, inputArray, startIndex, intermediateIndex);
			}
		}
		/* There is a break. */
		else if (inputArray[startIndex] > inputArray[endIndex]) {
			/* Check if the break is before intermediateIndex. */
			if (inputArray[startIndex] < targetNumber && targetNumber < inputArray[intermediateIndex]) {
				//split
				tempIndex = getIndex(targetNumber, inputArray, startIndex, intermediateIndex);
			}
			/* Break is after intermediateIndex. */
			else if (targetNumber < inputArray[startIndex]) {
				tempIndex = getIndex(targetNumber, inputArray, intermediateIndex, endIndex);
			}
		}
		return tempIndex;
	}
}
