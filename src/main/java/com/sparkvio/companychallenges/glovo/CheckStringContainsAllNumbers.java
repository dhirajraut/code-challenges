package com.sparkvio.companychallenges.glovo;

public class CheckStringContainsAllNumbers {

	
	public static void main(String[] args) {
		
		System.out.println(isContainingAllNums("foo32145bar6987"));
		
	}
	
	public static boolean isContainingAllNums(String inputString) {
		
		/* Error Conditions. */
		if (inputString == null || inputString.length() < 9) {
			/* Shorter string cannot accommodate 9 numbers. */
			return false;
		}
		
		boolean[] checkerArray = new boolean[9];
		
		for (int counter = 0; counter < inputString.length(); counter ++) {
			char characterMarker = inputString.charAt(counter);
			
			int numericValue = Character.getNumericValue(characterMarker);
			if (Character.isDigit(characterMarker) &&  numericValue != 0) {
				
				checkerArray[numericValue - 1] = true;
			}
		}
		
		for (int counter = 0; counter < checkerArray.length; counter ++) {
			if (checkerArray[counter] == false) {
				return false;
			}
		}
		
		return true;
	}
}
