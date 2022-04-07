package com.zensar;

public class Addition {
	public Integer add(int a, int b) {
		return a + b;
	}
	public Integer sub(int a, int b) {
		return a - b;
	}
	public Integer multi(int a, int b) {
		return a * b;
	}
	public Integer division(int a, int b) {
		return a / b;
	}
	public int[] myArr() {
		return new int[]{1,2,3,4,5};
	}
	public String getName(String name) {
		if(name.length()!=0) {
			return name;
		}
		throw new IllegalArgumentException();
	}
}
