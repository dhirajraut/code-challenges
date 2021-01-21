package com.sparkvio.codechallenges.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPartitionAroundValueX {

	public static void main(String[] args) {
		Integer[] inputData = {1, 6, 8, 5, 4, 3, 7, 2, 9};
		LinkedList<Integer> lList = new LinkedList<Integer>();
		lList.addAll(Arrays.asList(inputData));
		partitionAround(lList, 5);
		
	}
	
	private static void partitionAround(LinkedList<Integer> lList, int x) {
		
		Iterator<Integer> lListIterator = lList.iterator();
		LinkedList<Integer> greaterValuesLList = new LinkedList<Integer>();
		while (lListIterator.hasNext()) {
			/* If the value is less than x, continue. */
			Integer element = lListIterator.next();
			if (element < x) {
				continue;
			}
			/* If the value is equal to x, PUSH the element in another linkedList. */
			else if (element == x) {
				greaterValuesLList.push(element);
				lListIterator.remove();
			}
			/* If the value is greater than x, ADD the element in another linkedList. */
			else {
				greaterValuesLList.add(element);
				lListIterator.remove();
			}
		}
		lList.addAll(greaterValuesLList);
		System.out.println(lList);
	}
}
