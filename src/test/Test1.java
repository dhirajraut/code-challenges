package com.sparkvio.companychallenges.klarna;

public class Test1 {

    @Test
    public void nullInput() {
        assertThrows("banana,honey,mango,peach,pineapple",
                     Smoothie.ingredients(null));
    }
  
    @Test
    public void emptyInput() {
        assertEquals("banana,honey,mango,peach,pineapple",
                     Smoothie.ingredients(""));
    }
    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                     Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                     Smoothie.ingredients("Classic,-strawberry"));
    }    
  /*
  		System.out.println(ingredients("Classic,- strawberry, -peanut "));
		System.out.println(ingredients("Classic,-strawberry,- peanut,-banana,-pineapple,-mango,-peach,-honey"));
		System.out.println(ingredients("Greenie,-apple juice"));
		
		System.out.println(ingredients("Greenie,-juice"));
		System.out.println(ingredients("Greenie"));
		System.out.println(ingredients("Just Desserts,-banana"));
		System.out.println(ingredients("Greenie,chocolate"));
		System.out.println(ingredients(""));
		System.out.println(ingredients(null));
  */
    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                     Smoothie.ingredients("Classic,-strawberry"));
    }
}
