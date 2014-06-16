package com.sanyuan.leetcode.palindromePartition;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public static void main(String args[]){
		String t1 = "aab";
		List<List<String>> ret = partition(t1);
		for(List<String> l1 : ret){
			for(String s : l1){
				System.out.print(s+" ");
			}
			System.out.print("\n");
		}
	}
	
	
	public static List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        partitionHelper(ret,new ArrayList<String>(),s);
        return ret;
    }
    
    static void partitionHelper(List<List<String>> ret, List<String> al, String s){
        if(s.length() == 0){
            ret.add(al);
        }
        for(int i=1; i<=s.length();i++){
            String cur = s.substring(0, i);
            if(isPalindrome(cur)){
            	List<String> nextAL = new ArrayList<String>(al);
            	nextAL.add(cur);
            	partitionHelper(ret,nextAL,s.substring(i));
            }
        }
    }
    
    static boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
