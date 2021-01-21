package com.sparkvio.codechallenges.bit;

public class FlipBitToWin {

	/*
	Flip Bit to Win: You have an integer and you can flip exactly one bit from a O to a 1. Write code to find the 
	length of the longest sequence of 1 s you could create.
	EXAMPLE
		Input: 1775 (or: 11011101111)
		Output: 8
	*/
	
	public static void main(String[] args) {
		int number = 1775;
		System.out.println("number = " + number + " Binary = " + Integer.toBinaryString(number) + " Flip Length = " + flipBit(1775));
	}
	
	private static int flipBit(int number) {
		
		/* If all 1s, this is a longest sequence. */
		if (~number == 0) return Integer.BYTES * 8;
		
		int currentLength = 0;
		int previousLength = 0;
		int maxLength = 0;
		
		while (number != 0) {
			if ((number & 1) == 1) { // Current bit is 1.
				currentLength ++;
			}
			else if ((number & 1) == 0) { // Current bit is 0.
				/* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
				previousLength = (number & 2) == 0 ? 0 : currentLength;
				currentLength = 0;
			}
			maxLength = Math.max(previousLength + currentLength + 1, maxLength);
			number >>>= 1;
		}
		return maxLength;
	}
}
