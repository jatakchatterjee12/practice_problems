package com.practice;

public class StackUsingArray {
	int top = -1;
	int size = 5;
	int[] st = new int[size];
	
	void push(int x) {
		st[++top] = x;
	}
	
	int top() {
		if(top == -1) {
			return -1;
		}
		else {
			return st[top];
		}
	}
	
	int pop() {
		if(top == -1) return -1;
		 int el = st[top];
		 top = top-1;
		 return el;
	}
	
	int size() {
		return top+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackUsingArray st = new StackUsingArray();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.top());
		
		st.pop();
		System.out.println(st.top());
		
	}

}
