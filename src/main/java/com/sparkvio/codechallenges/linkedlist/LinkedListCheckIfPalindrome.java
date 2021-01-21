package com.sparkvio.codechallenges.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListCheckIfPalindrome {

	public static void main(String[] args) {
		Integer[] inputData = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.addAll(Arrays.asList(inputData));
		System.out.println(isPalindrome(lList));
	}
	
	private static boolean isPalindrome(LinkedList<Integer> lList) {
		
		/* Get size of the LinkedList */
		int size = lList.size();
		/* If size is odd, the center is size/2 + 1 */
		int centerIndex = -1;
		if (size % 2 == 1) {
			centerIndex = (size / 2) + 1;
		}
		/* If size is even, the center is (size + 2)/2, insert an element here. */
		else {
			centerIndex = (size + 2) / 2;
			lList.add(centerIndex - 1, 0);
		}
		
		int leftIndex = centerIndex - 1;
		int rightIndex = centerIndex - 1;
		for (int offset = 0; offset < (size/2); offset ++) {
			leftIndex --;
			rightIndex ++;
			if (lList.get(leftIndex) != lList.get(rightIndex)) {
				return false;
			}
		}
		return true;
	}
}
