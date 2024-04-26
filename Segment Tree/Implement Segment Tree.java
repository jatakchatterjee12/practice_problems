package com.practice;

import java.util.Scanner;

public class SegmentTree2 {
	
	 int[] a ;
	 int[] st ;
	
	public  void buildTree(int ind, int low, int high) { // O(n)
		if(low >= high) {
			st[ind] = a[low];
			return;
		}
		
		int mid = (low + (high-low)/2);
		buildTree(2*ind+1, low, mid);
		buildTree(2*ind+2, mid+1, high);
		
		st[ind] = st[2*ind+1] + st[2*ind+2];
	}
	
	private  int querySum(int ind, int low, int high, int l, int r) { //O(logn)
		
		if(low >= l && high <= r) {
			return st[ind];
		}
		
		else if(high < l || low > r) {
			return 0;
		}
		else {
			int mid = low + (high - low)/2;
			int left = querySum(2*ind+1, low, mid, l, r);
			int right = querySum(2*ind+2, mid+1, high, l, r);
			
			return left + right;
		}
	}

	
	void update(int ind, int low, int high, int updateIdx, int diff) { // O(logn)
		
		if(updateIdx < low || updateIdx > high) {
			return;
		}
		
		st[ind] += diff;
		
		if(low != high) {
			int mid = low + (high - low)/2;
			update(2*ind+1, low, mid, updateIdx, diff);
			update(2*ind+2, mid+1, high, updateIdx, diff);
		}
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers");
		
		SegmentTree2 obj  = new SegmentTree2();
		
		
		int n = 3;
		obj.a = new int[] {2, 5, 8};
		obj.st = new int[4*n];
		
		obj.buildTree(0, 0, n-1);
		
		
		
		
		
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		for(int i = 0; i < obj.st.length; i++) {
			System.out.print(obj.st[i] + " ");
			
			
		}
		System.out.println();
		
		System.out.println("------------------");
		System.out.println(obj.querySum(0, 0, n-1,l,r)); //output [0,2] --> 15
		
		
		//update the array
		int idx = 1;
		int val = 10;
		int diff = val - obj.a[idx];
		obj.a[idx] = val;
		
		obj.update(0,  0,  n-1,  idx,  diff);
		
		l = sc.nextInt();
		r = sc.nextInt();
		
		for(int i = 0; i < obj.st.length; i++) {
			System.out.print(obj.st[i] + " ");
			
		}
		System.out.println();
		System.out.println("------------------");

		System.out.println(obj.querySum(0, 0, n-1,l,r)); //output [0,2] --> 20 
		

	}

}
