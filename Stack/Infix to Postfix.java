package com.practice;

import java.util.Stack;

public class InfixToPostfix {
	
	private int priority(char ch) {
		if(ch == '^') return 3;
		else if(ch == '*' || ch == '/') return 2;
		else if(ch == '+' || ch == '-') return 1;
		else return -1;
	}
	
	
	public String infixToPostfix(String infix) {
		int i = 0;
		Stack<Character> st = new Stack<>();
		String ans = "";
		
		while(i < infix.length()) {
			
			if((infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z')  ||
				(infix.charAt(i) >= 'a' && infix.charAt(i) <= 'z') ||
				(infix.charAt(i) >= '0' && infix.charAt(i) <= '9')) {
				
				ans += infix.charAt(i);
			}
			else if(infix.charAt(i) == '(') {
				st.push(infix.charAt(i));
			}
			else if(infix.charAt(i) == ')') {
				
				while(!st.isEmpty() && st.peek() != '(') {
					
					ans += st.pop();
				}
				st.pop(); // popping out the opening bracket too
			}
			else {
				// means s[i] is an operator
				while(!st.isEmpty() && priority(infix.charAt(i)) <= priority(st.peek())) {
					ans += st.pop();
				}
				
				st.push(infix.charAt(i));
			}
			
			i++;
		}
		
		while(!st.isEmpty()) {
			ans += st.pop();
		}
		
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPostfix obj = new InfixToPostfix();
		String infix = "(p+q)*(m-n)";
		String infix2 = "a+b*(c^d-e)";
		System.out.println(obj.infixToPostfix(infix2)); //abcd^e-*+

		System.out.println(obj.infixToPostfix(infix)); // pq+mn-*
		
	}

}
