package com.sparkvio.codechallenges.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListFindKthToLastElement {

	
	public static void main (String args []) {
		
		Integer[] inputData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.addAll(Arrays.asList(inputData));
		printKthToLastElement(lList, 4);
	}
	
	public static void printKthToLastElement(LinkedList<Integer> lList, int k) {
		
		int counter = 0;
		int kThElement = -1;
		
		Iterator<Integer> forwardIterator = lList.iterator();
		Iterator<Integer> kThElementIterator = lList.iterator();
		for (; forwardIterator.hasNext(); counter++) {
			Integer currentElement = forwardIterator.next();
			if (counter >= k) {
				kThElement = kThElementIterator.next();
			}
		}
		if (counter < k) {
			System.out.println("Linked List too short");
		}
		else {
			System.out.println(kThElement);
		}
	}
}
