package com.sanyuan.leetcode.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	
	public static final Map<Character, Character> map = new HashMap<Character, Character>();
	
	static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}'); 
    }
	
	public static boolean isValid(String s) {
		Stack<Character> stk = new Stack<Character>();

		for(int i=0; i<s.length(); i++){
			Character c = s.charAt(i);
			switch (c){
			case '(': 
			case '[': 
			case '{': {
				stk.push(c);
				break;
			}
			case ')': 
			case ']':
			case '}':
			{
				if(stk.size()==0){
					return false;
				}
				if(!map.get(stk.pop()).equals(c)){
					return false;
				}
			}
			}
		}
		return stk.size()==0; 
	}



	public static void main(String args[]){
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("([)]"));
	}
}
