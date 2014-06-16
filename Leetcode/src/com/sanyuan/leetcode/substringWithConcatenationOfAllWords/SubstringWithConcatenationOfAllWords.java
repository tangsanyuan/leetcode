package com.sanyuan.leetcode.substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String S, String[] L) {
        ArrayList<String> dict = new ArrayList<String>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
         for(String l : L){
             dict.add(l);
         }
        for(int i=0; i<=S.length()-L[0].length(); i++){
            String tmp = S.substring(i,i+L[0].length());
            if(dict.contains(tmp)){
                ArrayList<String> tmpSet = new ArrayList<String>(Arrays.asList(L));
                tmpSet.remove(tmp);
                int t = i + L[0].length();
                while( t<=S.length()-L[0].length() && !tmpSet.isEmpty()  &&  tmpSet.contains(S.substring(t,t+L[0].length())) ){
                    tmpSet.remove(S.substring(t,t+L[0].length()));
                    t = t+L[0].length();
                }
                if(tmpSet.isEmpty()){
                    ret.add(i);
                }
            }
        }
        return ret;
    }
	
	public static void main(String args[]){
		String S = "barfoothefoobarman";
		String L[] = {"foo", "bar"};
		List<Integer> ret = findSubstring(S,L);
		for(Integer i : ret){
			System.out.println(i);
		}
	}
}
