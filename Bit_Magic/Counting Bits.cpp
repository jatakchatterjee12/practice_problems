/*
     
      Company Tags                : AMAZON
      Leetcode Link               : https://leetcode.com/problems/counting-bits/
*/


//********************************************* C++ ********************************************************************
//Approach-1 (Using built-in function) - __builtin_popcount - O(nlog(n))
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> result(n+1);
        
        for(int i = 0; i<n+1; i++) {
            result[i] = __builtin_popcount(i); //log(n)
        }
        
        return result;
    }
};

//Approach-2 - T.C : O(n)
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> result(n+1);
        
        if(n == 0)
            return result;
        
        result[1] = 1;
        
        for(int i = 2; i < n+1; i++) {
            
            if(i%2 == 0) {
                result[i] = result[i/2];
            } else {
                result[i] = result[i/2] + 1;
            }
            
        }
        
        return result;
        
    }
};

//********************************************************* JAVA ****************************************************//
//Approach-1 (Using built-in function) - Integer.bitCount - O(nlog(n))
class Solution {
public:
    int[] countBits(int n) {
        int[] result = new int[n+1];
        
        for(int i = 0; i<n+1; i++) {
            result[i] = Integer.bitCount(i); //log(n)
        }
        
        return result;
    }
}


//Same Approach without builtin func
class Solution {
    int solve(int n){
        int cnt = 0;
        while(n > 0) {
            cnt += n%2;
            n   = n/2; 
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i = 0; i < n+1; i++){
            res[i] = solve(i);
        }
        return res;
    }
}

//Approach 2: TC -O(N)
//Approach-2 - T.C : O(n)
class Solution {
public:
    vector<int> countBits(int n) {
        int[] result = new int[n+1];
        
        if(n == 0)
            return result;
        
        result[1] = 1;
        
        for(int i = 2; i < n+1; i++) {
            
            if(i%2 == 0) {
                result[i] = result[i/2];
            } else {
                result[i] = result[i/2] + 1;
            }
            
        }
        
        return result;
        
    }
}
