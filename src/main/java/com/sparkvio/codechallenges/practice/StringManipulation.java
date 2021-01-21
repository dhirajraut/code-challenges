package com.sparkvio.codechallenges.practice;

public class StringManipulation {

	public static void main(String args[]) {
		uppercaseCharactersAsciiValues();
		lowercaseCharactersAsciiValues();
		insertingString();
	}
	
	private static void uppercaseCharactersAsciiValues() {
		
		String lowercaseCharacterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		
		for (int counter = 0; counter < lowercaseCharacterString.length(); counter ++) {
			char character = lowercaseCharacterString.charAt(counter);
			int ascii = character;
			sb.append(character + " = " + ascii + "; ");
		}
		System.out.println(sb.toString());
	}
	
	private static void lowercaseCharactersAsciiValues() {
		
		String lowercaseCharacterString = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		
		for (int counter = 0; counter < lowercaseCharacterString.length(); counter ++) {
			char character = lowercaseCharacterString.charAt(counter);
			int ascii = character;
			sb.append(character + " = " + ascii + "; ");
		}
		System.out.println(sb.toString());
	}
	
	private static void insertingString() {
		
		String originalString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String newString = insertingStringInString(originalString, "NewString", 2);
		System.out.println(newString);
	}
	
	private static String insertingStringInString(String originalString, String stringToBeInserted, int insertionIndex) {
		
		StringBuffer newString = new StringBuffer(originalString.substring(0, insertionIndex));
		newString.append(stringToBeInserted);
		newString.append(originalString.substring(insertionIndex + 1, originalString.length()));
		return newString.toString();
	}
}
