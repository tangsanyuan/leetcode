package com.sanyuan.other.kmp;

public class KmpAlgorithm {
	public static int [] constructPrefixFunction(String p){
		int prefix[] = new int [p.length()];
		char pattern[] = p.toCharArray();
		prefix[0] = 0;
		int k=0;
		for(int i=1; i<p.length(); i++){
			while(k>0 && pattern[k] != pattern[i]){
				k = prefix[k];
			}
			if (pattern[k] == pattern[i]){
				k = k+1;
			}
			prefix[i] = k;
		}
		return prefix;
	}
	
	public static int getFirstMatch(String t, String p){
		int s = -1;
		int prefix[] = constructPrefixFunction(p);
		char pattern [] = p.toCharArray();
		char target [] = t.toCharArray();
		int idx = 0;
		for (int i=0; i<target.length; i++){
			while(idx>0 && pattern[idx] != target[i]){
				idx = prefix[idx];
			}
			if(pattern[idx] == target[i]){
				idx = idx+1; 
			}
			if (idx==p.length()-1){
				s = i - idx + 1 ;
				idx = prefix[idx];
			}
		}
		return s;
	}
	
	
	
	public static void main(String args[]){
		String p = "ababaca";
		String t0 = "ababacaa";
		String t1 = "bacbababaabcbab";
		String t2 = "babdabacbaababacaacb";
		System.out.println(getFirstMatch(t0,p));
		System.out.println(getFirstMatch(t1,p));
		System.out.println(getFirstMatch(t2,p));
	}
}
