package com.sanyuan.leetcode.interleavingString;

import java.util.ArrayList;

public class InterleavingString {
	/*
	 * Native solution, time exceed.
	 */
	public boolean isInterleave1(String s1, String s2, String s3) {
        if( (s3.length()) != (s1.length() + s2.length()) ){
            return false;
        }
        return  interleave(s1, 0, s2, 0, s3, 0);
    }
    
    public boolean interleave(String s1, int idx1, String s2, int idx2, String s3, int idx3){
        if(idx3 == s3.length() - 1){
            return true;
        }
        boolean match1 = idx1 < s1.length() ?  s1.charAt(idx1) == s3.charAt(idx3) : false;
        boolean match2 = idx2 < s2.length() ? s2.charAt(idx2) == s3.charAt(idx3) : false;
        if(match1 && match2){
            return interleave(s1,idx1+1,s2,idx2,s3,idx3+1) || interleave(s1,idx1,s2,idx2+1,s3,idx3+1);
        }
        if(match1){
            return interleave(s1,idx1+1,s2,idx2,s3,idx3+1);
        }
        if(match2){
            return interleave(s1,idx1,s2,idx2+1,s3,idx3+1);
        }
        return false;
    }
    /*
     * DP solution to save time. Doesn't work  :(
     *
     */
    
    public boolean isInterleave(String s1, String s2, String s3) {
        ArrayList<ArrayList<Integer>> state = new ArrayList<ArrayList<Integer>>();
        //initial the list
        if(s1.length() + s2.length() != s3.length() ){
            return false;
        }
        boolean match1 = 0 < s1.length() ?  s1.charAt(0) == s3.charAt(0) : false;
        boolean match2 = 0 < s2.length() ? s2.charAt(0) == s3.charAt(0) : false;
        if(match1){
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(1);
            al.add(0);
            state.add(al);
        }
        if(match2){
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(0);
            al.add(1);
            state.add(al);
        }
        for(int i=1; i<s3.length(); i++){
            ArrayList<ArrayList<Integer>> newState = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> al : state){
                int idx1 = al.get(0);
                int idx2 = al.get(1);
                boolean match3 = idx1 < s1.length() ? s1.charAt(idx1) == s3.charAt(i) : false;
                boolean match4 = idx2 < s2.length() ? s2.charAt(idx2) == s3.charAt(i) : false;
                if(match3){
                    ArrayList<Integer> lt = new ArrayList<Integer>();
                    lt.add(idx1+1);
                    lt.add(idx2);
                    newState.add(lt);
                }
                if(match4){
                    ArrayList<Integer> lt = new ArrayList<Integer>();
                    lt.add(idx1);
                    lt.add(idx2+1);
                    newState.add(lt);
                }
            }
            if(newState.size() == 0 ){
                return false;
            }
            state = newState;
        }        
        return true;
    }
    
    
    public static void main(String args[]){
    	String a = "a";
    	String b = "";
    	String c = "a";
    	System.out.println( isInterleave3(a,b,c));
    }
    
    
    public static boolean isInterleave3(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length() ){
            return false;
        }
        boolean record[][] = new boolean[s1.length()+1][s2.length()+1];
        record[0][0] = true;
        for(int i=1; i<=s1.length(); i++){
            record[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for(int i=1; i<=s2.length(); i++){
            record[0][i] = s2.substring(0,i).equals(s3.substring(0,i));
        }
        for(int i=1; i<=s1.length() ; i++){
            for(int j=1; j<s2.length(); j++){
                record[i][j] = ( s3.charAt(i+j-1)==s1.charAt(i-1) && record[i-1][j] )
                            || ( s3.charAt(i+j-1)==s2.charAt(j-1) && record[i][j-1] );
            }
        }
        return record[s1.length()][s2.length()];
    }
}
