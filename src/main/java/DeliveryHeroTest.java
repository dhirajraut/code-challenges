import java.util.Arrays;

public class DeliveryHeroTest {

	/*
	 * Compilation successful.
	 * 
	 * Example test: ['a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60', 'a', 10] Output:
	 * a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60 a WRONG ANSWER (got 0 expected 1)
	 * 
	 * Example test: ['a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60', 'b', 10] Output:
	 * a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60 b WRONG ANSWER (got 0 expected 2)
	 * 
	 */

	public static int solution(String p, String d, int s) {

		int counter = 0; // Counter for ping intervals.
		int dropCounter = 0; // Counter for drops.
		String[] inputTokens = p.split(" ");
		
		for (String token : inputTokens) {
			if (token.startsWith(d)) {
				
				/* Only consider the tokens with required device. */
				if (!token.contains(Integer.toString(counter))) {
					
					/* Found break */
					dropCounter++;
					counter = Integer.parseInt(token.split(",")[1]);
				}
				/* Next ping is expected at */
				counter += s;
			}
		}
		return dropCounter;

	}

	public static void main(String[] args) {
		System.out.println("Drop = " +solution("a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60", "a", 10));
	}
}
