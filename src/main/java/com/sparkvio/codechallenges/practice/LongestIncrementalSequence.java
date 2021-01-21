package com.sparkvio.codechallenges.practice;

public class LongestIncrementalSequence {

	public static void main(String args[]) {
		
		int[] originalArray = new int [] {
			2,
			3,
			5,
			8,
			4,
			6,
			3,
			9,
			5,
			6
		};
		System.out.println(findLIS(originalArray, originalArray.length));
	}
	
	static int findLIS(int[] originalArray, int numberOfElements) {
		int longestIncrementalSequenceHolder[] = new int [numberOfElements];
		if (numberOfElements == 1) {
			return 1;
		}
		
		int externalForwardCounter, internalBacksideCounter, maxSequenceCount=0;
		
		/* As individual digits all has 1 Longest Incremental Sequence. */
		for (externalForwardCounter = 0; externalForwardCounter < numberOfElements; externalForwardCounter++) {
			longestIncrementalSequenceHolder[externalForwardCounter] = 1; // Initialize all 1.
		}
		
		
		for (externalForwardCounter = 1; externalForwardCounter < numberOfElements; externalForwardCounter++) {
			for (internalBacksideCounter = 0; internalBacksideCounter < externalForwardCounter; internalBacksideCounter++) {
				
				/* Check 2 conditions.
				 * 1. The number pointed by externalForwardCounter is greater.
				 * 2. longestIncremetalSequenceHolder[externalForwardCounter] is less than or equal to 
				 * 		longestIncrementalSequenceHolder [internalBacksideCounter] */
				if (originalArray[externalForwardCounter] > originalArray[internalBacksideCounter]
						&& longestIncrementalSequenceHolder[externalForwardCounter] <= longestIncrementalSequenceHolder [internalBacksideCounter]) {
					longestIncrementalSequenceHolder[externalForwardCounter] = longestIncrementalSequenceHolder[internalBacksideCounter] + 1;
				}
			}
		}
		
		/* Traverse the array and find the max value. */
		for (externalForwardCounter=0; externalForwardCounter < numberOfElements; externalForwardCounter ++) {
			if (maxSequenceCount < longestIncrementalSequenceHolder [externalForwardCounter]) {
				maxSequenceCount = longestIncrementalSequenceHolder [externalForwardCounter];
			}
		}
		return maxSequenceCount;
	}
}
