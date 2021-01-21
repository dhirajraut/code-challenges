package com.sparkvio.codechallenges.practice;

/**
 * Hello world!
 *
 */
public class BitwiseOperators {
	public static void main(String[] args) {
		
		integerMaxValueRepresentation();
		leftShift();
	}

	private static void integerMaxValueRepresentation() {
		System.out.println("\nLeftmost signed bit.");
	    int maxNumber = Integer.MAX_VALUE;
	    System.out.println("Max Number  =  " + maxNumber + " Binary Representation =  " + Integer.toBinaryString(maxNumber));
	    maxNumber += 1;
	    System.out.println("Max Num + 1 = " + maxNumber + " Binary Representation = " + Integer.toBinaryString(maxNumber));
	    /*
		Max Number  =  2 147 483 647 Binary Representation =  111 1111 1111 1111 1111 1111 1111 1111
		Max Num + 1 = -2 147 483 648 Binary Representation = 1000 0000 0000 0000 0000 0000 0000 0000
	    */
    }

	private static void leftShift() {
		System.out.println("\nLeft shift is multiply by 2.");
		int number = 25;
		System.out.println("Number = " + number + " Binary Representation =  " + Integer.toBinaryString(number));
	    number = number << 1;
	    System.out.println("Number = " + number + " Binary Representation = " + Integer.toBinaryString(number));
	    
	}
}
