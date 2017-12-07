package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet676MagicDic {
	public static void main(String[] args) {
		MagicDictionary m = new MagicDictionary();
		String[] strArr = new String[] { "MagicDictionary", "buildDict",
				"search", "hello", "wyb", "eclipse", "eclipse" };
		m.buildDict(strArr);
		System.out.println(m.search("eclipse"));
		System.out.println(m.list.size());
		System.out.println(m.nList.size());
	}
}

class MagicDictionary {

	public List<String> list = null;
	public List<String> nList = null;

	/** Initialize your data structure here. */
	public MagicDictionary() {
		list = new ArrayList<String>();
		nList = new ArrayList<String>();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String w : dict) {
			if (nList.contains(w)) {
				continue;
			}
			nList.add(w);
			String[] wa = w.split("");
			for (int i = 0; i < wa.length; i++) {
				String c = wa[i];
				wa[i] = "*";
				String temp = String.join("", wa);
				list.add(temp);
				wa[i] = c; 
			}

		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
	public boolean search(String word) {

		String[] wa = word.split("");
		for (int i = 0; i < wa.length; i++) {
			String c = wa[i];
			wa[i] = "*";
			String temp = String.join("", wa);
			if (list.contains(temp) && !nList.contains(word)) {
				return true;
			}
			wa[i] = c;
		}
		return false;
	}
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary(); obj.buildDict(dict); boolean
 * param_2 = obj.search(word);
 */
