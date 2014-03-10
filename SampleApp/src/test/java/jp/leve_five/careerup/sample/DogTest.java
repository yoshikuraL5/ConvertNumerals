package jp.leve_five.careerup.sample;

import junit.framework.TestCase;

public class DogTest extends TestCase {
	
	public void testBowIsWorking() {
		Dog dog = new Dog();

		String results = dog.bow();
	
		assertTrue("bow".equals(results));
	}
	
	
}
