package com.sparkvio.codechallenges.practice;

public class QuickSort {

	
	private static int[] targetArray = { 60, 30, 50, 10, 80, 40, 90, 20, 70 };
	public static void main (String args[]) {
		
		quickSort (0, targetArray.length - 1);
		
		for (int element: targetArray) {
			System.out.println(element);
		}
	}
	
	private static void quickSort(int lowSide, int highSide) {
		if (lowSide < highSide) {
			int partition = getPartition(lowSide, highSide);
			quickSort(lowSide, partition);
			quickSort(partition + 1, highSide);
		}
	}
	
	private static int getPartition (int lowSide, int highSide) {
		
		int pivot = targetArray[lowSide];
		int i = lowSide;
		int j = highSide;
		
		while (i < j) {
			for (; targetArray[i] <= pivot && i < j; i++) {}
			for (; targetArray[j] > pivot; j--) {}
	
			if (i < j) {
				swapElements(i, j);
			}
		}
		
		swapElements(lowSide, j);
		return j;
	}
	
	
	private static void swapElements(int leftIndex, int rightIndex) {
		int temp = targetArray[leftIndex];
		targetArray[leftIndex] = targetArray[rightIndex];
		targetArray[rightIndex] = temp;
	}
}
