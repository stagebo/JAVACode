package com.dyi.leetcode;

import java.util.Stack;

/**
 * leet 224.
 * 
 * @author WANYONGBO
 * @version 2017-12-8 14:39:38
 */
public class Leet224BasicCalculator {
	public static void main(String[] args) {

	}
	public int calculate(String str){
		Stack<Character> s = new Stack<Character>();
		int result = 0;
		for(int i =0;i<str.length();i++){
			char c = str.charAt(i);
			if(c == '('){
				s.push(c);
			}else if (c<='9' && c>='0'){
				
			}else if(c=='-'){
				
			}else if(c=='+'){
				
			}else if(c==')'){
				
			}
		}
		
		return result;
	}
}
