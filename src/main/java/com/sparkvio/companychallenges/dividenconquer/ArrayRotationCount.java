package com.sparkvio.companychallenges.dividenconquer;

public class ArrayRotationCount {

	public static void main(String[] args) {
		/* Use ArrayRotationTest */
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
		return getMinElementIndex(inputArray, 0, inputArray.length - 1);
	}
	
	private static int getMinElementIndex (int[] inputArray, int startIndex, int endIndex) {
		
		/* Exit conditions. */
		if (inputArray[startIndex] < inputArray[endIndex]) {
			return startIndex;
		}
		
		/* Unit work. */		
		if ((endIndex - startIndex) == 1 && inputArray[startIndex] < inputArray[endIndex]) {
			return startIndex;
		}
		else if ((endIndex - startIndex) == 1 && inputArray[startIndex] > inputArray[endIndex]) {
			return endIndex;
		}
		
		/* Recursion */
		int minIndex = endIndex;
		int intermediateIndex = (startIndex + endIndex) / 2;
		if (inputArray[startIndex] < inputArray[intermediateIndex]) {
			if (inputArray[startIndex] < inputArray[minIndex]) {
				minIndex = startIndex;
			}
		}
		else {
			minIndex = getMinElementIndex(inputArray, startIndex, intermediateIndex);
		}
		if (inputArray[intermediateIndex] < inputArray[endIndex]) {
			if (inputArray[intermediateIndex] < inputArray[minIndex]) {
				minIndex = intermediateIndex;
			}
		}
		else {
			minIndex = getMinElementIndex(inputArray, intermediateIndex, endIndex);
		}
		
		return minIndex;
		
	}
}
