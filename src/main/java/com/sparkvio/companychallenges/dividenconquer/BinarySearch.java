package com.sparkvio.companychallenges.dividenconquer;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(getIndex(3, new int[] {2, 3, 5, 7, 9}));
		System.out.println(getIndex(7, new int[] {2, 3, 5, 7, 9}));
		System.out.println(getIndex(10, new int[] {2, 3, 5, 7, 9}));
	}
	
	private static int getIndex (int numberTarget, int[] searchArray) {
		
		/* Invalid data check. */
		if (searchArray == null || searchArray.length == 0) {
			return -1;
		}
		
		/* Out of bounds check. Assuming the input data is sorted. */
		if (numberTarget < searchArray[0] || numberTarget > searchArray[searchArray.length - 1]) {
			return -1;
		}
		
		return getIndex(numberTarget, searchArray, 0, searchArray.length - 1);
	}
	
	private static int getIndex (int numberTarget, int[] inputArray, int startIndex, int endIndex) {
		
		/* Unit work. */
		if (endIndex - startIndex == 1 && inputArray[startIndex] == numberTarget) {
			return startIndex;
		}
		else if (endIndex - startIndex == 1 && inputArray[endIndex] == numberTarget) {
			return endIndex;
		}
		else if (endIndex - startIndex == 1) {
			return -1;
		}
		
		/* Recursion */
		int intermediateIndex = (startIndex + endIndex) / 2;
		if (inputArray[intermediateIndex] == numberTarget) {
			return intermediateIndex;
		}
		else if (numberTarget < inputArray[intermediateIndex]) {
			/* Go for left side split. */
			return getIndex(numberTarget, inputArray, startIndex, intermediateIndex);
		}
		else {
			/* Go for right side split. */
			return getIndex(numberTarget, inputArray, intermediateIndex + 1, endIndex);
		}
	}
	
}
