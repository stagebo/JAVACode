package com.dyi.leetcode;

/**
 * 415.Given two non-negative integers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * @author WANYONGBO
 *
 */
public class Leet415AddString {
	public static void main(String[] args) {
		Leet415AddString le=new Leet415AddString();
		String s=le.addStrings("9", "99");
		System.out.println(s);
	}
	public String addStrings(String num1, String num2) {
        StringBuilder re=new StringBuilder();
        int carry=0;
        int i=0;
        while(i<num1.length()&&i<num2.length()){
            int m=num1.charAt(num1.length()-i-1)-'0'+
                num2.charAt(num2.length()-1-i)-'0'+carry;
            re.append(m%10);
            carry=m/10;
            i++;
        }
        while(i<num1.length()){
        	int m=num1.charAt(num1.length()-i-1)-'0'+carry;
        	re.append(m%10);
            carry=m/10;
            i++;
        }
        while(i<num2.length()){
        	int m=num2.charAt(num2.length()-i-1)-'0'+carry;
        	re.append(m%10);
            carry=m/10;
            i++;
        }
        re.append(carry==1?"1":"");
        return re.reverse().toString();
    }
}
