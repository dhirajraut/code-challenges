package com.sparkvio.companychallenges.glovo;

public class TransposeMatrix {

	
/**
          |  0 | 1 | 2 | 3        | 0 | 1 | 2 | 3
        ------------------      -----------------
        0 |  1   2   3   4      0 | 13   9  5  1
        1 |  5   6   7   8  =>  1 | 14  10  6  2
        2 |  9  10  11  12      2 | 15  11  7  3
        3 | 13  14  15  16      3 | 16  12  8  4
        
 */
	public static void main(String[] args) {
		
		int[][] inputMatrix = new int[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
			
		};
		
		int[][] transposedMatrix = transposeMatrix(inputMatrix);
		
		for (int[] array : transposedMatrix) {
			for (int element : array) {
				
				System.out.print(element + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static int[][] transposeMatrix(int[][] inputMatrix) {
		
		int[][] outputMatrix = new int[inputMatrix.length][inputMatrix.length];
		
		for (int rowCounter = 0; rowCounter < inputMatrix.length; rowCounter++) {
			
			for (int columnCounter = 0; columnCounter < inputMatrix.length; columnCounter++) {
				
				outputMatrix[columnCounter][inputMatrix.length - 1 - rowCounter] = inputMatrix[rowCounter][columnCounter];
			}
		}
		return outputMatrix;
	}
}
