package com.sanyuan.leetcode.uniqueBST;

public class UniqueBST {
	
	public static void main(String args[]){
		System.out.println(numTrees(3));
	}
	
	
	public static int numTrees(int n) {
        if(n<=1){
            return 1;
        }        
        int mid[] = new int[n+1];
        mid[0] = 1;
        mid[1] = 1;
        for(int i=2; i<=n; i++){
            int sum = 0;
            for(int j=0; j<i; j++){
                sum += mid[j]*mid[i-1-j];
            }
            mid[i] = sum;
        }
        return mid[n];
    }
}
