package com.sparkvio.companychallenges.klarna;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SmoothieIngredients {

	
	/*
	Classic: strawberry, banana, pineapple, mango, peach, honey
	Freezie: blackberry, blueberry, black currant, grape juice, frozen yogurt
	Greenie: green apple, lime, avocado, spinach, ice, apple juice
	Just Desserts: banana, ice cream, chocolate, peanut, cherry
	 */
	
	public static void main(String[] args) {
		System.out.println(ingredients("Classic,-strawberry, -peanut "));
		System.out.println(ingredients("Classic,-strawberry,- peanut,-banana,-pineapple,-mango,-peach,-honey"));
		System.out.println(ingredients("Greenie,-apple juice"));
		
		System.out.println(ingredients("Greenie,-juice"));
		System.out.println(ingredients("Greenie"));
		System.out.println(ingredients("Just Desserts,-banana"));
		System.out.println(ingredients("Greenie,chocolate"));
		System.out.println(ingredients(""));
		System.out.println(ingredients(null));
		
		//System.out.println(ingredients("Classic,chocolate"));
//		System.out.println(ingredients("Vitamin smoothie"));
	}
	
    public static String ingredients(String order) {
    	
    	/* Should be initialized outside this method. Should not be hard-coded in the method. Putting it at the method level just for test purpose. */
    	final Map<String, Set<String>> availableSmoothies = new HashMap<String, Set<String>>();
    	availableSmoothies.put("Classic", new HashSet<String>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
    	availableSmoothies.put("Freezie", new HashSet<String>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
    	availableSmoothies.put("Greenie", new HashSet<String>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
    	availableSmoothies.put("Just Desserts", new HashSet<String>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));
    	
    	/* Exception condition: Machine problem / invalid input. */
    	if (order == null || order.length() < 1) {
    		throw new IllegalArgumentException("Empty Order.");
    	}

    	/* Parse the order. */
    	String[] orderIngredients = order.split(",");
    	
    	/* First element is the name of the smoothie. */
    	String smoothieType = orderIngredients[0];
    	
    	/* Check order in available smoothies. */
    	Set<String> targetSmoothieIngredients = availableSmoothies.get(smoothieType); // Keeping smoothie type case sensitive as not mentioned in the requirements.

    	/* Exception condition: If the ordered smoothie type not available. */
    	if (targetSmoothieIngredients == null) {
    		throw new IllegalArgumentException("Not available: " + smoothieType);
    	}
    	    	
    	for (int counter = 1; counter < orderIngredients.length; counter++) {
			String ingredient = orderIngredients[counter].trim(); // Avoid extra spaces.
			
			if (ingredient.startsWith("-")) {
				/* Allergies: Remove ingredient. */
				ingredient = ingredient.substring(1); // Skip '-' sign.
				targetSmoothieIngredients.remove(ingredient); // Remove if exists. Keeping case sensitive as not mentioned in the requirements.
			}
			else {
				/* Exception condition: If the requested ingredient is not available. */
				throw new IllegalArgumentException("New ingredient cannot be added: " + ingredient);
			}
		}
    	
    	/* Sort the ingredients. */
    	TreeSet<String> targetSmoothieIngredientsSorted = new TreeSet<String>(targetSmoothieIngredients);
    	
    	return String.join(",", targetSmoothieIngredientsSorted);
    }
}
