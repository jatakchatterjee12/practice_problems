//GFG Problem
// Matrix given for a knows b or not

//  gfg lnk : https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

//******************************** C++ **************************************************//

class Solution 
{
    public:
    bool knows(vector<vector<int> >& M, int a, int b){
        return M[a][b] == 1;
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrity(vector<vector<int> >& M, int n) 
    {
       stack<int> st;
       for(int i=0; i<n; i++) {
           st.push(i);
       }
       
       while(st.size() > 1){
           int a = st.top();
           st.pop();
           
           int b = st.top();
           st.pop();
           
           //case 1: if(a knows b ,a discarded , b pushed in st)
           if(knows(M, a, b)){
               st.push(b);
           }
           else{
               //case 2: b knows a, a ko dalo firse
               st.push(a);
           }
       }
       int candidate = st.top();
       
       
       //step 3 : verify the potential candidate
       //row check
       
       int zeroCnt = 0;
       
       for(int i=0; i<n; i++) {
           if(M[candidate][i] == 0){
               zeroCnt++;
           }
       }
       
       if(zeroCnt != n) return -1;
       
       //column check
       int oneCnt = 0;
       
       for(int i=0; i<n; i++) {
           if(i != candidate && M[i][candidate] == 1){
               oneCnt++;
           }
       }
       
       if(oneCnt != n-1) return -1;
       
       return candidate;
       
    }
};

//Code studio link(Same as leetcode(premium) : https://www.codingninjas.com/studio/problems/the-celebrity-problem_982769?leftPanelTabValue=PROBLEM
//************************************************** JAVA ***************************************************** //
import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<n; i++) {
			st.push(i);
		}

		while(st.size() > 1) {
			int a = st.pop();
			int b = st.pop();

			//case 1: a knows b --> b can be a potential candidate
			if(Runner.knows(a, b) == true) {
				st.push(b);
			}
			else { //case 2: b knows a --> a can be a potentia candidate
				st.push(a); 
			}
		}

		int ans = st.peek(); // candidate

		//verify the candidate;
		for(int i=0;i<n;i++){
			if(i != ans && (Runner.knows(ans, i) || Runner.knows(i, ans) == false)){
				return -1;
			}
		}

		return ans;
    }
}
