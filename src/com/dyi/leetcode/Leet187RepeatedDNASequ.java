package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.mapping.Collection;

public class Leet187RepeatedDNASequ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		line="AAAAAAAAAAA";
		List<String> l=findRepeatedDnaSequences(line);
		for(String s:l)
			System.out.println(s);
		/*String pattern = "([A-Z]{10,})\\1";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		for (int i = 0; i < line.length(); i++) {

			String temp = line.substring(i, line.length() - 1);
			
			Matcher m = r.matcher(temp);
			while (m.find()) {
				System.out.println("Found value: " + m.group(0));
				// System.out.println("Found value: " + m.group(1) );
				// System.out.println("Found value: " + m.group(2) );
			}
		}*/
	}
	public static List<String> findRepeatedDnaSequences(String line) {
        List<String> result = new ArrayList<String>();
        String pattern = "([A-Z]{10})[A-Z]{0,}\\1";
		// 创建 Pattern 对象
		java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern);
		Set<String> hs = new HashSet<String>();
		// 现在创建 matcher 对象
		for (int i = 0; i < line.length(); i++) {

			String temp = line.substring(i, line.length() - 1);
			//System.out.println(i+":"+temp);
			java.util.regex.Matcher m = r.matcher(temp);
			while (m.find()) {
				hs.add(m.group(0).substring(0,m.group(0).length()/2));
				// System.out.println("Found value: " + m.group(1) );
				// System.out.println("Found value: " + m.group(2) );
			}
		}
		for(String s:hs)result.add(s);
        return result;
    }

}
