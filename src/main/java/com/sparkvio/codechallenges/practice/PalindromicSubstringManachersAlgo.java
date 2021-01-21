package com.sparkvio.codechallenges.practice;

public class PalindromicSubstringManachersAlgo {

	public static void main(String args[]) {
		identify("ABABABA");
	}

	private static void identify (String input) {
		
		char[] expandedInput = expand (input);
		System.out.println(expandedInput);
		
		int center = 0;
		int leftLimitOfIdentifiedPalindrome = 0, rightLimitOfIdentifiedPalindrome = 0;
		int counter = 0;
		
		int[] palindromeCounterArr = new int[expandedInput.length];
		
		for (counter = 2 /* Skip initial @# */ ; counter < expandedInput.length - 1; counter ++) {
			leftLimitOfIdentifiedPalindrome = center * 2 - counter;
			
			if (counter < rightLimitOfIdentifiedPalindrome) {
				palindromeCounterArr[counter] = Math.min(rightLimitOfIdentifiedPalindrome - counter, palindromeCounterArr[leftLimitOfIdentifiedPalindrome]);
			}
			while (expandedInput [counter + (palindromeCounterArr[counter] + 1)] == expandedInput [counter - (palindromeCounterArr[counter] + 1)]) {
				palindromeCounterArr[counter] ++;
			}
			
			if (counter + palindromeCounterArr[counter] > rightLimitOfIdentifiedPalindrome) {
				center = counter;
				rightLimitOfIdentifiedPalindrome = counter + palindromeCounterArr[counter];
			}
		}
		
		for (int element: palindromeCounterArr) {
			System.out.println(element);
		}
	}
	
	private static char[] expand (String input) {
		
		char[] expandedChars = new char[2 * input.length() + 3];
		
		int counter = 0;
		expandedChars[0] = '$';
		for (; counter <= input.length() - 1; counter++) {
			expandedChars[(2 * counter + 1)] = '#';
			expandedChars[(2 * counter) + 2] = input.charAt(counter);
		}
		expandedChars[(2 * counter + 1)] = '#';
		expandedChars[(2 * counter) + 2] = '@';
		return expandedChars;
	}
}
