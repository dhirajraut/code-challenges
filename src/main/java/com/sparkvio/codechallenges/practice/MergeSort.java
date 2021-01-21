package com.sparkvio.codechallenges.practice;


public class MergeSort {

	public static void main(String args[]) {
		
		int[] originalArray = new int[] {5,3,7,2,8,1,9,4,13,11,12,15,6};
		splitArray(originalArray, 0, originalArray.length - 1);
		for (int element: originalArray) {
			System.out.println(element);
		}
	}

	private static void splitArray(int originalArray[], int subSectionLeftEndIndex, int subSectionRightEndIndex) {

		if(subSectionLeftEndIndex < subSectionRightEndIndex) {
			
			/* Calculate the midPoint. Split the array in 2 subSections. */
			int subSectionMidPoint = (subSectionLeftEndIndex + subSectionRightEndIndex) / 2;
			
			/* Process both problems separately. */
			splitArray(originalArray, subSectionLeftEndIndex, subSectionMidPoint);
			splitArray(originalArray, subSectionMidPoint+1, subSectionRightEndIndex);

			/* Merge the results. */
			merge(originalArray, subSectionLeftEndIndex, subSectionMidPoint, subSectionRightEndIndex);
		}

	}
	private static void merge(int originalArray[], int subSectionLeftEnd, int subSectionMidPoint, int subSectionRightEnd) {

		/* Temporary replacement array. */
		int replacementArray[] = new int[subSectionRightEnd - subSectionLeftEnd + 1];

		int originalArrayLeftCounter = subSectionLeftEnd;
		int originalArrayRightCounter = subSectionMidPoint+1;
		int replacementArrayCounter = 0;

		/* To populate replacementArray, iterate left counter from 0 to midpoint, and right counter from midpoint+1 to right end. */
		for (; originalArrayLeftCounter <= subSectionMidPoint && originalArrayRightCounter <= subSectionRightEnd; replacementArrayCounter ++) {
			if(originalArray[originalArrayLeftCounter] <= originalArray[originalArrayRightCounter]) {
				/* Left side is smaller/equal. Store left side in replacementArray. */
				replacementArray[replacementArrayCounter] = originalArray[originalArrayLeftCounter];
				originalArrayLeftCounter ++;
			}
			else {
				/* Left side is greater. Swap the sequence. Store right side in replacementArray. */
				replacementArray[replacementArrayCounter] = originalArray[originalArrayRightCounter];
				originalArrayRightCounter ++;
			}
		}

		/* Copy remaining left side elements. If Any. */
		while(originalArrayLeftCounter <= subSectionMidPoint) {
			replacementArray[replacementArrayCounter] = originalArray[originalArrayLeftCounter];
			replacementArrayCounter += 1; originalArrayLeftCounter += 1;
		}

		/* Copy remaining right side elements. If Any. */
		while(originalArrayRightCounter <= subSectionRightEnd) {
			replacementArray[replacementArrayCounter] = originalArray[originalArrayRightCounter];
			replacementArrayCounter += 1; originalArrayRightCounter += 1;
		}

		/* Replace original array. */
		for(originalArrayLeftCounter = subSectionLeftEnd; originalArrayLeftCounter <= subSectionRightEnd; originalArrayLeftCounter += 1) {
			originalArray[originalArrayLeftCounter] = replacementArray[originalArrayLeftCounter - subSectionLeftEnd];
		}
	}


}
