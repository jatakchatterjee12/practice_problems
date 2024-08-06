package com.practice;

//class Node {
//	int data;
//	Node next;
//	Node(int x){
//		this.data = x;
//		this.next = null;
//	}
//	
//	Node(int x, Node y){
//		this.data = x;
//		this.next = y;
//	}
//}
public class QueueUsingLL {
	
	Node start = null;
	Node end = null;
	int size = 0;
	
	void push(int x) {
		
		Node temp = new Node(x);
		if(start == null) {
			start = end = temp;
		}
		else {
			end.next = temp;
			end = end.next;
		}
		
		size++;
		
	}
	
	void pop() {
		if(start == null) {
			System.out.println("No element");
		}
		
		Node temp = start;
		start = start.next;
		
		temp.next = null;
		
		size--;
	}
	
	int top() {
		if(start == null) return -1;
		return start.data;
	}
	
	int size() {
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUsingLL que = new QueueUsingLL();
		
		que.push(2);
		que.push(4);
		que.push(6);
		
		System.out.println(que.top());
		
		que.pop();
		
		System.out.println(que.top());
		
		que.pop();
		System.out.println(que.top());
		
		que.pop();
		System.out.println(que.top());
		
		que.push(77);
		
		System.out.println(que.top());
		
		
		

	}

}
