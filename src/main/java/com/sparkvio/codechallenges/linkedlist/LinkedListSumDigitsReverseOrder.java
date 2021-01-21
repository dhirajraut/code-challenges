package com.sparkvio.codechallenges.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSumDigitsReverseOrder {

	public static void main(String[] args) {
		Integer[] inputData1 = { 1, 6, 8 };
		Integer[] inputData2 = { 5, 4, 3 };
		/* 6, 0, 2, 1 */
		LinkedList<Integer> lList1 = new LinkedList<Integer>();
		LinkedList<Integer> lList2 = new LinkedList<Integer>();
		lList1.addAll(Arrays.asList(inputData1));
		lList2.addAll(Arrays.asList(inputData2));
		System.out.println(sumDigitsReverseOrder(lList1, lList2));
	}


	private static LinkedList<Integer> sumDigitsReverseOrder(LinkedList<Integer> lList1, LinkedList<Integer> lList2) {

		LinkedList<Integer> lListAnswer = new LinkedList<Integer>();
		Iterator<Integer> lList1Iterator = lList1.iterator();
		Iterator<Integer> lList2Iterator = lList2.iterator();

		int carryOverDigit = 0;
		while (lList1Iterator.hasNext() || lList2Iterator.hasNext() ) {
			int answerDigit = 0;
			
			if (lList1Iterator.hasNext()) {
				answerDigit += lList1Iterator.next();
			}
			if (lList2Iterator.hasNext()) {
				answerDigit += lList2Iterator.next();
			}
			answerDigit += carryOverDigit;
			
			carryOverDigit = answerDigit / 10;
			answerDigit %= 10;
			lListAnswer.add(answerDigit);
		}
		
		if (carryOverDigit != 0) {
			lListAnswer.add(carryOverDigit);
		}

		return lListAnswer;
	}
}
