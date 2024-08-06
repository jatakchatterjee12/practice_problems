package com.practice;

public class QueueUSingArray {
	int size  = 5;
	int[] que = new int[size];
	int currSize = 0;
	int start = -1;
	int end   = -1;
	
	void push(int x) {
		if(currSize == size) {
			System.out.println("No space for push operation");
		}
		
		if(currSize == 0) {
			start = 0;
			end = 0;
		}
		else {
			end = (end+1)%size;
		}
		
		que[end] = x;
		currSize++;
	}
	
	int pop() {
		if(currSize == 0) {
			return -1 ;
		}
		
		int el = que[start];
		
		if(currSize == 1) {
			start = -1;
			end  = -1;
		}
		else {
			start = (start+1)%size;
		}
		
		currSize--;
		return el;
		
		
	}
	
	int top() {
		if(currSize == 0) {
			return -1;
		}
		else {
			return que[start];
		}
	}
	
	int size() {
		return currSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueUSingArray q = new QueueUSingArray();
		System.out.println(q.top());
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println(q.top());
		q.pop();
		System.out.println(q.top());
		q.push(4);
		q.push(5);
		q.pop();
		q.pop();
		System.out.println(q.top());
		System.out.println(q.size());
		q.push(6);
		System.out.println(q.size());
		q.push(7);
		q.push(8);
		q.push(9);
		

	}

}
