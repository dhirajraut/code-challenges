package com.sparkvio.companychallenges.dividenconquer;

public class BinarySearchPractice1 {

	public static void main(String[] args) {
		System.out.println(getNumberIndex(1, null));
		System.out.println(getNumberIndex(1, new int[] {}));
		System.out.println(getNumberIndex(0, new int[] {1, 3, 5, 7, 9, 11}));
		System.out.println(getNumberIndex(12, new int[] {1, 3, 5, 7, 9, 11}));
		System.out.println(getNumberIndex(3, new int[] {1, 3, 5, 7, 9, 11}));
		System.out.println(getNumberIndex(9, new int[] {1, 3, 5, 7, 9, 11}));
	}
	
    public static int getNumberIndex(int targetNumber, int[] inputArray) {
    	
    	/* Invalid data exit conditions. */
    	if (inputArray == null || inputArray.length == 0) {
    		return -1;
    	}
    	
    	/* Valid data exit conditions. */
    	if (targetNumber < inputArray[0] || inputArray[inputArray.length - 1] < targetNumber) {
    		return -1;
    	}
    	
    	/* Valid data recursion. */
    	return getNumberIndex(targetNumber, inputArray, 0, inputArray.length - 1);
    }
    
    public static int getNumberIndex(int targetNumber, int[] inputArray, int startIndex, int endIndex) {
    	
    	/* Valid data exit conditions. Unit work. */
    	if (targetNumber == inputArray[startIndex]) {
    		return startIndex;
    	}
    	else if (targetNumber == inputArray[endIndex]) {
    		return endIndex;
    	}
    	else if (startIndex + 1 == endIndex) {
    		return -1;
    	}
    	
    	/* Recursion condition */
    	int intermediateIndex = (startIndex + endIndex) / 2;
    	if (inputArray[intermediateIndex] == targetNumber) {
    		return intermediateIndex;
    	}
    	else if (targetNumber < inputArray[intermediateIndex]) {
    		/* Left split. */
    		return getNumberIndex(targetNumber, inputArray, startIndex, intermediateIndex);
    	}
    	else {
    		/* Right split. */
    		return getNumberIndex(targetNumber, inputArray, intermediateIndex, endIndex);
    	}
    }
}
