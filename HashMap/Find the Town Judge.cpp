/*
    Company Tags                : Amazon, Uber, Microsoft
    Leetcode Link               : https://leetcode.com/problems/find-the-town-judge/
*/

//********************************************************** C++ ************************************************//
//Approach-1 (Using Indegree and Outdegree)
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> indegree(n+1);
        vector<int> outdegree(n+1);
        
        for(vector<int> &vec : trust) {
            indegree[vec[1]]++;
            outdegree[vec[0]]++;
        }
        
        for(int i = 1; i<n+1; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0)
                return i;
        }
        
        return -1;
    }
};


//Approach-2 (Using Single Count array)
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> count(n+1);
        
        for(vector<int> &vec : trust) {
            count[vec[0]]--;
            count[vec[1]]++;
        }
        
        for(int i = 1; i<n+1; i++) {
            if(count[i] == n-1)
                return i;
        }
        
        return -1;
    }
};

//****************************************************** JAVA **************************************************//
//Approach-1 (Using Indegree and Outdegree)
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] it : trust) {
            int u = it[0];
            int v = it[1];

            outdegree[u]++;
            indegree[v]++;
        }

        for(int i=1; i<=n; i++) {
            if(indegree[i] == n-1 && outdegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

//Approach-2 (Using Single Count array)
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] count = new int[n+1];
        

        for(int[] it : trust) {
            int u = it[0];
            int v = it[1];

            count[u]--;
            count[v]++;
        }

        for(int i=1; i<=n; i++) {
            if(count[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}
