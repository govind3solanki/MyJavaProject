package com.zensar;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckPalendromTest {

	@ParameterizedTest
	@ValueSource(strings= {"madam","121","xyz"})
	public void checkTest(String str) {
		CheckPalendrom p=new CheckPalendrom();
		boolean palindrome = p.isPalindrome(str);
		boolean a=true;
		assertEquals(a, palindrome);
	}
}
