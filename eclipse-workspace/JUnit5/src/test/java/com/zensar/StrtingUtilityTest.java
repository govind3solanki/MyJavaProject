package com.zensar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StrtingUtilityTest {

	@Test
	public void stringUtilityException2() {
		Integer convertToInt = StringUtility.convertToInt("10");
		assertEquals(10, convertToInt);
	}
	
	@Test
	public void stringUtilityException() {
		String str=null;
		assertThrows(IllegalArgumentException.class, () -> {
			StringUtility.convertToInt(str);
		});
	}
}
