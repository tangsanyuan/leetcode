package com.sanyuan.leetcode.validNumber;

public class ValidNumber {

	public enum State  {
		INITIAL, SIGN, DOT, NUM, DOT_DIGITAL, EXP, EXP_DIGITAL, SPACE, FALSE
	}
	
	
	public static void main(String args[]){
		System.out.println(isNumber("0"));
		System.out.println(isNumber(" 0.1"));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("2e10"));
	}

	static boolean isNumber(String s){
		State st = State.INITIAL;
		for(int i=0; i<s.length() ; i++){
			Character c = s.charAt(i);
			switch (st) {
			case INITIAL: {
				if(c.equals('-') || c.equals('+')){
					st = State.SIGN;
					continue;
				}
				if(Character.isDigit(c)){
					st = State.NUM;
					continue;
				}
				if(c.equals(' ' )){
					continue;
				}
				if(c.equals('.')){
					st = State.DOT;
					continue;
				}
				st = State.FALSE;
				break;
			}
			case SIGN:{
				if(Character.isDigit(c)){
					st = State.NUM;
					continue;
				}
				if(c.equals('.')){
					st = State.DOT;
					continue;
				}
				st = State.FALSE;
				break;
			}
			case DOT:{
				if(Character.isDigit(c)){
					st = State.DOT_DIGITAL;
					continue;
				}
				st = State.FALSE;
				break;
			}
			
			case NUM:{
				if (Character.isDigit(c)){
					continue;
				}
				if(c.equals(' ')){
					st = State.SPACE;
					continue;
				}
				if(c.equals('.')){
					st = State.DOT_DIGITAL;
					continue;
				}
				if(c.equals('e')){
					st = State.EXP;
					continue;
				}
				st = State.FALSE;
				break;
			}
			case DOT_DIGITAL:{
				if (Character.isDigit(c)){
					continue;
				}
				if(c.equals(' ')){
					st = State.SPACE;
					continue;
				}
				if(c.equals('e')){
					st = State.EXP;
					continue;
				}
				st = State.FALSE;
				break;
			}
			
			case EXP:{
				if(Character.isDigit(c)){
					st = State.EXP_DIGITAL;
					continue;
				}
				st = State.FALSE;
				break;
			}
			case EXP_DIGITAL: {
				if(c.equals(' ')){
					st = State.SPACE;
					continue;
				}
				if(Character.isDigit(c)){
					continue;
				}
				st = State.FALSE;
				break;
			}
			case SPACE: {
				if(c.equals(' ')){
					continue;
				}
				st = State.FALSE;
				break;
			}
			case FALSE:{
				return false;
			}
			}
		}
		if(st == State.NUM || st==State.DOT_DIGITAL || st == State.EXP_DIGITAL || st == State.SPACE){
			return true;
		}
		return false;
	}
}
