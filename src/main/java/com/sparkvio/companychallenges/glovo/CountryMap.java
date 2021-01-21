package com.sparkvio.companychallenges.glovo;

public class CountryMap {

	public static void main(String[] args) {
		int A[][] = new int [][] {
			{5, 4, 4},
			{4, 3, 4},
			{3, 2, 4},
			{2, 2, 2},
			{3, 3, 4},
			{1, 4, 4},
			{4, 1, 1}
		};
		System.out.println(solution (A));
	}
    public static int solution(int[][] A) {
    	
    	int markMap[][] = new int[A.length][A[0].length];
    	
    	int countryCounter = 0;
    	for (int rowCounter = 0; rowCounter < A.length; rowCounter++) {
    		for (int colCounter = 0; colCounter < A[0].length; colCounter++) {
    			int currentColor = A[rowCounter][colCounter];
    			
    			/* Paint current country if not done yet. */
    			if (markMap[rowCounter][colCounter] == 0) {
    				markMap[rowCounter][colCounter] = ++countryCounter;
    			}
    			
    			/* Check right direction. */
    			if (A[rowCounter].length - 1 > colCounter) {
    				
    				if (currentColor == A[rowCounter][colCounter + 1]) {
    					/* Same Country. */
    					markMap[rowCounter][colCounter + 1] = markMap[rowCounter][colCounter];
    				}
    				else {
    					/* Different Country. */
    					if (markMap[rowCounter][colCounter + 1] == 0) {
    						markMap[rowCounter][colCounter + 1] = ++countryCounter;
    					}
    				}
    			}
    			/* Check down direction. */
    			if (A.length - 1 > rowCounter) {
    				
    				/* If colors match, its a same country. */
    				if (currentColor == A[rowCounter + 1][colCounter]) {
    					markMap[rowCounter + 1][colCounter] = markMap[rowCounter][colCounter];    				
    				}
    				else {
        				/* If colors doesn't match, check south east direction if we have already numbered that country. */
    					if (A[rowCounter].length - 1 > colCounter && A[rowCounter + 1][colCounter] != A[rowCounter + 1][colCounter + 1]) {
    						/* Mismatch. Different Country. */
    						markMap[rowCounter + 1][colCounter] = ++countryCounter;
    					}
    					else if (A[rowCounter].length - 1 > colCounter && A[rowCounter + 1][colCounter] == A[rowCounter + 1][colCounter + 1]) {
    						/* Match. If the right country also matches, we have already numbered that country. */
    						if (A[rowCounter].length - 1 > colCounter) {
    							if (A[rowCounter + 1][colCounter] == A[rowCounter][colCounter + 1]) {
    								/* Paint DN and SE countries with RT country. */
    								markMap[rowCounter + 1][colCounter] = markMap[rowCounter][colCounter + 1];
    								markMap[rowCounter + 1][colCounter + 1] = markMap[rowCounter][colCounter + 1];
    							}
    							else {
    								/* Different Country. */
    								/* Paint DN and SE countries with new country. */
    								markMap[rowCounter + 1][colCounter] = ++countryCounter;
    								markMap[rowCounter + 1][colCounter + 1] = markMap[rowCounter + 1][colCounter];
    							}
    						}
    						else {
    							/* I don't have right country. */
    						}
    					}
    				}
    			}
    		}
    	}
    	return countryCounter;
    }
}
