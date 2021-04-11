package edu.poly.utils;

public class CheckData {
	public static boolean isNull(String s) {
		if(s.length()==0) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isExist(String s1,String s) {
		if(s1.equals(s)) {
			return true;
		}else {
			return false;
		}
	}
}
