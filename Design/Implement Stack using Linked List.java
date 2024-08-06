package com.practice;

class Node{
	int data;
	Node next;
	
	Node(int x){
		this.data = x;
		this.next = null;
	}
	
	Node(int x, Node n){
		this.data = x;
		this.next = n;
	}
}
public class StackUsingLL {
	
	Node top = null;
	int size = 0;
	
	void push(int x) {
		Node temp = new Node(x);
		temp.next = top;
		top = temp;
		
		size = size+1;
	}
	
	void pop() {
		
		Node temp = top;
		top = top.next;
		
		temp.next = null; // delete temp
		
		size  = size -1;
	}
	
	int top() {
		if(top != null) {
			return top.data;
		}
		return -1;
	}
	
	int size() {
		
		return size;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackUsingLL st = new StackUsingLL();
		st.push(2);
		st.push(6);
		st.push(4);
		
		System.out.println(st.top());
		System.out.println(st.size());
		
		st.pop();
	
		System.out.println(st.top());
		System.out.println(st.size());
		
		st.push(12);
		System.out.println(st.top());
		System.out.println(st.size());
		
		st.pop();
		st.pop();
		System.out.println(st.top());
		System.out.println(st.size());
	

	}

}
