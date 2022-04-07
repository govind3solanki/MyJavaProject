package com.zensar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



public class AdditionTest {
	Addition a = null;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeclass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	@Before
	public void before() {
		System.out.println("before");
		a = new Addition();
	}

	@After
	public void after() {
		System.out.println("after");
		a = null;
	}

	@Test
	public void test_add() {

		int actual = a.add(1, 1);
		int expected = 2;
		assertEquals(expected, actual);

	}

	@Test
	public void test_sub() {

		int actual = a.sub(1, 1);
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	public void test_multi() {

		int actual = a.multi(1, 1);
		int expected = 1;
		assertEquals(expected, actual);

	}

	@Test
	public void test_division() {

		int actual = a.division(1, 1);
		int expected = 1;
		assertEquals(expected, actual);

	}

	@Ignore
	@Test
	public void test() {
		System.out.println("Ram");
	}

	@Test
	public void testArray() {
		int actualArray[] = a.myArr();
		int expectedArray[] = { 1, 2, 3, 4, 5 };
		// assertEquals(expectedArray, actualArray);
		assertArrayEquals(expectedArray, actualArray);

	}

	@Test
	public void testString() {
		String actualResult = a.getName("Zensar");
		String expectedResult = "ZENSAR";
		assertNotEquals(expectedResult, actualResult);
	}

	@Test
	public void testStringForNull() {
		String actualResult = a.getName("abc");
		String expectedResult = null;
		// assertEquals(expectedResult, actualResult);
	//	assertNotNull(actualResult, expectedResult);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testStringForException() {
		a.getName("");
	}

}
