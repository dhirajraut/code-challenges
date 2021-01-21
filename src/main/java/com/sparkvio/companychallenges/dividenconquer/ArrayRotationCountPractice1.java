package com.sparkvio.companychallenges.dividenconquer;

public class ArrayRotationCountPractice1 {

	public static void main(String[] args) {
		/* Use ArrayRotationTest */
		// 6, 7, 1, 2, 3, 4, 5
	}

	public static int getRotationCount(int[] inputArray) {

		/* Invalid data exit conditions. */
		if (inputArray == null || inputArray.length == 0) {
			return -1;
		}
		
		/* Valid data exit conditions. */
		if (inputArray[0] < inputArray[inputArray.length - 1]) {
			return 0;
		}
		
		/* Valid data recursive condition. */
		return getMinNumberIndex(inputArray, 0, inputArray.length - 1);
	}

	public static int getMinNumberIndex(int[] inputArray, int startIndex, int endIndex) {
		
		/* Valid data condition exit conditions on block level. */
		if (inputArray[startIndex] < inputArray[endIndex]) {
			// This section doesn't contain the tripping point.
			return startIndex;
		}
		
		/* Unit work. */
		if (startIndex + 1 == endIndex && inputArray[startIndex] > inputArray[endIndex]) {
			return endIndex;
		}
		
		/* Recursion condition. */
		int intermediateIndex = (startIndex + endIndex) / 2;
		int minIndex = endIndex;
		if (inputArray[startIndex] < inputArray[intermediateIndex]) {
			// No need to split.
			if (inputArray[minIndex] > inputArray[startIndex]) {
				minIndex = startIndex;
			}
		}
		else {
			// Split.
			minIndex = getMinNumberIndex(inputArray, startIndex, intermediateIndex);
		}
		if (inputArray[intermediateIndex] < inputArray[endIndex]) {
			// No need to split.
			if (inputArray[minIndex] > inputArray[intermediateIndex]) {
				minIndex = intermediateIndex;
			}
		}
		else {
			// Split.
			minIndex = getMinNumberIndex(inputArray, intermediateIndex, endIndex);
		}
		
		return minIndex;
	}
}
