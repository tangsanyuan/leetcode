package com.sanyuan.leetcode.sqrt;

import java.util.Stack;

public class SqureFoot {
	public static void main(String args[]){
		System.out.println(sqrt(2147395599));
	}
	
	public static int sqrt(int x) {
        double last = 0;
        double tmp = 1;
        while(Math.abs(last-tmp) > 0.000000001  ){
            last = tmp;
            tmp = tmp/2 + x/(2*tmp);
        }
        return (int)tmp;
        //return (int) Math.ceil(tmp);        
    }
	
	 public int evalRPN(String[] tokens) {
	        Stack<Integer> stk = new Stack<Integer>();
	        for(String tk:tokens){
	            if(tk.equals("+")){
	                int a = stk.pop();
	                int b = stk.pop();
	                stk.push(a+b);
	            }else if(tk.equals("-")){
	                int a = stk.pop();
	                int b = stk.pop();
	                stk.push(b-a);
	            }else if(tk.equals("*")){
	                int a = stk.pop();
	                int b = stk.pop();
	                stk.push(b*a);
	            }else if(tk.equals("/")){
	                int a = stk.pop();
	                int b = stk.pop();
	                stk.push(b/a);
	            }else{
	                //Integer
	                stk.push(Integer.parseInt(tk));
	            }
	        }
	        return stk.pop();
	    }
}
