package com.sparkvio.companychallenges.klarna;

public class WritableSectorsPractice1 {

	public static void main(String[] args) {
		System.out.println(isWritable(1, 1, null));
		System.out.println(isWritable(1, 1, new int[] {}));
		System.out.println(isWritable(1, 1, new int[] { 1 }));
		System.out.println(isWritable(4, 2, new int[] {1, 4}));
		System.out.println(isWritable(0, 2, new int[] {1, 4}));
		System.out.println(isWritable(10, 2, new int[] {1, 2, 3, 4, 5, 6, 7, 10}));
	}
	
	private static boolean isWritable(int blockSize, int fileSize, int[] occupiedSectors) {
		
		/* Invalid input conditions. */
		if (blockSize < 0 || blockSize > 1000000 || fileSize < 1 || fileSize > blockSize || occupiedSectors == null || occupiedSectors.length > blockSize) {
			return false;
		}
		
		/* Is the space totally full. */
		if (occupiedSectors.length == blockSize) {
			return false;
		}
		
		/* Space available but less than fileSize. */
		if ((blockSize - occupiedSectors.length) < fileSize) {
			return false;
		}
		
		/* Space available and fileSize is 1. No continuous space allocation required. */
		if (fileSize == 1 && (blockSize - occupiedSectors.length) <= fileSize) {
			return true;
		}
		
		/* Space available and fileSize is > 1. Continuous space allocation required. */
		return isWritable(blockSize, fileSize, occupiedSectors, /* Begin Index */ 0, /* End Index */ occupiedSectors.length - 1);
	}
	
	private static boolean isWritable(int blockSize, int fileSize, int[] occupiedSectors, int startIndex, int endIndex) {
		
		/* If block is totally full. */
		if ((endIndex - startIndex) == (occupiedSectors[endIndex] - occupiedSectors[startIndex])) {
			System.out.println("skipping from " + startIndex + " to " + endIndex);
			return false;
		}
		
		/* Space available, but less than fileSize */
		if ((occupiedSectors[endIndex] - occupiedSectors[startIndex]) < fileSize) {
			System.out.println("skipping from " + startIndex + " to " + endIndex);
			return false;
		}
		
		/* Block level unit operation. */
		if ((endIndex - startIndex) == 1 && (occupiedSectors[endIndex] - occupiedSectors[startIndex]) > fileSize) {
			return true;
		}
		
		/* Recursion */
		int intermediateIndex = (endIndex + startIndex) / 2;
		if (isWritable(blockSize, fileSize, occupiedSectors, startIndex, intermediateIndex)) {
			return true;
		}
		else if (isWritable(blockSize, fileSize, occupiedSectors, intermediateIndex, endIndex)) {
			return true;
		}
		
		return false;
	}
}
