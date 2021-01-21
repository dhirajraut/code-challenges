package com.sparkvio.codechallenges.bit;

public class BitManipulationOfInteger {

	public static void main(String[] args) {
		
		/* Making all bits as 1. */
		// Expected 11111111111111111111111111111111
		int allOnes = ~0;
		System.out.println(Integer.toBinaryString(allOnes));
		
		/* Shift left. Fill 0s from right. */
		// Expected 11111111111111111111111111100000
		int leftShift = allOnes << 5; // Left shift by 5
		System.out.println(Integer.toBinaryString(leftShift));
		
		/* Shift right. Fill 1s from left. */
		// Expected 11111111111111111111111111111111
		int rightShift = allOnes >> 5; // Right shift by 5
		System.out.println(Integer.toBinaryString(rightShift));

		/* Shift right. Fill 0s from left. */
		// Expected 111111111111111111111111111
		int zeroFilledRightShift = allOnes >>> 5; // Right shift fill 0s by 5
		System.out.println(Integer.toBinaryString(zeroFilledRightShift));

		/* Fill last 5 positions as 1. */
		// Expected 111111
		int oneFilledRightPositions = (1 << 5) - 1; // First shift 1 bit from position 1 to 6 (5 count) position and then -1. 
		System.out.println(Integer.toBinaryString(oneFilledRightPositions));

		/* Fill 8 to 5 positions as 0. All other 1. */
		// Expected 11111111111111111111111100011111
		int leftSide = allOnes << 8;
		int rightSide = (1 << 5) - 1;
		System.out.println(Integer.toBinaryString(leftSide | rightSide));

		/* Fill 8 to 5 positions as 1. All other 0. */
		// Expected 11110000
		leftSide = (1 << 8) - 1;
		rightSide = allOnes << 4;
		System.out.println(Integer.toBinaryString(leftSide & rightSide));

	}
	
}
