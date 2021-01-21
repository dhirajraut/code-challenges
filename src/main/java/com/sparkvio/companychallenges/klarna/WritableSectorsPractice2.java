package com.sparkvio.companychallenges.klarna;

public class WritableSectorsPractice2 {

	public static void main(String[] args) {
		System.out.println(isWritable(1, 1, null));
		System.out.println(isWritable(1, 1, new int[] {}));
		System.out.println(isWritable(1, 1, new int[] { 1 }));
		System.out.println(isWritable(4, 2, new int[] {1, 4}));
		System.out.println(isWritable(0, 2, new int[] {1, 4}));
		System.out.println(isWritable(10, 2, new int[] {1, 2, 3, 4, 5, 6, 7, 10}));
	}
	
	private static boolean isWritable (int blockSize, int fileSize, int[] occupiedSectors) {
		
		/* Invalid input conditions. */
		if (blockSize <= 0 || blockSize > 1000000 || fileSize <= 0 || fileSize > blockSize || occupiedSectors == null || occupiedSectors.length > blockSize) {
			return false;
		}
		
		/* Block is totally full. */
		if (blockSize == occupiedSectors.length) {
			return false;
		}
		
		/* Block has space but not sufficient to accommodate fileSize. */
		if (blockSize - occupiedSectors.length < fileSize) {
			return false;
		}
		
		/* Block has space, maybe sufficient to accommodate fileSize. */
		/* fileSize == 1. No need to check continuous space. */
		if (fileSize == 1 && blockSize - occupiedSectors.length >= fileSize) {
			return true;
		}
		/* fileSize > 1. Need to check continuous space. */
		return isWritable(blockSize, fileSize, occupiedSectors, 0, occupiedSectors.length - 1);
	}
	private static boolean isWritable (int blockSize, int fileSize, int[] occupiedSectors, int startIndex, int endIndex) {
		
		/* Block is totally full. */
		if (endIndex - startIndex == occupiedSectors[endIndex] - occupiedSectors[startIndex]) {
			System.out.println("skipping from " + startIndex + " to " + endIndex);
			return false;
		}
		
		/* Block has space but not sufficient to accommodate fileSize. */
		if (occupiedSectors[endIndex] - occupiedSectors[startIndex] < fileSize) {
			System.out.println("skipping from " + startIndex + " to " + endIndex);
			return false;
		}
		
		/* Unit Work. */
		if (endIndex - startIndex == 1 && occupiedSectors[endIndex] - occupiedSectors[startIndex] > fileSize) {
			return true;
		}
		
		/* Recursion */
		int intermediateIndex = (startIndex + endIndex) / 2;
		if (isWritable(blockSize, fileSize, occupiedSectors, startIndex, intermediateIndex)) {
			return true;
		}
		else if (isWritable(blockSize, fileSize, occupiedSectors, intermediateIndex, endIndex)) {
			return true;
		}
		
		return false;
	}

}
