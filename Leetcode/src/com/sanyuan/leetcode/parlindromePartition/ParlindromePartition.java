package com.sanyuan.leetcode.parlindromePartition;

public class ParlindromePartition {

	public static void main(String args[]){
		//System.err.println(ParlindromePartitionSolution("aabb"));
		System.err.println(ParlindromePartitionSolution("dde"));
		System.err.println(ParlindromePartitionSolution("aabb"));
		System.err.println(ParlindromePartitionSolution("abccba"));
		//System.err.println(minCut("abccba"));
		//System.err.println(minCut("aab")); 
	}

	static int ParlindromePartitionSolution(final String s){
		int cuts[] = new int[s.length()+1];
		boolean isParlindrome[][] = new boolean[s.length()][s.length()];
		for(int i=0; i<=s.length();i++){
			cuts[i] = i-1;
		}
		for(int i=1; i<s.length(); i++){
			for(int j=i-1; j>0; j--){
				if( s.charAt(i)==s.charAt(j) && ( (i-j)<2 || isParlindrome[j+1][i-1]) ){
					isParlindrome[j][i] = true;
					cuts[i] = Math.min(cuts[i+1], cuts[j]+1);
				}
			}
		}
		
		for(int k=0 ; k<=s.length(); k++){
			System.out.print(cuts[k] + " ");
		}
		return cuts[s.length()-1];

	}

	public static int minCut(String s) {
		int min = 0;
		int len = s.length();
		boolean[][] matrix = new boolean[len][len];
		int cuts[] = new int[len+1];

		if (s == null || s.length() == 0)
			return min;
		for (int i=0; i<len; ++i){
			cuts[i] = len - i;
		}
		for (int i=len-1; i>=0; --i){
			for (int j=i; j<len; ++j){
				if ((s.charAt(i) == s.charAt(j) && (j-i<2))
						|| (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))
				{
					matrix[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j+1]+1);
				}
			}
		}
		for(int k=0 ; k<=s.length(); k++){
			//System.out.print(cuts[k] + " ");
		}
		min = cuts[0];
		return min-1;
	}

}
