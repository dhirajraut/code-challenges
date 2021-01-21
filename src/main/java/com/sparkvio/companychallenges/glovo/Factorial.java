package com.sparkvio.companychallenges.glovo;

import java.math.BigInteger;

public class Factorial {

    public static void main( String[] args )
    {
//    	System.out.println(solution(40, 20));
    	System.out.println(solution(5, 3));
//    	System.out.println(solution(40, 20));
//    	System.out.println(solution(40, 20));
    }
    
    public static int solution(int N, int K) {
        
        /* Condition 1: Factorial of -ve number is undefined. */
    	if (N < 0 || K < 0) {
    		return -1;
    	}
        /* Condition 2: N is greater than K. */
    	else if (N < K) {
    		return -1;
    	}
    	else if (K == 0 || N == 0) {
    		return 1;
    	}
    	/* Condition 3: Regular Calculation. */
    	else {
    		BigInteger denominator = BigInteger.valueOf(calculateDenominator(1, (N-K)));
        	BigInteger numrator = calculateNumarator(K + 1, N, denominator);
        	if (numrator.compareTo(BigInteger.ZERO) < 0) {
        		return -1;
        	}
        	else {
        		BigInteger result = numrator.divide(denominator);
        		return result.intValue();
        	}

    	}
    }
    
    public static long calculateDenominator(int from, int to) {
        long result = 1;
        for (int counter = from; counter <= to; counter++) {
            result = result * counter;
        }
        return result;
    }
    
    public static BigInteger calculateNumarator(int from, int to, BigInteger denominator) {
        BigInteger result = BigInteger.ONE;
        BigInteger max = denominator.multiply(BigInteger.valueOf(1000000000)); // Exit condition on max value.
        for (int counter = from; counter <= to; counter++) {
            if ((result.compareTo(max)) > 0) {
            	return BigInteger.valueOf(-1);
            }
    		result = result.multiply(BigInteger.valueOf(counter));
        }
        return result;
    }
}
