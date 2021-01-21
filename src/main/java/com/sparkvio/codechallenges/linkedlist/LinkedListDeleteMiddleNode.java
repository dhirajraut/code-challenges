package com.sparkvio.codechallenges.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDeleteMiddleNode {

	public static void main(String[] args) {
		Integer[] inputData = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.addAll(Arrays.asList(inputData));
		deleteMiddleNode(lList);
	}
	
	public static void deleteMiddleNode(LinkedList<Integer> lList) {
		
		Iterator<Integer> forwardIterator = lList.iterator();
		Iterator<Integer> backwordIterator = lList.iterator();
		int counter = -1;
		
		while (forwardIterator.hasNext()) {
			forwardIterator.next();
			counter ++;
			if (counter % 2 == 0) {
				backwordIterator.next();
			}
		}
		backwordIterator.remove();
		System.out.println(lList);
	}
}
