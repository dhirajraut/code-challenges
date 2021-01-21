package com.sparkvio.companychallenges.klarna;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WritableSectors {

	public static void main(String[] args) {
		System.out.println(isWritable(1, 1, null));
		System.out.println(isWritable(1, 1, new HashSet<Integer>()));
		System.out.println(isWritable(1, 1, new HashSet<Integer>(Arrays.asList(1))));
		System.out.println(isWritable(4, 2, new HashSet<Integer>(Arrays.asList(1, 4))));
		System.out.println(isWritable(0, 2, new HashSet<Integer>(Arrays.asList(1, 4))));
		//System.out.println(isWritable(1000000, 2, new HashSet<Integer>(Arrays.asList())));
	}

	public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
		
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
		
		/* Expecting the occupiedSectors to be sorted, but sorting if not. */
		TreeSet<Integer> sortedOccupiedSectors = new TreeSet<Integer>(occupiedSectors);
		
		Integer previousSector = 0;
		/* Iterate on the occupiedSectors instead of blockSize, to save on time complexity. */
		for (Integer currentSector : sortedOccupiedSectors) {
			
			/* Get available space. */
			Integer availableSpace = currentSector - previousSector;
			
			if (fileSize <= availableSpace) {
				return true;
			}
			previousSector = currentSector;
		}
		
		/* If there is a space available towards the end. */
		Integer availableSpace = blockSize - previousSector;
		if (fileSize <= availableSpace) {
			return true;
		}
		
		/* No space available. */
		return false;
	}

}
