package com.sparkvio.companychallenges.klarna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WritableSectorsModified {

	public static void main(String[] args) {
//		System.out.println(isWritable(1, 1, null));
//		System.out.println(isWritable(1, 1, new ArrayList<Integer>()));
//		System.out.println(isWritable(1, 1, Arrays.asList(1)));
//		System.out.println(isWritable(4, 2, Arrays.asList(1, 4)));
//		System.out.println(isWritable(0, 2, Arrays.asList(1, 4)));
		System.out.println(isWritable(10, 2, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10)));
	}
	
	public static boolean isWritable(int blockSize, int fileSize, List<Integer> occupiedSectors) {

		/* Exception condition: null input. */
		if (occupiedSectors == null) {
			return false;
		}
		
		/* Exception condition: invalid input. */
		if (blockSize > 1000000 || blockSize < fileSize) {
			return false;
		}
		
		/* Exception condition: There is no space which matches fileSize. */
		if (blockSize - occupiedSectors.size() < fileSize) {
			return false;
		}

		/* Allowable condition: fileSize is 1 and there is one space available. No need to check continuity. */
		if (fileSize == 1 && blockSize - occupiedSectors.size() >= fileSize) {
			return true;
		}

		/* Assuming the occupiedSectors to be sorted. */
		return isSlotAvailable(blockSize, fileSize, occupiedSectors, 0, occupiedSectors.size() - 1);
	}	
	
	public static boolean isSlotAvailable(int blockSize, int fileSize, List<Integer> occupiedSectors, int startIndex, int endIndex) {

		/*Unit work*/
		int startElement = occupiedSectors.get(startIndex);
		int endElement = occupiedSectors.get(endIndex);
		if ((endIndex - startIndex) == 1 && (endElement - startElement) > fileSize) {
			return true;
		}
		if ((endIndex - startIndex) == (endElement - startElement)) {
			/* Totally occupied. */
			System.out.println("Skipping " + startElement + " to " + endElement);
			return false;
		}
		/* Space is available but not sufficient. */
		if ((endElement - startElement) < fileSize) {
			return false;
		}

		/* Divide & conquer. */
		int subSectorIndex = (startIndex + endIndex) / 2;
		if (isSlotAvailable(blockSize, fileSize, occupiedSectors, startIndex, subSectorIndex)) {
			return true;
		}
		if (isSlotAvailable(blockSize, fileSize, occupiedSectors, subSectorIndex + 1, endIndex)) {
			return true;
		}
		
		return false;
	}

	
	
	
}
