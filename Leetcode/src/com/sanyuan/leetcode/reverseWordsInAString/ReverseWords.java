package com.sanyuan.leetcode.reverseWordsInAString;

public class ReverseWords {
	public static String reverseWords(String s) {
		String res = reverseStr(s);
        String a[] = res.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a.length; i++){
            sb.append(reverseStr(a[i]));
            sb.append(' ');
        }
        return sb.toString().trim();
    }
    
    public static String reverseStr(String s){
    	return new StringBuilder(s).reverse().toString();
    }
    
    public static void main(String args[]){
    	String s = new String("  the sky is blue ");
    	System.out.println(reverseWords(s));
    	String s1 = new String("   a   b ");
    	System.out.println(reverseWords(s1));
    }
}
