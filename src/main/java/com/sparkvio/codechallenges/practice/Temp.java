package com.sparkvio.codechallenges.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Temp {

	public static void main (String args[]) {
		
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[][] twoDimIntArray = new int[][] {
			{1, 2, 3, 4},
			{11, 12, 13, 14}
		};
		List<Integer> emptyList = Collections.emptyList();
		emptyList.toArray();
		List<int[]> asList = Arrays.asList(intArray);
		
		Integer[] numbers = {1, 2, 3}; 
		List<Integer> asList2 = Arrays.asList(numbers); 
		
		
		List<String> emptyList2 = Collections.emptyList();
		emptyList2.add("Hi");
		
		Arrays.sort(intArray);
		System.out.println();
	}
}
