/*package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*//**
 * Design a search autocomplete system for a search engine. Users may input a
 * sentence (at least one word and end with a special character '#'). For each
 * character they type except '#', you need to return the top 3 historical hot
 * sentences that have prefix the same as the part of sentence already typed.
 * Here are the specific rules:
 * 
 * The hot degree for a sentence is defined as the number of times a user typed
 * the exactly same sentence before. The returned top 3 hot sentences should be
 * sorted by hot degree (The first is the hottest one). If several sentences
 * have the same degree of hot, you need to use ASCII-code order (smaller one
 * appears first). If less than 3 hot sentences exist, then just return as many
 * as you can. When the input is a special character, it means the sentence
 * ends, and in this case, you need to return an empty list. Your job is to
 * implement the following functions:
 * 
 * The constructor function:
 * 
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
 * The input is historical data. Sentences is a string array consists of
 * previously typed sentences. Times is the corresponding times a sentence has
 * been typed. Your system should record these historical data.
 * 
 * Now, the user wants to input a new sentence. The following function will
 * provide the next character the user types:
 * 
 * List<String> input(char c): The input c is the next character typed by the
 * user. The character will only be lower-case letters ('a' to 'z'), blank space
 * (' ') or a special character ('#'). Also, the previously typed sentence
 * should be recorded in your system. The output will be the top 3 historical
 * hot sentences that have prefix the same as the part of sentence already
 * typed.
 * 
 * 
 * Example: Operation: AutocompleteSystem(["i love you", "island","ironman", "i
 * love leetcode"], [5,3,2,2]) The system have already tracked down the
 * following sentences and their corresponding times: "i love you" : 5 times
 * "island" : 3 times "ironman" : 2 times "i love leetcode" : 2 times Now, the
 * user begins another search:
 * 
 * Operation: input('i') Output: ["i love you", "island","i love leetcode"]
 * Explanation: There are four sentences that have prefix "i". Among them,
 * "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII
 * code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of
 * "ironman". Also we only need to output top 3 hot sentences, so "ironman" will
 * be ignored.
 * 
 * Operation: input(' ') Output: ["i love you","i love leetcode"] Explanation:
 * There are only two sentences that have prefix "i ".
 * 
 * Operation: input('a') Output: [] Explanation: There are no sentences that
 * have prefix "i a".
 * 
 * Operation: input('#') Output: [] Explanation: The user finished the input,
 * the sentence "i a" should be saved as a historical sentence in system. And
 * the following input will be counted as a new search.
 * 
 * Note: The input sentence will always start with a letter and end with '#',
 * and only one blank space will exist between two words. The number of complete
 * sentences that to be searched won't exceed 100. The length of each sentence
 * including those in the historical data won't exceed 100. Please use
 * double-quote instead of single-quote when you write test cases even for a
 * character input. Please remember to RESET your class variables declared in
 * class AutocompleteSystem, as static/class variables are persisted across
 * multiple test cases. Please see here for more details.
 * 
 * @author Stagebo
 *
 *//*
public class AutoSearchSystem {
	public static void main(String[] args) {
		AutocompleteSystem ac = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });
		List<String> l = ac.input('i');
		System.out.println("aim:" + String.join("--", l));
		l = ac.input(' ');
		System.out.println("aim:" + String.join("--", l));
		l = ac.input('a');
		System.out.println("aim:" + String.join("--", l));
		l = ac.input('#');
		System.out.println("aim:" + String.join("--", l));
		
		System.out.println(String.join("--", ac.s));
	}
}

class AutocompleteSystem {
	String[] s;
	int[] t;

	public AutocompleteSystem(String[] s, int[] t) {
		for (int i = 0; i < s.length; i++)
			s[i] = s[i] + "&" + t[i];
		this.s = s;
		this.t = t;
	}

	private String temp = "";

	public List<String> input(char c) {
		List<String> re = new ArrayList<String>();
		if (c == '#') {
			refresh();
			temp = "";
			return re;
		}
		temp = temp + c;
		sortList(s, temp);
		try {
			for (int kk = 0; kk < 3; kk++) {
				String tK = s[kk].split("&")[0];
				if (tK.startsWith(temp)) {
					re.add(tK);
				} else
					break;
			}
		} catch (Exception e) {

		}
		return re;

	}

	private void sortList(String[] l, String t) {
		Arrays.sort(l);
		for (int i = 0; i < l.length; i++) {
			for (int j = i; j < l.length; j++) {
				String[] s1 = l[i].split("&");
				String[] s2 = l[j].split("&");
				int i1 = Integer.parseInt(s1[1]);
				int i2 = Integer.parseInt(s2[1]);
				if (i1 < i2) {
					String ttt = l[i];
					l[i] = l[j];
					l[j] = ttt;
				}
				if (i1 == i2) {
					if (s1[0].compareTo(s2[0]) == 1) {
						String tt = s1[0];
						s1[0] = s2[0];
						s2[0] = tt;
						l[i] = String.join("&", s2);
						l[j] = String.join("&", s1);
					}
				}
			}
		}
	}

	private void refresh() {
		for (int i = 0; i < s.length; i++) {
			if (s[i].startsWith(temp + "&")) {
				String[] sT = s[i].split("&");
				int tims = Integer.parseInt(sT[1]);
				tims++;
				s[i] = sT[0] + "&" + tims;
			}}
				String[] sT = new String[s.length + 1];
				System.arraycopy(s, 0, sT, 0, s.length);
				sT[sT.length - 1] = temp + "&" + 1;
				s=sT;
			
		

	}
}
*/