package com.zensar;

public class StringUtility {

	public static Integer convertToInt(String str) {
		if(str==null||str.trim().length()==0) {
			throw new IllegalArgumentException("ssjflkjsdljf");
	}
	return Integer.valueOf(str);
}
}