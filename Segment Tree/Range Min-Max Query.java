/*
    Company Tags  : Facebook (Variation)
    Qn Link       : https://practice.geeksforgeeks.org/problems/range-minimum-query/1#
    Below code for "Min" Query. Simply replace min() with max() and it will be "Max" Query
*/


//******************************************************** C++ ******************************************************************//
#include<bits/stdc++.h>
using namespace std;

 void buildTree(vector<int>& nums, vector<int>& st, int low, int high, int ind) {
    
    if(low == high) {
        st[ind] = nums[low];
        return;
	}
	
    int mid = low + (high-low)/2;

    buildTree(nums, st, low, mid, 2*ind+1);
    buildTree(nums, st, mid+1, high, 2*ind+2);
   
    st[ind] = Math.min(st[2*ind+1], st[2*ind+2]);
    
}

int getMin(vector<int>& st, int ss, int se, int &qs, int &qe, int si) {
    //if range is out of query range
    if(ss > qe || se < qs) {
        return INT_MAX;
    }
    
    //if range is totally inside query range
    if(ss >= qs && se <= qe) {
        return st[si];
    }
    
    //else we need to split and find the required query range
    int mid = ss + (se-ss)/2;

    int left = getMin(st, ss, mid, qs, qe, 2*si+1);
    int right = getMin(st, mid+1, se, qs, qe, 2*si+2); 
    
    return min(left, right);
}

void updateTree(vector<int>& st, int ss, int se, int& idx, int& diff,  int si) {
	if(ss > se)
		return;
    //if idx is out of current range, then it has no impact 
    if(idx < ss || idx > se)
        return;
    st[si] += diff;
	if(ss != se) {
		int mid = ss + (se - ss)/2;
		updateTree(st, ss, mid, idx, diff, 2*si+1);
		updateTree(st, mid+1, se, idx, diff, 2*si+2);    
	}
}

int main() {
    vector<int> vec{1, 3, 2, 7, 9, 11};
    int n = vec.size();
    vector<int> st(4*n);
    buildTree(vec, st, 0, n-1, 0);
    int qs = 1, qe = 5;
    cout << getMin(st, 0, n-1, qs, qe, 0) << endl;

    
return 0;
}


//********************************************************* JAVA ***********************************************************//


/* The functions which 
builds the segment tree */
class GfG
{
    static int st[];
    
    public static int[] constructST(int arr[], int n)
    {
        st = new int[4*n];
        build(0, 0, n-1, arr);
        return st;
        
    }
    
    private static void build(int ind, int low, int high, int[] arr){
        
        if(low == high){
            st[ind] = arr[low];
            return;
        }
        
        int mid = (low + (high-low)/2);
        
        build(2*ind+1, low, mid, arr);
        build(2*ind+2, mid+1, high, arr);
        
        st[ind] = Math.min(st[2*ind+1], st[2*ind+2]);
        
        
    }
    
    static int query(int ind, int low, int high, int l, int r) {
        
        if(low >= l && high <= r){
            //completely within the range
            return st[ind];
        }
        else if(high < l || low > r){
            //completely  out of the range
            return Integer.MAX_VALUE;
        }
        else{
            
            //overlap case
            int mid = (low + (high-low)/2);
            int left = query(2*ind+1, low, mid, l, r);
            int right = query(2*ind+2, mid+1, high, l, r);
            
            return Math.min(left, right);
        }
    }
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
       
       return query(0, 0, n-1, l, r);
    }
    
    
}
