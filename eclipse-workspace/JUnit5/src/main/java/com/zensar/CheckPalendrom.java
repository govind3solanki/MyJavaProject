package com.zensar;

public class CheckPalendrom {
	public boolean isPalindrome(String str) {
		String reverce="";
		int length= str.length();
		for(int i=length-1;i>=0;i--) {
			reverce=reverce+str.charAt(i);
		}
		if(str.equals(reverce)) {
			return true;
		}else {
			return false;
		}
	}
}
