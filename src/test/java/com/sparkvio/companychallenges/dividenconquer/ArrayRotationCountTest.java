package com.sparkvio.companychallenges.dividenconquer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayRotationCountTest {

	@Test
	public void testNull() {
		assertEquals(-1, ArrayRotationCountPractice1.getRotationCount(null));
	}

	@Test
	public void testEmpty() {
		assertEquals(-1, ArrayRotationCountPractice1.getRotationCount(null));
	}

	@Test
	public void testNoRotation() {
		assertEquals(0, ArrayRotationCountPractice1.getRotationCount(new int[] { 1, 2, 3, 4, 5 }));
	}

	@Test
	public void testRotationOnLeftHalf() {
		assertEquals(2, ArrayRotationCountPractice1.getRotationCount(new int[] { 6, 7, 1, 2, 3, 4, 5 }));
	}

	@Test
	public void testRotationOnRightHalf() {
		assertEquals(6, ArrayRotationCountPractice1.getRotationCount(new int[] { 6, 7, 8, 9, 10, 11, 5 }));
	}

}
