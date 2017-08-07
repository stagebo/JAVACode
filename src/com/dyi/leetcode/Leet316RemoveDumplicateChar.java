package com.dyi.leetcode;
import java.util.HashSet;

/**
 * 316.Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example: Given "bcabc" Return "abc"
 * 
 * Given "cbacdcbc" Return "acdb"
 * 
 * @author WANYONGBO
 *
 */
public class Leet316RemoveDumplicateChar {
	/**
	 * 
	 * @param str
	 */
	public String sulotion(String str) {
		String[] s = str.split("");
		HashSet<String> hs = new HashSet<String>();
		for (String st : s)
			hs.add(st);
		Object[] o = hs.toArray();
		StringBuilder sb=new StringBuilder();
		for(Object oitem:o)
			sb.append(oitem);
		return sb.toString();
	}
	public static void main(String[] args) {
		new Leet316RemoveDumplicateChar().sulotion("bdabcd");
	}
}
